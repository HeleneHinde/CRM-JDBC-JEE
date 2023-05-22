package fr.wijin.crm.model;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1221366484235490734L;

	private Integer id;

	private String username;

	private String password;

	private String mail;

	private String grants;

	public User() {
		super();
	}

	public User(Integer id, String username, String password, String mail, String grants) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.grants = grants;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getGrants() {
		return grants;
	}

	public void setGrants(String grants) {
		this.grants = grants;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", mail=" + mail + ", grants="
				+ grants + "]";
	}

}
