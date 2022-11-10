package moblima.Model;

/** 
 * Language that can be used
 */
public enum Language {
	/**
	 * English Language
	 */
	ENGLISH("English"),
	
	/**
	 * Chinese Language
	 */
	CHINESE("Chinese"),
	
	/**
	 * Japanese Language
	 */
	JAPANESE("Japanese");
	
	/**
	 * This Language string 
	 */
	private final String lang;
	
	/**
	 * Create String to assciate with the enum
	 *@param lang  This Language's langage
	 */
	private Language(String lang) {
		this.lang = lang;
	}
	
	/**
	 * Get Langage string
	 *@return String	This language string
	 */
	public String getLanguage() {
		return lang;
	}
}
