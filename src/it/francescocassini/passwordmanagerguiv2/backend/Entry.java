package it.francescocassini.passwordmanagerguiv2.backend;

public class Entry {
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	int id;
	
	String username;
	
	String password;
	
	String url;
	
	String description;
	
	String label;
	
	public Entry(int id, String username, String password, String url, String description, String label) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.url = url;
		this.description = description;
		this.label = label;
		
	}

}
