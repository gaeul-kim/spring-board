package sampleProject.user.domain;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object obj, Errors e) {
        User user = (User) obj;
        // if (user.getUserId() == null || user.getUserId().length() == 0) {
        // e.rejectValue("userId", "field.required");
        // }
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "user_id", "user_id.empty");
    }

}
