package com.kripesh.salesapp.service;

import java.util.List;

import com.kripesh.salesapp.model.Item;
import com.kripesh.salesapp.model.Product;

public interface ItemService {

	List<Item> findAll();
	
	List<Item> findByname(String name);

	Item findByItemId(Long itemId);

	Item save(Item item);
	
	List<Item> findByProduct(Product product);
}
