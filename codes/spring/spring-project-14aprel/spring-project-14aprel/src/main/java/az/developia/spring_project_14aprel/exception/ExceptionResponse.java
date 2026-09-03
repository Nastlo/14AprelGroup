package az.developia.spring_project_14aprel.exception;

import java.util.List;

public class ExceptionResponse {

    private String message;
    private List<ValidationResponse> validations;

    public ExceptionResponse(String message, List<ValidationResponse> validations) {
        this.message = message;
        this.validations = validations;
    }

    public String getMessage() {
        return message;
    }

    public List<ValidationResponse> getValidations() {
        return validations;
    }
}