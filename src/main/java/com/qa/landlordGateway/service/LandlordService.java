package com.qa.landlordGateway.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qa.landlordGateway.Constants;
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
	
	public String deleteLandlord(Landlord landlord) {
		this.landlordRepo.delete(landlord);
		return Constants.getDeletionMessage();
	}
	
	public String deleteAllLandlords() {
		this.landlordRepo.deleteAll();
		return Constants.getAllDeletionMessage();
	}
	public String updateLandlord(String id, Landlord updateLandlord) {
		Landlord landlordToUpdate = this.landlordRepo.findById(id).orElse(new Landlord());
		landlordToUpdate.setFirstName(Optional.ofNullable(updateLandlord.getFirstName()).orElse(Optional.ofNullable(landlordToUpdate.getFirstName()).orElse(Constants.getNaString())));
		landlordToUpdate.setLastName(Optional.ofNullable(updateLandlord.getLastName()).orElse(Optional.ofNullable(landlordToUpdate.getLastName()).orElse(Constants.getNaString())));
		landlordToUpdate.setEmail(Optional.ofNullable(updateLandlord.getEmail()).orElse(Optional.ofNullable(landlordToUpdate.getEmail()).orElse(Constants.getNaString())));
		landlordToUpdate.setPhoneNumber(Optional.ofNullable(updateLandlord.getPhoneNumber()).orElse(Optional.ofNullable(landlordToUpdate.getPhoneNumber()).orElse(Constants.getNaString())));
		this.landlordRepo.deleteById(id);
		this.landlordRepo.save(landlordToUpdate);
		return Constants.getUpdateMesssage();
	}
}
