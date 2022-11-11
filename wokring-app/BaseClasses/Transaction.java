package BaseClasses;



import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Represent a transaction when a movie is booked
 */
@SuppressWarnings("serial")
public class Transaction implements Serializable{
	
	
	/**
	 * The transaction ID
	 */
	private String TID;
	
	/**
	 * The moviegoer username
	 */
	private String userName;
	
	/**
	 * The moviegoer email
	 */
	private String email;
	
	/**
	 * The moviegoer mobile number
	 */
	private String mobileNumber;
	
	/**
	 * The movie that was booked
	 */
	private Movie movie;
	
	
	/**
	 * Create a transaction with the given attributes
	 * @param cinemaCode 		The cinemacode the movie is playing in
	 * @param name				The movie goer username
	 * @param email				The movie goer email
	 * @param mobileNumber		The movie goer mobile number
	 * @param movie				The movie that is booked
	 */
	public Transaction(String cinemaCode,String name, String email, String mobileNumber, Movie movie) {
		String formattedTimestamp = new SimpleDateFormat("YYYYMMddHHmm").format(new Date());
		this.TID = cinemaCode.concat(formattedTimestamp);
		this.userName = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.movie = movie;
	}
	
	
	/**
	 * Get the ID of the transaction
	 * @return String 	This Transaction ID
	 */
	public String getTID() {
		return TID;
	}

	
	/**
	 * Get the movie goer username
	 * @return String  This transaction's username
	 */
	public String getName(){
		return userName;
	}
	
	
	/**
	 * Get the email of the movie goer
	 * @return String 	This Transaction's email
	 */
	public String getEmail(){
		return email;
	}
	
	
	/**
	 * Get movier goer's mobile number
	 * @return String
	 */
	public String getMobileNumber(){
		return mobileNumber;
	}
	
	/**
	 * Get movie which was booked by the user
	 * @return Movie  	This Transaction's movie 
	 */
	public Movie getMovie(){
		return movie;
	}
	
	
	/**
	 * Get the string when Transaction is called
	 * @return String 
	 */
	public String toString(){
		String toReturn = "";
		toReturn 	+= "TID: " + getTID() + "\t"
					+ "Movie: " + getMovie().getTitle() + "\n"
					+ "Name: " + getName() + "\n"
					+ "Mobile number: " + getMobileNumber() + "\n";
		return toReturn; 
	}
}
