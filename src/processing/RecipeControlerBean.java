package processing;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import model.CommentListBean;
import model.CommentSubmissionBean;
import model.RecipeListModelBean;
import model.RecipeModel;
import model.SearchRecipeBean;
import model.UserModel;
import dao.fabric.DaoFabric;
import dao.instance.CommentDao;
import dao.instance.RecipesDao;

@ManagedBean
@SessionScoped
public class RecipeControlerBean {
	private RecipesDao recipeDao;
	private CommentDao commentDao;

	public RecipeControlerBean() {
		this.recipeDao = DaoFabric.getInstance().createRecipesDao();
		this.commentDao = DaoFabric.getInstance().createCommentDao();
	}

	public void loadAllRecipe() {
		RecipeListModelBean recipeList = new RecipeListModelBean();
		// récupère l'espace de mémoire de JSF
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		// place la liste de recette dans l'espace de mémoire de JSF
		sessionMap.put("recipeList", recipeList);
	}

	public String getRecipList(SearchRecipeBean searchCriterias) {

		RecipeListModelBean recipeList = recipeDao
				.getRecipesByCriterias(searchCriterias);

		// récupère l'espace de mémoire de JSF
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		// place l'utilisateur dans l'espace de mémoire de JSF
		sessionMap.put("resultRecipe", recipeList);
		// redirect the current page


		return "recipeResult.jsf";

	}
	
	public String getRecipe(RecipeModel recipe){
				
		CommentListBean clist = new CommentListBean();
		clist = commentDao.getAllCommentByRecipe(recipe.getId());
		
		// récupère l'espace de mémoire de JSF
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("selectedRecipe", recipe);

		
		sessionMap.put("commentList", clist);
		
		return "recipe.jsf";
	}
	
	public void addComment(CommentSubmissionBean comment){
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		UserModel user = (UserModel) sessionMap.get("loggedUser");
		RecipeModel recipe = (RecipeModel) sessionMap.get("selectedRecipe");
		

		
		if(user !=null){
			comment.setUser_id(user.getId());
			comment.setRecipe_id(recipe.getId());
			commentDao.addComment(comment);
			
		}
		
	}
}
