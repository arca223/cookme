package processing;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import model.RecipeListModelBean;
import model.RecipeModel;
import model.SearchRecipeBean;
import dao.fabric.DaoFabric;
import dao.instance.RecipesDao;

@ManagedBean
@SessionScoped
public class RecipeControlerBean {
	private RecipesDao recipeDao;

	public RecipeControlerBean() {
		this.recipeDao = DaoFabric.getInstance().createRecipesDao();
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

		System.out.println(searchCriterias.toString());

		return "recipeResult.jsf";

	}
	
	public String getRecipe(RecipeModel recipe){
		
		System.out.println(recipe.toString());
		
		
		// récupère l'espace de mémoire de JSF
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("selectedRecipe", recipe);
		
		return "recipe.jsf";
	}
}
