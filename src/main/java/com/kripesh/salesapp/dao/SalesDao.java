package com.kripesh.salesapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kripesh.salesapp.model.Sales;

@Repository
public interface SalesDao extends JpaRepository<Sales, Long>{
	
	List<Sales> findAll();
	
	Sales findBySalesId(Long salesId);
	
	Sales save(Sales sales);
	
	@Query("select s from Sales s where MONTH(s.created) =:month")
	List<Sales> findByMonth(@Param("month") int month);
	
	@Query("select s from Sales s where MONTH(s.created) = MONTH(NOW())")
	List<Sales> findTodaysSales();

}
