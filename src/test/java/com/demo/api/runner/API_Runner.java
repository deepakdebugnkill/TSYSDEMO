package com.demo.api.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * @description Test runner class for API tests using Cucumber, orchestrating test scenarios defined in feature files. It configures Cucumber options, integrates with Allure and Extent reports
 */
@RunWith(Cucumber.class)
@CucumberOptions(tags = "@E2E", dryRun = false, glue = "com.demo.api.stepdefinition", features = "src\\test\\resources\\API_Features",
plugin = {
        "pretty",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
})

public class API_Runner{
private static final Logger log = LogManager.getLogger(API_Runner.class);

@BeforeClass
    public static void setup(){
//        RestAssured.baseURI = "";
        log.info("Setup method exeuted");
    }

    @AfterClass
    public static void tearDown(){
    RestAssured.reset();
    }
}
