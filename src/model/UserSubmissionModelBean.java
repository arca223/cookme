package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
// Durée de vue uniquement lors d'une requète
// même propriétés que UserModelBean mais portée différente
public class UserSubmissionModelBean extends UserModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6643948488693360359L;

	public UserSubmissionModelBean() {
	}
}
