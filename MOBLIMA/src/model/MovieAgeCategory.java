package moblima.Model;

public enum MovieAgeCategory {
	E("E"),
	PG("PG-13"),
	NC("NC-16"),
	M("M-18"),
	R("R-21");
	
	private final String ageCategory;
	private MovieAgeCategory(String cat) {
		this.ageCategory = cat;
	}
	public String getCat() {
		return ageCategory;
	}

}
