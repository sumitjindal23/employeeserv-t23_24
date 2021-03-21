package com.paypal.bfs.test.employeeserv.converters;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.entity.AddressEntity;
import org.springframework.core.convert.converter.Converter;

import javax.inject.Named;

@Named
public class AddressModelToEntityConverter implements Converter<Address, AddressEntity> {

    @Override
    public AddressEntity convert(Address addressModel) {
        if(addressModel == null){
            return null;
        }
        return AddressEntity.builder()
                .id(addressModel.getId())
                .line1(addressModel.getLine1())
                .line2(addressModel.getLine2())
                .city(addressModel.getCity())
                .state(addressModel.getState())
                .country(addressModel.getCountry())
                .zipcode(addressModel.getZipCode())
                .build();
    }
}
