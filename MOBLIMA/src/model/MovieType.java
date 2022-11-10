package moblima.Model;

/**
 * Movie type to be used
 */
public enum MovieType {
	
	/**
	 * 2D
	 */
	IN_2D("2D"),
	
	
	/**
	 * 3D
	 */
	IN_3D("3D");
	
	/**
	 * Movietype type
	 */
	private final String type;
	
	/**
	 * Construct enum
	 * @param type Movietype
	 */
	private MovieType(String type) {
		this.type = type;
	}
	
	/**
	 * Get enum in string
	 * @return String type
	 */
	public String getType() {
		return type;
	}
	
}
