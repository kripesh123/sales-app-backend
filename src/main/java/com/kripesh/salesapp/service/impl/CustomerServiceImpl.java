package com.kripesh.salesapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kripesh.salesapp.dao.CustomerDao;
import com.kripesh.salesapp.model.Customer;
import com.kripesh.salesapp.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerDao customerDao;

	@Override
	public Customer save(Customer customer) {
		return customerDao.save(customer);	
	}

	@Override
	public Customer findByCustomerId(Long customerId) {
		return customerDao.findByCustomerId(customerId);
	}

	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();				
	}

}
