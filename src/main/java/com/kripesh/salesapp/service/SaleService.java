package com.kripesh.salesapp.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kripesh.salesapp.model.Sale;

public interface SaleService {
	
	List<Sale> findAll();
	
	Sale findBySaleId(Long saleId);
	
	Sale save(Sale sales);
	
	List<Sale> findByMonth(int month);
	
	List<Sale> findTodaysSale();
}
