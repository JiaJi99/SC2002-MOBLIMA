import java.util.Scanner;

import moblima.Manager.DataManager;

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
		System.out.println("4. List Top 5 movies");
		System.out.println("4. Search Movies");
		System.out.println("5. Book ticket");
		System.out.println("6. Exit");//done
		System.out.println("==============================");	
	}
	public void displayChoices_Admin(AccountManager accountMgr){
		System.out.println("==============================");
		System.out.println("1. Log Out");//done
		System.out.println("2. Account Setting");//done
		System.out.println("3. List Top Five Movies");
		System.out.println("4. Update/Remove/Create Movie");
		System.out.println("4. Update/Remove/Create Showtime");
		System.out.println("5. ??");// left if need later
		System.out.println("6. Exit");//done
		System.out.println("==============================");	
	}
	
	public void displayChoices_MovieGoer(AccountManager accountMgr){
		System.out.println("==============================");
		System.out.println("1. Log Out");//done
		System.out.println("2. Account Setting");//done
		System.out.println("3. View History");
		System.out.println("4. List Top 5 Movies");
		System.out.println("4. Add Rating and Review");
		System.out.println("5. Book Movie Ticket");
		System.out.println("6. Exit");//done
		System.out.println("7. View Movies");
		System.out.println("8. Search Movies");
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
			case 4: //to be implemented
                    listTop5(accountMgr);
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
		case 3: //to be implemented
				 break;
		case 4: //to be implemented
				break;
		case 5:	//to be implemented
				break;
		case 6: exit(accountMgr);
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
		case 3: //to be implemented
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

}
