
package model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


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
	private int admin;

	// Contrainte BEAN constructeur sans paramètre
	public UserModel() {
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

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

}
