package sc2002ProjUI;

import java.util.*;


import moblima.Manager.*;
//import moblima.Manager.MoviesCtrl;




public class MovieSearchUI {	
	
	/**
	 * parameters to allow for easy access to calling for functions
	 */
	private String typeMovie;
	private String titleMovie;
	
	public final static int MOVIE_START_DATE = 9;
    	public final static int MOVIE_END_DATE = 10;
	
	Scanner sc = new Scanner(System.in);
	
	/**
	 * Controller that this UI will reference
	 */
	private MoviesCtrl moviesCtrl;

	/**
	 * to construct controller 
	 */
	public MovieSearchUI()
	{
		
		moviesCtrl = new MoviesCtrl();
	}
	
	//add parameters _MOVIE_CONTROLER_ _MOVIE_CTRL_
	public MovieSearchUI(MoviesCtrl moviesCtrl)
	{
		this.moviesCtrl = moviesCtrl;
	}
	
	/**
	 * To display the 3 UI for movie search
	 */
	public void main() {
		
		displayIntro_MovieSearch();

		displayUI_MovieSearch();
		
		displayExit_MovieSearch();
		
	}
	
	/**
	 * Get user input to select search movie by attributes
	 */
	public void displayUI_MovieSearch() {
		int choice;
		displayChoices_MovieSearch();
		do{
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			if (choice<1 || choice>6) {
				System.out.println(choice + " is not a valid choice: ");
				displayChoices_MovieSearch();
			} 
		}while (choice<1 || choice>6);
		
		switch(choice) {
			case 1:
					String searchTerm1 = retrieveSearchTerm(); 
				
					ArrayList<Movie> selectedMovies1 = moviesCtrl.readByID(choice, searchTerm1);
					displayAll_MovieDetails(selectedMovies1);
	        
					break;
				
			case 2: 
					String searchTerm2 = retrieveSearchTerm(); 
				
					ArrayList<Movie> selectedMovies2 = moviesCtrl.readByID(choice, searchTerm2);
					displayAll_MovieDetails(selectedMovies2);
					break;
			case 3: 
					String searchTerm3 = retrieveSearchTerm(); 
				
					ArrayList<Movie> selectedMovies3 = moviesCtrl.readByID(MOVIE_START_DATE, searchTerm3);
					displayAll_MovieDetails(selectedMovies3);
					break;
			case 4:
					String searchTerm4 = retrieveSearchTerm(); 
					
					ArrayList<Movie> selectedMovies4 = moviesCtrl.readByID(MOVIE_END_DATE, searchTerm4);
					displayAll_MovieDetails(selectedMovies4);
		        
					break;
					
			case 5: //Display all movies list
					ArrayList<Movie> allMovies = moviesCtrl.readAvailableMovies();
					
					displayAll_MovieDetails(allMovies);
					
					
					break;
					
			case 6: break;
		}
		
		
		
	}
	
	/**
	 * To search movies by pharse
	 */
	public String retrieveSearchTerm()
	{
		boolean isValid = false;
		String input = "";
		
		System.out.println("By providing a Attribute Phrase, all the Movie Details will be searched & retrieved: ");
		System.out.println("Enter Pharse to search: ");
		
        
        while(!isValid)
        {
        	input = sc.nextLine();
        	if(input != "")
        	{
        		isValid = true;
        		System.out.println("\nSerach Term inputted Correctly...\n");
        		
        	}
        	else
        	{
        		System.out.println("Serach Term inputted incorrectly...");
        		System.out.println("Re-Enter Value(in String form):");
        	}
        }
        
        return input;
		
	}
	
	
	
	/**
	 * Display list of movie in the given attribute
	 *@param selectedMovies  list of movie to display
	 */
	public void displayAll_MovieDetails(ArrayList<Movie> selectedMovies){
		
		
		if(!selectedMovies.isEmpty())
		{
			//if found
			displaySuccess_MovieSearch();
			
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
			//else
			displayFailure_MovieSearch();
			
			System.out.println("\nMovie does not Exist in the database");
			System.out.println("Exiting now.\n");
		}
	}
	
	
	
	/**
	 * Display movie search header
	 */
	public void displayIntro_MovieSearch()
	{
		System.out.println("==========================");
		System.out.println("||	    Welcome to 		||");
		System.out.println("||	   Movie Search 	||");
		System.out.println("|| 		  Section 		||");
		System.out.println("==========================");
	}
	
	
	/**
	 * Display movie search footer
	 */
	public void displayExit_MovieSearch() {
		
		System.out.println("\nThank you for using the Movie Search Section...\n");

		System.out.println("==========================");
		System.out.println("||	    Exiting the 	||");
		System.out.println("||	   Movie Search 	||");
		System.out.println("|| 		  Section 		||");
		System.out.println("==========================");
	
	}
	
	/**
	 * Display movie search body
	 */
	public void displayChoices_MovieSearch()
	{
		System.out.println("==========================================");
		System.out.println("|| 1. Search Movie via Title Name		||");
		System.out.println("|| 2. Search Movie via Age Category	Type||");
		System.out.println("|| 3. Search Movie via MOVIE START DATE	||");
		System.out.println("|| 4. Search Movie via MOVIE END DATE	||");
		System.out.println("==========================================");
		System.out.println("|| 5. Get the List of all Movies		||");
		System.out.println("|| 6. Back								||");
		System.out.println("==========================================");
		
	}
	
	/**
	 * print statement for movie is found
	 */
	public void displaySuccess_MovieSearch()
	{
		System.out.println("\nMovie Has Been Found...");
		System.out.println("Outputting the Search Results:\n");
		
	}
	
	
	/**
	 * Print statement when no movie is found
	 */
	public void displayFailure_MovieSearch()
	{
		System.out.println("\nMovie Could Not Be Found...");
	}	
}
