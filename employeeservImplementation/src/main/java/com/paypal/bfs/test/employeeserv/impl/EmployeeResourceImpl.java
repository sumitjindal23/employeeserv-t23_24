package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.api.response.ErrorDetails;
import com.paypal.bfs.test.employeeserv.api.response.ErrorResponse;
import com.paypal.bfs.test.employeeserv.exception.InvalidDataException;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

    @Inject
    private EmployeeService employeeService;

    @Override
    public ResponseEntity<Employee> employeeGetById(Integer id) {

        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employee> createEmployee(Employee employee) {
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception){
        if(exception instanceof InvalidDataException){
            InvalidDataException ex = (InvalidDataException) exception;
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage(ex.getErrorMessage());
            return new ResponseEntity<>(errorResponse,ex.getStatus());
        }
        if(exception instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) exception;
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("Validation Failed for the request");
            ex.getBindingResult().getFieldErrors().forEach( err -> {
                ErrorDetails errorDetails = new ErrorDetails();
                errorDetails.setField(err.getField());
                errorDetails.setRejectedValue(err.getRejectedValue()==null ? "null" : err.getRejectedValue().toString());
                errorDetails.setMessage(err.getDefaultMessage());
                errorResponse.getDetails().add(errorDetails);
            });
            return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
        }
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Unable to process your request.Please try again after sometime");
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
