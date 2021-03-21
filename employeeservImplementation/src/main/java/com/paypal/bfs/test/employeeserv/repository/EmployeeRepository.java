package com.paypal.bfs.test.employeeserv.repository;

import com.paypal.bfs.test.employeeserv.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Employee Repository class
 */
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {
}
