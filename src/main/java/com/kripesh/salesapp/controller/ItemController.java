package com.kripesh.salesapp.controller;

import static com.kripesh.salesapp.controller.utils.ApiConstant.ACTION_CHECK_ITEMS;
import static com.kripesh.salesapp.controller.utils.ApiConstant.API_VER;
import static com.kripesh.salesapp.controller.utils.ApiConstant.ITEM_PATH;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kripesh.salesapp.model.Item;
import com.kripesh.salesapp.service.ItemService;

@RestController
@RequestMapping(API_VER + ITEM_PATH)
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Item>>  getAllItem(){	
		List<Item> itemList=itemService.findAll();
		return new ResponseEntity<List<Item>>(itemList,HttpStatus.OK);
	}
	
	@RequestMapping(value="items", method = RequestMethod.GET,params={ACTION_CHECK_ITEMS})
	public ResponseEntity<List<Item>> getMinItem(@RequestParam String action,@RequestParam Integer quantity){
		List<Item> itemList = itemService.findByQuantityLessThan(quantity);
		if(itemList.isEmpty() || itemList == null){
			return new ResponseEntity<List<Item>>(itemList,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Item>>(itemList,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Item> saveItem(@RequestBody Item item) {
		itemService.save(item);
         return new ResponseEntity<Item>(item,HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Item> updateItem(@RequestBody Item item) {
         Item updatedItem=itemService.save(item);
         return new ResponseEntity<Item>(updatedItem,HttpStatus.CREATED);
    }
	

}
