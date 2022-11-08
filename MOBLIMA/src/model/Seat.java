package moblima.Model;

import java.io.Serializable;

public class Seat implements Serializable {
    private int seatID ;
    private boolean taken =false;
    
    public Seat(int seatID) {
    	this.seatID=seatID;
    }
    
    public Seat(int seatID,boolean taken) {
    	this.seatID=seatID;
    	this.taken=taken;
    }
    
    public boolean isTaken() {
    	return taken;
    }
    public void bookseat() {
    	this.taken=true;
    }
    public void unbookseat() {
    	this.taken=false;
    }
    
}