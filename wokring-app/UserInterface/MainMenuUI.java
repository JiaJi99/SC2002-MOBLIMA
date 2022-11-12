package UserInterface;
import java.util.ArrayList;
import java.util.Scanner;

import javax.security.auth.login.AccountExpiredException;

import ManagerClasses.*;
import BaseClasses.*;
import java.lang.System.*;

public class MainMenuUI {
	public static Scanner sc = new Scanner(System.in);
	

	/**
	 * Main function to start the moblima program
	 */
	public MainMenuUI() {
		start();
		firstRunDataInput();
		
        
    }
	
	/**
	 * To display the account type menu based on account logged in status 
	 * Display admin interface
	 * Display moviegoer interface
	 */
	public void main() {
         AccountManager accountMgr = new AccountManager();
        //  DataManager dataMgr = new DataManager();

		do {
			if (accountMgr.getMovieGoerLoggedIn() == false && accountMgr.getAdminLoggedIn() == false)
				displayUI_Main(accountMgr);
			else if (accountMgr.getMovieGoerLoggedIn() == true)
				displayUI_MovieGoer( accountMgr);
			else 
				displayUI_Admin( accountMgr);	
		} while (true);
	}
	
	/**
	 * Display available actions for movie goer before login
	 */
	public void displayChoices_Main(){
		System.out.println("\n==============MAIN MENU================");
		System.out.println("1. Login");//done
		System.out.println("2. Register New Account");//done
		System.out.println("3. View Currently Showing/Preview  Movies");
		System.out.println("4. List Top 5 movies");//done
		System.out.println("5. Search Movies");
		System.out.println("6. Exit");//done
		System.out.println("7. View History (email required)");
		System.out.println("==============================");	
	}
	
	
	/**
	 * Display availble actions for admin
	 */
	public void displayChoices_Admin(AccountManager accountMgr){
		System.out.println("\n==============ADMIN MENU================");
		System.out.println("1. Log Out");//done
		System.out.println("2. Account Setting");//done
		System.out.println("3. List Top Five Movies");//done
		System.out.println("4. Update/Remove/Create Movie");//done
		System.out.println("5. Update/Remove/Create Showtime");
		System.out.println("6. Exit");//one
		System.out.println("7. Configure Prices and Holidays");//done
		System.out.println("8. Search Movies");
		System.out.println("9. List All Movies In Database");

		System.out.println("==============================");	
	}
	
	
	/**
	 * Display available actions for movie goer after login
	 */
	public void displayChoices_MovieGoer(AccountManager accountMgr){
		System.out.println("\n===============USER MENU===============");
		System.out.println("1. Log Out");//done
		System.out.println("2. Account Setting");//done
		System.out.println("3. View Account History");//done
		System.out.println("4. List Top 5 Movies");//done
		System.out.println("5. Add Rating and Review");//done
		System.out.println("6. Book Movie Ticket");//done
		System.out.println("7. Exit");//done
		System.out.println("8. View Movies");
		System.out.println("9. Search Movies");
		System.out.println("==============================");	
	}
	
	
	/**
	 * Display and get user input for main UI (before login)
	 */
    public void displayUI_Main(AccountManager accountMgr) {
		int choice;
		// Scanner sc = new Scanner(System.in);
		displayChoices_Main();
		do {
			System.out.println("Enter your choice.");
			choice = getIntFromUser();
			if (choice<1 || choice>7) {
				System.out.println(choice + " is not a valid choice.");
				displayChoices_Main();					
			} 
		}	while (choice<1 || choice>7);
			
		switch(choice) {
			case 1: login(accountMgr);
					break;
			case 2: register(accountMgr);
					break;
			case 3: MoviesCtrl moviesCtrlTemp = new MoviesCtrl();
					ArrayList<Movie> availableMovies = moviesCtrlTemp.readAvailableMovies();
					for (int mo = 0;mo<availableMovies.size();mo++){
						System.out.println("Title : "+ availableMovies.get(mo).getTitle());
					}
					System.out.println("------------------------");
					 break;
			case 4: ViewMovieTop5UI tempNew = new ViewMovieTop5UI();
                    tempNew.listTop5(accountMgr);
					break;
			case 5:	MovieSearchUI movieSearchUI = new MovieSearchUI();
					movieSearchUI.main();
					break;
			case 6: exit(accountMgr);
					break;	
			case 7 : MovieBookingViewUI movieBookingViewUI = new MovieBookingViewUI();
						movieBookingViewUI.main();
		}

		// sc.close();
	}
	
	/**
	 * To display and get user input for moviegoer action after login
	 */
	public void displayUI_MovieGoer(AccountManager accountMgr) {
		int choice;
		// Scanner sc = new Scanner(System.in);
		displayChoices_MovieGoer(accountMgr);
		do {
			System.out.println("Enter your choice.");
			choice = getIntFromUser();
			if (choice<1 || choice>9) {
				System.out.println(choice + " is not a valid choice.");
				displayChoices_Main();					
			} 
		}	while (choice<1 || choice>9);
		
		switch(choice) {
		case 1: logout(accountMgr);
				break;
		case 2: updateAccountSetting(accountMgr);
				break;
		case 3: viewHistory(accountMgr);
				 break;
		case 4: ViewMovieTop5UI tempNew = new ViewMovieTop5UI();
                tempNew.listTop5(accountMgr);
				break;
        case 5:	addReview(accountMgr);
				break;                
        case 6: BookBuy tempBookBuy = new BookBuy();
				tempBookBuy.bookbuyMethod();
				break;		
        case 7:	exit(accountMgr);
				break;
		case 8: MovieDetailViewUI movieDetailViewUI = new MovieDetailViewUI();
				movieDetailViewUI.main();
				break;	
        case 9: MovieSearchUI movieSearchUI = new MovieSearchUI();
				movieSearchUI.main();
				break;	
                
	}
}

	/**
	 * Displays and get user input for admin menu
	 */
	public void displayUI_Admin(AccountManager accountMgr) {
		int choice;
		// Scanner sc = new Scanner(System.in);
		displayChoices_Admin(accountMgr);
		do {
			System.out.println("Enter your choice.");
			choice = getIntFromUser();
			if (choice<1 || choice>9) {
				System.out.println(choice + " is not a valid choice.");
				displayChoices_Main();					
			} 
		}	while (choice<1 || choice>9);
		
		switch(choice) {
		case 1: logout(accountMgr);
				break;
		case 2: updateAccountSetting(accountMgr);
				break;
		case 3: ViewMovieTop5UI tempNew = new ViewMovieTop5UI();
                 tempNew.listTop5(accountMgr);
				 break;
		case 4: UpdateRCMovie tempUpdateClass = new UpdateRCMovie();
                tempUpdateClass.updateMovieFunction();
				break;
		case 5:	UpdateRCShowtimeUI updateRCShowtimeUI = new UpdateRCShowtimeUI();
				updateRCShowtimeUI.displayUI_UpdateRCSession();
				break;
		case 6: exit(accountMgr);
				break;	

        case 7: ChangePrice chnagePriceTemp = new ChangePrice();
                chnagePriceTemp.changePriceMethod();
                break;

		case 8: MovieSearchUI movieSearchUI = new MovieSearchUI();
				movieSearchUI.main();
				break;	
		case 9: displayall();
				break;	


	}
	}


	/**
	 * To list all movies in database irrepsitve of current or old
	 */
	public void displayall(){
		System.out.println("-----------------------------------");

		MoviesCtrl moviesCtrlTemp = new MoviesCtrl();
		ArrayList<Movie> tempMList = moviesCtrlTemp.read();
		for (int i =0;i<tempMList.size();i++){
		System.out.println("TITLE: "+tempMList.get(i).getTitle());
		System.out.println("ID : "+tempMList.get(i).getID());
		System.out.println("-------------");

			
		}
	}

	/**
	 * To login
	 */
	public void login(AccountManager accountMgr) {

        DataManager dataMgr = new DataManager();
		dataMgr.initialize();
		LoginManager log_manager = new LoginManager(accountMgr, dataMgr);
		log_manager.loginUser();
		dataMgr.save();
	}
	
	/**
	 * Add new moviegoer account to database
	 */
	public void register(AccountManager accountMgr) {

        DataManager dataMgr = new DataManager();
		dataMgr.initialize();
		RegistrationManager reg_manager = new RegistrationManager(accountMgr, dataMgr);
		reg_manager.createMovieGoerAccount();
        dataMgr.save();

	}
	
	/**
	 * To logout
	 */
	public void logout(AccountManager accountMgr) {
        DataManager dataMgr = new DataManager();
		dataMgr.initialize();
		accountMgr.setActiveAccount(null);
		accountMgr.setMovieGoerLoggedIn(false);
		accountMgr.setAdminLoggedIn(false);
		System.out.println("Logged out successfully.");
        dataMgr.save();

	}
	
	/**
	 * To update account setting 
	 */ 
	public void updateAccountSetting(AccountManager accountMgr) {
        DataManager dataMgr = new DataManager();
		dataMgr.initialize();
		AccountSettingUI ac_ui= new AccountSettingUI(accountMgr, dataMgr);
		ac_ui.main();
        dataMgr.save();
	}
	
	/**
	 * To exit and end moblima 
	 */
	public void exit(AccountManager accountManager) {
        DataManager dataMgr = new DataManager();
		dataMgr.initialize();
		System.out.println("Thank you for using MOBLIMA!");
		System.exit(0);
        dataMgr.save();
	}


	/**
	 * To start moblima
	 */
    private void start(){
         AccountManager accountMgr = new AccountManager();
		 DataManager dataMgr = new DataManager();
		 dataMgr.initialize();
         AdminAccount temp = new AdminAccount("firstuser","helloworld","anon@gmail.com", 1234,AccountType.ADMIN);
         dataMgr.addAdminAccount(temp);
         dataMgr.save();
		 
    }

	
	/**
	 * To view movie goer history of transcation
	 */
    public void viewHistory(AccountManager accountMgr){
    
        Account viewAccount = accountMgr.getActiveAccount();
        TransactionsCtrl transCtrl = new TransactionsCtrl();
        String userEmail= viewAccount.getEmail();
        System.out.println("Booking hisotry for account :\n");
        ArrayList<Transaction> tList = transCtrl.readByMovieGoerUsername(userEmail);
        if (tList.size()==0){
            System.out.println("No history found for user :"+userEmail);
        }   
        else {
            for (int i =0;i<tList.size();i++){
                Transaction tempTransaction = tList.get(i);
                System.out.print("\n");
                tempTransaction.toString();
            }
        }    
        int exitNum =-1;
        // Scanner sc = new Scanner(System.in);
         do {
            System.out.println("Press 0 to exit ");
            exitNum = getIntFromUser();
         }
        while (exitNum!=0);


    }
	
	/**
	 * Calls update interface
	 */
    public void updateRCMovie(){
        UpdateRCMovie newUpdate  = new UpdateRCMovie();
        newUpdate.updateMovieFunction();
    }

	/**
	 * For creating the Cineplexes and Cinemas the first time the code is run and saving it to txt files
	 */
	public  void firstRunDataInput(){
		ArrayList<Cinemas> inputCinemasList1 = new ArrayList<Cinemas>();
		ArrayList<Cinemas> inputCinemasList2 = new ArrayList<Cinemas>();
		ArrayList<Cinemas> inputCinemasList3 = new ArrayList<Cinemas>();

		CineplexController cineplexController = new CineplexController();
		MoviesCtrl moviesCtrl = new MoviesCtrl();
		inputCinemasList1.add(new Cinemas("CR", new SeatPlan(8, 8)));
		inputCinemasList1.add(new Cinemas("KV", new SeatPlan(8, 8)));
		inputCinemasList1.add(new Cinemas("LW", new SeatPlan(8, 8)));
		inputCinemasList3.add(new Cinemas("DR", new SeatPlan(8, 8)));
		inputCinemasList3.add(new Cinemas("PV", new SeatPlan(8, 8)));
		inputCinemasList3.add(new Cinemas("OT", new SeatPlan(8, 8)));
		inputCinemasList2.add(new Cinemas("EZ", new SeatPlan(8, 8)));
		inputCinemasList2.add(new Cinemas("ID", new SeatPlan(8, 8)));
		inputCinemasList2.add(new Cinemas("TI", new SeatPlan(8, 8)));

		if(cineplexController.read().size()==0){
			cineplexController.create("Jurong East Cineplex", inputCinemasList1);
			cineplexController.create("Marina Bay Cineplex ", inputCinemasList2);
			cineplexController.create("Bouna Vista Cineplex", inputCinemasList3);

		}
	}

	/**
	 * Allow users to give their review and adds to reviews database
	 */
    public void addReview(AccountManager accountMgr){
        // Scanner sc = new Scanner(System.in);
        MoviesCtrl moviesCtrl = new MoviesCtrl();

        String movieTitle;
        String userComment ;
        Account tempMovieGoerAcc = accountMgr.getActiveAccount();
        String username = tempMovieGoerAcc.getUserName();

        System.out.println("Search for movie to create review:\nPlease enter title");
        movieTitle = sc.nextLine();
        ArrayList<Movie> movie = moviesCtrl.readByAttribute(MoviesCtrl.TITLE,movieTitle);
        if (movie.size()==0){
            System.out.println("No movie with this title exits, exiting search");
            return ;
        }
        int numStars = -1;
        System.out.println("Input number of stars 0 to 5");
        numStars = getIntFromUser();

        if (numStars>5) numStars =5;
        if (numStars<0) numStars =0;

        // sc.nextLine();//clear buffer discard input value;
        System.out.println("Input additional comment");
        userComment= sc.nextLine();
        Reviews newReview = new Reviews(username,userComment,numStars);
        Movie tempMovie = movie.get(0);
        ArrayList<Reviews> oldArrayList = tempMovie.getReviews();
        ArrayList<Reviews> newArrayList = new ArrayList<Reviews>();
        for (int i =0;i<oldArrayList.size();i++){
            newArrayList.add(oldArrayList.get(i));
        }
        newArrayList.add(newReview);
        moviesCtrl.updateMovie(MoviesCtrl.REVIEWS,tempMovie.getID(),newArrayList);
    }
	/**
	 * Get user input and return input if valid
	 *@return int  	Return user input if valid, else loop
	 */
    public static int getIntFromUser(){
        int input = -5;
        boolean validInput = false;
        while(!validInput) {
            if(sc.hasNextInt()){
                input = sc.nextInt();
                validInput = true;
            }
            else{
                System.out.println("Wrong input!");
            }
            sc.nextLine();
        }
        return input;
    }


}
