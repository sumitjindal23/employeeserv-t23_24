package com.paypal.bfs.test.employeeserv.api.response;

import lombok.Data;

@Data
public class ErrorDetails {

    private String field;

    private String rejectedValue;

    private String message;
}

