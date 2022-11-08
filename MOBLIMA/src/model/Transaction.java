package moblima.Model;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction implements Serializable{
	
	private String TID;
	private String userName;
	private String email;
	private String mobileNumber;
	private Movie movie;
	
	public Transaction(String cinemaCode,String name, String email, String mobileNumber, Movie movie) {
		String formattedTimestamp = new SimpleDateFormat("YYYYMMddHHmm").format(new Date());
		this.TID = cinemaCode.concat(formattedTimestamp);
		this.userName = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.movie = movie;
		
	}
	
	public String getTID() {
		return TID;
	}

	public String getName(){
		return userName;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getMobileNumber(){
		return mobileNumber;
	}
	
	public Movie getMovie(){
		return movie;
	}
	public String toString(){
		String toReturn = "";
		toReturn 	+= "TID: " + getTID() + "\t"
					+ "Movie: " + getMovie().getTitle() + "\n"
					+ "Name: " + getName() + "\n"
					+ "Mobile number: " + getMobileNumber() + "\n";
		return toReturn; 
	}
}
