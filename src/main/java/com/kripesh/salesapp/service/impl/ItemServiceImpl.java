package com.kripesh.salesapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kripesh.salesapp.dao.ItemDao;
import com.kripesh.salesapp.dao.ProductDao;
import com.kripesh.salesapp.model.Item;
import com.kripesh.salesapp.model.Product;
import com.kripesh.salesapp.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemDao itemDao;
	
	@Autowired
	ProductDao productDao;

	@Override
	public List<Item> findAll() {
		return itemDao.findAll();
	}

	@Override
	public List<Item> findByname(String name) {
		return itemDao.findByname(name);
	}

	@Override
	public Item findByItemId(Long itemId) {
		return itemDao.findByItemId(itemId);
	}

	@Override
	public Item save(Item item) {
		Product product = productDao.findByProductId(item.getProduct().getProductId());
		item.setProduct(product);
		return itemDao.save(item);
	}

	@Override
	public List<Item> findByProduct(Product product) {
		return itemDao.findByProduct(product);
	}

}
