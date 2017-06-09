package com.kripesh.salesapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kripesh.salesapp.model.Product;

public interface ProductDao extends JpaRepository<Product, Long>{

}
