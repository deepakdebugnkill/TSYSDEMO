package com.demo.ui.common_utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
	 InputStream inputstream;
	static Properties prop;
	Logger log = LoggerFactory.getLogger(ConfigReader.class);
	
	public String getProperty(String key) throws IOException {
		prop = new Properties();
		String propFileName = "user.dir\\configs\\config.properties";
		inputstream = getClass().getClassLoader().getResourceAsStream(propFileName);
		
		if(inputstream!= null) {
			prop.load(inputstream);
			log.info("loaded property ile");
		}else {
			log.info("Property file is not found in the class path");
			throw new FileNotFoundException("property file "+propFileName+" not found in the classpath");
		}
		String text = prop.getProperty(key);
		log.info("property value is :"+text);
		return prop.getProperty(key);
	}
	
	public void deleteProperty(String key) {
		prop = new Properties();
		prop.remove(key);
	}

//	private static Properties properties;
//		try {
//			properties = new Properties();
//			FileInputStream fis = new FileInputStream("config.properties");
//			properties.load(fis);
//			fis.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	public static String getReportType() {

		return prop.getProperty("reportType", "cucumber-jvm");

	}
	
	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}

}
