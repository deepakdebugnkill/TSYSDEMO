package com.demo.api.endpoints;

/**
 * @description The `Endpoints` class encapsulates the complete API endpoint URL as a string variable, providing a centralized location for managing and accessing endpoint information.
 */
public interface Endpoints {

	public static final String BASEURI = "https://restful-booker.herokuapp.com";
	public static final String BASICAUTH="https://restful-booker.herokuapp.com/auth";
	public static final String GET_BOOKING_IDS="https://restful-booker.herokuapp.com/booking";
	public static final String GET_BOOKING_ID= "https://restful-booker.herokuapp.com/booking/{id}";
	public static final String CREATE_BOOKING="https://restful-booker.herokuapp.com/booking";
	public static final String UPDATE_BOOKING="/{id}";
	public static final String PARTIAL_UPDATE_BOOKING="/{id}";
	public static final String DELETE_BOOKING="/{id}";
}
