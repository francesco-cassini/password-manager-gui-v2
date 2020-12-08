package it.francescocassini.passwordmanagerguiv2.backend;
public class Login {
	
	private String user = "fca";
	private String password = "1234";

	private String getUser() {
		return user;
	}

	private void setUser(String user) {
		this.user = user;
	}
	
	private String getPassword() {
		return password;
	}

	private void setPassword(String password) {
		this.password = password;
	}
	
	public Login() {
		
	}
	
	public Boolean auth(String inpUser, String inpPass) {
			    
		    if (inpUser.equals(getUser()) && inpPass.equals(getPassword())) {
		        //System.out.print("\n### Login success ### \n\n");
		        return true;
		    } else {
		        //System.out.print("\n### Error ### \n");
		        return false;
		    }
	}

}
