package com.qa.landlordGateway.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.landlordGateway.entity.Landlord;

@Repository
public interface LandlordRepo extends MongoRepository<Landlord, String>{
	public Optional<Landlord> findById(String title);

	public List<Landlord> findByEmail(String building);
	
	public List<Landlord> getLandlordsByFirstName(String request);
	public void delete(Landlord apartment);

	public Landlord getLandlordsByFirstNameAndLastName(String firstName, String lastName);
}
