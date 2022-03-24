package com.dsg.springbootboardexample.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BlogAPIException extends RuntimeException {

    private HttpStatus status;
    private String message;

    private BlogErrorCode errorCode;


    public BlogAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public BlogAPIException(BlogErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }

}
