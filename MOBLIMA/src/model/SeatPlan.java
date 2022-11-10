package moblima.Model;

import java.io.Serializable;


/**
 * Represent the seating plans in a cinema
 */
@SuppressWarnings("serial")
public class SeatPlan implements Serializable {
	
	/**
	 * Seat plans in a cinema
	 */
    private Seat [][] floorPlanSeats;
    
    /**
     * Seat row 
     */
    private int row ;
    
    /**
     * Seat column
     */
    private int column;
    
    
    /**
     * Create a seating plan with x row and y column
     * @param row 		number of row of seat
     * @param column	number of column of seat
     */
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
    
    
    /**
     * Display and print the Seat plans layout
     * X represent occupied seats
     * O represent free seats
     */
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
    
    
    /**
     * Get number of row
     * @return int 	number of row
     */
    public int getRow() {
    	return row;
    }
    
    
    /**
     * Get number of column
     * @return int 	number of column
     */
    public int getCol() {
    	return column;
    }
    
    
    /**
     * Get total number of seats in the seat plans 
     * @return int 	Total number of seats
     */
    public int getTotalSeatcount() {
    	return row*column;
    }
    
    
    /**
     * Book seat based on seat ID
     * @param ID  seat ID to book
     */
    public void assignSeats(int ID) {
    	int i = ID/row;
    	floorPlanSeats[i][ID-row*i].bookseat();
    }
    
    
    /**
     * Unbook seat based on seat ID
     * @param ID  seat ID to unbook
     */
    public void unassignSeats(int ID) {
    	int i = ID/row;
    	floorPlanSeats[i][ID-row*i].unbookseat();
    }
    
    
    /**
     * Check status of seat based on ID
     * @param ID  seat ID to check
     * @return boolean  	Return true of seat with seatID is taken, else false
     */
    public boolean checkSeats(int ID) {
    	int i = ID/row;
    	return floorPlanSeats[i][ID-row*i].isTaken();
    	
    }

    
}
