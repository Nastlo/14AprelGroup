package az.developia.spring_project_14aprel.validation;

import org.springframework.beans.factory.annotation.Autowired;

import az.developia.spring_project_14aprel.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        if (email == null) {
            return true;
        }

        return userRepository.findByEmailJPQL(email) == null;
    }

}