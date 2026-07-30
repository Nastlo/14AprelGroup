package az.developia.spring_project_14aprel.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueEmailValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {

    String message() default "Bu email artıq mövcuddur";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}