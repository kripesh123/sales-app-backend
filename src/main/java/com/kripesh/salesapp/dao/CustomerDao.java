package com.kripesh.salesapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kripesh.salesapp.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long>{
	
	Customer findByCustomerId(Long customerId);
	
	Customer save(Customer customer);
	
	List<Customer> findAll();
	
}
