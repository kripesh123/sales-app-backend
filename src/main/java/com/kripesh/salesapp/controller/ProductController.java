package com.kripesh.salesapp.controller;

import static com.kripesh.salesapp.controller.utils.ApiConstant.API_VER;
import static com.kripesh.salesapp.controller.utils.ApiConstant.PRODUCT_PATH;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kripesh.salesapp.model.Distributor;
import com.kripesh.salesapp.model.Product;
import com.kripesh.salesapp.service.ProductService;

@RestController
@RequestMapping(API_VER + PRODUCT_PATH)
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Product>>  getAllProduct(){	
		List<Product> productList=productService.findAll();
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		productService.save(product);
         return new ResponseEntity<Product>(product,HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		Product updatedProduct=productService.save(product);
         return new ResponseEntity<Product>(updatedProduct,HttpStatus.CREATED);
    }

}
