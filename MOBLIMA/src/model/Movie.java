package moblima.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;


public class Movie implements Serializable{
	
	private int id;
	private String title;
	private MovieType type;
	private Language lang;
	private MovieAgeCategory ageCat;
	private String synopsis;
	private String director;
	private int runTimeMins;
	private ArrayList<String> cast;
	private ArrayList<Reviews> reviews;
	private LocalDate startDate;
	private LocalDate endDate;
	private MovieStatus status;
	
	//Constructor
	
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
	public int getID() {return id;}
	public String getTitle() {return title;}
	public MovieType getType() {return type;}
	public Language getLang() {return lang;}
	public MovieAgeCategory getAgeCat() {return ageCat;}
	public String getSynopsis() {return synopsis;}
	public String getDirector() {return director;}
	public int getRunTime() {return runTimeMins;}
	public ArrayList<String> getCast(){return cast;}
	public ArrayList<Reviews> getReviews(){return reviews;}
	public LocalDate getStartDate() {return startDate;}
	public LocalDate getEndDate() {return endDate;}
	public MovieStatus getStatus() {return status;}
	
	public String getStartDateToString() {
		return startDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public String getEndDateToString() {
		return endDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	//Set methods
	public void setID(int id) {this.id=id;}
	public void setTitle(String title) {this.title=title;}
	public void setType(MovieType type) {this.type=type;}
	public void setLang(Language lang) {this.lang=lang;}
	public void setAgeCat(MovieAgeCategory ageCat) {this.ageCat = ageCat;}
	public void setSynopsis(String syn) {this.synopsis=syn;}
	public void setDirector(String director) {this.director=director;}
	public void setRunTime(int runTime) {this.runTimeMins=runTime;}
	public void setCast(ArrayList<String> cast) {this.cast=cast;}
	public void setReviews(ArrayList<Reviews> reviews) {this.reviews = reviews;}
	public void setStartDate(LocalDate startDate) {this.startDate = startDate;}
	public void setEndDate(LocalDate endDate) {this.endDate = endDate;}
	public void setMovieStatus(MovieStatus status) {this.status=status;}
	
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