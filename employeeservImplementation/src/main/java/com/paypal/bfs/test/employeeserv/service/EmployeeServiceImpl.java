package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.entity.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.exception.InvalidDataException;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Objects;
import java.util.Optional;

/**
 * Service Implementation class
 */
@Named
public class EmployeeServiceImpl implements EmployeeService {

    @Inject
    private ConversionService conversionService;

    @Inject
    EmployeeRepository employeeRepository;


    /**
     * Get Employee details based on employee Id
     *
     * @param id
     * @return
     */
    @Override
    public Employee getEmployee(Integer id) {

        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        if (employeeEntity.isPresent()) {
            return conversionService.convert(employeeEntity.get(), Employee.class);
        }
        throw new InvalidDataException("Employee data not found", HttpStatus.NOT_FOUND);
    }

    /**
     * Create Employee Details
     *
     * @param employee
     * @return
     */
    @Override
    public Employee createEmployee(Employee employee) {

        employeeRepository.findById(employee.getId()).ifPresent(e -> {
            throw new InvalidDataException("Employee Id is already present", HttpStatus.BAD_REQUEST);
        });

        EmployeeEntity employeeEntity = conversionService.convert(employee, EmployeeEntity.class);
        employeeEntity = employeeRepository.save(Objects.requireNonNull(employeeEntity));
        return conversionService.convert(employeeEntity, Employee.class);
    }
}
