package com.kripesh.salesapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kripesh.salesapp.model.Distributor;

@Repository
public interface DistributorDao extends JpaRepository<Distributor, Long>{
	
	List<Distributor> findAll();
	
	Distributor findByDistributorId(Long distributorId);
	
	List<Distributor> findByNameAndAddress(String name, String address);
	
	Distributor save(Distributor distributor);

}
