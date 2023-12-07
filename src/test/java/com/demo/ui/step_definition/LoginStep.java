package com.demo.ui.step_definition;

import com.demo.ui.common_utils.Baseclass;
import com.demo.ui.pagemanager.PageObjectManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;

public class LoginStep extends Baseclass {
	
//	private ExtentReport extentReport;
	public static Logger log = (Logger) LogManager.getLogger(LoginStep.class.getName());
	PageObjectManager pom = new PageObjectManager();
	
//	public LoginStep(ExtentReport extentReport) {
//		this.extentReport = extentReport;
//	}

	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		pom.getLoginPage().login();
		log.info("Browser launched successfully");
//		extentReport.logInfo("Launched website successfully");
	}

	@When("I enter username {string} and password {string}")
	public void i_enter_username_and_password(String username, String password) {
		pom.getLoginPage().loginCredentials(username, password);
		pom.getLoginPage().loginSubmit();
	}

	@Then("I should see success message {string}")
	public void i_should_see_success_message(String expMsg) {
		String actMsg = pom.getLoginPage().successMessageValidUser();
		Assert.assertEquals(actMsg, expMsg, "Verify success message");
	}

	@Then("I should see error message {string}")
	public void i_should_see_error_message(String expMsg) {
		String actMsg = pom.getLoginPage().errorMessageInvalidUser();
		Assert.assertEquals(actMsg, expMsg,"Verify error message"  );
	}

}