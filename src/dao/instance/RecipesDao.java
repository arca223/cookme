package dao.instance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.RecipeListModelBean;
import model.RecipeModel;
import model.SearchRecipeBean;

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

	public void updateRecipe(RecipeModel recipe) {
		// Création de la requête
		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
					+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
			//
			String sqlInsert = "UPDATE recipes SET title=?,description=?,expertise=?,nbpeople=?,duration=?,type=? WHERE id=?";
			PreparedStatement querySt = connection.prepareStatement(sqlInsert);
			querySt.setString(1, recipe.getTitle());
			querySt.setString(2, recipe.getDescription());
			querySt.setInt(3, recipe.getExpertise());
			querySt.setInt(4, recipe.getNbpeople());
			querySt.setInt(5, recipe.getDuration());
			querySt.setString(6, recipe.getType());
			querySt.setInt(7, recipe.getId());

			querySt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addRecipe(RecipeModel recipe) {
		// Création de la requête
		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
					+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
			//
			String sqlUpdate = "INSERT INTO cookme.recipes (title, description, expertise, nbpeople, duration, type) VALUES (?,?,?,?,?,?)";
			PreparedStatement querySt = connection.prepareStatement(sqlUpdate);
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
	
	public void deleteRecipe(RecipeModel recipe) {
		// Création de la requête
		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
					+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
			//
			String sqlDelete = "DELETE FROM recipes WHERE id=?";
			PreparedStatement querySt = connection.prepareStatement(sqlDelete);
			querySt.setInt(1, recipe.getId());

			querySt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public RecipeListModelBean getAllRecipes() {
		java.sql.Statement query;
		RecipeModel recipe;

		RecipeListModelBean recipeList = new RecipeListModelBean();

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
				recipe.setId(rst.getInt("id"));

				recipeList.addRecipeList(recipe);
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
			sqlSelect = (criterias.getDuration() > 0) ? sqlSelect
					+ " AND duration = ?" : sqlSelect;
			
			
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
				i++;
			}
			if (criterias.getDuration() > 0) {
				querySt.setInt(i, criterias.getDuration());
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
				recipe.setId(rst.getInt("id"));
				recipeList.addRecipeList(recipe);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return recipeList;
	}

}
