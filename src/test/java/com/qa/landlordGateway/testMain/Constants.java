package com.qa.landlordGateway.testMain;

import java.nio.charset.Charset;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.landlordGateway.entity.Landlord;
import com.qa.landlordGateway.entity.LandlordBuilder;

public class Constants {
	private static final Landlord NULL_LANDLORD = new Landlord();
	private static final Landlord DEFAULT_BUILDER_LANDLORD = LandlordBuilder.getLandlord().landlordBuild();
	public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	private static final String TEST_FIRST_NAME = "TestFirst";
	private static final String TEST_LAST_NAME = "TestLast";
	private static final String TEST_CONTACT_NUMBER = "07727715483";
	private static final String TEST_CONTACT_EMAIL = "TestEmail";
	private static final String NA_STRING = "N/A";
	private static final Landlord CONSTRUCTED_LANDLORD = new Landlord(
			TEST_FIRST_NAME,
			TEST_LAST_NAME,
			TEST_CONTACT_EMAIL,
			TEST_CONTACT_NUMBER);
	private static final ResponseEntity<Landlord> LANDLORD_CREATED = new ResponseEntity<Landlord>(HttpStatus.OK);
	public static Landlord getNullLandlord() {
		return NULL_LANDLORD;
	}
	public static Landlord getDefaultBuilderLandlord() {
		return DEFAULT_BUILDER_LANDLORD;
	}
	public static String getTestFirstName() {
		return TEST_FIRST_NAME;
	}
	public static String getTestLastName() {
		return TEST_LAST_NAME;
	}
	public static String getTestContactNumber() {
		return TEST_CONTACT_NUMBER;
	}
	public static String getTestContactEmail() {
		return TEST_CONTACT_EMAIL;
	}
	public static Landlord getConstructedLandlord() {
		return CONSTRUCTED_LANDLORD;
	}
	public static ResponseEntity<Landlord> getLandlordCreated() {
		return LANDLORD_CREATED;
	}
	public static String getNaString() {
		return NA_STRING;
	}
	
}
