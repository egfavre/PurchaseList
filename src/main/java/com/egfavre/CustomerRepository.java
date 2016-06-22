package com.egfavre;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by user on 6/22/16.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    public Customer findById (int id);
}
