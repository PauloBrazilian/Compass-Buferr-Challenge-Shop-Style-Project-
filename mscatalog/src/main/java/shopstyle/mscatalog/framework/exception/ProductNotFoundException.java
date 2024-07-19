package shopstyle.mscatalog.framework.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
