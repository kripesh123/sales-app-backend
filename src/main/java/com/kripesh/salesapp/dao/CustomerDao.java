package com.kripesh.salesapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kripesh.salesapp.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long>{

}
