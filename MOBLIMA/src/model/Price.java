package moblima.Model;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Price implements Serializable{
	
	private double student;
	private double adult;
	private double senior;
	private double weekend;
	private double after6;
	private double _3D;
	
	public Price(double student,double adult,double senior,double weekend,double after6,double _3D) {
		this.student = student;
		this.adult = adult;
		this.senior = senior;
		this.weekend = weekend;
		this.after6 = after6;
		this._3D=_3D;
	}
	
	public Price() {
		this.student = 0;
		this.adult = 0;
		this.senior = 0;
		this.weekend = 0;
		this.after6 = 0;
		this._3D = 0;
		
	}
	
	public void setStudent(double price) {
		this.student=price;
	}
	public void setAdult(double price) {
		this.adult=price;
	}
	public void setSenior(double price) {
		this.senior=price;
	}
	public void setWeekend(double price) {
		this.weekend=price;
	}
	public void setAfter6(double price) {
		this.after6=price;
	}
	public void set3D(double price) {
		this._3D=price;
	}
	public double getStudent() {
		return student;
	}
	public double getAdult() {
		return adult;
	}
	public double getSenior() {
		return senior;
	}
	public double getWeekend() {
		return weekend;
	}
	public double getAfter6() {
		return after6;
	}
	public double get3D() {
		return _3D;
	}
	
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
