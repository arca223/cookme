package processing;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import model.LoginBean;
import model.UserListModelBean;
import model.UserModel;
import model.UserSubmissionModelBean;
import dao.fabric.DaoFabric;
import dao.instance.UserDao;

@ManagedBean
@SessionScoped

public class UserControlerBean {
	private UserDao userDao;

	public UserControlerBean() {
		this.userDao = DaoFabric.getInstance().createUserDao();
	}

	
	public void getAllUsers() {
		ArrayList<UserModel> list = this.userDao.getAllUser();
		UserListModelBean userList = new UserListModelBean();
		for (UserModel user : list) {
			userList.addUserList(user);
		}
		// récupère l'espace de mémoire de JSF
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		// place la liste de recette dans l'espace de mémoire de JSF
		sessionMap.put("users", userList);
	}
	
	public String checkUser(LoginBean loginBean) {	
		
		UserModel user = this.userDao.checkUser(loginBean.getLogin(),loginBean.getPwd());
		if (user != null) {
			// récupère l'espace de mémoire de JSF
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = externalContext.getSessionMap();
			// place l'utilisateur dans l'espace de mémoire de JSF
			sessionMap.put("loggedUser", user);
			// redirect the current page
			return "userDisplay.xhtml";
		} 
		else 
		{
			// redirect the current page
			return "identification.xhtml";
		}
	}

	public String checkAndAddUser(UserSubmissionModelBean userSubmitted) {
		// Vérifier les propriétés de l'utilisateur
		// TODO
		// ajout de l'utilisateur à la base de données
		int res = this.userDao.addUser(userSubmitted);
		if (res != 0) {
			return "login.xhtml";
		} else {
			return Integer.toString(res);
		}
	}
	
	public int delUser(UserModel user){
		int ret = this.userDao.deleteUser(user);
		return ret;		
	}
	
	public int updateUser(UserModel user) {
		int ret = this.userDao.updateUser(user);
		return ret;	
	}
	
	public int addUser(UserModel user) {
		int ret = this.userDao.addUser(user);
		return ret;
	}
	
}
