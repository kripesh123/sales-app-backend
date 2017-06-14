package com.kripesh.salesapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kripesh.salesapp.model.Distributor;
import com.kripesh.salesapp.model.Product;
import com.kripesh.salesapp.model.User;

@Repository
public interface ProductDao extends JpaRepository<Product, Long>{

	List<Product> findAll();

	Product findByDistributor(Distributor distributor);
	
	Product findByName(String name);

	Product findByProductId(Long productId);

	Product save(Product product);

}
