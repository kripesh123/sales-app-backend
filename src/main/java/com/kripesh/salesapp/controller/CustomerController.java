package com.kripesh.salesapp.controller;

import static com.kripesh.salesapp.controller.utils.ApiConstant.API_VER;
import static com.kripesh.salesapp.controller.utils.ApiConstant.CUSTOMER_PATH;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kripesh.salesapp.model.Customer;
import com.kripesh.salesapp.model.Distributor;
import com.kripesh.salesapp.model.User;
import com.kripesh.salesapp.service.CustomerService;

@RestController
@RequestMapping(API_VER + CUSTOMER_PATH)
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Customer>>  getAllCustomer(){	
		List<Customer> customerList=customerService.findAll();
		return new ResponseEntity<List<Customer>>(customerList,HttpStatus.OK);
	}
	
	@RequestMapping(value="customer",method = RequestMethod.GET)
	public ResponseEntity<Customer> getByCustomerId(@RequestParam(value ="customerId", required = true) long customerId){
		Customer customer=customerService.findByCustomerId(customerId);
		if(customer != null){
			return new ResponseEntity<Customer>(customer,HttpStatus.OK);
		}
		return new ResponseEntity<Customer>(customer,HttpStatus.NO_CONTENT);
	}
	

	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		customerService.save(customer);
         return new ResponseEntity<Customer>(customer,HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		customerService.save(customer);
         return new ResponseEntity<Customer>(customer,HttpStatus.CREATED);
    }

}
