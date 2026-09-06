package az.developia.spring_project_14aprel.exception;

import org.springframework.validation.BindingResult;

public class OurRuntimeException extends RuntimeException {

    private BindingResult bindingResult;

    public OurRuntimeException(String message, BindingResult bindingResult) {
        super(message);
        this.bindingResult = bindingResult;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }
}