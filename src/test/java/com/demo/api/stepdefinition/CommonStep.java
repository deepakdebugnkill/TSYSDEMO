package com.demo.api.stepdefinition;


import com.demo.api.common_utils.BaseClass;
import com.demo.api.globaldatas.GlobalDatas;
import io.cucumber.java.en.Then;

/**
 * @description Set of commonly used steps that can be reused across multiple test scenarios
 */
public class CommonStep extends BaseClass {
	 GlobalDatas globalDatas = new GlobalDatas();

	/**
	 *
	 * @description For performing assertion checks to validate whether actual result matches expected result.
	 * @param expStatusCode
	 */
	@Then("the response status code should be {int}")
	public  void the_response_status_code_should_be(Integer expStatusCode) {
		
		assertStatusCode(response, expStatusCode);

	}

}
