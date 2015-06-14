
package model;

import java.io.Serializable;


public class UserModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstname; //prenom
	private String lastname; //nom
	private String mail;
	private int age;
	private String login;
	private String pwd;
	private int id;
	private boolean admin;

	// Contrainte BEAN constructeur sans paramètre
	public UserModel() {
	}
	public UserModel(String firstname, String lastname, String mail, int age, String login, String pwd, boolean admin) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.mail = mail;
		this.age = age;
		this.login = login;
		this.pwd = pwd;
		this.admin = admin;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "[SURNAME]:" + this.getFirstname() + ",[LASTNAME]:"
				+ this.getLastname() + ",[AGE]:" + this.getAge() + ",[LOGIN]:"
				+ this.getLogin() + ",[PWD]:" + this.getPwd() + ",[ADMIN]:" + this.getAdmin();
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public boolean getAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
