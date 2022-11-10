package moblima.Model;

/**
 * Represent an Admin Account
 */
public class AdminAccount extends Account{
	
	/**
	 * *Creates an admin account with the given attributes
	 * @param userName 			UserName of Admin
	 * @param password			Password of Admin
	 * @param email				Email of Admin
	 * @param mobileNumber		mobile number of Admin
	 * @param accountType		Account type
	 */
	public AdminAccount(String userName, String password, String email, int mobileNumber, AccountType accountType) {
		super(userName, password, email, mobileNumber, accountType);
	}
	
	
	
	/**
	 * Check of this Admin account is equal to anotherAccount
	 * @param anotherAccount   Account to check if equal to this admin Account
	 * @return boolean     	   Return true if this admin account is equal to another admin account, else return false
	 */
	public boolean equals(AdminAccount anotherAccount) {
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
	 * Copy and return a copy of this account
	 * @return AdminAccount 
	 */
	public AdminAccount copy() { 
		return new AdminAccount(this.userName, this.password, this.email, this.mobileNumber, this.accountType);
	}
}

