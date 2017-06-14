package com.kripesh.salesapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kripesh.salesapp.model.Sales;

@Repository
public interface SalesDao extends JpaRepository<Sales, Long>{
	
	List<Sales> findAll();
	
	Sales findBySalesId(Long salesId);
	
	Sales save(Sales sales);

}
