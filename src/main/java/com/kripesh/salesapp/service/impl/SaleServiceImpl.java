package com.kripesh.salesapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kripesh.salesapp.dao.CustomerDao;
import com.kripesh.salesapp.dao.ItemDao;
import com.kripesh.salesapp.dao.SaleDao;
import com.kripesh.salesapp.model.Customer;
import com.kripesh.salesapp.model.Item;
import com.kripesh.salesapp.model.Sale;
import com.kripesh.salesapp.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService{
	
	@Autowired
	SaleDao salesDao;
	
	@Autowired
	ItemDao itemDao;
	
	@Autowired
	CustomerDao customerDao;

	@Override
	public List<Sale> findAll() {
		return salesDao.findAll();
	}

	@Override
	public Sale findBySaleId(Long saleId) {
		return salesDao.findBySaleId(saleId);
	}

	@Override
	public Sale save(Sale sale) {
		int totalPrice =0;
		int totalQuantity=0;
		List<Item> itemList = new ArrayList<>();
		for(Item item: sale.getItemList()){
			Item purchaseItem = itemDao.findByItemId(item.getItemId());
			int totalItemCost = purchaseItem.getPrice() * item.getQuantity();
			totalPrice = totalPrice + totalItemCost;
			totalQuantity = totalQuantity + item.getQuantity();
			purchaseItem.setSoldQuantity(item.getQuantity());
			itemDao.save(purchaseItem);
			itemList.add(purchaseItem);
		}
		Customer customer =customerDao.findByCustomerId(sale.getCustomer().getCustomerId());
		sale.setCustomer(customer);
		sale.setItemList(itemList);
		sale.setTotalPrice(totalPrice);
		sale.setSoldPrice(sale.getSoldPrice());
		sale.setTotalQuantity(totalQuantity);
		return salesDao.save(sale);
	}

	@Override
	public List<Sale> findByMonth(int month) {
		return salesDao.findByMonth(month);
	}

	@Override
	public List<Sale> findTodaysSale() {
		return salesDao.findTodaysSale();
	}

	

}
