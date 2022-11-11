package BaseClasses;

/**
 *MovieStatus to use
 */
public enum MovieStatus {
	
	/**
	 * Coming soon
	 */
	COMING_SOON("Coming soon"),
	
	/**
	 * Preview
	 */
	PREVIEW("Preview"),
	
	/**
	 * Now Showing
	 */
	NOW_SHOWING("Now Showing"),
	
	/**
	 * End of show
	 */
	END_OF_SHOW("End of Show");
	
	
	/**
	 * This MovieStatus in string
	 */
	private final String status;
	
	/**
	 * Create new movie Status
	 * @param status this status status
	 */
	private MovieStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Get Status string
	 * @return String status 
	 */
	public String getStatus() {return status;}
}
