package vaoagost.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsopportedMathOperationException extends RuntimeException {
    // This class is used to create a custom exception for unsupported math operations
    // It extends the RuntimeException class
    // The constructor takes a string as a parameter and passes it to the superclass constructor
    public UnsopportedMathOperationException(String message) {
        super(message);
    }
}
