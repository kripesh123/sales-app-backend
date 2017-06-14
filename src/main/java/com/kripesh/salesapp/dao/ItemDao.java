package com.kripesh.salesapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kripesh.salesapp.model.Item;
import com.kripesh.salesapp.model.Product;

@Repository
public interface ItemDao extends JpaRepository<Item, Long>{
	
	List<Item> findAll();
	
	List<Item> findByname(String name);

	Item findByItemId(Long itemId);

	Item save(Item item);
	
	List<Item> findByProduct(Product product);
	
	List<Item> findByQuantityLessThan(int quantity);
	
}
