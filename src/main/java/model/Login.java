package model;

// EntityClass
public class Login {
	private String userId;
	private String pass;
	
	// Setter
	public Login(String userId, String pass) {
		this.userId= userId;
		this.pass= pass;
	}
	
	// Getter
	public String getUserId() { return userId; } 
	public String getPass() { return pass; } 

}
