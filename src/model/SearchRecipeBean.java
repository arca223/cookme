package model;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class SearchRecipeBean implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1897074829530405405L;
	
	private int expertise;
	private int nbpeople;
	private int duration;
	private String type;
	
	

	public SearchRecipeBean(){	
	}
	
	public SearchRecipeBean(int expertise, int nbpeople, int duration,
			String type) {
		super();
		this.expertise = expertise;
		this.nbpeople = nbpeople;
		this.duration = duration;
		this.type = type;
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
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		
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
