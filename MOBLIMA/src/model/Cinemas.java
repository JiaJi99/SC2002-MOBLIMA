package moblima.Model;

//import moblima.*;
import java.io.Serializable;
import java.util.ArrayList;


public class Cinemas implements Serializable {
    private String cinemaCode ;
    private SeatPlan seatPlan ;
    private ArrayList<Sessions> showTimes;

    public Cinemas(String cinemaCode, SeatPlan seatPlan ){
        this.cinemaCode= cinemaCode;
        this.seatPlan = seatPlan;
        this.showTimes = new ArrayList<Sessions>();
    }


    public String getCinemaCode(){
        return cinemaCode;
    }

    public void setCinemaCode(String cinemaCode ){
        this.cinemaCode = cinemaCode;
    }


    public void setSeatPlan(SeatPlan seatPlan ){
        this.seatPlan = seatPlan;
    }

    public SeatPlan getSeatPlan(){
        return seatPlan;
    }

    public ArrayList<Sessions> getShowtimes(){
        return showTimes;
    }

    public void setShowTimes (ArrayList<Sessions> showTimes){
        this.showTimes = showTimes;
    }

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