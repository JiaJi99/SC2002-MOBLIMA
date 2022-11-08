package moblima.Model;

import java.io.Serializable;

public class SeatPlan implements Serializable {
	
    private Seat [][] floorPlanSeats;
    private int row ;
    private int column;

    public SeatPlan(int row, int column) {
    	this.row=row;
    	this.column=column;
    	floorPlanSeats = new Seat[row][column];
    	for (int i=0;i<row;i++) {
    		for(int j=0;j<column;j++) {
    			floorPlanSeats[i][j] = new Seat(i*this.row+j);
    		}
    	}
    }
    
    public void printFloorPlan( ) {
		System.out.print("\nX means occupied, O means not occupied.\n");
		for (int i = 0; i < row; i++) {
			System.out.print("Seats " + (i * column) + " - " + ((i + 1) * column - 1) + ":\t");
			for (int j = 0; j < column; j++) {
				if(floorPlanSeats[i][j].isTaken()) System.out.print("X ");
				else System.out.print("0 ");
				if(j == column/2 - 1) System.out.print("\t");
			}
			System.out.print("\n");
		}
	}
    
    public int getRow() {
    	return row;
    }
    public int getCol() {
    	return column;
    }
    public int getTotalSeatcount() {
    	return row*column;
    }
    
    public void assignSeats(int ID) {
    	int i = ID/row;
    	floorPlanSeats[i][ID-row*i].bookseat();
    }
    
    public void unassignSeats(int ID) {
    	int i = ID/row;
    	floorPlanSeats[i][ID-row*i].unbookseat();
    }
    
    public boolean checkSeats(int ID) {
    	int i = ID/row;
    	return floorPlanSeats[i][ID-row*i].isTaken();
    	
    }

    
}