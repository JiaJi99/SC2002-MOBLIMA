package moblima.Manager;

import java.util.Scanner;

import moblima.Model.*;

public class AccountSettingManager {
	
	/**
	 * Manager that this manager will reference
	 */
	private AccountManager accountMgr;
	
	/**
	 * Manager that this manager will reference
	 */
	private DataManager dataMgr;
	
	
	/**
	 * Create a manager for easy access to it manager reference
	 * @param accountMgr
	 * @param dataMgr
	 */
	public AccountSettingManager(AccountManager accountMgr, DataManager dataMgr) {
		this.accountMgr = accountMgr;
		this.dataMgr = dataMgr;
	}
	 
	
	/**
	 * Update user name by getting input from user
	 */
	public void updateUserName() {
		Account currentAccount = accountMgr.getActiveAccount();
		String existingUserName = currentAccount.getUserName();
		String newUserName;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new username: ");
		newUserName = sc.nextLine();
		if (newUserName.equals(existingUserName)) {
			System.out.println("Username entered is the same as existing username.");
			System.out.println("No changes have been made.");
			return;
		}
		else {
			currentAccount.setUserName(newUserName);
			System.out.println("Username has been updated.");
		}
	}
	
	

	/**
	 * Update password by gettting input from user
	 */
	public void updatePassword() {
		Account currentAccount = accountMgr.getActiveAccount();
		String existingPassword = currentAccount.getPassword();
		String oldPassword, newPassword, re_newPassword;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter current password: ");
			oldPassword = sc.nextLine();
			if (!oldPassword.equals(existingPassword)) 
				System.out.println("Wrong password entered. Please try again.");
		} while (!oldPassword.equals(existingPassword));
		do {
			System.out.println("Enter new password: ");
			newPassword = sc.nextLine();
			System.out.println("Re-enter new password: ");
			re_newPassword = sc.nextLine();
			if (!isValidPassword(newPassword, re_newPassword))
				System.out.println("Password do not match. Please try again. ");
		} while (!isValidPassword(newPassword, re_newPassword));
		if (newPassword.equals(existingPassword)) {
			System.out.println("Password entered is the same as existing password.");
			System.out.println("No changes have been made.");
			return;
		}
		else {
			currentAccount.setPassword(newPassword);
			System.out.println("Password has been updated.");
		}	
	}
	
	/**
	 * update email by getting update from user
	 */
	public void updateEmail() {
		Account currentAccount = accountMgr.getActiveAccount();
		String existingEmail = currentAccount.getEmail();
		String newEmail;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new email: ");
		newEmail = sc.nextLine();
		if (newEmail.equals(existingEmail)) {
			System.out.println("Email entered is the same as existing email.");
			System.out.println("No changes have been made.");
			return;
		}
		else {
			currentAccount.setEmail(newEmail);
			System.out.println("Email has been updated.");
		}
	}
	
	
	/**
	 * update mobile number by getting input from user
	 */
	public void updateMobileNumber() {
		Account currentAccount = accountMgr.getActiveAccount();
		int existingMobileNumber = currentAccount.getMobileNumber();
		int newMobileNumber;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new phone number: ");
		newMobileNumber = sc.nextInt();
		if (newMobileNumber ==existingMobileNumber) {
			System.out.println("Mobile number entered is the same as existing mobile number.");
			System.out.println("No changes have been made.");
			return;
		}
		else {
			currentAccount.setMobileNumber(newMobileNumber);
			System.out.println("Mobile number has been updated.");
		}
	}
	
	
	/**
	 * update age by getting input from user
	 */
	public void updateAge() {
		MovieGoerAccount currentAccount = (MovieGoerAccount) accountMgr.getActiveAccount();
		int existingAge = currentAccount.getMobileNumber();
		int newAge;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new age: ");
		newAge = sc.nextInt();
		if (newAge == existingAge) {
			System.out.println("Age entered is the same as existing age.");
			System.out.println("No changes have been made.");
			return;
		}
		else {
			currentAccount.setMobileNumber(newAge);
			System.out.println("Age has been updated.");
		}
	}
	
	/**
	 * Check if both instance of password is equal to each other
	 * @param password     	first input of password
	 * @param re_password	second input of password
	 * @return
	 */
	public boolean isValidPassword(String password, String re_password) {
		if (password.equals(re_password))
			return true;
		else 
			return false;
	}
	
	
	/**
	 * Delete Account
	 */
	public void deleteAccount(){
		Account currentAccount = accountMgr.getActiveAccount();
		if (currentAccount.getAccountType() == AccountType.ADMIN)
			dataMgr.removeAdminAccount((AdminAccount)currentAccount);
		else
			dataMgr.removeMovieGoerAccount((MovieGoerAccount)currentAccount);
		accountMgr.setActiveAccount(null);	
		accountMgr.setAdminLoggedIn(false);
		accountMgr.setMovieGoerLoggedIn(false);
		System.out.println("Account successfully deleted.");
	}
	
	
	/**
	 * Get enum of account Typpe
	 * @param accountTypeStr
	 * @return enum string of account type
	 */
	public AccountType AccountType_StringToEnum(String accountTypeStr) {
		String tempString = accountTypeStr.toLowerCase();
		if (tempString.equals("admin")) 
			return AccountType.ADMIN;
		else 
			return AccountType.MOVIEGOER;	
	}
}
