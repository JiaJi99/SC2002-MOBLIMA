package moblima.BusinessLayer;

import java.time.LocalDate;
import java.util.ArrayList;

import moblima.Model.Language;
import moblima.Model.Movie;
import moblima.Model.MovieAgeCategory;
import moblima.Model.MovieType;
import moblima.customException.MovieException.EmptyCastException;
import moblima.customException.MovieException.EmptyStringException;
import moblima.customException.MovieException.EndBeforeReleaseException;
import moblima.customException.MovieException.ExistingMovieException;
import moblima.customException.MovieException.NegativeDurationException;
import moblima.customException.MovieException.NegativeNumberException;
import moblima.customException.MovieException.OutofRangeException;


public class MoviesLayer {
	
	public static boolean isMovieValid(String title, MovieType type, Language lang, 
			     MovieAgeCategory ageCat, String synopsis, String director,
			     int runTimeMins, ArrayList<String> cast,
			     LocalDate startDate,LocalDate endDate){
		boolean isValid = true;
            
        if (isEmpty_title(title))
            isValid = false;

        if (isEmpty_synopsis(synopsis))
            isValid = false;

        if (isDurationNegative(runTimeMins))
            isValid = false;

        if (areDatesValid(startDate, endDate) == false) 
            isValid = false;

        if (isEmpty_director(director))
            isValid = false;

        if (isEmpty_cast(cast))
            isValid = false;
        
        return isValid;
    }
	
	 /** Check if movie exist based on movieList
     * @param title     Movie's object to check for
     * @return boolean  Return true if movie already exist, else false
     */
    public static boolean isExistingMovie(Movie movie,ArrayList<Movie> movieList) {
    	for(int i=0;i<movieList.size();i++) {
    		if (movie.equals(movieList.get(i))) {
    			try {
    				throw new ExistingMovieException();
    			} catch (ExistingMovieException e) {
    				System.out.println(e.getMessage());
    			}
    			return true;
    		}
    	}
        return false;
    }
    
    /** Check if movie's title is empty
     * @param title     Movie's title to check for
     * @return boolean  Return true if movie's title is empty, else false
     */
    public static boolean isEmpty_title(String title) {
        if (isStringEmpty(title)){
            try {
                throw new EmptyStringException("Title cannot be empty");
            } catch (EmptyStringException e) {
                System.out.println(e.getMessage());
            }
            return true;
        } else {
            return false;
        }
    }
    

    
    /** Check if movie's synopsis is empty
     * @param synopsis  Movie's synopsis to check for
     * @return boolean  Return true if movie's synopsis is empty, else false
     */
    public static boolean isEmpty_synopsis(String synopsis) {
        if (isStringEmpty(synopsis)){
            try {
                throw new EmptyStringException("Synopsis cannot be empty");
            } catch (EmptyStringException e) {
                System.out.println(e.getMessage());
            }
            return true;
        } else {
            return false;
        }
    }

    
    /** Check if movie's review is empty
     * @param rating    Movie's review to check for
     * @return boolean  Return true if movie's review is empty, else false
     */
    public static boolean isEmpty_review(String review) {
        if (isStringEmpty(review)){
            try {
                throw new EmptyStringException("review cannot be empty");
            } catch (EmptyStringException e) {
                System.out.println(e.getMessage());
            }
            return true;
        } else {
            return false;
        }
    }

    
    /** Check if movie's duration is negative
     * @param duration  Movie's duration to check for
     * @return boolean  Return true if movie's duration is negative, else false
     */
    public static boolean isDurationNegative(int duration){
        if (duration < 0){
            try {
                throw new NegativeDurationException();
            } catch (NegativeDurationException e) {
                System.out.println(e.getMessage());
            }
            return true;
        } else {
            return false;
        }
    }
    
    /** Check if input integer is negative
     * @param duration  input to check for
     * @return boolean  Return true if input is negative, else false
     */
    public static boolean isNumberNegative(int number){
        if (number < 0){
            try {
                throw new NegativeNumberException();
            } catch (NegativeNumberException e) {
                System.out.println(e.getMessage());
            }
            return true;
        } else {
            return false;
        }
    }

    
    /** Check if movie's end date is before the release date
     * @param movieReleaseDate  Movie's release date to check for
     * @param movieEndDate      Movie's end date to check for
     * @return boolean          Return true if end date is before release date, else false
     */
    public static boolean areDatesValid(LocalDate movieReleaseDate, LocalDate movieEndDate){
        if (movieReleaseDate.isBefore(movieEndDate)){
            return true;
        } else {
            try {
                throw new EndBeforeReleaseException();
            } catch (EndBeforeReleaseException e) {
                System.out.println(e.getMessage());
            }
            return false;
        }
    }

    
    /** Check if movie's director is empty
     * @param director  Movie's director to check for
     * @return boolean  Return true if movie's director is empty, else false
     */
    public static boolean isEmpty_director(String director) {
        if (isStringEmpty(director)){
            try {
                throw new EmptyStringException("director cannot be empty");
            } catch (EmptyStringException e) {
                System.out.println(e.getMessage());
            }
            return true;
        } else {
            return false;
        }
    }
    
    /** Check if movie's cast is empty
     * @param cast Movie's cast to check for
     * @return boolean Return true if movie's cast is empty, else false
     */
    public static boolean isEmpty_Cast(String cast) {
    	if(isStringEmpty(cast)) {
    		try {
    			throw new EmptyStringException("cast cannot be empty");
    		} catch (EmptyStringException e) {
    			System.out.println(e.getMessage());
    		}
    		return true;
    	} else {
    		return false;
    	}
    }
    
    /** Check if movie's list of cast is empty
     * @param cast      Movie's list of cast to check for
     * @return boolean  Return true if movie's list of cast is empty, else false
     */
    public static boolean isEmpty_cast(ArrayList<String> cast) {
        if (cast.isEmpty()){
            try {
                throw new EmptyCastException();
            } catch (EmptyCastException e) {
                System.out.println(e.getMessage());
            }
            return true;
        } else {
            return false;
        }
    }
    
 
    
    public static boolean isCastSmall(int size) {
    	if(size<2) {
    		try {
    			throw new EmptyStringException("Cast size must be at least 2");
    		} catch (EmptyStringException e) {
    			System.out.println(e.getMessage());
    		}
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    
    /** 
     * Check if a string is empty
     * @param item      String to check for
     * @return boolean  Return true if string is empty, else false
     */
    private static boolean isStringEmpty(String item) {
        return item.equals("");
    }

    
    /**
     * check if integer is out of range
     * @param i integer i is outside ArrayList.size to check for
     * @return boolean Return true if outside index, else false
     */
    public static boolean isOutofRange(int choice,int size) {
    	if(choice > size|| choice<0) {
			try{
				throw new OutofRangeException();
			} catch (OutofRangeException e) {
				System.out.println(e.getMessage());
			}
		return true;
		} else {
		return false;
		}
    }

	
    	
  
	
}
