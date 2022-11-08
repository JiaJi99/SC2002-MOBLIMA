package Model;

@SuppressWarnings("serial")
public class Admin extends User {
	
	public Admin(String username, String password) throws NoSuchAlgorithmException {
		super(username, password, ADMIN);
	}
}
