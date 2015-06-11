package model;

public class CommentModel {

	private int user_id;
	private int recipe_id;
	private String comment;
	private String commentDate;
	private String login;
	private int rate;

	public CommentModel() {

	}

	public CommentModel(int user_id, int recipe_id, String comment,
			String commentDate, String login, int rate) {
		super();
		this.user_id = user_id;
		this.recipe_id = recipe_id;
		this.comment = comment;
		this.commentDate = commentDate;
		this.login = login;
		this.rate = rate;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public String toString(){
		return "[Login] : " + login + "[Comment] : " + comment + "[Rate] : " + rate + "[Date] : " + commentDate;
	}
	
}
