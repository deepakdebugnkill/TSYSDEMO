package com.demo.api.stepdefinition;

import com.demo.api.common_utils.BaseClass;
import com.demo.api.common_utils.ConfigReader;
import com.demo.api.common_utils.ExtentReportSetup;
import com.demo.api.endpoints.Endpoints;
import com.demo.api.globaldatas.GlobalDatas;
import com.demo.api.payload.AuthPayload;
import com.demo.api.pojo.AuthPojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

/**
 * @description Initializes request specifications, handles basic authentication credentials, sets headers, and processes POST requests to obtain and store authentication tokens.
 */
public class TC_01_AuthenticationStep extends BaseClass {
	static ExtentReports extent = ExtentReportSetup.getExtent();
	static ExtentTest test;
	public TC_01_AuthenticationStep(){
		reqspec = new RequestSpecBuilder().build();

	}

	AuthPayload ap = new AuthPayload();
	ConfigReader cr = new ConfigReader();
	static GlobalDatas globalDatas = new GlobalDatas();

	@Given("basic authentication credentials are provided")
	public void basic_authentication_credentials_are_provided() throws IOException {
		test = extent.createTest("basic_authentication_credentials_are_provided");
		addBasicAuth(cr.getProperty("api.username"), cr.getProperty("api.password"));
		test.log(Status.INFO, "Basic authentication credentials provided");
	}

	@Given("the header {string} is set to {string}")
	public void the_header_is_set_to(String headerKey, String headerValue) {

		addHeader(headerKey, headerValue);
		test.log(Status.INFO, "Header is added to request");
	}
	@Given("the request should contain payload")
	public void the_request_should_contain_payload() throws IOException {
		AuthPojo body = ap.authPayLoad();
		addBody(body);
	}



	@When("a POST request is made to the endpoint")
	public void a_post_request_is_made_to_the_endpoint() {
		requestType("POST", Endpoints.BASICAUTH);

	}

	@Then("an authentication token should be returned")
	public void an_authentication_token_should_be_returned() {
		String tokenres = extractResponse("token");
		globalDatas.setToken(tokenres);
	}

}
