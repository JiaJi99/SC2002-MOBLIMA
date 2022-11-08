/**
 * 
 */
package moblima.Model;


import java.util.ArrayList;


/**
 * @author
 *
 */
public class Cineplex {
	
	private String cinePlexStr; //name of cinema cineplex
	private ArrayList<Cinemas> cinePlex; //dynamic list for cinemas created
	
	public Cineplex()
	{
		this.cinePlexStr = "";
		this.cinePlex = new ArrayList<Cinemas>();
	}
	
	public Cineplex(String cinePlexStr)
	{
		this.cinePlexStr = cinePlexStr;
		this.cinePlex = new ArrayList<Cinemas>();
	}
	
	public Cineplex(String cinePlexStr, ArrayList<Cinemas> cinemas) {
		this.cinePlexStr=cinePlexStr;
		this.cinePlex=cinemas;
	}

	
	public void addtoCineplex(Cinemas cinemas)
	{
		this.cinePlex.add(cinemas);
	}
	
	public ArrayList<Cinemas> getWholeCineplex()
	{
		return cinePlex;
	}
	
	public void setCineplexName(String newName)
	{
		this.cinePlexStr = newName;
	}
	
	public void setCinePlex(ArrayList<Cinemas> cinePlex) {
		this.cinePlex=cinePlex;
	}
	
	public String getCineplexName()
	{
		return cinePlexStr;
	}
	
}
