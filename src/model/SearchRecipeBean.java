package model;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class SearchRecipeBean {
	
	private int expertise;
	private int nbpeople;
	private String duration;
	private String type;
	
	public SearchRecipeBean(){	
	}
	
	public int getExpertise() {
		return expertise;
	}
	public void setExpertise(int expertise) {
		this.expertise = expertise;
	}
	public int getNbpeople() {
		return nbpeople;
	}
	public void setNbpeople(int nbpeople) {
		this.nbpeople = nbpeople;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String toString(){
		return "[EXPERTISE]="+expertise+";[NBPEOPLE]="+nbpeople+";[DURATION]="+duration+";[TYPE]="+type;
		
	}

}
