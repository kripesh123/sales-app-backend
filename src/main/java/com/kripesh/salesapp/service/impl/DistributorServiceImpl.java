package com.kripesh.salesapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kripesh.salesapp.dao.DistributorDao;
import com.kripesh.salesapp.model.Distributor;
import com.kripesh.salesapp.service.DistributorService;

@Service
public class DistributorServiceImpl implements DistributorService{
	
	@Autowired
	DistributorDao distributorDao;

	@Override
	public List<Distributor> findAll() {
		return distributorDao.findAll();
	}

	@Override
	public Distributor findByDistributorId(Long distributorId) {
		return distributorDao.findByDistributorId(distributorId);
	}

	@Override
	public List<Distributor> findByNameAndAddress(String name, String address) {
		return distributorDao.findByNameAndAddress(name, address);
	}

	@Override
	public Distributor save(Distributor distributor) {
		List<Distributor> distributorList = findAll();
		for(Distributor d : distributorList){
			if(d.getName().equals(distributor.getName()) && d.getAddress().equals(distributor.getAddress())){
				return new Distributor();
			}
		}
		return distributorDao.save(distributor);
	}

	@Override
	public Distributor update(Distributor distributor) {
		return distributorDao.save(distributor);
	}

}
