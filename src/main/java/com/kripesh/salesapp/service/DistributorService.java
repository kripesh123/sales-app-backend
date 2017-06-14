package com.kripesh.salesapp.service;

import java.util.List;

import com.kripesh.salesapp.model.Distributor;

public interface DistributorService {
	
	List<Distributor> findAll();
	
	Distributor findByDistributorId(Long distributorId);
	
	List<Distributor> findByNameAndAddress(String name, String address);
	
	Distributor save(Distributor distributor);
	
	Distributor update(Distributor distributor);

}
