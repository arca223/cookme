package dao.instance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.UserModel;

public class UserDao {
	private Connection connection;
	private String dB_HOST;
	private String dB_PORT;
	private String dB_NAME;
	private String dB_USER;
	private String dB_PWD;

	public UserDao(String DB_HOST, String DB_PORT, String DB_NAME,
			String DB_USER, String DB_PWD) {
		dB_HOST = DB_HOST;
		dB_PORT = DB_PORT;
		dB_NAME = DB_NAME;
		dB_USER = DB_USER;
		dB_PWD = DB_PWD;
	}

	public int addUser(UserModel user) {
		// Création de la requête
		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
					+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			String sqlInsert = "INSERT INTO users(firstname, lastname, age, mail, login, pwd) VALUES (?,?,?,?,?,?)";
			PreparedStatement querySt = connection.prepareStatement(sqlInsert);

			querySt.setString(1, user.getFirstname());
			querySt.setString(2, user.getLastname());
			querySt.setInt(3, user.getAge());
			querySt.setString(4, user.getMail());
			querySt.setString(5, user.getLogin());
			querySt.setString(6, user.getPwd());

			int res = querySt.executeUpdate();
			connection.close();
			
			return res;
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
			return 0;
		}
	}

	public ArrayList<UserModel> getAllUser() {

		java.sql.Statement query;
		UserModel user;
		// return value
		ArrayList<UserModel> userList = new ArrayList<UserModel>();
		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
					+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			String sqlSelect = "SELECT * FROM users";

			query = connection.createStatement();

			ResultSet rst = query.executeQuery(sqlSelect);

			while (rst.next()) {

				user = new UserModel();// rst.getString("firstname"),rst.getString("lastname"));
				user.setFirstname(rst.getString("firstname"));
				user.setLastname(rst.getString("lastname"));
				user.setMail(rst.getString("mail"));
				user.setAge(rst.getInt("age"));
				user.setLogin(rst.getString("login"));
				user.setPwd(rst.getString("pwd"));
				user.setAdmin(rst.getInt("admin"));
				

				userList.add(user);

			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	public UserModel checkUser(String login, String pwd) {
		
		UserModel user = null;
		
		try{
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
					+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			String sqlSelect = "SELECT * FROM users WHERE login = ? AND pwd = ?";
			PreparedStatement querySt = connection.prepareStatement(sqlSelect);
			querySt.setString(1, login);
			querySt.setString(2, pwd);
			
			ResultSet rst = querySt.executeQuery();
			
			
			while (rst.next()) {

				user = new UserModel();
				user.setFirstname(rst.getString("firstname"));
				user.setLastname(rst.getString("lastname"));
				user.setMail(rst.getString("mail"));
				user.setAge(rst.getInt("age"));
				user.setLogin(rst.getString("login"));
				user.setPwd(rst.getString("pwd"));

			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
}
