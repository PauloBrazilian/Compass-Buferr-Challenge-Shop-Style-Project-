package shopstyle.mscatalog.framework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<ErrorDetails> productNotFoundException(ProductNotFoundException e){
        var errorDetails = new ErrorDetails(HttpStatus.NOT_FOUND, e.getMessage(), e.getCause());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<ErrorDetails> categoryNotFoundException(CategoryNotFoundException e){
        var errorDetails = new ErrorDetails(HttpStatus.NOT_FOUND, e.getMessage(), e.getCause());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    @ExceptionHandler(CategoryIsNotActiveException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public ResponseEntity<ErrorDetails> categoryIsNotActiveException(CategoryIsNotActiveException e){
        var errorDetails = new ErrorDetails(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e.getCause());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorDetails);
    }

    @ExceptionHandler(CategoryIsParentExistsException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public ResponseEntity<ErrorDetails> categoryIsParentExistsException(CategoryIsParentExistsException e){
        var errorDetails = new ErrorDetails(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), e.getCause());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorDetails);
    }

}
