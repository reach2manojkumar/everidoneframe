package com.everi.page.promotion;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.everi.Enum.LocatorType;
import com.everi.Helper.GlobalVariables;
import com.everi.driver.Driver;
import com.everi.exception.AutomationException;
import com.everi.page.BasePage;

public class ReportsPlayerActivity extends BasePage {

	static Logger logger = LogManager.getLogger(ReportsPlayerActivity.class);
	public static String promotionId;
	WebDriver webDriver = GlobalVariables.webDriver;
	
	private final String reportsTabXpath = "(//*[contains(text(),\"Reports\")])[1]";
	private final String playerActivity = "//*[contains(text(),\"Player Activity\")]";
	private final String submit = "SiteMaster_MainContent_lbSubmit";
	private final String reportsArgs = "((//*[@id=\"SiteMaster_MainContent_gvLogs\"]/tbody/tr)[2]/td)[11]";
	private final String reportsArgsNext = "((//*[@id=\"SiteMaster_MainContent_gvLogs\"]/tbody/tr)[3]/td)[11]";
	private final String playerIDBox = "SiteMaster_MainContent_tbPlayerID";
	
	
	public void clickReportsTab() throws AutomationException {
		clickNoWait(getwebElement(reportsTabXpath, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on the Reports tab");
	}

	public void clickPlayerActivity() throws AutomationException {
		clickNoWait(getwebElement(playerActivity, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on the Player Activity link");
	}

	public void enterPlayerIdNumber() throws AutomationException, IOException {
		clickNoWait(getwebElement(playerIDBox, LocatorType.ID, 10), 10);
		logger.info("Click action performed on enter PlayerId Text box");
		String playerId = GlobalVariables.testDataMap.get("PlayerId");
		threadWait(1000);
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + playerId + "'",
				getwebElement(playerIDBox, LocatorType.ID, 10));
		threadWait(1000);
		logger.info("Entered PlayerId in Text box" + playerId );
	}
	
	public void clickSubmit() throws AutomationException {
		clickNoWait(getwebElement(submit, LocatorType.ID, 10), 10);
		logger.info("Click action on submit");
	}
	
	public void reportsArgs() throws AutomationException {
		String reports = gettext(getwebElement(reportsArgs, LocatorType.XPATH, 10));
		System.out.println("text on ui " + reports);
		if (reports.equals (" "))
		{
			logger.info("No Args found for the row");
			threadWait(1000);
			
		}
		else {
			String reportsNext = gettext(getwebElement(reportsArgsNext, LocatorType.XPATH, 10));
			logger.info("Args on ui" + reportsNext);
			threadWait(1000);

		}
	}

	
}
