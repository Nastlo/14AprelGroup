package az.developia.spring_project_14aprel.exception;

import org.springframework.validation.BindingResult;

import java.util.List;

public class ValidationException {

    public static List<ValidationResponse> handle(BindingResult bindingResult) {
        return bindingResult.getFieldErrors()
                .stream()
                .map(error -> new ValidationResponse(
                        error.getField(),
                        error.getDefaultMessage()
                ))
                .toList();
    }
}