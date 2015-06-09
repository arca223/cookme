package processing;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import processing.UserControlerBean;
import processing.RecipeControlerBean;

@ManagedBean
@SessionScoped

public class AdminControlerBean {

	
	public AdminControlerBean(){}
	
	public String manageUsers() {
		System.out.println("test");
		UserControlerBean u = new UserControlerBean();
		u.getAllUsers();
		
		return "manageUsers.jsf";
	}
	
	
	public String manageRecipes() {
		
		RecipeControlerBean r = new RecipeControlerBean();
		r.loadAllRecipe();
		
		return "manageRecipes.jsf";
	}
	
	
	
	
}
