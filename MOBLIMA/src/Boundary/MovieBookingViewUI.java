package sc2002ProjUI;

import java.util.*;
import java.util.regex.*;


import moblima.Manager.*;
//import moblima.Manager.MoviesCtrl;
//import moblima.Manager.TransactionsCtrl;


public class MovieBookingViewUI {
	
	Scanner sc = new Scanner(System.in);

	
	
	//add controllers for transactions
	private TransactionsCtrl transactionCtrl;
	
	
	public MovieBookingViewUI()
	{
		this.transactionCtrl= new TransactionsCtrl();
	}
	
	public MovieBookingViewUI(TransactionsCtrl transactionCtrl)
	{
		this.transactionCtrl= transactionCtrl;
	}
	
	
	public void main() {
		
		displayIntro_MovieBooking();

		displayUI_MovieBooking();
		
		displayExit_MovieBooking();
	}
	
	public void settingTransactionCtrl(TransactionsCtrl transactionCtrl) {
		
		this.transactionCtrl= transactionCtrl;
	
	}
	
	
	public void displayUI_MovieBooking() {
		int choice;
		String userEmail;

		
		displayChoices_MovieBooking();
		
	
		
		do{
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			if (choice<1 || choice>2) {
				System.out.println(choice + " is not a valid choice: ");
				displayUI_MovieBooking();
			} 
		}while (choice<1 || choice>2);
		
		switch(choice) {
			case 1: System.out.println("Enter your Email-ID: ");
					userEmail =retrieveUserEmail();
					displayAllTransactions_MovieBooking(userEmail);
		        	break;
		        	
			case 2:	break;
		}	
		
		
	}
	
	public void displayIntro_MovieBooking(){
		System.out.println("==========================");
		System.out.println("||	    Welcome to 		||");
		System.out.println("||  Movie Booking View 	||");
		System.out.println("|| 		  Section 		||");
		System.out.println("==========================");
	}
	
	public void displayExit_MovieBooking() {
		
		System.out.println("Thank you for using the Movie Booking View Section...");

		System.out.println("==========================");
		System.out.println("||	    Exiting the 	||");
		System.out.println("||  Movie Booking View 	||");
		System.out.println("|| 		  Section 		||");
		System.out.println("==========================");
		
	}
	
	public void displayChoices_MovieBooking()
	{
		System.out.println("======================================");
		System.out.println("|| 1. View Movie Booking via Email	||");
		System.out.println("|| 2. Back							||");
		System.out.println("======================================");
	}
	
	public void displayAllTransactions_MovieBooking(String userEmail) {
		
		System.out.println("\n\nRetrieving all the Transactions for the Email "+ userEmail +":\n");

		
		ArrayList<Transaction> transactionCtrlList = transactionCtrl.readByMovieGoerUsername(userEmail);
		
		if(!transactionCtrlList.isEmpty())
		{
			System.out.println("======================================");
			System.out.println("|| 	||Found All Booking Details||	||");
			
			for(int i=0; i<transactionCtrlList.Size(); i++)
			{
				System.out.printf("|| Transaction %d: 	%s	\n", (i+1), transactionCtrlList.get(i).toString());
			}
			System.out.println("======================================");
		}
		else
		{
			System.out.println("\nTransactions & Booking History is Empty for the Email "+ userEmail);
			System.out.println("Please make a booking right now\n");
		}
		
	}

	/*
	 Restrict E-mail from Trailing, Consecutive, and Leading
		Restrict email to enter a number of characters in the top-level domain
	 */
	public String retrieveUserEmail()
	{
		
		boolean isEmailValid = false;
		String email= "";
		//Regular Expression   
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
        //Compile regular expression to get the pattern  
        Pattern pattern = Pattern.compile(regex);
        
        while(!isEmailValid)
        {
        	email = sc.nextLine();
        	//Create instance of matcher   
            Matcher matcher = pattern.matcher(email); 
        	if(matcher.matches()==true)
        	{
        		System.out.println("\nEmail inputted Correctly...\n");
        		isEmailValid = true;
        	}
        	else
        	{
        		System.out.println("Email inputted incorrectly...");
        		System.out.println("Re-Enter Email:");
        	}
        }
        
        return email;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
