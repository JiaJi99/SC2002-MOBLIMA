package UserInterface;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import BaseClasses.Movie;
import ManagerClasses.*;
//import moblima.Manager.MoviesCtrl;

public class MovieDetailViewUI {
	 
	Scanner sc = new Scanner(System.in);
	/**
	 * Controller that this UI will reference
	 */
	private MoviesCtrl moviesCtrl;
	
	public MovieDetailViewUI() {
		
		this.moviesCtrl = new MoviesCtrl();
		
	}
	
	public MovieDetailViewUI(MoviesCtrl moviesCtrl) {
		
		this.moviesCtrl = moviesCtrl;		
		
	}
	
	
	/**
	 * To display movie detail UI
	 */
	public void main() {
		
		displayIntro_MovieDetail();

		displayUI_MovieDetail();
		
		displayExit_MovieDetail();
		
	}
	
	/**
	 * Displays header for movie details UI
	 */
	public void displayIntro_MovieDetail()
	{
		System.out.println("==========================");
		System.out.println("||	    Welcome to 		||");
		System.out.println("||	 Movie Detail View 	||");
		System.out.println("|| 		  Section 		||");
		System.out.println("==========================");
		
	}
	
	
	/**
	 * Display footer for movie detail UI
	 */
	public void displayExit_MovieDetail()
	{
		System.out.println("\nThank you for using the Movie Details Section...\n");

		System.out.println("==========================");
		System.out.println("||	    Exiting the 	||");
		System.out.println("||	 Movie Detail View 	||");
		System.out.println("|| 		  Section 		||");
		System.out.println("==========================");
	}

	/**
	 * Display and get user input to select actions for movie detail UI
	 */
	public void displayUI_MovieDetail(){
		int choice;
		
		displayChoices_MovieDetail();
		
		do{
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			if (choice<1 || choice>3) {
				System.out.println(choice + " is not a valid choice: ");
				displayChoices_MovieDetail();
			} 
		}while (choice<1 || choice>3);
		
		switch(choice) {
			case 1: System.out.println("By providing a Movie-ID, all the Movie Details will be retrieved: ");
					System.out.println("Enter a Movie-ID: ");
					
					int movieID = retrieveMovieID();
					Movie selectedMovie = moviesCtrl.readByID(movieID);

					displayAll_MovieDetail(selectedMovie);
		        	break;
		        	
			case 2:	displayAttributesChoices_MovieDetail();
					System.out.println("By providing a Attribute Choice, all the Movie Details will be retrieved: ");
					System.out.println("Enter a Attribute Choice: ");
			
					int movieID1 = retrieveMovieAttr();
					
					System.out.println("Enter Pharse to search: ");
					String searchTerm = sc.nextLine(); 
					
					ArrayList<Movie> selectedMovies = moviesCtrl.readByAttribute(movieID1, searchTerm);
					displayAll_MovieDetails(selectedMovies);
				
			case 3: break;
		}

	}
	
	/**
	 * Display menu for selection of searching movie
	 */
	public void displayAttributesChoices_MovieDetail()
	{
		System.out.println("==========================================");
		System.out.println("|| 1. Search Movie via Title Name		||");
		System.out.println("|| 2. Search Movie via Age Category	Type||");
		System.out.println("|| 3. Search Movie via MOVIE START DATE	||");
		System.out.println("|| 4. Search Movie via MOVIE END DATE	||");
		System.out.println("==========================================");
		
	}
	
	
	/**
	 * To display all movie details in given list of movie
	 *@param selectedMovies  	list of movies's detail to be display
	 */
	public void displayAll_MovieDetails(ArrayList<Movie> selectedMovies){
		
		
		if(!selectedMovies.isEmpty())
		{
			System.out.println("======================================");
			System.out.println("|| 	 ||Found All Movie Details||    ||");
			
			for(int i=0; i<selectedMovies.size(); i++)
			{
				System.out.printf("|| Movie %d: 	%s	\n", (i+1), selectedMovies.get(i).toString());
			}
			System.out.println("======================================");
		}
		else
		{
			System.out.println("\nThis Movie does not Exist in the database");
			System.out.println("Exiting now.\n");
		}
	}
	
	
	/**
	 * To get user to select movie attributes return a constant that represent the attributes for access
	 *@return int  Return constant for selection of movie attributes
	 */
	public int retrieveMovieAttr()
	{
		boolean isMovieIDValid = false;
		int input =-1;
		
        
        while(!isMovieIDValid)
        {
        	input = sc.nextInt();
        	if(input>0 && input<5)
        	{
        		isMovieIDValid = true;
        		System.out.println("\nValue inputted Correctly...\n");
        		
        	}
        	else
        	{
        		System.out.println("Int Value inputted incorrectly...");
        		System.out.println("Re-Enter Value(in int form):");
        	}
        }
        
        if(input == 3) //movie start date so need to return 9 as  public final static int MOVIE_START_DATE = 9;
        { input = 9; }
        else if(input == 4) //movie end date so need to return 10 as public final static int MOVIE_END_DATE = 10;
        { input = 10; }
        
        return input;
	}
	
	
	
	/**
	 * To get and return MovieID
	 *@return int  Return Movie'sID if valid, else loop
	 */
	public int retrieveMovieID()
	{
		boolean isMovieIDValid = false;
		int input=-1;
		
        
        while(!isMovieIDValid)
        {
        	if(sc.hasNextInt())
        	{
        		input = sc.nextInt();
        		isMovieIDValid = true;
        		System.out.println("\nValue inputted Correctly...\n");
        		
        	}
        	else
        	{
        		System.out.println("Int Value inputted incorrectly...");
        		System.out.println("Re-Enter Value(in int form):");
        	}
        }
        
        return input;
	}
	
	
	
	/**
	 * Display detail of given movie
	 *@param selectedMovie  	movie to be printed
	 */
	public void displayAll_MovieDetail(Movie selectedMovie)
	{
		
		if(selectedMovie != null)
		{
			String movieDetails = selectedMovie.toString();
			System.out.println("======================================");
			System.out.println("|| 	   ||Found Movie Details||	    ||");
			System.out.printf("|| Movie:	%s  ", movieDetails);
			System.out.println("======================================");
			
		}
		else
		{
			System.out.println("\nThis Movie does not Exist in the database");
			System.out.println("Exiting now.\n");
		}
	}
	
	
	/**
	 * Display movie detail UI
	 */
	public void displayChoices_MovieDetail() {
		System.out.println("==========================================");
		System.out.println("|| 1. Search Movie via Movie ID		||");
		System.out.println("|| 2. Search Movie via Movie Attribute	||");
		System.out.println("|| 3. Back					||");
		System.out.println("==========================================");
	}

	
	
	
	
	

}
