package com.kripesh.salesapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kripesh.salesapp.model.Sale;

@Repository
public interface SaleDao extends JpaRepository<Sale, Long>{
	
	List<Sale> findAll();
	
	Sale findBySaleId(Long saleId);
	
	Sale save(Sale sale);
	
	@Query("select s from Sale s where MONTH(s.created) =:month")
	List<Sale> findByMonth(@Param("month") int month);
	
	@Query("select s from Sale s where MONTH(s.created) = MONTH(NOW())")
	List<Sale> findTodaysSale();

}
