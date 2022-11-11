package ManagerClasses;


import java.util.Scanner;

import BaseClasses.*;

public class LoginManager {
		private AccountManager accountMgr;
		private DataManager dataMgr;
		
		public LoginManager(AccountManager accountMgr, DataManager dataMgr) {
			this.accountMgr = accountMgr;
			this.dataMgr = dataMgr;
		}
		
		
		public void loginUser() {
			Scanner sc = new Scanner(System.in);
			String userName, password;
			Account tempAccount;
			System.out.println("Enter your username: ");
			userName = sc.nextLine();
			System.out.println("Enter your password: ");
			password = sc.nextLine();
			tempAccount = accountMatch(userName, password);
			if (tempAccount == null) {
				System.out.println("Account does not exist / Wrong username or password entered.");
				System.out.println("Please register a new account / Try again");
				return;
			}
			else {
				accountMgr.setActiveAccount(tempAccount);
				System.out.printf("Welcome, %s\n", tempAccount.getUserName());
				if (tempAccount.getAccountType() == AccountType.ADMIN)
					accountMgr.setAdminLoggedIn(true);
				else 
					accountMgr.setMovieGoerLoggedIn(true);
				return;
			}
			
					
		}
		
		public Account accountMatch(String userName, String password) {
			Account tempAccount;
			for (int i=0; i< dataMgr.getAdminAccounts().size(); i++) {
				tempAccount = dataMgr.getAdminAccounts().get(i);
				if (userName.equals(tempAccount.getUserName()) &&
					password.equals(tempAccount.getPassword()))
					return tempAccount;
			}
				for (int i=0; i< dataMgr.getMovieGoerAccounts().size(); i++) {
					tempAccount = dataMgr.getMovieGoerAccounts().get(i);
					if (userName.equals(tempAccount.getUserName()) &&
						password.equals(tempAccount.getPassword()))
						return tempAccount;
			}
			return null;
		}
		

		
		public AccountType AccountType_StringToEnum(String accountTypeStr) {
			String tempString = accountTypeStr.toLowerCase();
			if (tempString.equals("admin")) 
				return AccountType.ADMIN;
			else 
				return AccountType.MOVIEGOER;	
		}
	}
