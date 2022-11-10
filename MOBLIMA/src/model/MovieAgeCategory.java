package moblima.Model;


/**
 * MovieAgeCategory that can be used
 */
public enum MovieAgeCategory {
	
	/**
	 * Everyone
	 */
	E("E"),
	
	
	/**
	 * PG-13
	 */
	PG("PG-13"),
	
	/**
	 * NC-16
	 */
	NC("NC-16"),
	
	/**
	 * M-18
	 */
	M("M-18"),
	
	
	/**
	 * R-21
	 */
	R("R-21");
	
	
	/**
	 * This movie age Category in string
	 */
	private final String ageCategory;
	
	
	/**
	 *Set  MovieAgeCategory
	 *@param String  This agecategory's category
	 */
	private MovieAgeCategory(String cat) {
		this.ageCategory = cat;
	}
	
	
	/**
	 *Get Movie age category
	 *@return String agecategory
	 */
	public String getCat() {
		return ageCategory;
	}

}
