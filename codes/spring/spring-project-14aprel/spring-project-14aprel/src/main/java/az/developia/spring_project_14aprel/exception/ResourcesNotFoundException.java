package az.developia.spring_project_14aprel.exception;

public class ResourcesNotFoundException extends RuntimeException {

    public ResourcesNotFoundException(String message) {
        super(message);
    }
}