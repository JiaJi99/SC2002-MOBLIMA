package BaseClasses;


import java.io.Serializable;

/**
 * Represent a seat
 */
@SuppressWarnings("serial")
public class Seat implements Serializable {

	
	/**
	 * This seat's ID
	 */
    private int seatID ;
    
    
    /**
     * This seat taken status, true = taken,
     * false = not taken
     */
    private boolean taken =false;
    
    /**
     * Create a seat with SeatID
     * default taken as not taken
     * @param seatID 	This seat's seatID
     */
    public Seat(int seatID) {
    	this.seatID=seatID;
    }
    
    
    /**
     * Create a seat with given attributes
     * @param seatID 	This seat's seatID
     * @param taken		This seat taken status
     */
    public Seat(int seatID,boolean taken) {
    	this.seatID=seatID;
    	this.taken=taken;
    }
    
    
    /**
     * Get seat ID
     * @return int This seat's ID
     */
    public int getseatID(){
    	return seatID;
    }
    
    
    /**
     * Get boolean of seat taken status
     * @return boolean 		true if seat is taken, else false
     */
    public boolean isTaken() {
    	return taken;
    }
    
    
    /**
     * Book a seat
     * Changes taken to true
     */
    public void bookseat() {
    	this.taken=true;
    }
    
    
    /**
     * Unbook a seat
     * Change taken to false
     */
    public void unbookseat() {
    	this.taken=false;
    }
    
}
