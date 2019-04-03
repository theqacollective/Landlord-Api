package com.qa.landlordgateway;

public class Constants {
	public static final String CREATE_LANDLORD_PATH = "/createLandlord";
	public static final String DELETE_URL = "/deleteLandlord";
	public static final String UPDATE_URL = "/updateLandlord/{firstName}/{lastName}";
	public static final String GET_ALL_LANDLORDS_PATH = "/getAllLandlords";
	public static final String LANDLORD_SERCH_PATH = "/landlordSearch";

	private static String naString = "N/A";
	private static final String CREATION_MESSAGE = "New entry added";
	private static final String DELETION_MESSAGE = "Entry(ies) deleted";
	private static final String ALL_DELETION_MESSAGE = "All entries deleted";
	private static final String UPDATE_MESSSAGE = "Entry updated";

	public static String getNaString() {
		return naString;
	}

	public static void setNaString(String naString) {
		Constants.naString = naString;
	}

	public static String getCreateLandlordPath() {
		return CREATE_LANDLORD_PATH;
	}

	public static String getGetAllLandlordsPath() {
		return GET_ALL_LANDLORDS_PATH;
	}

	public static String getLandlordSerchPath() {
		return LANDLORD_SERCH_PATH;
	}

	public static String getCreationMessage() {
		return CREATION_MESSAGE;
	}

	public static String getDeletionMessage() {
		return DELETION_MESSAGE;
	}

	public static String getAllDeletionMessage() {
		return ALL_DELETION_MESSAGE;
	}

	public static String getUpdateMesssage() {
		return UPDATE_MESSSAGE;
	}

}
