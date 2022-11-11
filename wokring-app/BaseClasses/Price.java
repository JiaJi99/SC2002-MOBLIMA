package BaseClasses;


import java.io.Serializable;
import java.text.DecimalFormat;


/**
 * Represent price of the movie
 */
@SuppressWarnings("serial")
public class Price implements Serializable{
	
	/**
	 * The base price for student
	 */
	private double student;
	
	/**
	 * The base price for adults 
	 */
	private double adult;
	
	/**
	 * The base price for senior
	 */
	private double senior;
	
	/**
	 * The price for weekend ticket
	 */
	private double weekend;
	
	/**
	 * The additional cost for after 6 weekday movie
	 */
	private double after6;
	
	/**
	 * The additional cost for 3D movies
	 */
	private double _3D;
	
	
	/**
	 * Create the price list with the given attributes
	 * @param student 	The base price for student
	 * @param adult		The base price for adult
	 * @param senior	The base price for senior
	 * @param weekend	The base price for weekend
	 * @param after6	The additional price for after 6 movie
	 * @param _3D		The additional price for 3D movie
	 */
	public Price(double student,double adult,double senior,double weekend,double after6,double _3D) {
		this.student = student;
		this.adult = adult;
		this.senior = senior;
		this.weekend = weekend;
		this.after6 = after6;
		this._3D=_3D;
	}
	
	
	/**
	 * Create a default price list
	 */
	public Price() {
		this.student = 7.0;
		this.adult = 8.5;
		this.senior = 4.0;
		this.weekend = 11.0;
		this.after6 = 1.5;
		this._3D = 1.5;
		
	}
	
	
	/**
	 * Set Student price
	 * @param price 	Student price
	 */
	public void setStudent(double price) {
		this.student=price;
	}
	
	/**
	 * Set Adult price
	 * @param price 	Adult price
	 */
	public void setAdult(double price) {
		this.adult=price;
	}
	
	/**
	 * Set senior price
	 * @param price	 senior price
	 */
	public void setSenior(double price) {
		this.senior=price;
	}
	
	
	/**
	 * Set weekend price
	 * @param price 	Weekend price
	 */
	public void setWeekend(double price) {
		this.weekend=price;
	}
	
	
	/**
	 * Set after 6 additional cost
	 * @param price Addition cost for after 6 weekday movie 
	 */
	public void setAfter6(double price) {
		this.after6=price;
	}
	
	
	/**
	 * Set additional price for 3D movie
	 * @param price 	Additional price for 3D movie
	 */
	public void set3D(double price) {
		this._3D=price;
	}
	
	
	/**
	 * Get student price
	 * @return double 	Student price
	 */
	public double getStudent() {
		return student;
	}
	
	
	/**
	 * Get adult price
	 * @return double 	Adult price
	 */
	public double getAdult() {
		return adult;
	}
	
	
	/**
	 * Get senior price
	 * @return double	 senior price
	 */
	public double getSenior() {
		return senior;
	}
	
	
	/**
	 * Get Weekend price
	 * @return double 	weekend price
	 */
	public double getWeekend() {
		return weekend;
	}
	
	
	/**
	 * Get after 6 price modifier
	 * @return double 	After 6 price
	 */
	public double getAfter6() {
		return after6;
	}
	
	
	/**
	 * Get 3D price
	 * @return double 	3D price
	 */
	public double get3D() {
		return _3D;
	}
	
	
	/**
	 * String to return when Price is called
	 * @return String
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		String detail ="";
		detail = "Weekday before 6:\n"
				+ "Student: " + df.format(getStudent())
				+ "\nAdults: "+ df.format(getAdult()) 
				+ "\nSenior: "+ df.format(getSenior()) 
				+ "\nAfter 6 prices: additional " + df.format(getAfter6())
				+ "\nWeekends all day prices: "+ df.format(getWeekend())
				+ "\n3D movies: addional " + df.format(get3D());
				
		return detail;
	}
	
}
