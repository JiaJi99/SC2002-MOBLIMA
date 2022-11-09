import java.util.ArrayList;
import java.util.Scanner;

import javax.security.auth.login.AccountExpiredException;

import moblima.Manager.AccountManager;
import moblima.Manager.DataManager;
import moblima.Manager.MoviesCtrl;
import moblima.Manager.TransactionsCtrl;
import moblima.Model.Account;
import moblima.Model.Movie;
import moblima.Model.Reviews;
import moblima.Model.Transaction;

import java.lang.System.*;

public class MainMenuUI {
	
	public MainMenuUI() {
        start();
    }

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
	
	public void displayChoices_Main(AccountManager accountMgr){
		System.out.println("==============================");
		System.out.println("1. Login");//done
		System.out.println("2. Register New Account");//done
		System.out.println("3. View Movies");
		System.out.println("4. List Top 5 movies");//done
		System.out.println("5. Search Movies");
		System.out.println("6. Exit");//done
		System.out.println("==============================");	
	}
	public void displayChoices_Admin(AccountManager accountMgr){
		System.out.println("==============================");
		System.out.println("1. Log Out");//done
		System.out.println("2. Account Setting");//done
		System.out.println("3. List Top Five Movies");//done
		System.out.println("4. Update/Remove/Create Movie");
		System.out.println("5. Update/Remove/Create Showtime");
		System.out.println("6. Exit");//done
		System.out.println("==============================");	
	}
	
	public void displayChoices_MovieGoer(AccountManager accountMgr){
		System.out.println("==============================");
		System.out.println("1. Log Out");//done
		System.out.println("2. Account Setting");//done
		System.out.println("3. View History");//done
		System.out.println("4. List Top 5 Movies");//done
		System.out.println("5. Add Rating and Review");//done
		System.out.println("6. Book Movie Ticket");
		System.out.println("7. Exit");//done
		System.out.println("8. View Movies");
		System.out.println("9. Search Movies");
		System.out.println("==============================");	
	}
	
    public void displayUI_Main(AccountManager accountMgr) {
		int choice;
		Scanner sc = new Scanner(System.in);
		displayChoices_Main(accountMgr);
		do {
			System.out.println("Enter your choice.");
			choice = sc.nextInt();
			if (choice<1 || choice>6) {
				System.out.println(choice + " is not a valid choice.");
				displayChoices_Main(accountMgr);					
			} 
		}	while (choice<1 || choice>6);
			
		switch(choice) {
			case 1: login(accountMgr);
					break;
			case 2: register(accountMgr);
					break;
			case 3: //to be implemented
					 break;
			case 4: ViewMovieTop5UI tempNew = new ViewMovieTop5UI();
                    tempNew.listTop5(accountMgr);
					break;
			case 5:	//to be implemented
					break;
			case 6: exit(accountMgr);
					break;	
		}
	}
	
	public void displayUI_MovieGoer(AccountManager accountMgr) {
		int choice;
		Scanner sc = new Scanner(System.in);
		displayChoices_MovieGoer(accountMgr);
		do {
			System.out.println("Enter your choice.");
			choice = sc.nextInt();
			if (choice<1 || choice>6) {
				System.out.println(choice + " is not a valid choice.");
				displayChoices_Main(accountMgr);					
			} 
		}	while (choice<1 || choice>6);
		
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
        case 6:	//to be implemented
				break;		
        case 7:	exit(accountMgr);
				break;
		case 8: //to be implemented
				break;	
        case 9: //to be implemented
				break;	
                
	}
}

	
	public void displayUI_Admin(AccountManager accountMgr) {
		int choice;
		Scanner sc = new Scanner(System.in);
		displayChoices_Admin(accountMgr);
		do {
			System.out.println("Enter your choice.");
			choice = sc.nextInt();
			if (choice<1 || choice>6) {
				System.out.println(choice + " is not a valid choice.");
				displayChoices_Main(accountMgr);					
			} 
		}	while (choice<1 || choice>6);
		
		switch(choice) {
		case 1: logout(accountMgr);
				break;
		case 2: updateAccountSetting(accountMgr);
				break;
		case 3: ViewMovieTop5UI tempNew = new ViewMovieTop5UI();
                 tempNew.listTop5(accountMgr);
				 break;
		case 4: //to be implemented
				break;
		case 5:	//to be implemented
				break;
		case 6: exit(accountMgr);
				break;	
	}
	}
	
	public void login(AccountManager accountMgr) {

        DataManager dataMgr = new DataManager();

		LoginManager log_manager = new LoginManager(accountMgr, dataMgr);
		log_manager.loginUser();
	}
	
	public void register(AccountManager accountMgr) {

        DataManager dataMgr = new DataManager();

		RegistrationManager reg_manager = new RegistrationManager(accountMgr, dataMgr);
		reg_manager.createMovieGoerAccount();
        dataMgr.save();

	}
	
	public void logout(AccountManager accountMgr) {
        DataManager dataMgr = new DataManager();
		accountMgr.setActiveAccount(null);
		accountMgr.setMovieGoerLoggedIn(false);
		accountMgr.setAdminLoggedIn(false);
		System.out.println("Logged out successfully.");
        dataMgr.save();

	}
	
	public void updateAccountSetting(AccountManager accountMgr) {
        DataManager dataMgr = new DataManager();
		AccountSettingUI ac_ui= new AccountSettingUI(accountMgr, dataMgr);
		ac_ui.main();
        dataMgr.save();
	}
	
	public void exit() {
        DataManager dataMgr = new DataManager();
		System.out.println("Thank you for using MOBLIMA!");
		System.exit(0);
        dataMgr.save();
	}



    private void start(){
         AccountManager accountMgr = new AccountManager();
		 DataManager dataMgr = new DataManager();
         AdminAccount temp = new AdminAccount(firstuser,helloworld,anon@gmail.com, 1234,ADMIN);
         dataMgr.addAdminAccount(temp);
         dataMgr.save();
    }

    public void viewHistory(AccountManager accountMgr){
    
        Account viewAccount = accountMgr.getActiveAccount;
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
        Scanner sc = new Scanner(System.in);
         do {
            System.out.println("Press 0 to exit ");
            exitNum = sc.nextInt();
         }
        while (exitNum!=0);

        sc.close();
    }

    public void addReview(AccountManager accountMgr){
        Scanner sc = new Scanner(System.in);
        private MoviesCtrl moviesCtrl = new MoviesCtrl();
        private SearchMovieUI searchMovieUI = new SearchMovieUI();
        String movieTitle;
        String userComment ;
        Account tempMovieGoerAcc = accountMgr.getActiveAccount();
        String username = tempMovieGoerAcc.getUserName();
        // searchMovieUI.listAllMovies();

        System.out.println("Search for movie to create review:\n Please enter title");
        movieTitle = sc.next();
        ArrayList<Movie> movie = moviesCtrl.readByAttribute(MoviesCtrl.TITLE,movieTitle);
        if (movie.size()==0){
            System.out.println("No movie with this title exits, exiting search");
            return ;
        }
        int numStars = -1;
        System.out.println("Input number of stars 0 to 5");
        numStars = sc.nextInt();

        if (numStars>5) numStars =5;
        if (numStars<0) numStars =0;

        sc.nextLine();//clear buffer discard input value;
        System.out.println("Input additional comment");
        userComment= sc.nextLine();
        Reviews newReview = new Review(username,userComment,numStars);
        Movie tempMovie = movie.get(0);
        ArrayList<Reviews> oldArrayList = tempMovie.getReviews();
        ArrayList<Reviews> newArrayList = new ArrayList<Reviews>();
        for (int i =0;i<oldArrayList.size();i++){
            newArrayList.add(oldArrayList.get(i));
        }
        newArrayList.add(newReview);
        moviesCtrl.updateMovie(MoviesCtrl.REVIEWS,tempMovie.getID(),newArrayList);
    }

}
