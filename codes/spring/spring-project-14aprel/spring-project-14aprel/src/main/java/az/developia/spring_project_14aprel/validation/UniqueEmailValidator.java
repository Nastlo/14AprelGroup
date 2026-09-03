package az.developia.spring_project_14aprel.validation;

import az.developia.spring_project_14aprel.config.SpringContext;
import az.developia.spring_project_14aprel.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null) {
            return true;
        }
        UserRepository userRepository = SpringContext.getBean(UserRepository.class);
        return userRepository.findByEmailJPQL(email) == null;
    }
}