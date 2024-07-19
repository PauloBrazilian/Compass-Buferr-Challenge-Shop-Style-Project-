package shopstyle.mscatalog.framework.exception;

import org.springframework.http.HttpStatus;

public record ErrorDetails(HttpStatus status, String message, Throwable cause) {
}
