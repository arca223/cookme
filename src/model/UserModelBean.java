package model;

import java.io.Serializable;

public class UserModelBean implements Serializable {
	private String firstname; //prenom
	private String lastname; //nom
	private String mail;
	private int age;
	private String login;
	private String pwd;

	// Contrainte BEAN constructeur sans paramètre
	public UserModelBean() {
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
				+ this.getLogin() + ",[PWD]:" + this.getPwd();
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}
