
public class User implements java.io.Serializable {
	/**
	 * User
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String pass;
	private String role;
	
	public User() {
	}
	
	public User(String name,String pass,String role) {
		this.setName(name);
		this.setPass(pass);
		this.setRole(role);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}