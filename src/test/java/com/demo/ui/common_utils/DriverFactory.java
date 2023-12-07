package com.demo.ui.common_utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariOptions;

import java.io.IOException;
import java.time.Duration;

public class DriverFactory {

	
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return webDriver.get();
	}

	public static void setWebDriver(WebDriver driver) {
		webDriver.set(driver);
	}
	
	public DriverFactory() {}
	
	public static WebDriver launchBrowser(String browser, String browserVersion,String platform) throws IOException {
		
		WebDriver driver = null;
		Baseclass bc = new Baseclass();
		ConfigReader config = new ConfigReader();
		
		if (platform.equalsIgnoreCase(config.getProperty("windows.platform")) && browser.equalsIgnoreCase("FireFox")) {
			
//			log.info("Selected platform is firefox");
			FirefoxOptions browserOptions = new FirefoxOptions();
//			log.info("platform is"+ platform);
			browserOptions.setCapability("platformName",platform);
//			log.info("browserVersion is"+ browserVersion);
			browserOptions.setCapability("browserVersion",browserVersion);
			
		} else if(platform.equalsIgnoreCase(config.getProperty("windows.platform")) && browser.equalsIgnoreCase("Chrome")) {
			
//			log.info("Selected platform is Chrome");
			ChromeOptions browserOptions = new ChromeOptions();
//			log.info("platform is"+ platform);
			browserOptions.setCapability("platformName",platform);
//			log.info("browserVersion is"+ browserVersion);
			browserOptions.setCapability("browserVersion",browserVersion);
//			log.info("extendedDebugging is = true");
			browserOptions.setCapability("extendedDebugging", "true");

		}else if(platform.equalsIgnoreCase(config.getProperty("windows.platform")) && browser.equalsIgnoreCase("IE")) {
			
//			log.info("Selected platform is IE");
			InternetExplorerOptions browserOptions = new InternetExplorerOptions();
//			log.info("platform is"+ platform);
			browserOptions.setCapability("platformName",platform);
//			log.info("browserVersion is"+ browserVersion);
			browserOptions.setCapability("browserVersion",browserVersion);
//			log.info("extendedDebugging is = true");
			browserOptions.setCapability("extendedDebugging", "true");

		}else if(platform.equalsIgnoreCase(config.getProperty("windows.platform")) && browser.equalsIgnoreCase("Edge")) {
			
//			log.info("Selected platform is Edge");
			DesiredCapabilities browserOptions = new DesiredCapabilities();
//			log.info("platform is"+ platform);
			browserOptions.setCapability("platformName",platform);
//			log.info("browserVersion is"+ browserVersion);
			browserOptions.setCapability("browserVersion",browserVersion);
//			log.info("extendedDebugging is = true");
			browserOptions.setCapability("extendedDebugging", "true");

		}else if(platform.equalsIgnoreCase(config.getProperty("windows.platform")) && browser.equalsIgnoreCase("Safari")) {
			
//			log.info("Selected platform is Safari");
			SafariOptions browserOptions = new SafariOptions();
//			log.info("platform is"+ platform);
			browserOptions.setCapability("platformName",platform);
//			log.info("browserVersion is"+ browserVersion);
			browserOptions.setCapability("browserVersion",browserVersion);
//			log.info("extendedDebugging is = true");
			browserOptions.setCapability("extendedDebugging", "true");

		}else if(platform.equalsIgnoreCase("ipad")) {

		}else if(platform.equalsIgnoreCase("Android_emulator")) {

		}else if(platform.equalsIgnoreCase("ios")) {

		}else if(platform.equalsIgnoreCase("iPhone")) {

		}else if(platform.equalsIgnoreCase("Android")) {

		}else if(platform.equalsIgnoreCase("Tab")) {

		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		return driver;
	}
	
	
}
