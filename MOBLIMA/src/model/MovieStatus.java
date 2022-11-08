package moblima.Model;

public enum MovieStatus {
	COMING_SOON("Coming soon"),
	PREVIEW("Preview"),
	NOW_SHOWING("Now Showing"),
	END_OF_SHOW("End of Show");
	
	private final String status;
	
	private MovieStatus(String status) {
		this.status = status;
	}
	public String getStatus() {return status;}
}
