package moblima.Model;


/**
 *Represent a moviegoer account
 */
@SuppressWarnings("serial")
public class MovieGoerAccount extends Account{
	
	/**
	 * MovieGoerAccount age
	 */
	protected int age;
	
	
	/**
	 * Create a movie goer account with the given attributes
	 * @param userName  		Name of movie goer
	 * @param password			Password of account
	 * @param email				email of movie goer
	 * @param mobileNumber		Mobile number of movie goer
	 * @param accountType		Type of account
	 * @param age				Age of movie goer
	 */
	public MovieGoerAccount(String userName, String password, String email, int mobileNumber, AccountType accountType, int age) {
		super(userName, password, email, mobileNumber, accountType);
		this.age = age;
	}
	
	
	/**
	 * Get movie goer age
	 * @return int  This moviegoer's age
	 */
	public int getAge() {
		return this.age;
	}
	
	
	/**
	 * Set movie goer age
	 * @param age  This movie goer's age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	
	/**
	 * Compare this account to anotherAccount
	 * @param anotherAccount
	 * @return boolean   	Return true if both account are equal, else false
	 */
	public boolean equals(MovieGoerAccount anotherAccount) {
		if ((this.userName).equals(anotherAccount.getUserName())    &&
			(this.password).equals(anotherAccount.getPassword())    &&
			(this.email).equals(anotherAccount.getEmail())          &&
			 this.mobileNumber == anotherAccount.getMobileNumber()  &&
			 this.accountType  == anotherAccount.getAccountType()   &&
			 this.age == anotherAccount.getAge()                     )
			return true;
		else 
			return false;
	}
	
	/**
	 * Copy and return a copy of this account
	 * @return MovieGoerAccount  	A copy of this MovieGoerAccount
	 */
	public MovieGoerAccount copy() {
		return new MovieGoerAccount(this.userName, this.password, this.email, this.mobileNumber, this.accountType, this.age);
	}
}
