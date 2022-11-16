package net.daif.cliente.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Error> illegalArgEx(Exception ex){
        Error error = new Error();
        error.setMsg(ex.getMessage());
        error.setStatus("Error");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceDuplicityException.class)
    public ResponseEntity<Error> resourceDuplicityException(Exception ex){
        Error error = new Error();
        error.setMsg(ex.getMessage());
        error.setStatus("Error");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceAbsentException.class)
    public ResponseEntity<Error> resourceAbsentException(Exception ex){
        Error error = new Error();
        error.setMsg(ex.getMessage());
        error.setStatus("Error");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
