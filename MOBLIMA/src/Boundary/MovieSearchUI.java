package sc2002ProjUI;

import java.util.ArrayList;
import java.util.Scanner;

//import javax.security.auth.login.AccountExpiredException;

//import moblima.Manager.*;


public class MovieSearchUI {
	
	
	static Scanner sc = new Scanner(System.in);
	
	
	private String typeMovie;
	private String titleMovie;
	
	//add controllers for movie
	//private  _MOVIE_CONTROLER_ _MOVIE_CTRL_
	 
	 
	private MoviesCtrl moviesCtrl = new MoviesCtrl();
	
	/*
	private MoviesCtrl moviesCtrl;	
	public MovieSearchUI()
	{
		//default contructor
		moviesCtrl = new MoviesCtrl();
	}
	
	//add parameters _MOVIE_CONTROLER_ _MOVIE_CTRL_
	public MovieSearchUI(MoviesCtrl moviesCtrl)
	{
		this.moviesCtrl = moviesCtrl;
		//this._MOVIE_CONTROLER_ _MOVIE_CTRL_ = _MOVIE_CONTROLER_ _MOVIE_CTRL_
	}
	*/
	
	public void main() {
		
		displayUI_MovieSearch();
		
		
	}
	
	public void displayUI_MovieSearch() {
		int choice;
		displayIntro_MovieSearch();
		displayChoices_MovieSearch();
		do{
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			if (choice<1 || choice>5) {
				System.out.println(choice + " is not a valid choice: ");
				displayChoices_MovieSearch();
			} 
		}while (choice<1 || choice>5);
		
		switch(choice) {
			case 1: //call search option method by name ();
					/*NEED TO DO IF-ELSE CHECK IF IT EXISTS?*/
					//if found
					displaySuccess_MovieSearch();
					displayResult_MovieSearch();
					//else
					displayFailure_MovieSearch();
		        	break;
		        	
			case 2: //call search option method by Age category ();
					/*NEED TO DO IF-ELSE CHECK IF IT EXISTS?*/
					//if found
					displaySuccess_MovieSearch();
					displayResult_MovieSearch();
					//else
					displayFailure_MovieSearch();
					break;
					
			case 3: //call search option method by any other method implemented in controller ();
					/*NEED TO DO IF-ELSE CHECK IF IT EXISTS?*/
					//if found
					displaySuccess_MovieSearch();
					displayResult_MovieSearch();
					//else
					displayFailure_MovieSearch();
					
					break;
					
			case 4: //Display all movies list
				
					
					displayAllMovies_MovieSearch();
					break;
					
			case 5:	break;
		}
		
		displayExit_MovieSearch();
		
		
		
		
		
		
	}
	
	public void displayExit_MovieSearch() {
		
		System.out.println("Thank you for using the Movie Search Section...");

		System.out.println("==========================");
		System.out.println("||	    Exiting the 	||");
		System.out.println("||	   Movie Search 	||");
		System.out.println("|| 		  Section 		||");
		System.out.println("==========================");
	
	}
	
	
	public void displayIntro_MovieSearch()
	{
		System.out.println("==========================");
		System.out.println("||	    Welcome to 		||");
		System.out.println("||	   Movie Search 	||");
		System.out.println("|| 		  Section 		||");
		System.out.println("==========================");
	}
	
	
	public void displayChoices_MovieSearch()
	{
		System.out.println("======================================");
		System.out.println("|| 1. Search via Movie Name 		||");
		System.out.println("|| 2. Search via Movie Age Category	||");
		System.out.println("|| 3. Search via Movie __smt else__	||");
		System.out.println("|| 4. Get the List of all Movies	||");
		System.out.println("|| 5. Back							||");
		System.out.println("======================================");
		
	}
	
	public void displaySuccess_MovieSearch()
	{
		System.out.println("\nMovie Has Been Found...");
		System.out.println("Outputting the Search Results:\n");
		
	}
	public void displayFailure_MovieSearch()
	{
		System.out.println("\nMovie Could Not Be Found...");
		System.out.println("Please re-imput a valid Search term:\n");
	}
	
	public void displayResult_MovieSearch(/*Arryalist_foundmovie*/)
	{
		System.out.println("======================================");
		System.out.println("|| 		||Found Movie Details||		||");
		System.out.printf("|| 1. Title				: 		%s	\n", string);
		System.out.printf("|| 2. Movie Id			: 		%s	\n", string);
		System.out.printf("|| 3. Showing Language	: 		%s	\n", string);
		System.out.printf("|| 4. Cast				:		%s	\n", string);
		System.out.printf("|| 5. Overall Rating		:		%s	\n", string);
		System.out.printf("|| 6. Age Category		:		%s	\n", string);
		System.out.println("======================================");
		
	}
	
	
	public void displayAllMovies_MovieSearch(/*Arryalist_allmovies*/)
	{
		//for loop thru the list
		int i;
		System.out.println("======================================");
		System.out.printf("|| No. || Title:		||\n");
		//for(i-0; i<list.Size();i++)
		//{
			System.out.printf("|| %d  || %s		||\n", i);
		//}
		System.out.println("======================================");
		
	}
	
	
	
	
}
