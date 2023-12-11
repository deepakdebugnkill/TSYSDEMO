package com.demo.api.common_utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
public class ExtentReportSetup {
    static ExtentReports extent;
    static {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("TSYSDEMO\\target\\report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
    public static ExtentReports getExtent() {
        return extent;
    }
}