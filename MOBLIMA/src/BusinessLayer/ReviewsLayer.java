package moblima.BusinessLayer;

import moblima.Manager.MoviesCtrl;
import moblima.Model.Movie;
import moblima.customException.ReviewsException.ExistingReviewException;
import moblima.customException.ReviewsException.StarsOutOfRangeException;

public class ReviewsLayer {
	public MoviesCtrl MM = new MoviesCtrl();

	/** 
     * Check if review can be created based on parameters passed
     * @param movie                 Name of movie that this review will be added to
     * @param username              Username of the movie's reviewer
     * @param numOfStars            Number of stars given by reviewer
     * @param additionalComment     Addition remark given by reviewer (optional)
     * @return boolean
     */
	public static boolean isReviewValid(Movie movie, String username, int numOfStars, String additionalComment) {

        boolean isValid = true;

        if (isNumOfStarsinValid(numOfStars) == true)
            isValid = false;

        if (isExistingReview(movie, username))
            isValid = false;

        return isValid;
    }

	 /** 
     * Check if reviewer has already given his/her review for the movie
     * @param movie     Movie to check for
     * @param username  Username of reviewer to check for
     * @return boolean  Return true if review already exist, else false
     */
    public static boolean isExistingReview(Movie movie, String username) {
    	for (int i=0;i<movie.getReviews().size();i++) {
    		if(movie.getReviews().get(i).getName()==username) {
    			try{
    				throw new ExistingReviewException();
    			} catch (ExistingReviewException e) {
    				System.out.println(e.getMessage());
    			}
    				return true;
    			}
    		}
    	return false;
    
    }

    
    /** 
     * Check if the number of stars given by the reviewer is in the valid range
     * @param numOfStars    Number of stars given by reviewer
     * @return boolean      Return true if number of stars given is in invalid range, else false
     */
    public static boolean isNumOfStarsinValid(int numOfStars) {
        if (numOfStars < 0 || numOfStars > 5) {
            try {
                throw new StarsOutOfRangeException();
            } catch (StarsOutOfRangeException e) {
                System.out.println(e.getMessage());
            }
            return true;
        } else {
            return false;
        }
    }
}
	

