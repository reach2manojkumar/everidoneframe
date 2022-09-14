package com.everi.page.promotion;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.everi.Enum.LocatorType;
import com.everi.Helper.GlobalVariables;
import com.everi.exception.AutomationException;
import com.everi.page.BasePage;

public class GeneralInformationPage extends BasePage {

	static Logger logger = LogManager.getLogger(GeneralInformationPage.class);
	private final String promotionNameId = "SiteMaster_MainContent_tbName";
	private final String promotionStartDateId = "SiteMaster_MainContent_dtStart1_dcDate_textBoxDate"; // 07/20/2021
	private final String promotionEndDateId = "SiteMaster_MainContent_dtEnd1_dcDate_textBoxDate"; // 08/24/2022
	private final String selectAllKiosksCheckboxXpath = "(//*[@id=\"SiteMaster_MainContent_cbAllKiosks\"]/../label/span)[1]";
	private final String firstRowSecondKiosksXpath = "//table[@id='SiteMaster_MainContent_cblKiosks']/tbody/tr[1]/td[2]";
	private final String promotionThumbnailUploadId = "SiteMaster_MainContent_fuAsset";
	private final String createBtnId = "SiteMaster_MainContent_lbSubmit";
	private final String startDateTimeId = "SiteMaster_MainContent_dtStart1_tc2Time_tbTime";
	private final String endDateTimeId = "SiteMaster_MainContent_dtEnd1_tc2Time_tbTime";
	private final String errorContainerId = "SiteMaster_flashMessage_errorContainer";
	private final String successContainerId = "SiteMaster_flashMessage_successContainer";
	private final String enrollmentTabXpath = "//a[contains(@href,'PromotionEnrollment')]";
	private final String startTimeDailyId = "SiteMaster_MainContent_tcStartTime_tbTime";
	private final String endTimeDailyId = "SiteMaster_MainContent_tcEndTime_tbTime";
	private final String descriptionId = "SiteMaster_MainContent_tbDescription";
	private final String priority = "SiteMaster_MainContent_tbPriority";
	private final String inactiveCheckboxXpath = "(//*[@id=\"SiteMaster_MainContent_cbInactive\"]/following::span)[1]";
	private final String archiveCheckboxXpath = "(//*[@id=\"SiteMaster_MainContent_cbArchived\"]/following::span)[1]";
	private final String postToCalendarCheckboxXpath = "(//*[@id=\"SiteMaster_MainContent_cbPostToCalendar\"]/following::span)[1]";
	private final String errorInvalidDateContainerXpath = "(//*[@class=\"field-validation-error\"])[1]";
	private final String addPeriodId = "SiteMaster_MainContent_lbAddPeriod";
	private final String deletePeriodId = "SiteMaster_MainContent_lbDeletePeriod2";
	private final String promotionStartDateId2 = "SiteMaster_MainContent_dtStart2_dcDate_textBoxDate";
	private final String promotionEndDateId2 = "SiteMaster_MainContent_dtEnd2_dcDate_textBoxDate";
	private final String startDateTimeId2 = "SiteMaster_MainContent_dtStart2_tc2Time_tbTime";
	private final String endDateTimeId2 = "SiteMaster_MainContent_dtEnd2_tc2Time_tbTime";
	private final String multiplePeriodXpath = "//*[@id=\"SiteMaster_MainContent_cbGenerateRanges\"]/../label/span";
	private final String multiplePeriodFridayXpath = "(//*[@id=\"SiteMaster_MainContent_cblDaysOfWeek_2\"]/../label/span)[5]";
	private final String createButton = "SiteMaster_MainContent_lbCreate";
	private final String deleteButton2 = "SiteMaster_MainContent_lbDeletePeriod2";
	private final String deleteButton3 = "SiteMaster_MainContent_lbDeletePeriod3";
	private final String deleteButton4 = "SiteMaster_MainContent_lbDeletePeriod4";
	private final String noKioskWarning = "SiteMaster_flashMessage_warningContainer";
	private final String errorInvalidImageContainerXpath = "(//*[@id=\"SiteMaster_MainContent_fuAsset\"]/../span)[1]";
	private final String postToCalendarText = "SiteMaster_MainContent_tbCalendarDescription";
	private final String dontShowPromotion = "//*[@id=\"SiteMaster_MainContent_cbDontShowPromoOutsideDailyTimeRange\"]/../label/span";
	private final String oneKiosk = "//*[@for=\"SiteMaster_MainContent_cblKiosks_9\"]/span";
	private final String endDateTimeIdPeriod = "//*[@id=\"SiteMaster_MainContent_dtEnd2_tc2Time_tbTime\"]";

	public void enterPromotionName() throws AutomationException, IOException {
		sendKeys(getwebElement(promotionNameId, LocatorType.ID, 10), GlobalVariables.testDataMap.get("PromotionName"));
		logger.info("Promotion name send to promotion name text box");
	}

	public void enterPromotionNamePromo() throws AutomationException, IOException {
		sendKeys(getwebElement(promotionNameId, LocatorType.ID, 10), GlobalVariables.testDataMap.get("PromotionNamePromo"));
		logger.info("Promotion name send to promotion name text box");
	}
	
	public void enterDescription() throws AutomationException, IOException {
		sendKeys(getwebElement(descriptionId, LocatorType.ID, 10),
				GlobalVariables.testDataMap.get("PromotionDescription"));
		logger.info("Promotion Description send to Promotion Description text box");
	}

	public void enterPriority() throws AutomationException, IOException {
		sendKeys(getwebElement(priority, LocatorType.ID, 10), GlobalVariables.testDataMap.get("Priority"));
		logger.info("Priority send to Priority text box");
	}

	public void isInactiveSelected() throws AutomationException, IOException {
		WebElement inactiveSelectedCheck = getwebElement(inactiveCheckboxXpath, LocatorType.XPATH, 10);
		waitUntilElementVisible(inactiveSelectedCheck, 10);
		clickNoWait(inactiveSelectedCheck, 10);
		System.out.println(inactiveSelectedCheck.isSelected());
		if (!(inactiveSelectedCheck.isSelected())) {
			clickNoWait(inactiveSelectedCheck, 10);
			logger.info("Click action performed on inactive checkbox");
		}
	}

	public void isarchiveSelected() throws AutomationException, IOException {
		WebElement inarchiveSelectedCheck = getwebElement(archiveCheckboxXpath, LocatorType.XPATH, 10);
		waitUntilElementVisible(inarchiveSelectedCheck, 10);
		clickNoWait(inarchiveSelectedCheck, 10);
		System.out.println(inarchiveSelectedCheck.isSelected());
		if (!(inarchiveSelectedCheck.isSelected())) {
			clickNoWait(inarchiveSelectedCheck, 10);
			logger.info("Click action performed on archive checkbox");
		}
	}

	public void ispostToCalendarSelected() throws AutomationException, IOException {
		WebElement postToCalendarSelectedCheck = getwebElement(postToCalendarCheckboxXpath, LocatorType.XPATH, 10);
		waitUntilElementVisible(postToCalendarSelectedCheck, 10);
		clickNoWait(postToCalendarSelectedCheck, 10);
		System.out.println(postToCalendarSelectedCheck.isSelected());
		if (!(postToCalendarSelectedCheck.isSelected())) {
			clickNoWait(postToCalendarSelectedCheck, 10);
			logger.info("Click action performed on Post To Calendar checkbox");
		}
	}

	public void postToCalendarSelected() throws AutomationException, IOException {
		clickNoWait(getwebElement(postToCalendarCheckboxXpath, LocatorType.XPATH, 10), 10);
		System.out.println(postToCalendarCheckboxXpath);

	}

	public void postToCalendarText() throws AutomationException, IOException {
		clickNoWait(getwebElement(postToCalendarText, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Post to Calendar");
		String calendarDescription = GlobalVariables.testDataMap.get("calendarDescription");
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript(
				"arguments[0].value='" + calendarDescription + "'",
				getwebElement(postToCalendarText, LocatorType.ID, 10));
		logger.info("Calendar Description sent to Calendar Description text box");
	}

	public void enterStartDataAndTime() throws AutomationException, IOException {
		sendKeys(getwebElement(promotionStartDateId, LocatorType.ID, 10),
				GlobalVariables.testDataMap.get("PromotionStartDate"));
		String startTime = GlobalVariables.testDataMap.get("StartTime");
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + startTime + "'",
				getwebElement(startDateTimeId, LocatorType.ID, 10));
		logger.info("Start date and time send to start date calendar text box");
	}

	public void enterEndDataAndTime() throws AutomationException, IOException {
		clickNoWait(getwebElement(promotionEndDateId, LocatorType.ID, 10), 10);
		sendKeysAndEnter(getwebElement(promotionEndDateId, LocatorType.ID, 10),
				GlobalVariables.testDataMap.get("PromotionEndDate"));
		String endTime = GlobalVariables.testDataMap.get("EndTime");
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + endTime + "'",
				getwebElement(endDateTimeId, LocatorType.ID, 10));
		logger.info("End date and time send to end date calendar text box");
	}

	public void clickAddPeriod() throws AutomationException {
		clickNoWait(getwebElement(addPeriodId, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Add period button");
	}

	public void enterStartDataAndTime2() throws AutomationException, IOException {
		sendKeys(getwebElement(promotionStartDateId2, LocatorType.ID, 10),
				GlobalVariables.testDataMap.get("PromotionStartDate"));
		String startTime = GlobalVariables.testDataMap.get("StartTime");
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + startTime + "'",
				getwebElement(startDateTimeId2, LocatorType.ID, 10));
		logger.info("Start date 2 and time send to start date 2 calendar text box");
	}

	public void enterEndDataAndTime2() throws AutomationException, IOException {
		clickNoWait(getwebElement(promotionEndDateId2, LocatorType.ID, 10), 10);
		sendKeysAndEnter(getwebElement(promotionEndDateId2, LocatorType.ID, 10),
				GlobalVariables.testDataMap.get("PromotionEndDate"));
		String endTime = GlobalVariables.testDataMap.get("EndTime");
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + endTime + "'",
				getwebElement(endDateTimeId2, LocatorType.ID, 10));
		logger.info("End date 2 and time send to end date 2 calendar text box");
	}

	public void deleteAddPeriod() throws AutomationException {
		clickNoWait(getwebElement(deletePeriodId, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Delete Add period button");
	}

	public void enterDailyTime() throws AutomationException, IOException {
		// sendKeys(getwebElement(startTimeDailyId, LocatorType.ID, 10),
		// GlobalVariables.testDataMap.get("StartTimeDaily"));
		String startTimeDaily = GlobalVariables.testDataMap.get("StartTimeDaily");
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + startTimeDaily + "'",
				getwebElement(startTimeDailyId, LocatorType.ID, 10));
		// sendKeys(getwebElement(endTimeDailyId, LocatorType.ID, 10),
		// GlobalVariables.testDataMap.get("EndTimeDaily"));
		String endTimeDaily = GlobalVariables.testDataMap.get("EndTimeDaily");
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + endTimeDaily + "'",
				getwebElement(endTimeDailyId, LocatorType.ID, 10));
		logger.info("Daily start and end time send to daily time text box");
	}

	public void isAllKiosksSelected() throws AutomationException, IOException {
		WebElement allKiosksSelectedCheck = getwebElement(selectAllKiosksCheckboxXpath, LocatorType.XPATH, 20);
		waitUntilElementVisible(allKiosksSelectedCheck, 10);
		System.out.println(allKiosksSelectedCheck.isSelected());
		if (!(allKiosksSelectedCheck.isSelected())) {
			clickNoWait(allKiosksSelectedCheck, 30);
			logger.info("Click action performed on unselected all kiosks selection checkbox");
		}
	}

	public void isOneKiosksSelected() throws AutomationException, IOException {
		clickNoWait(getwebElement(selectAllKiosksCheckboxXpath, LocatorType.XPATH, 10), 10);
		clickNoWait(getwebElement(oneKiosk, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on one kiosk selection checkbox");
	}

	public void uploadPromotionListImage() throws AutomationException, IOException {
		sendKeys(getwebElement(promotionThumbnailUploadId, LocatorType.ID, 10),
				System.getProperty("user.dir") + "/src/main/resources/Images/AutomationTesting_PNG_500kB.png");
		logger.info("Upload of promotion image is completed");
	}

	public void clickCreatebtn() throws AutomationException {
		clickNoWait(getwebElement(createBtnId, LocatorType.ID, 10), 10);
		logger.info("Click action performed on create button");
	}

	public void clickEnrollmentTab() throws AutomationException {
		clickNoWait(getwebElement(enrollmentTabXpath, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on enrollment tab");
	}

	public boolean isErrorPresent() {
		if (GlobalVariables.webDriver.findElements(By.id(errorContainerId)).size() > 0)
			return true; // element is present so error exist
		else
			return false; // element not present and no error
	}
	
	public boolean isItemSavedSuccessfully() {
		return getwebElement(successContainerId, LocatorType.ID, 10).isDisplayed();
	}

	public boolean isInvalidTimeErrorPresent() {
		JavascriptExecutor js = (JavascriptExecutor) GlobalVariables.webDriver;
		js.executeScript("window.scrollTo(0,900)");
		return getwebElement(errorInvalidDateContainerXpath, LocatorType.XPATH, 10).isDisplayed();
	}

	public void clickCreateMultiplePeriods() throws AutomationException, IOException {
		clickNoWait(getwebElement(multiplePeriodXpath, LocatorType.XPATH, 10), 30);
		logger.info("Click action performed on Create Multiple Period checkbox");
	}

	public void clickCreateMultiplePeriodFriday() throws AutomationException, IOException {
		clickNoWait(getwebElement(multiplePeriodFridayXpath, LocatorType.XPATH, 10), 30);
		logger.info("Click action performed on Create Multiple Period Friday checkbox");
	}

	public void clickCreateButton() throws AutomationException, IOException {
		clickNoWait(getwebElement(createButton, LocatorType.ID, 10), 50);
		logger.info("Click action performed on Create button");
	}

	public void clickDeleteButton2() throws AutomationException, IOException {
		clickNoWait(getwebElement(deleteButton2, LocatorType.ID, 10), 50);
		logger.info("Click action performed on Delete 2 button");
	}

	public void clickDeleteButton3() throws AutomationException, IOException {
		clickNoWait(getwebElement(deleteButton3, LocatorType.ID, 10), 50);
		logger.info("Click action performed on Delete 3 button");
	}

	public void clickDeleteButton4() throws AutomationException, IOException {
		clickNoWait(getwebElement(deleteButton4, LocatorType.ID, 10), 50);
		logger.info("Click action performed on Delete 4 button");
	}

	public boolean isNoKioskWarningDisplayed() {
		return getwebElement(noKioskWarning, LocatorType.ID, 10).isDisplayed();
	}

	public void uploadInvalidPromotionListImage() throws AutomationException, IOException {
		sendKeys(getwebElement(promotionThumbnailUploadId, LocatorType.ID, 10),
				System.getProperty("user.dir") + "/src/main/resources/Images/AutoTest_JPG.jpg");
		logger.info("Upload of invalid promotion image is completed");
	}

	public boolean isInvalidImageErrorPresent() {
		JavascriptExecutor js = (JavascriptExecutor) GlobalVariables.webDriver;
		js.executeScript("window.scrollTo(0,2000)");
		return getwebElement(errorInvalidImageContainerXpath, LocatorType.XPATH, 10).isDisplayed();
	}

	public void clickDontShowPromotion() throws AutomationException, IOException {
		clickNoWait(getwebElement(dontShowPromotion, LocatorType.XPATH, 10), 20);
		logger.info("Click action performed on Dont Show Promotion Tile checkbox");
	}
	
	public void enterStartDataAndTimePeriod() throws AutomationException, IOException {
		sendKeys(getwebElement(promotionStartDateId2, LocatorType.ID, 10),
				GlobalVariables.testDataMap.get("PromotionStartDate"));
		String startTime = GlobalVariables.testDataMap.get("StartTimeAddPeriod");
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + startTime + "'",
				getwebElement(startDateTimeId2, LocatorType.ID, 10));
		logger.info("Start date 2 and time send to start date 2 calendar text box");
	}

	public void enterEndDataAndTimePeriod() throws AutomationException, IOException {
		clickNoWait(getwebElement(promotionEndDateId2, LocatorType.ID, 10), 10);
		sendKeysAndEnter(getwebElement(promotionEndDateId2, LocatorType.ID, 10),
				GlobalVariables.testDataMap.get("PromotionEndDate"));
		String endTime = GlobalVariables.testDataMap.get("EndTimeAddPeriod");
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + endTime + "'",
				getwebElement(endDateTimeIdPeriod, LocatorType.XPATH, 10));
		logger.info("End date 2 and time send to end date 2 calendar text box");
	}
}
