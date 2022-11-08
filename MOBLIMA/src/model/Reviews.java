package moblima.Model;

import java.io.Serializable;

public class Reviews implements Serializable {
	private String userName;
	private String review;
	private int rating;
	
	public Reviews (String userName,String review,int rating) {
		this.userName = userName;
		this.review=review;
		this.rating=rating;
	}
	
	public String getName() {
		return userName;
	}
	public String getReview() {
		return review;
	}
	public int getrating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating=rating;
	}
	public void setReview(String review) {
		this.review = review;
	}

}
