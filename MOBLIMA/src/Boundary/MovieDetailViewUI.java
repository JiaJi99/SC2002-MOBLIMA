package sc2002ProjUI;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import moblima.Manager.*;
//import moblima.Manager.MoviesCtrl;

public class MovieDetailViewUI {
	
	Scanner sc = new Scanner(System.in);
	
	private MoviesCtrl moviesCtrl;
	
	public MovieDetailViewUI() {
		
		this.moviesCtrl = new MoviesCtrl();
		
	}
	
	public MovieDetailViewUI(MoviesCtrl moviesCtrl) {
		
		this.moviesCtrl = moviesCtrl;		
		
	}
	
	public void main() {
		
		displayIntro_MovieDetail();

		displayUI_MovieDetail();
		
		displayExit_MovieDetail();
		
	}
	
	
	public void displayIntro_MovieDetail()
	{
		System.out.println("==========================");
		System.out.println("||	    Welcome to 		||");
		System.out.println("||	 Movie Detail View 	||");
		System.out.println("|| 		  Section 		||");
		System.out.println("==========================");
		
	}
	
	public void displayExit_MovieDetail()
	{
		System.out.println("\nThank you for using the Movie Details Section...\n");

		System.out.println("==========================");
		System.out.println("||	    Exiting the 	||");
		System.out.println("||	 Movie Detail View 	||");
		System.out.println("|| 		  Section 		||");
		System.out.println("==========================");
	}

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
					
					ArrayList<Movie> selectedMovies = moviesCtrl.readByID(movieID1, searchTerm);
					displayAll_MovieDetails(selectedMovies);
				
			case 3: break;
		}

	}
	
	public void displayAttributesChoices_MovieDetail()
	{
		System.out.println("==========================================");
		System.out.println("|| 1.  Search Movie via Title Name		||");
		System.out.println("|| 2.  Search Movie via Type			||");
		System.out.println("|| 3.  Search Movie via Age Category	||");
		System.out.println("|| 4.  Search Movie via Synopsis		||");
		System.out.println("|| 5.  Search Movie via DIRECTOR 		||");
		System.out.println("|| 6.  Search Movie via DURATION		||");
		System.out.println("|| 7.  Search Movie via CAST			||");
		System.out.println("|| 8.  Search Movie via REVIEWS			||");
		System.out.println("|| 9.  Search Movie via MOVIE START DATE||");
		System.out.println("|| 10. Search Movie via MOVIE END DATE	||");
		System.out.println("==========================================");
		
	}
	
	
	public void displayAll_MovieDetails(ArrayList<Movie> selectedMovies){
		
		
		if(!selectedMovies.isEmpty())
		{
			System.out.println("======================================");
			System.out.println("|| 	 ||Found All Movie Details||    ||");
			
			for(int i=0; i<selectedMovies.Size(); i++)
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
	
	public int retrieveMovieAttr()
	{
		boolean isMovieIDValid = false;
		int input;
		
        
        while(!isMovieIDValid)
        {
        	input = sc.nextInt();
        	if(input>0 && input<11)
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
        
        return input;
	}
	
	public int retrieveMovieID()
	{
		boolean isMovieIDValid = false;
		int input;
		
        
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
	
	public void displayChoices_MovieDetail() {
		System.out.println("==========================================");
		System.out.println("|| 1. Search Movie via Movie ID			||");
		System.out.println("|| 2. Search Movie via Movie Attribute	||");
		System.out.println("|| 3. Back								||");
		System.out.println("==========================================");
	}

	
	
	
	
	

}
