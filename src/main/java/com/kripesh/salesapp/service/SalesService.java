package com.kripesh.salesapp.service;

import java.util.List;

import com.kripesh.salesapp.model.Sales;

public interface SalesService {
	
	List<Sales> findAll();
	
	Sales findBySalesId(Long salesId);
	
	Sales save(Sales sales);
}
