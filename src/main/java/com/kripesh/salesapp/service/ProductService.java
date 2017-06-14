package com.kripesh.salesapp.service;

import java.util.List;

import com.kripesh.salesapp.model.Distributor;
import com.kripesh.salesapp.model.Product;

public interface ProductService {
	List<Product> findAll();

	Product findByDistributor(Distributor distributor);
	
	Product findByName(String name);

	Product findByProductId(Long productId);

	Product save(Product product);

}
