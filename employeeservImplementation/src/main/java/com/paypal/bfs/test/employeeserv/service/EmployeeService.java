package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

public interface EmployeeService {

    Employee getEmployee(Integer id);

    Employee createEmployee(Employee employee);
}
