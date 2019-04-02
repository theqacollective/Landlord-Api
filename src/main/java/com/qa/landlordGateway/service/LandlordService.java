package com.qa.landlordGateway.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qa.landlordGateway.entity.Landlord;
import com.qa.landlordGateway.repository.LandlordRepo;

@Service 
public class LandlordService {
	private LandlordRepo landlordRepo;
	
	public LandlordService(LandlordRepo landlordRepo) {
		this.landlordRepo = landlordRepo;
	}
	
	public ResponseEntity<Landlord> createLandlord(Landlord landlord) {
		return new ResponseEntity<Landlord>(this.landlordRepo.save(landlord), HttpStatus.OK);
	}
	public List<Landlord> getLandlords(){
		return this.landlordRepo.findAll();	
		}
	public List<Landlord> landlordSearch(Landlord landlord){
		return this.getLandlords().stream().filter(x -> x.matches(landlord)).collect(Collectors.toList());
	}
}
