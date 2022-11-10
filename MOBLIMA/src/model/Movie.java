package moblima.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;

/**
 * Represent a movie
 */
@SuppressWarnings("serial")
public class Movie implements Serializable{
	
	/**
	 * This movie's unique ID
	 */
	private int id;
	
	/**
	 * This movie's title
	 */
	private String title;
	
	/**
	 * This movie's MovieType
	 */
	private MovieType type;
	
	/**
	 * This movie's Language
	 */
	private Language lang;
	
	/**
	 * This movie's AgeCategory
	 */
	private MovieAgeCategory ageCat;
	
	/**
	 * This movie's synopsis
	 */
	private String synopsis;
	
	/**
	 * This movie's director
	 */
	private String director;
	
	/**
	 * This movie's runtime in minutes 
	 */
	private int runTimeMins;
	
	/**
	 * This movie's list of Cast
	 */
	private ArrayList<String> cast;
	
	/**
	 * This movie's list of review and rating
	 */
	private ArrayList<Reviews> reviews;
	
	/**
	 * This movie's release date
	 */
	private LocalDate startDate;
	
	/**
	 * This movie's last screen date
	 */
	private LocalDate endDate;
	
	/**
	 * This movie's status
	 */
	private MovieStatus status;
	
	//Constructor
	/**
	 * Create a movie with the given attributes
	 * @param id 			This movie's unique ID
	 * @param title			This movie's title
	 * @param type			This movie's MovieType
	 * @param lang			This movie's Language
	 * @param ageCat		This movie's age Category
	 * @param synopsis		This movie's synopsis
	 * @param director		This movie's director
	 * @param runTimeMins	This movie's run time in minutes
	 * @param cast			This movie's list of cast member
	 * @param startDate		This movie's release date
	 * @param endDate		This movie's last screen date
	 */
	public Movie(int id,String title, MovieType type, Language lang, 
			     MovieAgeCategory ageCat, String synopsis, String director,
			     int runTimeMins, ArrayList<String> cast,
			     LocalDate startDate,LocalDate endDate) {
		this.id = id;
		this.title = title;
		this.type = type;
		this.lang = lang;
		this.ageCat = ageCat;
		this.synopsis = synopsis;
		this.director = director;
		this.runTimeMins = runTimeMins;
		this.cast = cast;
		this.reviews = new ArrayList<Reviews>();
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = this.ShowStatus();
	}
	
	//Get Methods
	
	/**
	 * Get this movie's unique ID
	 * @return int This movie's unique ID
	 */
	public int getID() {
		return id;
		}
	
	
	/**
	 * Get this movie's title
	 * @return String 	This movie's title
	 */
	public String getTitle() {
		return title;
		}
	
	
	/**
	 * Get this movie's MovieType
	 * @return MovieType 	This movie's movie type
	 */
	public MovieType getType() {
		return type;
		}
	
	
	/**
	 * Get this movie's language
	 * @return Language 	This movie's language	
	 */
	public Language getLang() {return lang;}
	
	
	/**
	 * Get this movie's age category
	 * @return MovieAgeCategory 	This movie's age category
	 */
	public MovieAgeCategory getAgeCat() {
		return ageCat;
		}
	
	
	/**
	 * Get this movie's synopsis 
	 * @return String 	This movie's synopsis
	 */
	public String getSynopsis() {
		return synopsis;
		}
	
	
	/**
	 * Get This movie's director
	 * @return String 	This movie's director
	 */
	public String getDirector() {
		return director;
		}
	
	
	/**
	 * Get this movie's runtime in minutes
	 * @return int 	This movie's runtime in minutes
	 */
	public int getRunTime() {
		return runTimeMins;
		}
	
	
	/**
	 * Get this movie's list of cast
	 * @return ArrayList<String> 	this movie's list of cast
	 */
	public ArrayList<String> getCast(){
		return cast;
		}
	
	
	/**
	 * Get this movie's list of review and rating
	 * @return model.{@link Reviews} 	this movie's list of review and rating
	 */
	public ArrayList<Reviews> getReviews(){
		return reviews;
		}
	
	
	/**
	 * Get this movie's start date
	 * @return LocalDate 	This movie's start date
	 */
	public LocalDate getStartDate() {
		return startDate;
		}
	
	
	/**
	 * Get this movie's end date
	 * @return LocalDate 	This movie's end date
	 */
	public LocalDate getEndDate() {
		return endDate;
		}
	
	
	/**
	 * Get this movie's current status
	 * @return MovieStatus  	This Movie's status
	 */
	public MovieStatus getStatus() {return status;}
	
	
	
	/**
	 * Get this movie's start date in a String format
	 * @return String 	This movie's start date
	 */
	public String getStartDateToString() {
		return startDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	
	/**
	 * Get this movie's end date in a String format
	 * @return String 	This movie's end date
	 */
	public String getEndDateToString() {
		return endDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	//Set methods
	
	
	
	/**
	 * Set the ID of this movie
	 * @param id	This movie's ID
	 */
	public void setID(int id) {
		this.id=id;
		}
	
	
	/**
	 * Set the title of this movie
	 * @param title 	this movie's title
	 */
	public void setTitle(String title) {
		this.title=title;
		}
	
	
	/**
	 * Set the type of this movie
	 * @param type  	this movie's type
	 */
	public void setType(MovieType type) {
		this.type=type;
		}
	
	
	/**
	 * Set the language of his movie
	 * @param langaguage 	This movie's language
	 */
	public void setLang(Language language) {
		this.lang=language;
		}
	
	
	/**
	 * Set the movie's age category
	 * @param ageCat 	This movie's age category
	 */
	public void setAgeCat(MovieAgeCategory ageCat) {
		this.ageCat = ageCat;
		}
	
	
	/**
	 * Set the movie's synopsis
	 * @param synopsis 	This movie's synopsis
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis=synopsis;
		}
	
	
	/**
	 * Set the movie's director
	 * @param director 	This movie's director
	 */
	public void setDirector(String director) {
		this.director=director;
		}
	
	
	/**
	 * Set the movie's runtime
	 * @param runTime This movie's run time in minutes
	 */
	public void setRunTime(int runTime) {
		this.runTimeMins=runTime;
		}
	
	
	/**
	 * Set the movie's list of cast
	 * @param cast 	This movie's list of cast
	 */
	public void setCast(ArrayList<String> cast) {
		this.cast=cast;
		}
	
	
	/**
	 * Set the movie's list of Reviews
	 * @param reviews		This movie's list of reviews
	 */
	public void setReviews(ArrayList<Reviews> reviews) {
		this.reviews = reviews;
		}
	
	
	/**
	 * Set the movie's start date
	 * @param startDate 	This movie's start date
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
		}
	
	
	/**
	 * Set the movie's end date
	 * @param endDate 	This movie's end date
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
		}
	
	
	/**
	 * Set the movie status
	 * @param status 	This movie's status
	 */
	public void setMovieStatus(MovieStatus status) {this.status=status;}
	
	
	
	/** 
	 * String to return when this Movie is being called
	 * @return String
	 */
	public String toString() {
		String castString = "";
		for (int i=0;i<getCast().size();i++) {
			castString = castString.concat(getCast().get(i) + ", ");
		}
		castString = castString.substring(0, castString.length()-2);
		
		String reviews = "";
		for(int i=0;i<getReviews().size();i++) {
			reviews = reviews.concat(getReviews().get(i).getReview()) + "\n\n";
		}
		if (reviews == "") {reviews ="N/A";}
		else{
			reviews = reviews.substring(0,reviews.length()-1);
		}
		
		
		String details;
		details = "Title: " + getTitle() + "\n"
				+ "Type: " + getType() + "\n"
				+ "Dates: " + getStartDateToString() + " to " + getEndDateToString() +"\n"
				+ "Language: " + getLang() + "\n"
				+ "Age Category: " + getAgeCat() + "\n"
				+ "Synopsis: "+ getSynopsis() + "\n"
				+ "Duration: " + getRunTime() + "\n"
				+ "Director: " + getDirector() + "\n"
				+ "Cast members: " + castString + "\n"
				+ "Overall Rating: " + avgRating() + "\n"
				+ "Reviews: \n" + reviews + "\n"; 
		return details;
	}
	
	
	/**
	 * Get the movie avg rating in String format
	 * @return	String 	return average rating if reviews list size > 1,else return "NA"
	 */
	public String avgRating() {
		double avg_rating = 0.0f;
		int count = 0;
		for(int i=0;i<this.getReviews().size();i++) {
			avg_rating += this.getReviews().get(i).getrating();
			count++;
		}
		if (count == 0) {
			return "N/A";
		}
		avg_rating /= count;
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format(avg_rating);
		
	}

	//For sorting
	/** 
     * Compare and check if object is identical to this Movie
     * @param movie     item to be compared to
     * @return boolean  Return true if item is identical to this Movie, else false
     */
	public boolean equals(Object movie) {
		if (this.getClass() == movie.getClass()) {
			Movie other = (Movie) movie;
			return 
				this.title == other.getTitle()
				&& this.type == other.getType()
				&& this.lang == other.getLang()
				&& this.ageCat == other.getAgeCat()
				&& this.synopsis == other.getSynopsis()
				&& this.director == other.getDirector()
				&& this.cast == other.getCast()
				&& this.runTimeMins == other.getRunTime()
				&& this.startDate == other.getStartDate()
				&& this.endDate == other.getEndDate();
				
		}				
		return false;
	}
 
	/**
	 * Get the movie status with this movie's start and end date
	 * Movie status is determine by today date, movie's start date and end date
	 * If today's date is after movie's end date, return END_OF_SHOW,
	 * Else if today's date is <7 days before start date, return PREVIEW
	 * Else if today's date is between start date and end date, return NOW_SHOWING 
	 * Else, return COMING_SOON
	 * @return MovieStatus 	Movie's status based on this movie's start and end date
	 */
	public MovieStatus ShowStatus() {
		LocalDate now = LocalDate.now();
		if (now.isAfter(endDate)) {
			return MovieStatus.END_OF_SHOW;
		}
		else if(now.isAfter(startDate) && now.isBefore(endDate)){
			return MovieStatus.NOW_SHOWING;
		}
		else {
			float daysBetween = Duration.between(now.atStartOfDay(), startDate.atStartOfDay()).toDays();
			if (daysBetween <= 7) {
				return MovieStatus.PREVIEW;
			}
			else {
				return MovieStatus.COMING_SOON;
			}
		}
	}

}
