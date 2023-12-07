package com.demo.ui.test_reports;

import com.demo.ui.common_utils.Baseclass;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class JVMReporting extends Baseclass {
	public static void generateJVMReport(String jsonFile) throws FileNotFoundException, IOException {
		File reportloc = new File(getPath() + getProperty("jvmpath"));
		Configuration con = new Configuration(reportloc, "Demo Framework");
		con.addClassifications("platform", "windows 10");
		con.addClassifications("sprint", "1");
		con.addClassifications("Author", "DELL");

		List<String> list = new LinkedList<String>();
		list.add(jsonFile);

		ReportBuilder builder = new ReportBuilder(list, con);
		builder.generateReports();
	}

}
