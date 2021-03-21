package com.paypal.bfs.test.employeeserv.api.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Error Response class
 */
@Data
public class ErrorResponse {

    private String message;

    private List<ErrorDetails> details = new ArrayList<>();
}
