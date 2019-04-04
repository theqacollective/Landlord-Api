package com.qa.landlordGateway.controllers;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.landlordGateway.Constants;
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

	@PostMapping(Constants.CREATE_LANDLORD_PATH)
	public ResponseEntity<Landlord> createLandlord(@RequestBody Landlord landlord) {
		return this.landlordService.createLandlord(landlord);
	}

	@GetMapping(Constants.GET_ALL_LANDLORDS_PATH)
	public List<Landlord> getLandlords() {
		return this.landlordService.getLandlords();
	}

	@GetMapping(Constants.LANDLORD_SERCH_PATH)
	public List<Landlord> landlordSearch(String firstName, String lastName, String email, String phoneNumber) {
		return this.landlordService.landlordSearch(landlordBuilder.firstName(firstName).lastName(lastName).email(email)
				.phoneNumber(phoneNumber).landlordBuild());
	}

	@DeleteMapping(Constants.DELETE_URL)
	public String deleteLandlord(String firstName, String lastName, String email, String phoneNumber) {

		List<Landlord> landlords = this.landlordSearch(firstName, lastName, email, phoneNumber);

		for (int i = 0; i < landlords.size(); i++) {
			this.landlordService.deleteLandlord(landlords.get(i));
		}
		return Constants.getDeletionMessage();
	}

	private RestTemplateBuilder rtb;

	@PutMapping(Constants.UPDATE_URL)
	public String updateLandlord(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName, @RequestBody Landlord updateLandlord)
	{
		return this.landlordService.updateLandlord(firstName, lastName, updateLandlord);
	}

	public RestTemplateBuilder getRtb() {
		return rtb;
	}

	public void setRtb(RestTemplateBuilder rtb) {
		this.rtb = rtb;
	}

}
