package BaseClasses;
import java.io.Serializable;
import java.util.ArrayList;


/**
 * Represent a Cinemas
 * A Cinemas has cinemacode, seat plans and a list of sessions in that cinema
 */
public class Cinemas implements Serializable {
	
	/**
	 * This Cinema's cinemaCode
	 */
    private String cinemaCode;
    
    /**
     * This Cinema's seatPlan
     */
    private SeatPlan seatPlan;

    /**
     * This Cinema's list of sessions
     */
    private ArrayList<Sessions> showTimes;

    
    /**
     * Create a cinema with the given attributes
     * @param cinemaCode 	This cinema's Unique code
     * @param seatPlan		THis cinema's seat plans
     */
    public Cinemas(String cinemaCode, SeatPlan seatPlan ){
        this.cinemaCode= cinemaCode;
        this.seatPlan = seatPlan;
        this.showTimes = new ArrayList<Sessions>();
    }


    /**
     * Get this Cinema code
     * @return String 	this cinema's cinemaCode
     */
    public String getCinemaCode(){
        return cinemaCode;
    }

    
    /**
     * Set this Cinema's code
     * @param cinemaCode 	New cinemaCode of this Cinema
     */
    public void setCinemaCode(String cinemaCode ){
        this.cinemaCode = cinemaCode;
    }


    /**
     * Set this Cinema's Seat Plans
     * @param seatPlan 	New seatPlan of this Cinema
     */
    public void setSeatPlan(SeatPlan seatPlan ){
        this.seatPlan = seatPlan;
    }

    
    /**
     * Get this Cinema's Seat Plans
     * @return SeatPlan 	this cinema's seat plan
     */
    public SeatPlan getSeatPlan(){
        return seatPlan;
    }

    
    /**
     * Get this Cinemas' list of session
     * @return ArrayList<Sessions> 	this cinemas' list of sessions
     */
    public ArrayList<Sessions> getShowtimes(){
        return showTimes;
    }

    
    /**
     * Set this Cinemas' session
     * @param showTimes 	New session of this Cinema
     */
    public void setShowTimes (ArrayList<Sessions> showTimes){
        this.showTimes = showTimes;
    }

    
    /**
     * String to return when this cinemas is called
     * @return String
     */
    public String getStringCinema(){
        String tempShowtime = "";
        for (int i =0;i<showTimes.size();i++){
            tempShowtime = tempShowtime.concat("=========="+showTimes.get(i)+"\n");
        }
        tempShowtime= tempShowtime.substring(0,tempShowtime.length());
        String returnTemp = "";
         returnTemp = ("Cinema  code is "+ getCinemaCode()+"\n" +"Showtimes :"+getShowtimes().size()+"\n"+tempShowtime);
        return returnTemp;
    }
}
