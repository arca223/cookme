package validators;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "validators.userage")
public class UserAgeValidator implements Validator {
	private static final int USERAGE_PATTERN = 100;

	public UserAgeValidator() {
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		 if(! ((Integer)value<USERAGE_PATTERN)){
			 FacesMessage msg =
			 new FacesMessage("user login validation failed.",
					 "Please respect constraint : inferior to "+USERAGE_PATTERN);
			 msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			 throw new ValidatorException(msg); 
		 }
	 }
}


