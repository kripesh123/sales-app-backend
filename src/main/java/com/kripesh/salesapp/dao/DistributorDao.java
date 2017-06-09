package com.kripesh.salesapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kripesh.salesapp.model.Distributor;

public interface DistributorDao extends JpaRepository<Distributor, Long>{

}
