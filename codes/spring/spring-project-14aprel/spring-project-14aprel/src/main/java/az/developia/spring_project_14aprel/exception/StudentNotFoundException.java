package az.developia.spring_project_14aprel.exception;

public class StudentNotFoundException extends OurRuntimeException {

    public StudentNotFoundException(String message) {
        super(message);
    }
}