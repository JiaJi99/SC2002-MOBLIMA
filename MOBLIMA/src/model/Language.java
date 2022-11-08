package moblima.Model;

public enum Language {
	ENGLISH("English"),
	CHINESE("Chinese"),
	JAPANESE("Japanese");
	
	private final String lang;
	private Language(String lang) {
		this.lang = lang;
	}
	public String getLanguage() {
		return lang;
	}
}
