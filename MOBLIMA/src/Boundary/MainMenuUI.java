package finalnewcodesorted;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import Project.ShowTime;
import finalnewcodesorted.Enum.*;

public class MainMenuUI {
	private AccountManager accountMgr;
	private DataManager dataMgr;
	
	public MainMenuUI() {
		this.accountMgr = new AccountManager();
		this.dataMgr = new DataManager();
		dataMgr.initialize();
	}
	
	public void main() {
		do {
			if (accountMgr.getMovieGoerLoggedIn() == false && accountMgr.getAdminLoggedIn() == false)
				displayUI_Main();
			else if (accountMgr.getMovieGoerLoggedIn() == true)
				displayUI_MovieGoer();
			else 
				displayUI_Admin();	
		} while (true);
	}
	
	public void displayChoices_Main(){
		System.out.println("==============================");
		System.out.println("1. Login"); //done
		System.out.println("2. Register New Account");//done
		System.out.println("3. Exit");//done
		System.out.println("==============================");	
	}
	public void displayChoices_Admin(){
		System.out.println("==============================");
		System.out.println("1. Log Out");//done
		System.out.println("2. Account Setting");//done
		System.out.println("3. Create Movie");//done
		System.out.println("4. Update Movie");//done
		System.out.println("5. Remove Movie");//done
		System.out.println("6. Create Showtime");
		System.out.println("7. Update Showtime");
		System.out.println("8. Remove Showtime");
		System.out.println("9. Exit");//done
		System.out.println("==============================");	
	}
	
	public void displayChoices_MovieGoer(){
		System.out.println("==============================");
		System.out.println("1. Log Out");//done
		System.out.println("2. Account Setting");//done
		System.out.println("3. Register New Account");//done
		System.out.println("4. View Movies");//done
		System.out.println("5. List Top 5 movies");//done by rating , to do order by sales or no need
		System.out.println("6. Search Movies");//done 
		System.out.println("7. Book ticket");
		System.out.println("8. Add Rating and Review");//done
		System.out.println("9. Exit");//done
		//System.out.println("10. View Booking History");  // //  TODO
		// also after every function should we call dispaly Choices movie goer again;
		System.out.println("==============================");	
	}
	
	public void displayUI_Main() {
		int choice;
		Scanner sc = new Scanner(System.in);
		displayChoices_Main();
		do {
			System.out.println("Enter your choice.");
			choice = sc.nextInt();
			if (choice<1 || choice>3) {
				System.out.println(choice + " is not a valid choice.");
				displayChoices_Main();					
			} 
		}	while (choice<1 || choice>3);
			
		switch(choice) {
			case 1: login();
					break;
			case 2: register();
					break;
			case 3: exit();
					break;	
		}
	}
	
	public void displayUI_MovieGoer() {
		int choice;
		Scanner sc = new Scanner(System.in);
		displayChoices_MovieGoer();
		do {
			System.out.println("Enter your choice.");
			choice = sc.nextInt();
			if (choice<1 || choice>9) {
				System.out.println(choice + " is not a valid choice.");
				displayChoices_Main();					
			} 
		}	while (choice<1 || choice>9);
		
		switch(choice) {
		case 1: logout();
				break;
		case 2: updateAccountSetting();
				break;
		case 3: register();
				 break;
		case 4: viewMovies();
				break;
		case 5: topFiveMovies();
				break;
		case 6:	searchMovie();
				break;
		case 7: //to be implemented
				break;		
		case 8:	addRatingReview();
				break;

		case 9: exit();
				break;	
	}
}


	
	public void displayUI_Admin() {
		int choice;
		Scanner sc = new Scanner(System.in);
		displayChoices_Admin();
		do {
			System.out.println("Enter your choice.");
			choice = sc.nextInt();
			if (choice<1 || choice>9) {
				System.out.println(choice + " is not a valid choice.");
				displayChoices_Main();					
			} 
		}	while (choice<1 || choice>9);
		
		switch(choice) {
		case 1: logout();
				break;
		case 2: updateAccountSetting();
				break;
		case 3: createMovie();
				break;
	    case 4: updateMovie();
			   break;
	    case 5:	removeMovie();
			   break;
	    case 6:	createShowTime();
			   break;
	    case 7: updateShowtime();
			   break;
		case 8:	removeShowtime();
			   break;

	    case 9: exit();
				break;	
	}
	}
	public void addRatingReview(){
		Scanner sc = new Scanner(System.in);
		MovieMenu movieMenuTemp = new MovieMenu();
		ArrayList<Movie> movieList= movieMenuTemp.getMovie();
		System.out.println("enter movie title to add rating or review");
		bool found = false;
		String inputMovieName = sc.nextLine();
		for (int i =0;i<movieList.size();i++){
			Movie tempMovie = movieList.get(i);
			if (inputMovieName.equals(tempMovie.getTitle())){
				found = true;
				int chioce = 0;
				System.out.println("\n\nChoose option \n1)Add Rating only \n2)Add Rating and Review");
				switch  (chioce){
				case 1 : 
					movieMenuTemp.addRating(tempMovie);
					break;
				case 2:
					movieMenuTemp.addReview(tempMovie);
					break;
			}
			movieMenuTemp.saveMovie(movieList);
			System.out.println("Rating or review successfully added, returning to user menu");
			break;
			}
		}
		if (found == false){
			System.out.println("Movie not found, returning to user menu");
		}

		displayUI_MovieGoer();
	}

	public void removeMovie(){
		Scanner sc = new Scanner(System.in);
		MovieMenu movieMenuTemp = new MovieMenu();
		ArrayList<Movie> movieList= movieMenuTemp.getMovie();
		System.out.println("Enter movie name to remove");
		bool found = false;
		String inputMovieName = sc.nextLine();
		for (int i =0;i<movieList.size();i++){
			Movie tempMovie = movieList.get(i);
			if (inputMovieName.equals(tempMovie.getTitle())){
				found = true;
				movieMenuTemp.removeMovie(tempMovie);
				movieMenuTemp.saveMovie(movieList);

			}
		}
		if (found == false){
			System.out.println("Sorry moive not found, going back to menu ");
		}
		sc.close();
		displayUI_Admin();

	}

	
	public void updateMovie(){
		Scanner sc = new Scanner(System.in);
		MovieMenu movieMenuTemp = new MovieMenu();
		ArrayList<Movie> movieList= movieMenuTemp.getMovie();
		System.out.println("Enter movie name to update");
		bool found = false;
		String inputMovieName = sc.nextLine();
		for (int i =0;i<movieList.size();i++){
			Movie tempMovie = movieList.get(i);
			if (inputMovieName.equals(tempMovie.getTitle())){
				found = true;
				movieMenuTemp.updateMovie(tempMovie);
				movieMenuTemp.saveMovie(movieList);
				System.out.println("Movie updated and saved successfully, going back to menu");
			}
		}

		if (found == false){
			System.out.println("Sorry moive not found, going back to  menu ");
		}
		sc.close();
		displayUI_Admin();

	}

	public void createMovie(){
		MovieMenu movieMenuTemp = new MovieMenu();
		Movie newMovie = new Movie();
		movieMenuTemp.addMovie(newMovie);
		
		movieMenuTemp.addToArray(newMovie);
		movieMenuTemp.saveMovie(movieMenuTemp.getMovie());
		System.out.println("Movie successfully created and saved.");
		
		displayUI_Admin();

	}


	public void topFiveMovies(){
		MovieMenu movieMenuTemp = new MovieMenu();
		ArrayList<Movie> movieList= movieMenuTemp.getMovie();
		Collections.sort(movieList,sortByRating);
		int num = 0;
		if (movieList.size()<5)
			num = movieList.size();
		else 
			num = 5;
		
		for (int i =0;i<num;i++){
			tempMovie = movieList.get(i)
			System.out.println("Title : " tempMovie.getTitle());

		}
		displayUI_MovieGoer();

	}




	public void searchMovie(){
		MovieMenu movieMenuTemp = new MovieMenu();
		ArrayList<Movie> movieList= movieMenuTemp.getMovie();
		System.out.prinln("Enter movie title to search");
		Scanner sc = new Scanner(System.in);
		String inputMovieName = sc.nextLine();
		for (int i =0;i<movieList.size();i++){
			Movie tempMovie = movieList.get(i);
			if (inputMovieName.equals(tempMovie.getTitle())){
				// System.out.println("Name : "tempMovie.getTitle());
				// System.out.println("Ratings : " tempMovie.getRating());
				// System.out.println("Status :"+ tempMovie.getStatus());
				// System.out.println("Director: "+ tempMovie.getDirector());
				// System.out.println("Synopsis : "+ tempMovie.getSynopsis());
				// ArrayList<String> tempCast = this.getClass();
				// System.out.print(tempCast.get(0)+" "+tempCast.get(1));
				// System.out.println("---------------------------");
				System.out.println(tempMovie.toString());
				System.out.println("---------------------------");

				
			}


		}
		displayUI_MovieGoer();

	}
	public void viewMovies(){
		MovieMenu movieMenuTemp = new MovieMenu();
		ArrayList<Movie> movieList= movieMenuTemp.getMovie();
		System.out.println("---------------------------");
		for (int i =0 ;i<movieList.size();i++){
			Movie tempMovie = movieList.get(i);
			if (tempMovie.ShowStatus()!=MovieStatus.END_OF_SHOW &&tempMovie.ShowStatus()!=MovieStatus.NA){
				System.out.println("-----------------------------")
				System.out.println(tempMovie.getTitle()+" in "+tempMovie.getType());
				// System.out.println(tempMovie.getTitle()+" in "+tempMovie.getType()+" by "+tempMovie.getDirector()+" starring ");
				// ArrayList<String> tempCast = this.getClass();
				// System.out.print(tempCast.get(0)+" and others.");
			}

		}
		displayUI_MovieGoer();
	}
	
	public void login() {
		LoginManager log_manager = new LoginManager(accountMgr, dataMgr);
		log_manager.loginUser();
	}
	
	public void register() {
		RegistrationManager reg_manager = new RegistrationManager(accountMgr, dataMgr);
		reg_manager.createMovieGoerAccount();
	}
	
	public void logout() {
		accountMgr.setActiveAccount(null);
		accountMgr.setMovieGoerLoggedIn(false);
		accountMgr.setAdminLoggedIn(false);
		System.out.println("Logged out successfully.");
	}
	
	public void updateAccountSetting() {
		AccountSettingUI ac_ui= new AccountSettingUI(accountMgr, dataMgr);
		ac_ui.main();
	}
	
	public void exit() {
		System.out.println("Thank you for using MOBLIMA!");
		dataMgr.save();
		System.exit(0);
	}



}


class sortByRating implements Comparator<Movie>{
	public int compare(Movie a, Movie b){
		String ratingA = a.avgRating();
		String ratingB = b.avgRating();
		if(ratingA == "N/A" && ratingB == "N/A") return 0;
		if(ratingA == "N/A") return 1;
		if(ratingB == "N/A") return -1;
		double difference = Double.parseDouble(ratingA) - Double.parseDouble(ratingB);
		if (difference > 0) return -1;
		if (difference < 0) return 1;
		return 0;

	}
}

// class sortBySlaes implements Comparator<Movie>{}