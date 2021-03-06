package processing;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import model.RecipeModel;
import model.UserListModelBean;
import model.UserModel;
import processing.UserControlerBean;
import processing.RecipeControlerBean;

@ManagedBean
@SessionScoped

public class AdminControlerBean {

	private int addRecipe = 0;
	private int addUser = 0;
	private RecipeControlerBean recipeControler;
	public AdminControlerBean(){}
	
	public String manageUsers() {
		UserControlerBean u = new UserControlerBean();
		u.getAllUsers();
		
		return "manageUsers.jsf";
	}
	
	
	public String manageRecipes() {
		
		recipeControler = new RecipeControlerBean();
		recipeControler.loadAllRecipe();
		

		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.remove("editedRecipe");
		
		return "manageRecipes.jsf";
	}
	
	public String editSelectedUser(UserModel user) {
		addUser = 0;
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("selectedUser", user);
		return "manageUsers.jsf";
	}

	public String deleteUser(UserModel user) {
		UserControlerBean u = new UserControlerBean();
		int ret = u.delUser(user);
		u.getAllUsers();
		return Integer.toString(ret);
	}
	
	public String saveUser(UserModel user) {
		UserControlerBean u = new UserControlerBean();
		int ret = 0;
		if (this.addUser==0) {
			ret = u.updateUser(user);
		} else {
			ret = u.addUser(user);
		}		
		u.getAllUsers();
		return Integer.toString(ret);
	}
	
	public void closeTab() {
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.remove("selectedUser");
	}	
	
	public void newUser() {
		this.addUser = 1;
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("selectedUser", new UserModel("","","",0,"","",false));
	}
	
	
	public String editSelectedRecipe(RecipeModel recipe){
		addRecipe = 0;
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("editedRecipe", recipe);
		return "manageRecipes.jsf";
	}
	
	public String addNewRecipe(){
		addRecipe = 1;
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("editedRecipe", new RecipeModel("","",0,0,0,"salad"));
		System.out.println("test");
		
		return "manageRecipes.jsf";
	}
	
	public String saveRecipe(RecipeModel recipe){
		if(addRecipe == 1){
			recipeControler.addRecipe(recipe);
		}
		else{
			recipeControler.updateRecipe(recipe);
		}
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.remove("editedRecipe");
		
		return "manageRecipes.jsf";
	}
	
	public String deleteRecipe(RecipeModel recipe){
		recipeControler.deleteRecipe(recipe);
		
		
		return "manageRecipes.jsf";
	}
	
	public String closeRecipeTab() {
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.remove("editedRecipe");
		
		return "manageRecipes.jsf";
	}
	
}
