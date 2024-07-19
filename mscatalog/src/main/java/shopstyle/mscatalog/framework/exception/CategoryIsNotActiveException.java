package shopstyle.mscatalog.framework.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CategoryIsNotActiveException extends RuntimeException{

    public CategoryIsNotActiveException(String message, Throwable cause) {
        super(message, cause);
    }
}
