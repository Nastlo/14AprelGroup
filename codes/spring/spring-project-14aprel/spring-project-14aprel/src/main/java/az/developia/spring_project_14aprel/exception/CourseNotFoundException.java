package az.developia.spring_project_14aprel.exception;

import org.springframework.validation.BindingResult;

public class CourseNotFoundException extends Exception {
	
    public CourseNotFoundException(String message) {
        super(message);
    }
}