package com.paypal.bfs.test.employeeserv.converters;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.entity.AddressEntity;
import org.springframework.core.convert.converter.Converter;

import javax.inject.Named;

@Named
public class AddressEntityToModelConverter implements Converter<AddressEntity, Address> {

    @Override
    public Address convert(AddressEntity addressEntity) {
        if(addressEntity == null){
            return null;
        }
        Address address = new Address();
        address.setId(addressEntity.getId());
        address.setLine1(addressEntity.getLine1());
        address.setLine2(addressEntity.getLine2());
        address.setCity(addressEntity.getCity());
        address.setState(addressEntity.getState());
        address.setCountry(addressEntity.getCountry());
        address.setZipCode(addressEntity.getZipcode());
        return address;
    }
}