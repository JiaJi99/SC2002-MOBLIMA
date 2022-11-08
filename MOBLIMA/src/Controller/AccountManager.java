package moblima.Manager;

import moblima.Model.Account;

public class AccountManager {
	private boolean movieGoerLoggedIn;
	private boolean adminLoggedIn;
	private Account activeAccount;
	
	public AccountManager() {
		this.movieGoerLoggedIn = false;
		this.adminLoggedIn = false;
		this.activeAccount = null;		
	}
	
	public boolean getMovieGoerLoggedIn() {
		return this.movieGoerLoggedIn;
	}
	
	public boolean getAdminLoggedIn() {
		return this.adminLoggedIn;
	}
	
	public Account getActiveAccount() {
		return this.activeAccount;
	}
	
	public void setMovieGoerLoggedIn(boolean bool) {
		this.movieGoerLoggedIn = bool;
	}
	
	public void setAdminLoggedIn(boolean bool) {
		this.adminLoggedIn = bool;
	}
	
	public void setActiveAccount(Account activeAccount) {
		this.activeAccount = activeAccount;
	}
}
