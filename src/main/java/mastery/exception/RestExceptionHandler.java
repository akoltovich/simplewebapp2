package mastery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.ConnectException;

@RestControllerAdvice
public class RestExceptionHandler {

    ApiError apiError;

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> validationFailed(MethodArgumentNotValidException ex) {
        apiError = new ApiError();
        apiError.setError(ex.getMessage() + " Invalid data for employee.");
        apiError.setStatus(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ConnectException.class)
    public ResponseEntity<ApiError> serverNotAvailable(ConnectException ex) {
        apiError = new ApiError();
        apiError.setError(ex.getMessage() + "Server not available");
        apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
