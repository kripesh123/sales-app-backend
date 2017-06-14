package com.kripesh.salesapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kripesh.salesapp.dao.DistributorDao;
import com.kripesh.salesapp.dao.ProductDao;
import com.kripesh.salesapp.model.Distributor;
import com.kripesh.salesapp.model.Product;
import com.kripesh.salesapp.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;
	
	@Autowired
	DistributorDao distributorDao;
	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public Product findByDistributor(Distributor distributor) {
		return productDao.findByDistributor(distributor);
	}

	@Override
	public Product findByName(String name) {
		return productDao.findByName(name);
	}

	@Override
	public Product findByProductId(Long productId) {
		return productDao.findByProductId(productId);
	}

	@Override
	public Product save(Product product) {
		Distributor distributor = distributorDao.findByDistributorId(product.getDistributor().getDistributorId());
		product.setDistributor(distributor);
		return productDao.save(product);
	}

}
