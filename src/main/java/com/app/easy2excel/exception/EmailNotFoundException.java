package com.app.easy2excel.exception;

public class EmailNotFoundException extends  RuntimeException{

    public EmailNotFoundException(final String message) {
        super(message);
    }
}
