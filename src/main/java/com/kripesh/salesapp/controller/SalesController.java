package com.kripesh.salesapp.controller;

import static com.kripesh.salesapp.controller.utils.ApiConstant.API_VER;
import static com.kripesh.salesapp.controller.utils.ApiConstant.SALES_PATH;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kripesh.salesapp.model.Sales;
import com.kripesh.salesapp.service.SalesService;

@RestController
@RequestMapping(API_VER + SALES_PATH)
public class SalesController {
	
	@Autowired
	SalesService salesService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Sales>> getAllSales(){
		List<Sales> salesList = salesService.findAll();
		return new ResponseEntity<List<Sales>>(salesList,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Sales> saveSales(@RequestBody Sales sales) {
		salesService.save(sales);
         return new ResponseEntity<Sales>(sales,HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Sales> updateSales(@RequestBody Sales sales) {
		Sales updatedSales=salesService.save(sales);
         return new ResponseEntity<Sales>(updatedSales,HttpStatus.CREATED);
    }

}
