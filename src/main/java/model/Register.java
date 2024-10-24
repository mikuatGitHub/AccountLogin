package model;

// EntityClass
public class Register {
	private String userId;
	private String pass;
	private String message;
	private int age;
	
	// Setter
	public Register(String userId, String pass, String message, int age) {
		this.userId= userId;
		this.pass= pass;
		this.message= message;
		this.age= age;
	}
	
	// Getter
	public String getUserId() { return userId; } 
	public String getPass() { return pass; } 
	public String getMessage() { return message; }  
	public int getAge() { return age; } 

}
