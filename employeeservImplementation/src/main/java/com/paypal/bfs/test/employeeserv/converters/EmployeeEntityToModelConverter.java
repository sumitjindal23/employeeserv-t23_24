package com.paypal.bfs.test.employeeserv.converters;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.entity.EmployeeEntity;
import org.springframework.core.convert.converter.Converter;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class EmployeeEntityToModelConverter implements Converter<EmployeeEntity, Employee> {

    @Inject
    private AddressEntityToModelConverter addressConverter;

    @Override
    public Employee convert(EmployeeEntity employeeEntity) {
        if(employeeEntity == null){
            return null;
        }
        Employee employee = new Employee();
        employee.setId(employeeEntity.getId());
        employee.setFirstName(employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setDateOfBirth(employeeEntity.getDateOfBirth());
        employee.setAddress(addressConverter.convert(employeeEntity.getAddress()));
        return employee;
    }
}
