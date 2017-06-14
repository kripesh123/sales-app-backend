package com.kripesh.salesapp.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kripesh.salesapp.model.Sales;

public interface SalesService {
	
	List<Sales> findAll();
	
	Sales findBySalesId(Long salesId);
	
	Sales save(Sales sales);
	
	List<Sales> findByMonth(int month);
	
	List<Sales> findTodaysSales();
}
