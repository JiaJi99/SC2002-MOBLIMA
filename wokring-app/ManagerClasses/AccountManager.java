package ManagerClasses;

import java.io.Serializable;

import BaseClasses.*;

public class AccountManager implements Serializable {
	private boolean movieGoerLoggedIn;
	private boolean adminLoggedIn;
	private Account activeAccount;
	
	
	/**
	 * Create a default constructor
	 */
	public AccountManager() {
		this.movieGoerLoggedIn = false;
		this.adminLoggedIn = false;
		this.activeAccount = null;		
	}
	
	/**
	 * Get Logged in status for moviegoer
	 * @return boolean 	
	 */
	public boolean getMovieGoerLoggedIn() {
		return this.movieGoerLoggedIn;
	}
	
	/**
	 * Get logged in status for admin
	 * @return
	 */
	public boolean getAdminLoggedIn() {
		return this.adminLoggedIn;
	}
	
	
	/**
	 * Get The Account that is being used
	 * Return admin account or
	 * return movie goer 
	 * @return Account
	 */
	public Account getActiveAccount() {
		return this.activeAccount;
	}
	
	/**
	 * Set login status for movie goer
	 * @param bool  true to set login successful, else false
	 */
	public void setMovieGoerLoggedIn(boolean bool) {
		this.movieGoerLoggedIn = bool;
	}
	
	
	/**
	 * Set login status for admin
	 * @param bool   true to set login successful, else false
	 */
	public void setAdminLoggedIn(boolean bool) {
		this.adminLoggedIn = bool;
	}
	
	
	/**
	 * Set the account object to be used
	 * movie goer account or
	 * admin account
	 * @param activeAccount  
	 */
	public void setActiveAccount(Account activeAccount) {
		this.activeAccount = activeAccount;
	}
}
