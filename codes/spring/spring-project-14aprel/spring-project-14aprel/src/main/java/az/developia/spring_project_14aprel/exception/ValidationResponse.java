package az.developia.spring_project_14aprel.exception;

public class ValidationResponse {

    private String field;
    private String defaultMessage;

    public ValidationResponse(String field, String defaultMessage) {
        this.field = field;
        this.defaultMessage = defaultMessage;
    }

    public String getField() {
        return field;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }
}