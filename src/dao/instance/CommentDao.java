package dao.instance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.CommentListBean;
import model.CommentModel;
import model.RecipeListModelBean;
import model.RecipeModel;
import model.SearchRecipeBean;

public class CommentDao {

	private Connection connection;
	private String dB_HOST;
	private String dB_PORT;
	private String dB_NAME;
	private String dB_USER;
	private String dB_PWD;

	public CommentDao(String DB_HOST, String DB_PORT, String DB_NAME,
			String DB_USER, String DB_PWD) {
		dB_HOST = DB_HOST;
		dB_PORT = DB_PORT;
		dB_NAME = DB_NAME;
		dB_USER = DB_USER;
		dB_PWD = DB_PWD;
	}

	public void addComment(CommentModel comment) {
		// Création de la requête
		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
					+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
			//
			String sqlInsert = "INSERT INTO comments(user_id, recipe_id, comment, rate) VALUES (?,?,?,?)";
			PreparedStatement querySt = connection.prepareStatement(sqlInsert);
			querySt.setInt(1, comment.getUser_id());
			querySt.setInt(2, comment.getRecipe_id());
			querySt.setString(3, comment.getComment());
			querySt.setInt(4, comment.getRate());

			querySt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public CommentListBean getAllCommentByRecipe(int recipe_id) {
		CommentModel comment;

		CommentListBean commentList = new CommentListBean();

		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
					+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			String sqlSelect = "SELECT * FROM vw_comments WHERE recipe_id = ?";
			PreparedStatement querySt = connection.prepareStatement(sqlSelect);
			querySt.setInt(1, recipe_id);
			ResultSet rst = querySt.executeQuery();

			while (rst.next()) {
				comment = new CommentModel(0,
						rst.getInt("recipe_id"), rst.getString("comment"),
						rst.getString("commentDate"), rst.getString("login"),
						rst.getInt("rate"));
				commentList.addCommentList(comment);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return commentList;
	}

}
