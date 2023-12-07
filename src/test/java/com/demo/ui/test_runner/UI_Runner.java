package com.demo.ui.test_runner;

import com.demo.ui.common_utils.Baseclass;
import com.demo.ui.test_reports.JVMReporting;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.FileNotFoundException;
import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@Login", dryRun = false, glue = "com\\demo\\ui\\step_definition", features = "src\\test\\resources\\UI_Features", plugin = {
        "pretty",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "json:target/DemoFramework.json",
        "html:target/DemoFramework.html",
        "junit:target/DemoFramework.xml"
})

public class UI_Runner {

    //	private static ExtentReport extentReport;
    private static Baseclass bc;

    @BeforeClass
    public void setup() {
        System.out.println("Initial");

    }

    @AfterClass
    public static void report() throws FileNotFoundException, IOException {
        String report = bc.getProperty("reportType");
        if ("extent".equalsIgnoreCase(report)) {
//			extentReport.flushReport(); 
        } else if ("jvm".equalsIgnoreCase(report)) {
            JVMReporting.generateJVMReport(bc.getPath() + bc.getProperty("jsonpath"));
        } else {
            System.out.println("Invalid report type in config.properties");
        }
    }
}
