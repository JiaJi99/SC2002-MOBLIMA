package UserInterface;
import java.util.Scanner;

import BaseClasses.Account;
import BaseClasses.AccountType;
import BaseClasses.AdminAccount;
import BaseClasses.MovieGoerAccount;
import ManagerClasses.AccountManager;
import ManagerClasses.AccountSettingManager;
import ManagerClasses.DataManager;



public class AccountSettingUI {
	
	/**
	 * Controller that this UI will reference
	 */ 
	private AccountSettingManager accountSettingMgr;
	
	
	/**
	 * Controller that this UI will reference
	 */ 
	private AccountManager accountMgr;
	
	/**
	 * Paramasize Constructor 
	 */
	public AccountSettingUI(AccountManager accountMgr, DataManager dataMgr) {
		this.accountSettingMgr = new AccountSettingManager(accountMgr, dataMgr);
		this.accountMgr = accountMgr;
	}
	
	
	/**
	 * Initalise account database to read and write
	 */
	public void main() {
		Account tempAccount = accountMgr.getActiveAccount();
		if (tempAccount.getAccountType() == AccountType.ADMIN) {
			displayAdminAccountDetail((AdminAccount)tempAccount);
			displayUI_Admin();
		}
		else {
			displayMovieGoerAccountDetail((MovieGoerAccount)tempAccount);
			displayUI_MovieGoer();	
		}
	}
	
	
	/**
	 * Display and get user input for selection of user setting configuration
	 */
	public void displayUI_Admin() {
		int choice;
		Scanner sc = new Scanner(System.in);
		displayChoices_Admin();
		do {
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			if (choice<1 || choice>6) {
				System.out.println(choice + " is not a valid choice: ");
				displayChoices_Admin();				
			} 
		}	while (choice<1 || choice>6);
		
		switch(choice) {
			case 1: accountSettingMgr.updateUserName();
			        displayAccountDetail();;
					break;
			case 2: accountSettingMgr.updatePassword();
					displayAccountDetail();;
					break;
			case 3: accountSettingMgr.updateEmail();
					displayAccountDetail();;
					break;
			case 4: accountSettingMgr.updateMobileNumber();
					displayAccountDetail();;
					break;
			case 5:	accountSettingMgr.deleteAccount();
					break;
			case 6:	break;
		}	
	}
	
	
	/**
	 * Display and get user input for update movie goer UI
	 */
	public void displayUI_MovieGoer() {
		int choice;
		Scanner sc = new Scanner(System.in);
		displayChoices_MovieGoer();
		do {
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			if (choice<1 || choice>7) {
				System.out.println(choice + " is not a valid choice: ");
				displayChoices_Admin();				
			} 
		}	while (choice<1 || choice>7);
		
		switch(choice) {
			case 1: accountSettingMgr.updateUserName();
			        displayAccountDetail();
					break;
			case 2: accountSettingMgr.updatePassword();
					displayAccountDetail();
					break;
			case 3: accountSettingMgr.updateEmail();
					displayAccountDetail();	
					break;
			case 4: accountSettingMgr.updateMobileNumber();
					displayAccountDetail();
					break;
			case 5: accountSettingMgr.updateAge();
					displayAccountDetail();
					break;
			case 6:	accountSettingMgr.deleteAccount();
					break;
			case 7:	break;
		}	
	}
	
	
	/**
	 * display admin UI
	 */
	public void displayChoices_Admin() {
		System.out.println("==============================");
		System.out.println("1. Update username");
		System.out.println("2. Update password");
		System.out.println("3. Update email");
		System.out.println("4. Update mobile number");
		System.out.println("5. Delete account");
		System.out.println("6. Back");
		System.out.println("==============================");	
	}
	
	
	/**
	 * Display MovieGoer UI
	 */
	public void displayChoices_MovieGoer() {
		System.out.println("==============================");
		System.out.println("1. Update username");
		System.out.println("2. Update password");
		System.out.println("3. Update email");
		System.out.println("4. Update mobile number");
		System.out.println("5. Update age");
		System.out.println("6. Delete account");
		System.out.println("7. Back");
		System.out.println("==============================");	
	}
	
	
	/**
	 * Calls and display account detail of this account
	 */
	public void displayAccountDetail(){
		Account tempAccount = accountMgr.getActiveAccount();
		if (tempAccount.getAccountType() == AccountType.ADMIN)
			displayAdminAccountDetail((AdminAccount)tempAccount);
		else 			
			displayMovieGoerAccountDetail((MovieGoerAccount) tempAccount);		
	}
	
	
	/**
	 * Display Movie goer account detail in a string format
	 */
	public void displayMovieGoerAccountDetail(MovieGoerAccount acc){
		System.out.println("==============================");
		System.out.println("        ACCOUNT DETAIL        ");
		System.out.printf("Name            : %s\n", acc.getUserName());
		System.out.printf("Email           : %s\n", acc.getEmail());
		System.out.printf("Mobile Number   : %d\n", acc.getMobileNumber());
		System.out.printf("Age             : %d\n", acc.getAge());
		System.out.println("==============================");	
	}
	
	
	
	
	/**
	 * Display Admin account detail in a string format
	 */
	public void displayAdminAccountDetail(AdminAccount acc){
		System.out.println("==============================");
		System.out.println("        ACCOUNT DETAIL        ");
		System.out.printf("Name            : %s\n", acc.getUserName());
		System.out.printf("Email           : %s\n", acc.getEmail());
		System.out.printf("Mobile Number   : %d\n", acc.getMobileNumber());
		System.out.println("==============================");	
	}
}
