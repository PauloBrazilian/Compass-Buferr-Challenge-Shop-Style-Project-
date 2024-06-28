package shopstyle.mscustomer.framework.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddressNotFoundException extends RuntimeException{

    public AddressNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
