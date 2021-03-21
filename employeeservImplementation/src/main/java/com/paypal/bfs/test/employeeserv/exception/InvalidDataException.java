package com.paypal.bfs.test.employeeserv.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Custom Exception class
 *
 */
@Getter
public class InvalidDataException extends RuntimeException {

    private final String errorMessage;
    private final HttpStatus status;

    public InvalidDataException(String errorMessage,HttpStatus status){
        this.errorMessage = errorMessage;
        this.status = status;
    }
}
