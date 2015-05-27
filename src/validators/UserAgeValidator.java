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
	private static final int AGE_PATTERN = 100;
	private static final String USERAGE_PATTERN = "[0-9]+";
	private Pattern pattern;
	private Matcher matcher;

	public UserAgeValidator() {
		pattern = Pattern.compile(USERAGE_PATTERN);
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		 matcher = pattern.matcher(value.toString());
		 if(! (((Integer)value < AGE_PATTERN) && (matcher.matches()))){
			 FacesMessage msg =
			 new FacesMessage("user login validation failed.",
					 "Please respect constraint : number "+USERAGE_PATTERN+" inferior to "+AGE_PATTERN);
			 msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			 throw new ValidatorException(msg); 
		 }
	 }
}


