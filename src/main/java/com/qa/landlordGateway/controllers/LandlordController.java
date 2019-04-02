package com.qa.landlordGateway.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.landlordGateway.MainConstants;
import com.qa.landlordGateway.entity.Landlord;
import com.qa.landlordGateway.entity.LandlordBuilder;
import com.qa.landlordGateway.service.LandlordService;

@RestController
@CrossOrigin
public class LandlordController {

	private LandlordService landlordService;
	private LandlordBuilder landlordBuilder;
	
	public LandlordController(LandlordService landlordService, LandlordBuilder landlordBuilder) {
		this.landlordService = landlordService;
		this.landlordBuilder = landlordBuilder;
	}
	
	@PostMapping(MainConstants.CREATE_LANDLORD_PATH)
	public ResponseEntity<Landlord> createLandlord(@RequestBody Landlord landlord) {
		return this.landlordService.createLandlord(landlord);
	}
	@GetMapping(MainConstants.GET_ALL_LANDLORDS_PATH)
	public List<Landlord> getLandlords(){
		return this.landlordService.getLandlords();
	}
	@GetMapping(MainConstants.LANDLORD_SERCH_PATH)
	public List<Landlord> landlordSearch(String firstName, String lastName){
		return this.landlordService.landlordSearch(landlordBuilder.firstName(firstName).lastName(lastName).landlordBuild());
	}

	private RestTemplateBuilder rtb;

	public RestTemplateBuilder getRtb() {
		return rtb;
	}

	public void setRtb(RestTemplateBuilder rtb) {
		this.rtb = rtb;
	}
	
}

