package processing;

import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import model.LoginBean;
import model.UserModelBean;
import model.UserSubmissionModelBean;
import dao.fabric.DaoFabric;
import dao.instance.UserDao;

@ManagedBean
@ApplicationScoped
// Utilisation de application scope afin d'offrir un point d'entrée unique à
// l'ensemble des clients
public class UserControlerBean {
	private UserDao userDao;

	public UserControlerBean() {
		this.userDao = DaoFabric.getInstance().createUserDao();
	}

	public String checkUser(LoginBean loginBean) {	
		
		UserModelBean user = this.userDao.checkUser(loginBean.getLogin(),loginBean.getPwd());
		System.out.println(user.toString());
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
	
	
	
	
}
