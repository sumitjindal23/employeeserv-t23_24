package com.paypal.bfs.test.employeeserv.converters;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.entity.EmployeeEntity;
import org.springframework.core.convert.converter.Converter;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class EmployeeModelToEntityConverter implements Converter<Employee, EmployeeEntity> {

    @Inject
    private AddressModelToEntityConverter addressConverter;

    @Override
    public EmployeeEntity convert(Employee employeeModel) {
        if(employeeModel == null){
            return null;
        }
        return EmployeeEntity.builder()
                .id(employeeModel.getId())
                .firstName(employeeModel.getFirstName())
                .lastName(employeeModel.getLastName())
                .dateOfBirth(employeeModel.getDateOfBirth())
                .address(addressConverter.convert(employeeModel.getAddress()))
                .build();
    }
}
