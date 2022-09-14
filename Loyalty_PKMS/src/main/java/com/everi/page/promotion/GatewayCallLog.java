package com.everi.page.promotion;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.everi.Enum.LocatorType;
import com.everi.Helper.GlobalVariables;
import com.everi.driver.Driver;
import com.everi.exception.AutomationException;
import com.everi.page.BasePage;

public class GatewayCallLog extends BasePage {

	static Logger logger = LogManager.getLogger(GatewayCallLog.class);
	public static String promotionId;
	WebDriver webDriver = GlobalVariables.webDriver;
	String playerId = GlobalVariables.testDataMap.get("PlayerId");
	int RedemptionCodeOnWin = Integer.parseInt(GlobalVariables.testDataMap.get("RedemptionCodeOnWin"));

	private final String gatewayTabXpath = "(//*[contains(text(),\"Gateway\")])[1]";
	private final String gatewayLink = "(//*[contains(text(),\"Gateway\")])[2]";
	private final String submit = "//*[@id=\"SiteMaster_MainContent_lbSearch\"]";
	private final String responseLink = "(//*[@id=\"linkresponse\"])[1]";
	private final String successLink = "(//*[contains(text(),\"AddPoints\")])[3]/../following::td[2]/a";
	private final String meterValue = "(//*[contains(text(),\"MeterValue\")])[1]/../span[@class=\"tx\"]";
	private final String close = "SiteMaster_MainContent_GatewayCallsLog_lnkBack";
	private final String amount = "(//*[contains(text(),\"Amount\")])[3]/../span[@class=\"tx\"]";
	private final String textData = "//*[@id=\"SiteMaster_MainContent_gvCallLog\"]";
	private final String method = "(//*[contains(text(),\"Method\")])[2]";
	private final String methodDrop = "select2-SiteMaster_MainContent_ddlMethod-container";
	private final String playerID = "(//*[contains(text(),\"AddPoints\")])[3]/../following::td[1]";
	private final String demoCard = "(//*[contains(text(),\"getDemographicFieldsByCardNumber\")])[2]/../following::td[2]";
	private final String pinPrizeCompDeduct = "(//*[contains(text(),\"Pin\")])[3]";
	private final String playerIDCompPoints = "(//*[contains(text(),\"AddCompPoints\")])[3]/../following::td[1]";
	private final String successLinkCompPoints = "(//*[contains(text(),\"AddCompPoints\")])[3]/../following::td[2]/a";
	private final String playerIdSlotfree = "(//*[contains(text(),\"Award\")])[3]/../following::td[1]";
	private final String successlinkSlotfree = "(//*[contains(text(),\"Award\")])[3]/../following::td[2]/a";

	public void clickGatewayTab() throws AutomationException {
		clickNoWait(getwebElement(gatewayTabXpath, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on the gateway tab");
	}

	public void clickGatewayLink() throws AutomationException {
		clickNoWait(getwebElement(gatewayLink, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on the gateway link");
	}

	public void clickSubmit() throws AutomationException {
		clickNoWait(getwebElement(submit, LocatorType.XPATH, 10), 10);
		logger.info("Click action on submit");
	}

	public void responseLink() throws AutomationException {
		System.out.println("The Player ID is " + playerId);

		String screenPlayerId = gettext(getwebElement(playerID, LocatorType.XPATH, 10));
		String split = screenPlayerId.substring(0, 10);
		System.out.println("Player ID is " + split);

		if (split.equals(playerId)) {
			clickNoWait(getwebElement(successLink, LocatorType.XPATH, 10), 10);
			logger.info("Click action on Success Link");

			String amountfromUI = gettext(getwebElement(amount, LocatorType.XPATH, 10));
			System.out.println("Amount from Gateway CallLog is " + amountfromUI);
			System.out.println("Redemption code is " + RedemptionCodeOnWin);

			if (amountfromUI.equals(RedemptionCodeOnWin)) {
				System.out.println("Amount values have matched");
			} else {
				System.out.println("Amount Values have not matched");
			}

			clickNoWait(getwebElement(close, LocatorType.ID, 10), 10);
			logger.info("Click action performed on the close link");

		}

		else {
			logger.info("Player IDs are not matching");
		}
	}

	public void responseLinkPrizeCompAdd() throws AutomationException {
		System.out.println("The Player ID is " + playerId);

		String screenPlayerId = gettext(getwebElement(playerIDCompPoints, LocatorType.XPATH, 10));
		String split = screenPlayerId.substring(0, 10);
		System.out.println("Player ID is " + split);

		if (split.equals(playerId)) {
			clickNoWait(getwebElement(successLinkCompPoints, LocatorType.XPATH, 10), 10);
			logger.info("Click action on Success Link");

			String amountfromUI = gettext(getwebElement(amount, LocatorType.XPATH, 10));
			System.out.println("Amount from Gateway CallLog is " + amountfromUI);
			System.out.println("Redemption code is " + RedemptionCodeOnWin);

			if (amountfromUI.equals(RedemptionCodeOnWin)) {
				System.out.println("Amount values have matched");
			} else {
				System.out.println("Amount Values have not matched");
			}

			clickNoWait(getwebElement(close, LocatorType.ID, 10), 10);
			logger.info("Click action performed on the close link");
		}

		else {
			logger.info("Player IDs are not matching");
		}
	}

	public void responseLinkPrizeSlotFree() throws AutomationException {
		System.out.println("The Player ID is " + playerId);

		String screenPlayerId = gettext(getwebElement(playerIdSlotfree, LocatorType.XPATH, 10));
		String split = screenPlayerId.substring(0, 10);
		System.out.println("Player ID is " + split);

		if (split.equals(playerId)) {
			clickNoWait(getwebElement(successlinkSlotfree, LocatorType.XPATH, 10), 10);
			logger.info("Click action on Success Link");

			String amountfromUI = gettext(getwebElement(amount, LocatorType.XPATH, 10));
			System.out.println("Amount from Gateway CallLog is " + amountfromUI);
			System.out.println("Redemption code is " + RedemptionCodeOnWin);

			if (amountfromUI.equals(RedemptionCodeOnWin)) {
				System.out.println("Amount values have matched");
			} else {
				System.out.println("Amount Values have not matched");
			}
			clickNoWait(getwebElement(close, LocatorType.ID, 10), 10);
			logger.info("Click action performed on the close link");

		}

		else {
			logger.info("Player IDs are not matching");
		}
	}

	public void responseLinkDemo() throws AutomationException {
		clickNoWait(getwebElement(demoCard, LocatorType.XPATH, 10), 10);
		logger.info("Click action on demo Link");
		clickNoWait(getwebElement(close, LocatorType.ID, 10), 10);
		logger.info("Click action performed on the close link");

	}

	public void selectMethod() throws AutomationException {
		clickNoWait(getwebElement(methodDrop, LocatorType.ID, 10), 10);
		logger.info("Click action on Method Dropdown");
		WebElement methodType = GlobalVariables.webDriver.findElement(By.xpath(
				"(//*[contains(text(),\"Method\")])[2]/../td/div/select[@id=\"SiteMaster_MainContent_ddlMethod\"]"));
		Select s = new Select(methodType);
		s.selectByValue("AddPoints");
		clickNoWait(getwebElement(method, LocatorType.XPATH, 10), 10);

	}

	public void selectMethodPrizeCompAdd() throws AutomationException {
		clickNoWait(getwebElement(methodDrop, LocatorType.ID, 10), 10);
		logger.info("Click action on Method Dropdown");
		WebElement methodType = GlobalVariables.webDriver.findElement(By.xpath(
				"(//*[contains(text(),\"Method\")])[2]/../td/div/select[@id=\"SiteMaster_MainContent_ddlMethod\"]"));
		Select s = new Select(methodType);
		s.selectByValue("AddCompPoints");
		clickNoWait(getwebElement(method, LocatorType.XPATH, 10), 10);

	}

	public void selectMethodPrizeSlotFree() throws AutomationException {
		clickNoWait(getwebElement(methodDrop, LocatorType.ID, 10), 10);
		logger.info("Click action on Method Dropdown");
		WebElement methodType = GlobalVariables.webDriver.findElement(By.xpath(
				"(//*[contains(text(),\"Method\")])[2]/../td/div/select[@id=\"SiteMaster_MainContent_ddlMethod\"]"));
		Select s = new Select(methodType);
		s.selectByValue("AwardFreePlay");
		clickNoWait(getwebElement(method, LocatorType.XPATH, 10), 10);

	}

	public void getValueOfLog() throws AutomationException {
		String valueFromUI = gettext(getwebElement(textData, LocatorType.XPATH, 10));
		System.out.println("Data from UI " + valueFromUI);
	}

}
