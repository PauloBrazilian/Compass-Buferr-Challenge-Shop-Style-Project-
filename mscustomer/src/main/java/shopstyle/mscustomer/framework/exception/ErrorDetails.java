package shopstyle.mscustomer.framework.exception;

import org.springframework.http.HttpStatus;

public record ErrorDetails(HttpStatus status, String message, Throwable cause) {

}
