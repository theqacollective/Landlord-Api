package com.qa.landlordGateway.entity;

import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class LandlordBuilder {
	private String firstName = null;
	private String lastName = null;
	private String email = null;
	private String phoneNumber = null;
	private static LandlordBuilder landlordBuilder;
	
	private LandlordBuilder() {
		
	}
	public LandlordBuilder firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public LandlordBuilder lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public LandlordBuilder email(String email) {
		this.email = email;
		return this;
	}
	public LandlordBuilder phoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}
	public Landlord landlordBuild() {
		Landlord landlord = new Landlord(
				Optional.ofNullable(this.firstName).orElse("N/A"),
				Optional.ofNullable(this.lastName).orElse("N/A"),
				Optional.ofNullable(this.email).orElse("N/A"),
				Optional.ofNullable(this.phoneNumber).orElse("N/A"));
		landlordBuilder = null;
		return landlord;
	}
	
	public static LandlordBuilder getLandlord() {
		if (landlordBuilder == null) {
			landlordBuilder = new LandlordBuilder(); 
		}
		return landlordBuilder;
	}
}
