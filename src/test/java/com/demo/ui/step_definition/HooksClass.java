package com.demo.ui.step_definition;

import com.demo.ui.common_utils.Baseclass;
import com.demo.ui.common_utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class HooksClass extends Baseclass {

	private ConfigReader config;
//	private ExtentReport extentReport;

	@Before
	public void setup(Scenario scenario) throws IOException {
		launchBrowser(getProperty("browser"));
		navigateTo(getProperty("url"));
		setImplicitWait(10);
		System.out.println("Scenario started: " + scenario.getName());
		System.out.println("Scenario start time: " + System.currentTimeMillis());
//		extentReport = new ExtentReport();
//		extentReport.createTest("Cucumber Test Report");
		
	}
	@After
	public void tearDown(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			
//			extentReport.logFail("Test Case Failed"+ scenario.getName());
//			extentReport.captureScreenshot();
			String screenshotDir = getAbsolutePath("src\\test\\resources\\FailedScreenshot");
			browserCapture(screenshotDir, scenario.getName());
			scenario.attach(screenshotForCucumber(), "Image.png", "Every Scenario");
		}
//		else {
//			extentReport.logPass("Test Case Passed"+scenario.getName());
//		}
//		extentReport.flushReport();
		if(driver!= null) {
			driver.quit();
		}
		System.out.println("Scenario end time: "+ System.currentTimeMillis());
		System.out.println("Scenario result: "+(scenario.isFailed()? "FAILED":"PASSED"));
	}

}
