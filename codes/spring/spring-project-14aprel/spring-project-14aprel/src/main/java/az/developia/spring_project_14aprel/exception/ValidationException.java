package az.developia.spring_project_14aprel.exception;

import org.springframework.validation.BindingResult;

import java.util.LinkedHashMap;
import java.util.Map;

public class ValidationException {

    public static Map<String, String> handle(BindingResult bindingResult) {

        Map<String, String> errors = new LinkedHashMap<>();

        bindingResult.getFieldErrors().forEach(error ->
                errors.put(
                        error.getField(),
                        error.getDefaultMessage()
                )
        );

        return errors;
    }
}