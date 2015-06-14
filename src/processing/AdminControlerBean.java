package processing;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import model.UserListModelBean;
import model.UserModel;
import processing.UserControlerBean;
import processing.RecipeControlerBean;

@ManagedBean
@SessionScoped

public class AdminControlerBean {

	
	public AdminControlerBean(){}
	
	public String manageUsers() {
		UserControlerBean u = new UserControlerBean();
		u.getAllUsers();
		
		return "manageUsers.jsf";
	}
	
	
	public String manageRecipes() {
		
		RecipeControlerBean r = new RecipeControlerBean();
		r.loadAllRecipe();
		
		return "manageRecipes.jsf";
	}
	
	public String editSelectedUser(UserModel user) {
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
		int ret = u.updateUser(user);
		u.getAllUsers();
		return Integer.toString(ret);
	}
	
	public void closeTab() {
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.remove("selectedUser");
	}
	
	
}
