package com.kripesh.salesapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kripesh.salesapp.dao.CustomerDao;
import com.kripesh.salesapp.dao.ItemDao;
import com.kripesh.salesapp.dao.SalesDao;
import com.kripesh.salesapp.model.Customer;
import com.kripesh.salesapp.model.Item;
import com.kripesh.salesapp.model.Sales;
import com.kripesh.salesapp.service.SalesService;

@Service
public class SalesServiceImpl implements SalesService{
	
	@Autowired
	SalesDao salesDao;
	
	@Autowired
	ItemDao itemDao;
	
	@Autowired
	CustomerDao customerDao;

	@Override
	public List<Sales> findAll() {
		return salesDao.findAll();
	}

	@Override
	public Sales findBySalesId(Long salesId) {
		return salesDao.findBySalesId(salesId);
	}

	@Override
	public Sales save(Sales sales) {
		int totalPrice =0;
		int totalQuantity=0;
		List<Item> itemList = new ArrayList<>();
		for(Item item: sales.getItemLists()){
			Item purchaseItem = itemDao.findByItemId(item.getItemId());
			int totalItemCost = purchaseItem.getPrice() * item.getQuantity();
			totalPrice = totalPrice + totalItemCost;
			totalQuantity = totalQuantity+item.getQuantity();
			purchaseItem.setSoldQuantity(item.getQuantity());
			itemDao.save(purchaseItem);
			itemList.add(purchaseItem);
		}
		Customer customer =customerDao.findByCustomerId(sales.getCustomer().getCustomerId());
		sales.setCustomer(customer);
		sales.setItemLists(itemList);
		sales.setTotalPrice(totalPrice);
		sales.setSoldPrice(sales.getSoldPrice());
		sales.setTotalQuantity(totalQuantity);
		return salesDao.save(sales);
	}

}
