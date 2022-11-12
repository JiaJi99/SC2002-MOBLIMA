package ManagerClasses;

import java.util.Scanner;

import BaseClasses.*;

public class RegistrationManager {
	private AccountManager accountMgr;
	private DataManager dataMgr;
	
	public RegistrationManager(AccountManager accountMgr, DataManager dataMgr) {
		this.accountMgr = accountMgr;
		this.dataMgr = dataMgr;
	}

	public void createMovieGoerAccount() {
		String userName, password, re_password, email;
		int mobileNumber, age;
		MovieGoerAccount tempAccount;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username: ");
		userName = sc.nextLine();
		do{System.out.println("Enter password: ");
			password = sc.nextLine();
			System.out.println("Re-enter password: ");
			re_password = sc.nextLine();
			if (!isValidPassword(password, re_password))
				System.out.println("Password do not match. Please try again. ");
		} while (!isValidPassword(password, re_password));
		System.out.println("Enter email: ");
		email = sc.nextLine();
		System.out.println("Enter mobile number: ");
		mobileNumber = sc.nextInt();
		System.out.println("Enter age: ");
		age = sc.nextInt();
		tempAccount = new MovieGoerAccount(userName, password, email, mobileNumber, AccountType.MOVIEGOER, age);
		if (!dataMgr.isExistingMovieGoerAccount(tempAccount)) {
			dataMgr.addMovieGoerAccount(tempAccount);
			accountMgr.setActiveAccount(tempAccount);
			accountMgr.setMovieGoerLoggedIn(true);
			System.out.println("Account Successfully Created.");
			System.out.println("Weclome to the user home screen.");


		}
		else System.out.println("Account already exists.");
	}
	
	public boolean isValidPassword(String password, String re_password) {
		if (password.equals(re_password))
			return true;
		else 
			return false;
	}
	
	public AccountType AccountType_StringToEnum(String accountTypeStr) {
		String tempString = accountTypeStr.toLowerCase();
		if (tempString.equals("admin")) 
			return AccountType.ADMIN;
		else 
			return AccountType.MOVIEGOER;	
	}
}