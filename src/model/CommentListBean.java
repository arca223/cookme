package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CommentListBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5844110761498901268L;
	
	private List<CommentModel> commentList;
	
	public CommentListBean(){
		commentList = new ArrayList<CommentModel>();
	}
	
	public void addCommentList(CommentModel comment){
		commentList.add(comment);
	}
	
	public List<CommentModel> getCommentList(){
		return commentList;
	}

}
