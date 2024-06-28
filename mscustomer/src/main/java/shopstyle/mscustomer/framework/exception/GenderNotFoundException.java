package shopstyle.mscustomer.framework.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GenderNotFoundException extends RuntimeException{

    public GenderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}