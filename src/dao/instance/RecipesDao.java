package dao.instance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.RecipeListModelBean;
import model.RecipeModel;
import model.SearchRecipeBean;
import model.UserModel;

public class RecipesDao {

	private Connection connection;
	private String dB_HOST;
	private String dB_PORT;
	private String dB_NAME;
	private String dB_USER;
	private String dB_PWD;

	public RecipesDao(String DB_HOST, String DB_PORT, String DB_NAME,
			String DB_USER, String DB_PWD) {
		dB_HOST = DB_HOST;
		dB_PORT = DB_PORT;
		dB_NAME = DB_NAME;
		dB_USER = DB_USER;
		dB_PWD = DB_PWD;
	}

	public void addRecipe(RecipeModel recipe) {
		// Création de la requête
		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
					+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
			//
			String sqlInsert = "INSERT INTO cookme.recipes (title, description, expertise, nbpeople, duration, type) VALUES (?,?,?,?,?,?)";
			PreparedStatement querySt = connection.prepareStatement(sqlInsert);
			querySt.setString(1, recipe.getTitle());
			querySt.setString(2, recipe.getDescription());
			querySt.setInt(3, recipe.getExpertise());
			querySt.setInt(4, recipe.getNbpeople());
			querySt.setInt(5, recipe.getDuration());
			querySt.setString(6, recipe.getType());

			querySt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<RecipeModel> getAllRecipes() {
		java.sql.Statement query;
		RecipeModel recipe;

		ArrayList<RecipeModel> recipeList = new ArrayList<RecipeModel>();

		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
					+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			String sqlSelect = "SELECT * FROM recipes";

			query = connection.createStatement();

			ResultSet rst = query.executeQuery(sqlSelect);

			while (rst.next()) {

				recipe = new RecipeModel();
				recipe.setTitle(rst.getString("title"));
				recipe.setDescription(rst.getString("description"));
				recipe.setExpertise(rst.getInt("expertise"));
				recipe.setNbpeople(rst.getInt("nbpeople"));
				recipe.setDuration(rst.getInt("duration"));
				recipe.setType(rst.getString("type"));

				recipeList.add(recipe);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return recipeList;
	}

	public RecipeListModelBean getRecipesByCriterias(SearchRecipeBean criterias) {
		RecipeModel recipe;

		RecipeListModelBean recipeList = new RecipeListModelBean();
		// Création de la requête
		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
					+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
			//
			String sqlSelect = "SELECT * FROM recipes WHERE 1=1";

			sqlSelect = (criterias.getExpertise() > 0) ? sqlSelect
					+ " AND expertise = ?" : sqlSelect;
			sqlSelect = (criterias.getNbpeople() > 0) ? sqlSelect
					+ " AND nbpeople = ?" : sqlSelect;
			sqlSelect = (criterias.getType().length() > 0) ? sqlSelect
					+ " AND type = ?" : sqlSelect;
			sqlSelect = (criterias.getConvertedDuration() > 0) ? sqlSelect
					+ " AND duration = ?" : sqlSelect;
			
			System.out.println(sqlSelect);
			
			PreparedStatement querySt = connection.prepareStatement(sqlSelect);

			int i = 1;

			if (criterias.getExpertise() > 0) {
				querySt.setInt(i, criterias.getExpertise());
				i++;
			}
			if (criterias.getNbpeople() > 0) {
				querySt.setInt(i, criterias.getNbpeople());
				i++;
			}
			if (criterias.getType().length() > 0) {
				querySt.setString(i, criterias.getType());
				System.out.println(criterias.getType() + " " + i);
				i++;
			}
			if (criterias.getConvertedDuration() > 0) {
				querySt.setInt(i, criterias.getConvertedDuration());
				System.out.println(criterias.getConvertedDuration() + " " + i);
			}

			ResultSet rst = querySt.executeQuery();

			while (rst.next()) {

				recipe = new RecipeModel();
				recipe.setTitle(rst.getString("title"));
				recipe.setDescription(rst.getString("description"));
				recipe.setExpertise(rst.getInt("expertise"));
				recipe.setNbpeople(rst.getInt("nbpeople"));
				recipe.setDuration(rst.getInt("duration"));
				recipe.setType(rst.getString("type"));
				recipeList.addRecipeList(recipe);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return recipeList;
	}

}
