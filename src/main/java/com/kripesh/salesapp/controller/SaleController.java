package com.kripesh.salesapp.controller;

import static com.kripesh.salesapp.controller.utils.ApiConstant.ACTION_TODAYS_SALE;
import static com.kripesh.salesapp.controller.utils.ApiConstant.API_VER;
import static com.kripesh.salesapp.controller.utils.ApiConstant.SALES_PATH;
import static com.kripesh.salesapp.controller.utils.ApiConstant.ACTION_MONTHS_SALE;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kripesh.salesapp.model.Sale;
import com.kripesh.salesapp.service.SaleService;

@RestController
@RequestMapping(API_VER + SALES_PATH)
public class SaleController {
	
	@Autowired
	SaleService saleService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Sale>> getAllSale(){
		List<Sale> salesList = saleService.findAll();
		return new ResponseEntity<List<Sale>>(salesList,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET,params={ACTION_TODAYS_SALE})
	public ResponseEntity<List<Sale>> getTodaySales(@RequestParam String action){
		List<Sale> todaysSaleList = saleService.findTodaysSale();
		if(todaysSaleList.isEmpty() || todaysSaleList == null){
			return new ResponseEntity<List<Sale>>(todaysSaleList,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Sale>>(todaysSaleList,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET,params={ACTION_MONTHS_SALE})
	public ResponseEntity<List<Sale>> getMonthSales(@RequestParam String action,@RequestParam String formatted){
		Date date = new Date(formatted);
		List<Sale> monthsSaleList = saleService.findByMonth(date.getMonth()+1);
		if(monthsSaleList.isEmpty() || monthsSaleList == null){
			return new ResponseEntity<List<Sale>>(monthsSaleList,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Sale>>(monthsSaleList,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Sale> saveSales(@RequestBody Sale sales) {
		saleService.save(sales);
         return new ResponseEntity<Sale>(sales,HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Sale> updateSales(@RequestBody Sale sales) {
		Sale updatedSales=saleService.save(sales);
         return new ResponseEntity<Sale>(updatedSales,HttpStatus.CREATED);
    }

}
