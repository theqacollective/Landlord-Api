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
	
	public String createLandlord(Landlord landlord) {
		if(this.landlordRepo.getLandlordsByFirstNameAndLastName(landlord.getFirstName(), landlord.getLastName()) !=null) {
			return "Landlord Already Exists";
		}
		this.landlordRepo.save(landlord);
		return "Landlord Created";
	}
	public List<Landlord> getLandlords(){
		return this.landlordRepo.findAll();	
		}
	public List<Landlord> landlordSearch(Landlord landlord){
		return this.getLandlords().stream().filter(x -> x.matches(landlord)).collect(Collectors.toList());
	}
	
	public String deleteAllLandlords() {
		this.landlordRepo.deleteAll();
		return Constants.getAllDeletionMessage();
	}
	public String updateLandlord(String firstName,String lastName, Landlord updateLandlord) {
		Landlord landlordToUpdate = this.landlordSearch(landlordRepo.getLandlordsByFirstNameAndLastName(firstName, lastName)).get(0);
		landlordToUpdate.setFirstName(Optional.ofNullable(updateLandlord.getFirstName()).orElse(Optional.ofNullable(landlordToUpdate.getFirstName()).orElse(Constants.getNaString())));
		landlordToUpdate.setLastName(Optional.ofNullable(updateLandlord.getLastName()).orElse(Optional.ofNullable(landlordToUpdate.getLastName()).orElse(Constants.getNaString())));
		landlordToUpdate.setEmail(Optional.ofNullable(updateLandlord.getEmail()).orElse(Optional.ofNullable(landlordToUpdate.getEmail()).orElse(Constants.getNaString())));
		landlordToUpdate.setPhoneNumber(Optional.ofNullable(updateLandlord.getPhoneNumber()).orElse(Optional.ofNullable(landlordToUpdate.getPhoneNumber()).orElse(Constants.getNaString())));
		this.landlordRepo.delete(landlordSearch(landlordRepo.getLandlordsByFirstNameAndLastName(firstName, lastName)).get(0));
		this.landlordRepo.save(landlordToUpdate);
		return Constants.getUpdateMesssage();
	}

	public String deleteLandlord(String firstName,String lastName) {
		if(this.landlordRepo.getLandlordsByFirstNameAndLastName(firstName, lastName)==null)
		{
			return "Requested Landlord Does Not Exist";
		}
		this.landlordRepo.delete(this.landlordRepo.getLandlordsByFirstNameAndLastName(firstName, lastName));
		return Constants.getDeletionMessage();
	}
}
