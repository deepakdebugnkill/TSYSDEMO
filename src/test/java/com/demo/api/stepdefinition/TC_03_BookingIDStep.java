package com.demo.api.stepdefinition;

import com.demo.api.common_utils.BaseClass;
import com.demo.api.endpoints.Endpoints;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class TC_03_BookingIDStep extends BaseClass {
	@When("a GET request is made to the booking specific booking endpoint {string} , {string}")
	public void a_get_request_is_made_to_the_booking_specific_booking_endpoint(String headerKey, String headerValue) {
		List<Integer> bookings = TC_01_AuthenticationStep.globalDatas.getBookings();

		Random random = new Random();
		int nextInt = random.nextInt(bookings.size());

		String endpointWithId = Endpoints.GET_BOOKING_ID.replace("{id}", String.valueOf(bookings.get(nextInt)));
		addHeader(headerKey, headerValue);
		requestType("GET", endpointWithId);
	}



	@Then("the response should contain single booking information")
	public void the_response_should_contain_single_booking_information() {
		String responseBody = response.getBody().asString();
		System.out.println("Response Body: " + responseBody);
		String actualValue = response.then().extract().path("additionalneeds");
		Assert.assertTrue(
				actualValue.equals("super bowls") || actualValue.equals("Breakfast")|| actualValue.equals("Extra pillows please"),
				"Actual value is not equal to either 'super bowls' or 'Breakfast'"
		);


	}

}
