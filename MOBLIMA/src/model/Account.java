package moblima.Model;
import java.io.*;

/**
 * Represent an Account
 */
public class Account implements Serializable{
	
	/**
	 * This Account's userName
	 */
	protected String userName;
	
	/**
	 * This Account's email
	 */
	protected String password;
	
	/**
	 * This Account's password 
	 */
	protected String email;
	
	/**
	 * This Account's mobileNumber 
	 */
	protected int mobileNumber;
	
	/**
	 * This Account's accountType
	 */
	protected AccountType accountType;
	
	
	/**
	 * Create an Account with the given attributes
	 * @param userName 		This Account's userName
	 * @param password		This Account's password
	 * @param email			This Account's  email
	 * @param mobileNumber	This Account's mobileNumber
	 * @param accountType	This Account's accountType
	 */
	public Account(String userName, String password, String email, int mobileNumber, AccountType accountType) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.accountType = accountType;
	}
	
	
	/**
	 * Get the UserName of this Account
	 * @return String 	UserName of this Account
	 */
	public String getUserName() {
		return this.userName;
	}
	
	
	/**
	 * Get the Password of this Account
	 * @return String 	Password of this Account
	 */
	public String getPassword() {
		return this.password;
	}
	
	
	/**
	 * Get the Email of the Account
	 * @return String	Email of this Account
	 */
	public String getEmail() {
		return this.email;
	}
	
	
	/**
	 * Get the MobileNumber of this Account
	 * @return int		MobileNumber of this Account
	 */
	public int getMobileNumber() {
		return this.mobileNumber;
	}
	
	
	/**
	 * Get the AccountType of this Account
	 * @return AccountType		AccountType of this Account
	 */
	public AccountType getAccountType() {
		return this.accountType;
	}
	
	
	/**
	 * Set the UserName of this Account
	 * @param userName		New UserName of this Account
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	/**
	 * Set the Password of this Account
	 * @param password		New Password of this Account
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	/**
	 * Set the Email of this Account
	 * @param email		New Email of this Account
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	/**
	 * Set the MobileNumber of this Account
	 * @param mobileNumber		New MobileNumber of this Account
	 */
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
	/**
	 * Set the AccountType of this Account
	 * @param accountType		New AccountType of this Account
	 */
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
	
	/**
	 * Compare and check if object is identical to this Account
	 * @param anotherAccount	item to be compared to
	 * @return boolean			Return true if anotherAccount is identical to this Account, else false 
	 */
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
	

	/**
	 * Copy the Account
	 * @return Account Return Account of this Account
	 */
	public  Account copy() {
		return new Account(this.userName, this.password, this.email, this.mobileNumber, this.accountType);
		
	}

	
}
