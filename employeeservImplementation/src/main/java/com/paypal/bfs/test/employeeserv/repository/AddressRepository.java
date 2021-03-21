package com.paypal.bfs.test.employeeserv.repository;

import com.paypal.bfs.test.employeeserv.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Address Repository class
 */
public interface AddressRepository extends CrudRepository<AddressEntity, Integer> {
}
