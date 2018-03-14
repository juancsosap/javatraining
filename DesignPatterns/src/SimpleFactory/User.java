package SimpleFactory;

public abstract class User {
	
	private String username;
	private String password;
	
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		System.out.println(this + " Created");
	}
	
	public abstract String toString();
	
	public abstract void administer();
	public abstract void browse();
	public abstract void visit();
	
}
