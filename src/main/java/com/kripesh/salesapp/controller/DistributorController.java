package com.kripesh.salesapp.controller;

import static com.kripesh.salesapp.controller.utils.ApiConstant.API_VER;
import static com.kripesh.salesapp.controller.utils.ApiConstant.DISTRIBUTOR_PATH;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kripesh.salesapp.model.Distributor;
import com.kripesh.salesapp.service.DistributorService;

@RestController
@RequestMapping(API_VER + DISTRIBUTOR_PATH)
public class DistributorController {
	
	@Autowired
	DistributorService distributorService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Distributor>>  getAllDistributor(){	
		List<Distributor> distributorList=distributorService.findAll();
		return new ResponseEntity<List<Distributor>>(distributorList,HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Distributor> saveDistributor(@RequestBody Distributor distributor) {
		distributorService.save(distributor);
         return new ResponseEntity<Distributor>(distributor,HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Distributor> updateDistributor(@RequestBody Distributor distributor) {
		Distributor updatedDistributor=distributorService.update(distributor);
         return new ResponseEntity<Distributor>(updatedDistributor,HttpStatus.CREATED);
    }
}
