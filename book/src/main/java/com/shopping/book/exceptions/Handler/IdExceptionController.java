package com.shopping.book.exceptions.Handler;

import com.shopping.book.exceptions.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class IdExceptionController {
    @ExceptionHandler(value = IdNotFoundException.class)
    public ResponseEntity<Object> exception(IdNotFoundException e){
        return new ResponseEntity<>("ID is Not Exist ", HttpStatus.NOT_FOUND);
    }
}
