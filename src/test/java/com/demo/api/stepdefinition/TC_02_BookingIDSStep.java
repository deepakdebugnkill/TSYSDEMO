package com.demo.api.stepdefinition;

import com.demo.api.common_utils.BaseClass;
import com.demo.api.endpoints.Endpoints;
import com.demo.api.pojo.BookingPojo;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TC_02_BookingIDSStep extends BaseClass {
	List<Integer> bookingIDs = new ArrayList<>();
	public TC_02_BookingIDSStep(){
		reqspec = new RequestSpecBuilder().build();

	}
	@When("the header is  {string} is set to {string}")
	public void the_header_is_is_set_to(String headerKey, String headerValue) {
		addHeader(headerKey, headerValue);
	}
	@When("a GET request is made to the booking endpoint")
	public void a_get_request_is_made_to_the_booking_endpoint() {

		response = requestType("GET", Endpoints.GET_BOOKING_IDS);
	}

	@Then("the response should contain booking information written to a JSON file")
	public void the_response_should_contain_booking_information_written_to_a_json_file() throws IOException {
		String responseBody = getasprettyformat(response);
		List<BookingPojo> bookings = response.jsonPath().getList("", BookingPojo.class);
		
		for (BookingPojo booking : bookings) {
			int bookingid = booking.getBookingid();
			bookingIDs.add(bookingid);
	
		}
		
		TC_01_AuthenticationStep.globalDatas.setBookings(bookingIDs);

	}

}
