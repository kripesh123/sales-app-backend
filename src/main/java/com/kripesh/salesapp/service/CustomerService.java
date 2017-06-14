package com.kripesh.salesapp.service;

import java.util.List;

import com.kripesh.salesapp.model.Customer;

public interface CustomerService {
	Customer save(Customer customer);
	Customer findByCustomerId(Long customerId);
	List<Customer> findAll();
}
