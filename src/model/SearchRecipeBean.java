package model;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class SearchRecipeBean {
	
	private int expertise;
	private int nbpeople;
	private String duration;
	private int convertedDuration;
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
		
		//convertedDuration = Integer.parseInt(duration.substring(0, 1));
		convertedDuration = (duration.length() > 0 ) ? Integer.parseInt(duration.substring(0, 1)) : 0;
		this.duration = duration;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public int getConvertedDuration() {
		return convertedDuration;
	}

	public void setConvertedDuration(int convertedDuration) {
		this.convertedDuration = convertedDuration;
	}

	public String toString(){
		return "[EXPERTISE]="+expertise+";[NBPEOPLE]="+nbpeople+";[DURATION]="+convertedDuration+";[TYPE]="+type;
		
	}
	
	

}
