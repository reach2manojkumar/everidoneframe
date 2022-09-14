package com.everi.testRunners;

import com.everi.Test.ProjectGlobalVariables;

import com.everi.driver.Driver;
import com.everi.exception.AutomationException;
import com.everi.util.Util;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.junit.runner.RunWith;

//Runwith Class will run the Class with Cucumber
@RunWith(Cucumber.class)
//Cucumber Options integrate the feature package and glue package
@CucumberOptions(features = "src/test/resources/features/", glue = "com/everi/stepdefinitions",
		// tags = "@CashAdvanceWithPin",
		plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "junit:target/JunitReport" },
		// dryRun = true,
		monochrome = true)

public class TestRunner {

	static Logger logger = LogManager.getLogger(TestRunner.class);
	static Driver driverHandler = new Driver();
	
	// runs before all the features
	@BeforeClass
	public static void setup() throws InterruptedException, AutomationException {
		logger.info("******************************************************************************");
		logger.info("$$$$$$$$$$$$$$$$$$$$ Entering setup before all Features $$$$$$$$$$$$$$$$$$$$$$");

		ProjectGlobalVariables.loyaltyProperties = Util.getFileAsProperty("Properties/loyalty.properties");
		com.everi.Helper.GlobalVariables.everi_property = Util.getFileAsProperty("Properties/everitest.properties");
		logger.info(" Loading everitest property file in Helper package of Global Variables everi_property");
		// driverHandler.runModeConfig();
		driverHandler.startService();
		logger.info("Starting webdriver service");
	}

	// runs after all the features
	@AfterClass
	public static void tearDown() throws AutomationException {
		logger.info("Inside tear down");
		driverHandler.stopService();
		logger.info("Stopped webdriver service");
		logger.info("XXXXXXXXXXXXX             -E---N---D-             XXXXXXXXXXXXX");
	}

}
