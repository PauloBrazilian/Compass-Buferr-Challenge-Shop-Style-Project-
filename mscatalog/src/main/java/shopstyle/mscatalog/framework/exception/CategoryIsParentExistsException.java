package shopstyle.mscatalog.framework.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CategoryIsParentExistsException extends RuntimeException{

    public CategoryIsParentExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
