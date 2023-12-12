package com.demo.api.common_utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportSetup {
    static ExtentReports extent;
    static {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("target/report.html");
        htmlReporter.config().setDocumentTitle("Automation test results");
        htmlReporter.config().setReportName("DA");
        htmlReporter.config().setTheme(Theme.STANDARD);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
    public static ExtentReports getExtent() {
        return extent;
    }
}