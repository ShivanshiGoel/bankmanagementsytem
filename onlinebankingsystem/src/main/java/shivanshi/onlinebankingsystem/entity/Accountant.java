package shivanshi.onlinebankingsystem.entity;

public class Accountant {
	//just declaration of the objects in the stack memory
	private String accountantUsername;
	private String accountantEmail;
	private String accountantPassword;
	
	//parameterized constructor
	public Accountant(String accountantUsername, String accountantEmail, String accountantPassword) {
		super();
		this.accountantUsername = accountantUsername;
		this.accountantEmail = accountantEmail;
		this.accountantPassword = accountantPassword;
	}
	
	//non parameterized constructor (to initialize the object)
	public Accountant() {
		super();
	}
	
	//getters and setters
	
	public String getAccountantUsername() {
		return accountantUsername;
	}
	public void setAccountantUsername(String accountantUsername) {
		this.accountantUsername = accountantUsername;
	}
	public String getAccountantEmail() {
		return accountantEmail;
	}
	public void setAccountantEmail(String accountantEmail) {
		this.accountantEmail = accountantEmail;
	}
	public String getAccountantPassword() {
		return accountantPassword;
	}
	public void setAccountantPassword(String accountantPassword) {
		this.accountantPassword = accountantPassword;
	}
	
	//toString() method
	@Override
	public String toString() {
		return "Accountant [accountantUsername=" + accountantUsername + ", accountantEmail=" + accountantEmail
				+ ", accountantPassword=" + accountantPassword + "]";
	}
	
	
	
}
