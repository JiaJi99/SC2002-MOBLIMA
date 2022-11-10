package moblima.Model;

import java.io.Serializable;


/**
 * Represent a review
 */
@SuppressWarnings("serial")
public class Reviews implements Serializable {
	
	/**
	 * The reviews reviewer
	 */
	private String userName;
	
	/**
	 * This Review's review
	 */
	private String review;
	
	/**
	 * movie's rating (1-5)
	 */
	private int rating;
	
	
	/**
	 * Create a review with the given attributes
	 * @param userName 	The movie goer username
	 * @param review	This review's review
	 * @param rating	movie rating
	 */
	public Reviews (String userName,String review,int rating) {
		this.userName = userName;
		this.review=review;
		this.rating=rating;
	}
	
	
	/**
	 * Get moviegoer username
	 * @return String 	this review' username
	 */
	public String getName() {
		return userName;
	}
	
	
	/**
	 * Get this review's review
	 * @return String 	this review's review
	 */
	public String getReview() {
		return review;
	}
	
	
	/**
	 * Get review rating
	 * @return int 	this movie's rating
	 */
	public int getrating() {
		return rating;
	}
	
	
	
	/**
	 * Set rating for movie
	 * @param rating 	this movie rating
	 */
	public void setRating(int rating) {
		this.rating=rating;
	}
	
	/**
	 * Set review for movie
	 * @param review 	this movie review
	 */
	public void setReview(String review) {
		this.review = review;
	}

}
