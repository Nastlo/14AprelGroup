package az.developia.spring_project_14aprel.exception;

public class CourseNotFoundException extends OurRuntimeException {

    public CourseNotFoundException(String message) {
        super(message);
    }
}