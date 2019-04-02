package com.qa.landlordGateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.landlordGateway.entity.Landlord;

@Repository
public interface LandlordRepo extends JpaRepository<Landlord, Long>{

}
