package moblima.Model;

public class MovieGoerAccount extends Account{
	protected int age;
	//private ArrayList<History> history; 
	public MovieGoerAccount(String userName, String password, String email, int mobileNumber, AccountType accountType, int age) {
		super(userName, password, email, mobileNumber, accountType);
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
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
	
	public MovieGoerAccount copy() {
		return new MovieGoerAccount(this.userName, this.password, this.email, this.mobileNumber, this.accountType, this.age);
	}
}