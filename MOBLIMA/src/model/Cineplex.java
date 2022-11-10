package moblima.Model;


import java.util.ArrayList;
import java.io.Serializable;

/**
 * Represent a cineplex
 * A Cineplex has a list of cinemas and the name of cineplex
 */

@SuppressWarnings("serial")
public class Cineplex implements Serializable{
	
	/**
	 * This Cineplex's name
	 */
	private String cinePlexStr; //name of cinema cineplex
	
	/**
	 * This cineplex's list of cinemas
	 */
	private ArrayList<Cinemas> cinePlex; //dynamic list for cinemas created
	
	
	/**
	 * Creates a cineplex with empty values
	 */
	public Cineplex()
	{
		this.cinePlexStr = "";
		this.cinePlex = new ArrayList<Cinemas>();
	}
	
	
	/**
	 * Create a cineplex with empty list of cinemas
	 * @param cinePlexStr 	This cineplex's name
	 */
	public Cineplex(String cinePlexStr)
	{
		this.cinePlexStr = cinePlexStr;
		this.cinePlex = new ArrayList<Cinemas>();
	}
	
	
	/**
	 * Creates a cineplex with the given attributes
	 * @param cinePlexStr 	This Cineplex's name
	 * @param cinePlex 		This Cineplex's list of cinemas
	 */
	public Cineplex(String cinePlexStr, ArrayList<Cinemas> cinemas) {
		this.cinePlexStr=cinePlexStr;
		this.cinePlex=cinemas;
	}

	
	/**
	 * Add a new cinemas to This cineplex's list of cinemas
	 * @param cinemas		New Cinemas of this Cineplex's list of cinemas
	 */
	public void addtoCineplex(Cinemas cinemas)
	{
		this.cinePlex.add(cinemas);
	}
	
	
	/**
	 * Get this Cineplex's list of Cinemas
	 * @return Model.(@link Cinemas} this Cineplex's list of cinemas
	 */
	public ArrayList<Cinemas> getWholeCineplex()
	{
		return cinePlex;
	}
	
	
	/**
	 * Set newName for this Cineplex
	 * @param newName 	This cineplex's new name
	 */
	public void setCineplexName(String newName)
	{
		this.cinePlexStr = newName;
	}
	
	
	/**
	 * Set new list of Cinemax for this Cineplex
	 * @param cinePlex 	This cineplex's new list of cinemas
	 */
	public void setCinePlex(ArrayList<Cinemas> cinePlex) {
		this.cinePlex=cinePlex;
	}
	
	
	/**
	 * Get Cineplex's name
	 * @return String	This cineplex's Name
	 */
	public String getCineplexName()
	{
		return cinePlexStr;
	}
	
}
