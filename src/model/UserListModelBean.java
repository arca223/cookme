package model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class UserListModelBean {

	
	private List<UserModel> userList;
	private UserModel selectedUser;
	
	public UserListModelBean() {		
		userList = new ArrayList<UserModel>();
	}
	
	public List<UserModel> getUserList() {
		return userList;
	}
	
	public void addUserList(UserModel user) {
		this.userList.add(user);
	}

	public UserModel getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UserModel selectedUser) {
		this.selectedUser = selectedUser;
	}
	
}

