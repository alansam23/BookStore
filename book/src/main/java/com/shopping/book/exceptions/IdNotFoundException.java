package com.shopping.book.exceptions;

public class IdNotFoundException extends RuntimeException{

    public IdNotFoundException(String message){
        super(message);
    }
}
