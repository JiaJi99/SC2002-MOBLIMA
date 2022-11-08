package moblima.Model;
import java.io.*;

public class Account implements Serializable{
	protected String userName;
	protected String password;
	protected String email;
	protected int mobileNumber;
	protected AccountType accountType;
	
	public Account(String userName, String password, String email, int mobileNumber, AccountType accountType) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.accountType = accountType;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public int getMobileNumber() {
		return this.mobileNumber;
	}
	
	public AccountType getAccountType() {
		return this.accountType;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
	public  boolean equals(Account anotherAccount) {
		if ((this.userName).equals(anotherAccount.getUserName())    &&
				(this.password).equals(anotherAccount.getPassword())    &&
				(this.email).equals(anotherAccount.getEmail())          &&
				 this.mobileNumber == anotherAccount.getMobileNumber()  &&
				 this.accountType  == anotherAccount.getAccountType()   )
				return true;
			else 
				return false;
	}
	

	public  Account copy() {
		return new Account(this.userName, this.password, this.email, this.mobileNumber, this.accountType);
		
	}

	
}
