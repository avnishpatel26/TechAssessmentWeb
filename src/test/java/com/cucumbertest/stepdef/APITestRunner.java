package com.cucumbertest.stepdef;



import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        tags = {"@APIAutomation"},
        plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        monochrome = true,
        dryRun = false
)

public class APITestRunner {
	
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\extentconfig.xml");
	     Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	     Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
	}

}
