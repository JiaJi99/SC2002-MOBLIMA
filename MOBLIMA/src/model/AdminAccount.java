package moblima.Model;

	public class AdminAccount extends Account{

		public AdminAccount(String userName, String password, String email, int mobileNumber, AccountType accountType) {
			super(userName, password, email, mobileNumber, accountType);
		}
		
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
		
		public AdminAccount copy() {
			return new AdminAccount(this.userName, this.password, this.email, this.mobileNumber, this.accountType);
		}
}

