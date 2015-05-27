package validators;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "validators.usermail")
public class UserMailValidator implements Validator {
	private static final String USERMAIL_PATTERN = "[a-zA-Z0-9-._]+@[a-zA-Z0-9-._]+.[a-z]+";
	private Pattern pattern;
	private Matcher matcher;

	public UserMailValidator() {
		pattern = Pattern.compile(USERMAIL_PATTERN);
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		 matcher = pattern.matcher(value.toString());
		 if(!matcher.matches()){
			 FacesMessage msg =
			 new FacesMessage("user mail validation failed.",
					 "Please respect constraint : "+USERMAIL_PATTERN);
			 msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			 throw new ValidatorException(msg); 
		 }
	 }
}

