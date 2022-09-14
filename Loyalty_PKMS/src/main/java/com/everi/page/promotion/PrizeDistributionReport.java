package com.everi.page.promotion;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
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
import com.everi.soapservices.PromotionEndPoints;
import com.everi.stepdefinitions.PromotionAPISteps;
import com.everi.util.WebServiceUtil;

import kong.unirest.HttpResponse;

public class PrizeDistributionReport extends BasePage {

	static Logger logger = LogManager.getLogger(PrizeDistributionReport.class);
	public static String promotionId;
	WebDriver webDriver = GlobalVariables.webDriver;
	JavascriptExecutor js = (JavascriptExecutor) GlobalVariables.webDriver;
	public static String receiptID;
	PromotionAPISteps api = new PromotionAPISteps();

	private final String reportsTabXpath = "(//*[contains(text(),\"Reports\")])[1]";
	private final String prizeDistribution = "(//*[contains(text(),\"Prize Distribution\")])[1]";
	private final String submit = "(//*[@id=\"SiteMaster_MainContent_lbSubmit\"])[1]";
	private final String prizeArgs = "(//*[@id=\"SiteMaster_MainContent_gvDetail\"]/tbody/tr)[2]";
	private final String prizeArgsNext = "(//*[@id=\"SiteMaster_MainContent_gvDetail\"]/tbody/tr)[3]";
	private final String playerIDBox = "SiteMaster_MainContent_tbPlayerID";
	private final String receiptId = "(//*[@id=\"SiteMaster_MainContent_gvDetail\"]/tbody/tr)[2]/td[1]";

	public void clickReportsTab() throws AutomationException {
		clickNoWait(getwebElement(reportsTabXpath, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on the Reports tab");
	}

	public void clickPrizeDistribution() throws AutomationException {
		clickNoWait(getwebElement(prizeDistribution, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on the Prize Distribution link");
	}

	public void clickSubmit() throws AutomationException {
		js.executeScript("window.scrollTo(0,600)");
		clickNoWait(getwebElement(submit, LocatorType.XPATH, 10), 10);
		logger.info("Click action on submit");
	}

	public void prizeArgs() throws AutomationException {
		System.out.println("The Receipt ID is " + receiptId);

		String prize = gettext(getwebElement(prizeArgs, LocatorType.XPATH, 10));

		System.out.println("text on ui " + prize);

//		} else {
		String prizeNext = gettext(getwebElement(prizeArgsNext, LocatorType.XPATH, 10));
		logger.info("Prize Args on ui " + prizeNext);
		threadWait(1000);
	}

}
