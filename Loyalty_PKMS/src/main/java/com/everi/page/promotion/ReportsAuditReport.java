package com.everi.page.promotion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Set;

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

public class ReportsAuditReport extends BasePage {

	static Logger logger = LogManager.getLogger(ReportsAuditReport.class);
	public static String promotionId;
	WebDriver webDriver = GlobalVariables.webDriver;
	String promotionName = EnrollmentPage.promotionName;
	
	private final String reportsTabXpath = "(//*[contains(text(),\"Reports\")])[1]";
	private final String auditReport = "//*[contains(text(),\"Audit Report\")]";
	private final String submit = "SiteMaster_MainContent_lbSubmit";
	private final String reportsArgs = "((//*[@id=\"SiteMaster_MainContent_gvLogs\"]/tbody/tr)[2]/td)[11]";
	private final String reportsArgsNext = "((//*[@id=\"SiteMaster_MainContent_gvLogs\"]/tbody/tr)[3]/td)[11]";
	private final String playerIDBox = "SiteMaster_MainContent_tbPlayerID";
	private final String search = "SiteMaster_MainContent_lbSearch";
	private final String create = "(//*[contains(text(),\"Create\")])[4]/../td[6]/div/a";
	private final String name = "(//*[contains(text(),\"name\")]/../td)[3]";
	private final String datefrom = "(//*[contains(text(),\"date From\")]/../td)[3]";
	private final String dateto = "(//*[contains(text(),\"date To\")]/../td)[3]";
	private final String timefrom = "(//*[contains(text(),\"time From\")]/../td)[3]";
	private final String timeto = "(//*[contains(text(),\"time To\")]/../td)[3]";
	private final String createLink = "(//*[contains(text(),\"Create\")])[4]/../td[contains(text(),\"Promotion.PromotionDateRange\")]";

	public void clickReportsTab() throws AutomationException {
		clickNoWait(getwebElement(reportsTabXpath, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on the Reports tab");
	}

	public void clickAuditReport() throws AutomationException {
		clickNoWait(getwebElement(auditReport, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on the Audit Report link");
	}

	public void clickSearch() throws AutomationException {
		clickNoWait(getwebElement(search, LocatorType.ID, 10), 10);
		logger.info("Click action on search");
	}

	public void createField() throws AutomationException {
		WebElement createView = webDriver
				.findElement(By.xpath("(//*[contains(text(),\"Create\")])[4]/../td[contains(text(),\"Promotion\")]"));
		String startDate = GlobalVariables.testDataMap.get("PromotionStartDate");
		String startTime = GlobalVariables.testDataMap.get("StartTime");
		String endDate = GlobalVariables.testDataMap.get("PromotionEndDate");
		String endTime = GlobalVariables.testDataMap.get("EndTime");

		if (createView.isDisplayed()) {
			clickNoWait(getwebElement(create, LocatorType.XPATH, 10), 10);
			logger.info("Click action on view fields on create mode");

			// Get all the details of the current window
			String ParentHandle = webDriver.getWindowHandle();
			System.out.println("Parent Window " + ParentHandle);

			Set<String> allHandles = webDriver.getWindowHandles();

			System.out.println("Window Handle " + allHandles);

			for (String handle : allHandles) {
				System.out.println("Switching to window " + handle);

				// Switch to the window first and then execute commands using driver
				webDriver.switchTo().window(handle);
			}

			String nameID = gettext(getwebElement(name, LocatorType.XPATH, 10));
			System.out.println("Name from Audit Report is " + nameID);
//			assertEquals(nameID, promotionName);

			String dateFrom = gettext(getwebElement(datefrom, LocatorType.XPATH, 10));
			System.out.println("Text from date from is " + dateFrom);
			assertEquals(dateFrom, startDate);

			String dateTo = gettext(getwebElement(dateto, LocatorType.XPATH, 10));
			System.out.println("Text from date to is " + dateTo);
			assertEquals(dateTo, endDate);

			String timeFrom = gettext(getwebElement(timefrom, LocatorType.XPATH, 10));
			System.out.println("Text from time from is " + timeFrom);
			assertEquals(timeFrom, startTime);

			String timeTo = gettext(getwebElement(timeto, LocatorType.XPATH, 10));
			System.out.println("Text from time to is " + timeTo);
			assertEquals(timeTo, endTime);

			// Move back to Parent Window
			System.out.println("Switching to Parent window" + ParentHandle);
			webDriver.switchTo().window(ParentHandle);

			webDriver.quit();
		}

		else {
			logger.info("Click action on create not required");

		}
	}
}

