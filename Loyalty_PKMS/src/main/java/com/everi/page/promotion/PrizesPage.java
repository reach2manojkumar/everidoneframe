package com.everi.page.promotion;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.everi.Enum.LocatorType;
import com.everi.Helper.GlobalVariables;
import com.everi.driver.Driver;
import com.everi.exception.AutomationException;
import com.everi.page.BasePage;

import io.cucumber.java.tlh.ach;

public class PrizesPage extends BasePage {

	static Logger logger = LogManager.getLogger(PrizesPage.class);
	WebDriver webDriver = GlobalVariables.webDriver;
	JavascriptExecutor js = (JavascriptExecutor) GlobalVariables.webDriver;
	Actions a = new Actions(webDriver);

	private final String createNewPrizeId = "SiteMaster_MainContent_lbCreateNew";
	private final String prizeName = "//*[@id=\"SiteMaster_MainContent_tbName\"]";
	private final String prizeIdentifierId = "SiteMaster_MainContent_tbIdentityName";
	private final String quantityId = "SiteMaster_MainContent_tbQuantity";
	private final String enforceQuantityXpath = "//label[@for='SiteMaster_MainContent_cbEnforceQuantity']";
	private final String prizeTypeSelectorXpath = "//div[@id='s2id_SiteMaster_MainContent_ddlPrizeType']/a/span[2]";
	private final String prizeTypeTexXpath = "//div[@id='select2-drop']/div/input";
	private final String prizeValueIdPrizeChoice = "SiteMaster_MainContent_ctl21_tbValuePc";
	private final String prizeRedemptionId = "SiteMaster_MainContent_ctl21_tbRedemptionCode";
	private final String saveBtnId = "//*[@id=\"SiteMaster_MainContent_lbSubmit\"]";
	private final String uploadText = "SiteMaster_MainContent_divUploadAsset";
	private final String prizeThumbnailUploadId = "SiteMaster_MainContent_fuAsset";
	private final String prizeLine1 = "SiteMaster_MainContent_tbPrizeLine1";
	private final String prizeLine2 = "SiteMaster_MainContent_tbPrizeLine2";
	private final String printReceipt = "//*[@id=\"SiteMaster_MainContent_cbPrintReceipt\"]/../label/span";
	private final String receiptMsg = "SiteMaster_MainContent_tbReciept";
	private final String screenMsg = "SiteMaster_MainContent_tbScreenMessage1";
	private final String prizeDropDown = "SiteMaster_MainContent_TBDForm_ddlPrize";
	private final String prizeStartDate = "SiteMaster_MainContent_TBDForm_dtFrom_dcDate_textBoxDate";
	private final String prizeStartTime = "SiteMaster_MainContent_TBDForm_dtFrom_tc2Time_tbTime";
	private final String prizeEndDate = "SiteMaster_MainContent_TBDForm_dtTo_dcDate_textBoxDate";
	private final String prizeEndTime = "(//*[@id=\"SiteMaster_MainContent_TBDForm_dtTo_tc2Time_tbTime\"])[1]";
	private final String startPrizeTimeDaily = "SiteMaster_MainContent_TBDForm_tcStartTime_tbTime";
	private final String endPrizeTimeDaily = "//*[@id=\"SiteMaster_MainContent_TBDForm_tcEndTime_tbTime\"]";
	private final String stopPrizeDate = "SiteMaster_MainContent_TBDForm_dtStopDistributionAfter_dcDate_textBoxDate";
	private final String stopPrizeTime = "SiteMaster_MainContent_TBDForm_dtStopDistributionAfter_tc2Time_tbTime";
	private final String addDisbursement = "SiteMaster_MainContent_TBDForm_lbGeneratePrizes";
	private final String uploadPrize = "SiteMaster_MainContent_lbUploadPrizes";
	private final String choosePrize = "ctl00_MainContent_fuPrizes";
	private final String uploadButton = "ctl00_MainContent_lbUpload";
	private final String maxTime = "//*[@id=\"SiteMaster_MainContent_ctl21_MaxTimeToClaimPrize_rbMaxTimeToClaimWithinHours\"]/../label/span[1]";
	private final String maxTimeHours = "SiteMaster_MainContent_ctl21_MaxTimeToClaimPrize_tbMaxTimeToClaimWithinHours";
	private final String addDisText = "//*[contains(text(),\"Add Time Based Prize Disbursement\")]";
	private final String queryOnWin = "SiteMaster_MainContent_ctl21_tbQuery";
	private final String addSubPrize = "(//*[@id=\"addBtn\"]/a/i)[1]";
	private final String prizeNameSubPrize = "(//*[contains(text(),\"Prize Name\")])[3]/../td/div/input";
	private final String prizeScreenMsgSubPrize = "(//*[contains(text(),\"Screen Message 1\")])[2]/../td/div/table/tbody/tr/td/input";
	private final String printReceiptSubPrize = "(//*[contains(text(),\"Print Receipt\")])[2]/span[1]";
	private final String receiptMsgSubPrize = "(//*[contains(text(),\"Receipt Message\")])[2]/../td/div/input";
	private final String prizeTypeSelectorXpathSubPrize = "(//*[@class=\"select2-choice\"])[2]/span[@class=\"select2-arrow\"]";
	private final String prizeTypeTexXpathSubPrize = "(//*[@class=\"select2-search\"])[2]/input";
	private final String prizeValueSubPrize = "(//*[contains(text(),\"Value of Prize\")])[2]/../td/div/input";
	private final String prizeRedeemSubPrize = "(//*[contains(text(),\"Redemption Code\")]/../following::input)[1]";
	private final String prizeNameSubPrize2 = "(//*[contains(text(),\"Prize Name\")])[4]/../td/div/input";
	private final String prizeScreenMsgSubPrize2 = "(//*[contains(text(),\"Screen Message 1\")])[3]/../td/div/table/tbody/tr/td/input";
	private final String printReceiptSubPrize2 = "(//*[contains(text(),\"Print Receipt\")])[3]/span[1]";
	private final String receiptMsgSubPrize2 = "(//*[contains(text(),\"Receipt Message\")])[3]/../td/div/input";
	private final String prizeTypeSelectorXpathSubPrize2 = "(//*[@class=\"select2-choice\"])[3]/span[@class=\"select2-arrow\"]";
	private final String prizeTypeTexXpathSubPrize2 = "((//*[@class=\"select2-search\"])/input)[3]";
	private final String prizeValueSubPrize2 = "(//*[contains(text(),\"Value of Prize\")])[3]/../td/div/input";
	private final String prizeRedeemSubPrize2 = "((//*[contains(text(),\"Redemption Code\")]/../following::li)[3]/input)[1]";
	private final String prizeValueId = "SiteMaster_MainContent_ctl21_tbValue";
	private final String expiresIn = "SiteMaster_MainContent_ctl21_tbExpiresInDays";
	private final String costValue = "SiteMaster_MainContent_ctl21_tbCost";
	private final String prizeValueIdPrizePackage = "SiteMaster_MainContent_ctl21_tbValuePp";
	private final String addButton = "SiteMaster_MainContent_ctl21_btnAdd";
	private final String prizePackageName = "ctl00_MainContent_tbNamePp";
	private final String printReceiptPrizePackage = "//*[@id=\"ctl00_MainContent_cbPrintReceiptPp\"]/../label/span[1]";
	private final String receiptMsgPrizePackage = "ctl00_MainContent_tbRecieptPp";
	private final String prizeTypeSelectorXpathPrizePackage = "//*[@id=\"s2id_ctl00_MainContent_ddlPrizeType\"]/a/span[@class=\"select2-arrow\"]";
	private final String prizeTypeTexXpathPrizePackage = "(//*[@id=\"s2id_autogen32_search\"])[1]";
	private final String prizeValuePrizePackageWindow = "ctl00_MainContent_ctl06_tbValue";
	private final String prizeRedemWindow = "ctl00_MainContent_ctl06_tbRedemptionCode";
	private final String addButtonWindow = "ctl00_MainContent_lbSubmit";
//	private final String prizeTypeTexXpathPrizePackage2 = "//*[@id=\"popup_content\"]/../following-sibling::div//input";
	private final String prizeTypeTexXpathPrizePackage2 = "//*[@id=\"select2-drop\"]/div/input";
	private final String drawingEntry = "SiteMaster_MainContent_ctl21_ddlDrawing";
	private final String noOfEntries = "SiteMaster_MainContent_ctl21_tbNumOfEntries";
	private final String periodDuringSwipe = "//*[@for=\"SiteMaster_MainContent_ctl21_rbPeriod\"]/span";
	private final String multiplier = "SiteMaster_MainContent_ctl21_tbMultiplier";
	private final String pointLimit = "SiteMaster_MainContent_ctl21_tbPointLimit";
	private final String applyTo = "SiteMaster_MainContent_ctl21_ddlApplyTo";
	private final String machineGroup = "SiteMaster_MainContent_ctl21_ddlMachineGroup";
	private final String multiplyPointsQueue = "//*[@for=\"SiteMaster_MainContent_ctl21_rbQueue\"]/span";
	private final String multiplyPointsQueueHours = "SiteMaster_MainContent_ctl21_tbQueueHours";
	private final String useQualifications = "//*[@for=\"SiteMaster_MainContent_PrizeQualificationForm_cbUseQualifications\"]/span";
	private final String startDateUseQualification = "SiteMaster_MainContent_PrizeQualificationForm_tcStartTime_dcDate_textBoxDate";
	private final String endDateUseQualification = "SiteMaster_MainContent_PrizeQualificationForm_tcEndTime_dcDate_textBoxDate";
	private final String startTimeUseQualification = "(//*[@id=\"SiteMaster_MainContent_PrizeQualificationForm_tcStartTime_tc2Time_tbTime\"])[1]";
	private final String endTimeUseQualification = "(//*[@id=\"SiteMaster_MainContent_PrizeQualificationForm_tcEndTime_tc2Time_tbTime\"])[1]";
	private final String limitPerCust = "SiteMaster_MainContent_PrizeQualificationForm_tbLimitPerCustomer";
	private final String limitPerTime = "SiteMaster_MainContent_PrizeQualificationForm_ddlPartCondition";
	private final String limitValue = "SiteMaster_MainContent_PrizeQualificationForm_tbPartConditionEvery2";
	private final String selectPromo = "SiteMaster_MainContent_ctl21_ddlPromotion";
	private final String startDateText = "//*[contains(text(),\"Start Time\")]";
	private final String prizeValueSubPrizeMultiple = "((//*[contains(text(),\"Value of Prize\")])[2]/../td/div/input)[1]";
	private final String addSubPrizeMultiple = "//*[@id=\"addBtnLevel1\"]/a/i";
	private final String prizeRedeemSubPrizeMultiple = "(//*[contains(text(),\"Redemption Code\")]/../following::div[1]/ul/li[1]/input[1])";
	private final String prizeNameSubPrizeMultiple2 = "(//*[contains(text(),\"Prize Name\")])[5]/../td/div/input";
	private final String prizeScreenMsgSubPrizeMultiple2 = "(//*[contains(text(),\"Screen Message 1\")])[4]/../td/div/table/tbody/tr/td/input";
	private final String prizeTypeSelectorXpathSubPrizeMultiple2 = "(//*[@class=\"select2-choice\"])[4]/span[@class=\"select2-arrow\"]";
	private final String prizeTypeTexXpathSubPrizeMultiple2 = "(//*[@class=\"select2-search\"])[6]/input";
	private final String prizeValueSubPrizeMultiple2 = "(//*[contains(text(),\"Value of Prize\")])[4]/../td/div/input";
	private final String prizeRedeemSubPrizeMultiple2 = "(//*[contains(text(),\"Redemption Code\")]/../following::div[1]/ul/li[1]/input[1])[2]";
	private final String prizeNameSubPrizeMultiple = "(//*[contains(text(),\"Prize Name\")])[6]/../td/div/input";
	private final String prizeScreenMsgSubPrizeMultiple = "(//*[contains(text(),\"Screen Message 1\")])[5]/../td/div/table/tbody/tr/td/input";
	private final String prizeTypeSelectorXpathSubPrize2Multiple = "(//*[@class=\"select2-choice\"])[5]/span[@class=\"select2-arrow\"]";
	private final String prizeValueSubPrize2Multiple = "(//*[contains(text(),\"Value of Prize\")])[5]/../td/div/input";
	private final String prizeRedeemSubPrize2Multiple = "((//*[contains(text(),\"Redemption Code\")]/../following::div[1]/ul/li)/input[1])[3]";
	private final String prizeTypeTexXpathSubPrize2Multiple = "(//*[@class=\"select2-search\"])[4]/input";
	private final String prizeTypeTexXpathSubPrize2Multiple2 = "((//*[@class=\"select2-search\"])/input)[5]";
	private final String prizeRedeemSubPrize2Multiple2 = "((//*[contains(text(),\"Redemption Code\")]/../following::div[1]/ul/li)/input[1])[5]";
	private final String groupCheckbox = "(//*[@id=\"SiteMaster_MainContent_divGroups\"]/span/label/span)[1]";
	private final String groupCheckbox1 = "//*[@id=\"SiteMaster_MainContent_promotionGroup_cblGroups_1\"]/following::label[1]/span[1]";
	private final String savePrize = "SiteMaster_MainContent_lbSave";
	private final String uploadErrorMsg = "//*[@id=\"ctl00_MainContent_fuPrizes\"]/../div/span";
	private final String cancelPrize = "cancel";
	private final String addButtonAgain = "//*[contains(text(),'Create all')]/../following::div/div/div[@class='rightButton']";
	private final String createdPrize = "//*[@id=\"SiteMaster_MainContent_gvPrizes\"]/tbody/tr/td/h4";
	private final String editReceipt = "(//*[contains(text(),\"Edit Receipt\")])[3]";
	private final String participationDate = "(//*[contains(text(),\"ParticipationDate\")])[1]";
	private final String editPrize = "(//*[contains(text(),\"Edit Prize\")])[3]";
	private final String disabledButton = "(//*[@id=\"ctl00_MainContent_cbDisabledPp\"])[1]/../label/span";
	private final String update = "//*[@id=\"ctl00_MainContent_lbSubmit\"]/span";
	private final String errorContainerId = "SiteMaster_flashMessage_errorContainer";
	private final String filter = "//*[@id=\"select2-SiteMaster_MainContent_ddlGroup-container\"]";
	private final String filterText = "//*[@class=\"select2-search select2-search--dropdown\"]";
	private final String prizeText = "(//*[contains(text(),\"Thumbnail\")]/../following::tr)[1]";
	private final String groupDrop = "//*[contains(text(),\"Group:\")]/span";
	
	public void clickCreateNewPrize() throws AutomationException, IOException {
		clickNoWait(getwebElement(createNewPrizeId, LocatorType.ID, 10), 10);
		logger.info("Click action performed on create new prize");
	}

	public void enterPrizeName() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeName, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Prize name text box");
		sendKeys(getwebElement(prizeName, LocatorType.XPATH, 10), GlobalVariables.testDataMap.get("PrizeName"));
		logger.info("Prize name sent to prize name text box");
	}

	public void enterPrizeLine1() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeLine1, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Prize line 1");
		String prizeLineText1 = GlobalVariables.testDataMap.get("PrizeLine1");
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + prizeLineText1 + "'",
				getwebElement(prizeLine1, LocatorType.ID, 10));
		logger.info("Prize line 1 sent to prize line1 text box");

	}

	public void enterPrizeLine2() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeLine2, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Prize line 2");
		String prizeLineText2 = GlobalVariables.testDataMap.get("PrizeLine2");
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + prizeLineText2 + "'",
				getwebElement(prizeLine2, LocatorType.ID, 10));
		logger.info("Prize line 2 sent to prize line2 text box");
	}

	public void enterPrizeIdentifier() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeIdentifierId, LocatorType.ID, 10), 10);
		sendKeys(getwebElement(prizeIdentifierId, LocatorType.ID, 10),
				GlobalVariables.testDataMap.get("PrizeIdentifier"));
		logger.info("Prize identifier sent to prize identifier text box");
	}

	public void enterQuantity() throws AutomationException, IOException {
		clickNoWait(getwebElement(quantityId, LocatorType.ID, 10), 10);
		sendKeys(getwebElement(quantityId, LocatorType.ID, 10), GlobalVariables.testDataMap.get("PrizeQuantity"));
		logger.info("Prize quantity sent to quantity text box");
	}

	public void clickEnforceQuantity() throws AutomationException, IOException {
		clickNoWait(getwebElement(enforceQuantityXpath, LocatorType.XPATH, 10), 20);
		logger.info("Click action performed on enforce quantity check box");
	}

	public void clickPrintReceipt() throws AutomationException, IOException {
		clickNoWait(getwebElement(printReceipt, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Print Receipt");
	}

	public void enterReceiptMessage() throws AutomationException, IOException {
		clickNoWait(getwebElement(receiptMsg, LocatorType.ID, 10), 10);
		sendKeys(getwebElement(receiptMsg, LocatorType.ID, 10), GlobalVariables.testDataMap.get("ReceiptMessage"));
		logger.info("Receipt Message sent to Receipt Message text box");
	}

	public void enterScreenMessage() throws AutomationException, IOException {
		clickNoWait(getwebElement(screenMsg, LocatorType.ID, 10), 10);
		sendKeys(getwebElement(screenMsg, LocatorType.ID, 10), GlobalVariables.testDataMap.get("ScreenMessage"));
		logger.info("Screen Message sent to Screen Message text box");
	}

	public void choosePrizeType() throws AutomationException, IOException {
		js.executeScript("window.scrollTo(0,900)");
		clickNoWait(getwebElement(prizeTypeSelectorXpath, LocatorType.XPATH, 10), 20);
		clickNoWait(getwebElement(prizeTypeTexXpath, LocatorType.XPATH, 10), 20);
		sendKeysAndEnter(getwebElement(prizeTypeTexXpath, LocatorType.XPATH, 20),
				GlobalVariables.testDataMap.get("PrizeType"));
		logger.info("Prize type is choosen from prize type");
	}

	public void choosePrizeTypePromo() throws AutomationException, IOException {
		js.executeScript("window.scrollTo(0,900)");
		clickNoWait(getwebElement(prizeTypeSelectorXpath, LocatorType.XPATH, 10), 20);
		clickNoWait(getwebElement(prizeTypeTexXpath, LocatorType.XPATH, 10), 20);
		sendKeysAndEnter(getwebElement(prizeTypeTexXpath, LocatorType.XPATH, 20),
				GlobalVariables.testDataMap.get("PrizeTypePromo"));
		logger.info("Prize type is choosen from prize type");
	}
	
	public void enterPrizeValue() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeValueId, LocatorType.ID, 10), 10);
		sendKeys(getwebElement(prizeValueId, LocatorType.ID, 10), GlobalVariables.testDataMap.get("PrizeValue"));
		logger.info("Prize value sent to value text box");
	}

	public void enterPrizeValuePrizeChoice() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeValueIdPrizeChoice, LocatorType.ID, 10), 10);
		sendKeys(getwebElement(prizeValueIdPrizeChoice, LocatorType.ID, 10),
				GlobalVariables.testDataMap.get("PrizeValue"));
		logger.info("Prize value sent to value text box");
	}

	public void enterPrizeValuePrizePackage() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeValueIdPrizePackage, LocatorType.ID, 10), 10);
		sendKeys(getwebElement(prizeValueIdPrizePackage, LocatorType.ID, 10),
				GlobalVariables.testDataMap.get("PrizeValue"));
		logger.info("Prize value sent to value text box");
	}

	public void enterRedemptionCode() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeRedemptionId, LocatorType.ID, 10), 10);
		sendKeys(getwebElement(prizeRedemptionId, LocatorType.ID, 10),
				GlobalVariables.testDataMap.get("RedemptionCodeOnWin"));
		logger.info("Redemption code sent to redemption code text box");
	}

	public void maxTimeToClaim() throws AutomationException, IOException {
		clickNoWait(getwebElement(maxTime, LocatorType.XPATH, 10), 10);
		sendKeys(getwebElement(maxTimeHours, LocatorType.ID, 10), "5");
		clickNoWait(getwebElement(queryOnWin, LocatorType.ID, 10), 10);
		logger.info("Max Time to Claim Prize within hours");
	}

	public void uploadPrizeScreen() throws AutomationException, IOException {
		js.executeScript("window.scrollTo(0,5000)");
		logger.info("Scrolled to Upload of prize image is completed");
		clickNoWait(getwebElement(uploadText, LocatorType.ID, 10), 10);
		logger.info("Click action performed on upload text");
		sendKeys(getwebElement(prizeThumbnailUploadId, LocatorType.ID, 20),
				System.getProperty("user.dir") + "/src/main/resources/Images/prize.jpg");
		logger.info("Upload of prize image is completed");
	}

	public void uploadPrizeScreenPrizePackage() throws AutomationException, IOException {
//		js.executeScript("window.scrollTo(0,5000)");
//		js.executeScript("arguments[0].scrollIntoView(true);",saveBtnId);
		WebElement save = webDriver.findElement(By.xpath("(//*[@id=\"SiteMaster_MainContent_lbSubmit\"])[1]"));
		a.moveToElement(save).perform();

		logger.info("Scrolled to Upload of prize image is completed");
		clickNoWait(getwebElement(uploadText, LocatorType.ID, 10), 10);
		logger.info("Click action performed on upload text");
		sendKeys(getwebElement(prizeThumbnailUploadId, LocatorType.ID, 20),
				System.getProperty("user.dir") + "/src/main/resources/Images/prize.jpg");
		logger.info("Upload of prize image is completed");
	}

	public void clickSaveButton() throws AutomationException, IOException {
		clickNoWait(getwebElement(saveBtnId, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on create button");
	}

	public void clickSavePrize() throws AutomationException, IOException {
		clickNoWait(getwebElement(savePrize, LocatorType.ID, 10), 10);
		logger.info("Click action performed on create button");
	}

	public void clickPrizeDropDown() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeDropDown, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Prize DropDown in Add Time Based section");
		WebElement prizeDropDownType = GlobalVariables.webDriver
				.findElement(By.id("SiteMaster_MainContent_TBDForm_ddlPrize"));
		Select s = new Select(prizeDropDownType);
		s.selectByIndex(1);
		logger.info(s + "is the value chosen for Prize to be disbursed");

	}

	public void enterPrizeStartDateAndTime() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeStartDate, LocatorType.ID, 10), 10);
		sendKeys(getwebElement(prizeStartDate, LocatorType.ID, 10),
				GlobalVariables.testDataMap.get("TimeBasedPrizeStartDate"));
		String startTime = GlobalVariables.testDataMap.get("TimeBasedPrizeStartTime");
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + startTime + "'",
				getwebElement(prizeStartTime, LocatorType.ID, 10));
		logger.info("Start date and time send to start date calendar text box");

	}

	public void enterPrizeEndDateAndTime() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeEndDate, LocatorType.ID, 10), 10);
		sendKeys(getwebElement(prizeEndDate, LocatorType.ID, 10),
				GlobalVariables.testDataMap.get("TimeBasedPrizeEndDate"));
		String endTime = GlobalVariables.testDataMap.get("TimeBasedPrizeEndTime");
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + endTime + "'",
				getwebElement(prizeEndTime, LocatorType.XPATH, 10));
		logger.info("End date and time sent to end date calendar text box");
	}

	public void enterDailyTime() throws AutomationException, IOException {
		String startTimeDaily = GlobalVariables.testDataMap.get("TimeBasedPrizeStartTimeDaily");
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + startTimeDaily + "'",
				getwebElement(startPrizeTimeDaily, LocatorType.ID, 10));
		String endTimeDaily = GlobalVariables.testDataMap.get("TimeBasedPrizeEndTimeDaily");
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + endTimeDaily + "'",
				getwebElement(endPrizeTimeDaily, LocatorType.XPATH, 10));
		logger.info("Daily start and end time sent to daily time text box");

	}

	public void enterStopPrize() throws AutomationException, IOException {
		clickNoWait(getwebElement(stopPrizeDate, LocatorType.ID, 10), 10);
		sendKeys(getwebElement(stopPrizeDate, LocatorType.ID, 10), GlobalVariables.testDataMap.get("StopPrizeDate"));
		String stopTime = GlobalVariables.testDataMap.get("StopPrizeTime");
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + stopTime + "'",
				getwebElement(stopPrizeTime, LocatorType.ID, 10));
		logger.info("Stop Prize date and time sent to end date calendar text box");
	}

	public void clickAddDisbursement() throws AutomationException, IOException {
		clickNoWait(getwebElement(addDisText, LocatorType.XPATH, 10), 10);
		clickNoWait(getwebElement(addDisbursement, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Add Disbursement");
	}

	public void clickuploadPrize() throws AutomationException, IOException {
		clickNoWait(getwebElement(uploadPrize, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Upload Prize");
	}

	public void navigateToPrizeFrame() throws AutomationException, IOException {
		webDriver.switchTo().frame("popupframe");
		logger.info("Switched to Upload Prize Frame");
	}

	public void clickChooseValidFile() throws AutomationException, IOException {
		sendKeys(getwebElement(choosePrize, LocatorType.ID, 10),
				System.getProperty("user.dir") + "/src/main/resources/Prizes/SampleBulkLoadSheet_PrizeValid.csv");
		logger.info("Upload of valid prize csv is completed");
	}

	public void clickChoosePromoEnrollInValidFile() throws AutomationException, IOException {
		sendKeys(getwebElement(choosePrize, LocatorType.ID, 10), System.getProperty("user.dir")
				+ "/src/main/resources/Prizes/SampleBulkLoadSheet_PrizeNoValuePromoEnrollment.csv");
		logger.info("Upload of invalid prize csv is completed");
	}

	public void clickChoosePromoEnrollNoPromoidFile() throws AutomationException, IOException {
		sendKeys(getwebElement(choosePrize, LocatorType.ID, 10),
				System.getProperty("user.dir") + "/src/main/resources/Prizes/SampleBulkLoadSheet_PrizeNoPromoid.csv");
		logger.info("Upload of invalid prize csv is completed");
	}

	public void clickChoosePromoEnrollInvalidPromoidFile() throws AutomationException, IOException {
		sendKeys(getwebElement(choosePrize, LocatorType.ID, 10), System.getProperty("user.dir")
				+ "/src/main/resources/Prizes/SampleBulkLoadSheet_PrizeInvalidPromoid.csv");
		logger.info("Upload of invalid prize csv is completed");
	}

	public void clickChoosePointAddNoRedeemCode() throws AutomationException, IOException {
		sendKeys(getwebElement(choosePrize, LocatorType.ID, 10), System.getProperty("user.dir")
				+ "/src/main/resources/Prizes/SampleBulkLoadSheet_PrizePointAddNoRedeemCode.csv");
		logger.info("Upload of invalid prize csv is completed");
	}

	public void clickChoosePrizePackage() throws AutomationException, IOException {
		sendKeys(getwebElement(choosePrize, LocatorType.ID, 10), System.getProperty("user.dir")
				+ "/src/main/resources/Prizes/SampleBulkLoadSheet_PrizePackageValid.csv");
		logger.info("Upload of valid prize csv is completed");
	}

	public void clickChooseEnrollmentGroups() throws AutomationException, IOException {
		sendKeys(getwebElement(choosePrize, LocatorType.ID, 10), System.getProperty("user.dir")
				+ "/src/main/resources/Prizes/SampleBulkLoadSheet_PrizeEnrollmentGroupsValid.csv");
		logger.info("Upload of valid prize csv is completed");
	}

	public void clickuploadbutton() throws AutomationException, IOException {
		clickNoWait(getwebElement(uploadButton, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Upload button");
	}

	public void clickAddSubPrize() throws AutomationException, IOException {
		clickNoWait(getwebElement(addSubPrize, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Add Sub Prize button");
	}

	public void clickAddSubPrizeMultiple() throws AutomationException, IOException {
		clickNoWait(getwebElement(addSubPrizeMultiple, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Add Sub Prize down button");
	}

	public void enterPrizeNameSubPrize() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeNameSubPrize, LocatorType.XPATH, 10), 10);
		sendKeys(getwebElement(prizeNameSubPrize, LocatorType.XPATH, 10),
				GlobalVariables.testDataMap.get("SubPrizeName"));
		logger.info("Sub Prize name sent to sub prize name text box");
	}

	public void enterPrizeNameSubPrizeMultiple() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeNameSubPrizeMultiple, LocatorType.XPATH, 10), 10);
		sendKeys(getwebElement(prizeNameSubPrizeMultiple, LocatorType.XPATH, 10),
				GlobalVariables.testDataMap.get("SubPrizeNameMultiple2"));
		logger.info("Sub Prize name sent to sub prize name text box");
	}

	public void enterprizeScreenMsgSubPrize() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeScreenMsgSubPrize, LocatorType.XPATH, 10), 10);
		sendKeys(getwebElement(prizeScreenMsgSubPrize, LocatorType.XPATH, 10),
				GlobalVariables.testDataMap.get("ScreenMessage"));
		logger.info("Screen Message for Sub Prize name sent to text box");
	}

	public void enterprizeScreenMsgSubPrizeMultiple() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeScreenMsgSubPrizeMultiple, LocatorType.XPATH, 10), 10);
		sendKeys(getwebElement(prizeScreenMsgSubPrizeMultiple, LocatorType.XPATH, 10),
				GlobalVariables.testDataMap.get("ScreenMessage"));
		logger.info("Screen Message for Sub Prize name sent to text box");
	}

	public void clickPrintReceiptSubPrize() throws AutomationException, IOException {
		clickNoWait(getwebElement(printReceiptSubPrize, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Print Receipt in SubPrize");
	}

	public void enterReceiptMessageSubPrize() throws AutomationException, IOException {
		clickNoWait(getwebElement(receiptMsgSubPrize, LocatorType.XPATH, 10), 10);
		sendKeys(getwebElement(receiptMsgSubPrize, LocatorType.XPATH, 10),
				GlobalVariables.testDataMap.get("ReceiptMessage"));
		logger.info("Receipt Message sent to Receipt Message Sub Prize text box");
	}

	public void choosePrizeTypeSubPrize() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeTypeSelectorXpathSubPrize, LocatorType.XPATH, 10), 20);
		clickNoWait(getwebElement(prizeTypeTexXpathSubPrize, LocatorType.XPATH, 10), 20);
		sendKeysAndEnter(getwebElement(prizeTypeTexXpathSubPrize, LocatorType.XPATH, 20),
				GlobalVariables.testDataMap.get("SubPrizeType"));
		logger.info("Prize type is choosen from sub prize type dropdown");
	}

	public void choosePrizeTypeSubPrizes() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeTypeSelectorXpathSubPrize, LocatorType.XPATH, 10), 20);
		String prizeTypeTexXpathSubPrizeSel = GlobalVariables.testDataMap.get("SubPrizeTypeMultiple");
		clickNoWait(getwebElement(prizeTypeTexXpathSubPrize, LocatorType.XPATH, 10), 20);
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript(
				"arguments[0].value='" + prizeTypeTexXpathSubPrizeSel + "'",
				getwebElement(prizeTypeTexXpathSubPrize, LocatorType.XPATH, 10));
		logger.info("Prize type is choosen from sub prize type dropdown");
	}

	public void enterPrizeValueSubPrize() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeValueSubPrize, LocatorType.XPATH, 10), 10);
		sendKeys(getwebElement(prizeValueSubPrize, LocatorType.XPATH, 10),
				GlobalVariables.testDataMap.get("PrizeValue"));
		logger.info("Prize value sent to value text box");
	}

	public void enterPrizeValueSubPrizeMultiple() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeValueSubPrizeMultiple, LocatorType.XPATH, 10), 10);
		sendKeys(getwebElement(prizeValueSubPrizeMultiple, LocatorType.XPATH, 10),
				GlobalVariables.testDataMap.get("PrizeValue"));
		logger.info("Prize value sent to value text box for multiple prizes");
	}

	public void enterPrizeRedeemSubPrize() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeRedeemSubPrize, LocatorType.XPATH, 10), 10);
		sendKeys(getwebElement(prizeRedeemSubPrize, LocatorType.XPATH, 10),
				GlobalVariables.testDataMap.get("RedemptionCodeOnWin"));
		logger.info("Redemption code sent to redemption code text box");
	}

	public void enterPrizeNameSubPrize2() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeNameSubPrize2, LocatorType.XPATH, 10), 10);
		sendKeys(getwebElement(prizeNameSubPrize2, LocatorType.XPATH, 10),
				GlobalVariables.testDataMap.get("SubPrizeNameMultiple1"));
		logger.info("Sub Prize name sent to sub prize 2 name text box");
	}

	public void enterPrizeNameSubPrizeMultiple2() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeNameSubPrizeMultiple2, LocatorType.XPATH, 10), 10);
		sendKeys(getwebElement(prizeNameSubPrizeMultiple2, LocatorType.XPATH, 10),
				GlobalVariables.testDataMap.get("SubPrizeNameMultiple"));
		logger.info("Sub Prize name sent to sub prize Multiple name text box");
	}

	public void enterprizeScreenMsgSubPrize2() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeScreenMsgSubPrize2, LocatorType.XPATH, 10), 10);
		sendKeys(getwebElement(prizeScreenMsgSubPrize2, LocatorType.XPATH, 10),
				GlobalVariables.testDataMap.get("ScreenMessage"));
		logger.info("Screen Message for Sub Prize name 2 sent to text box");
	}

	public void enterprizeScreenMsgSubPrizeMultiple2() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeScreenMsgSubPrizeMultiple2, LocatorType.XPATH, 10), 10);
		sendKeys(getwebElement(prizeScreenMsgSubPrizeMultiple2, LocatorType.XPATH, 10),
				GlobalVariables.testDataMap.get("ScreenMessage"));
		logger.info("Screen Message for Sub Prize name multiple sent to text box");
	}

	public void clickPrintReceiptSubPrize2() throws AutomationException, IOException {
		clickNoWait(getwebElement(printReceiptSubPrize2, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Print Receipt 2 in SubPrize");
	}

	public void enterReceiptMessageSubPrize2() throws AutomationException, IOException {
		clickNoWait(getwebElement(receiptMsgSubPrize2, LocatorType.XPATH, 10), 10);
		sendKeys(getwebElement(receiptMsgSubPrize2, LocatorType.XPATH, 10),
				GlobalVariables.testDataMap.get("ReceiptMessage"));
		logger.info("Receipt Message sent to Receipt Message 2 Sub Prize text box");
	}

	public void choosePrizeTypeSubPrize2() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeTypeSelectorXpathSubPrize2, LocatorType.XPATH, 10), 20);
		clickNoWait(getwebElement(prizeTypeTexXpathSubPrize2, LocatorType.XPATH, 10), 20);
		sendKeysAndEnter(getwebElement(prizeTypeTexXpathSubPrize2, LocatorType.XPATH, 20),
				GlobalVariables.testDataMap.get("SubPrizeType"));
		logger.info("Prize type is choosen from sub prize 2 type dropdown");
	}

	public void choosePrizeTypeSubPrizeMutiple() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeTypeSelectorXpathSubPrize2, LocatorType.XPATH, 10), 20);
		clickNoWait(getwebElement(prizeTypeTexXpathSubPrize2Multiple, LocatorType.XPATH, 10), 20);
		sendKeysAndEnter(getwebElement(prizeTypeTexXpathSubPrize2Multiple, LocatorType.XPATH, 20),
				GlobalVariables.testDataMap.get("SubPrizeTypeMultiple"));
		logger.info("Prize type is choosen from sub prize multiple type dropdown");
	}

	public void choosePrizeTypeSubPrize2Mutiple() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeTypeSelectorXpathSubPrize2Multiple, LocatorType.XPATH, 10), 20);
		clickNoWait(getwebElement(prizeTypeTexXpathSubPrize2Multiple2, LocatorType.XPATH, 10), 20);
		sendKeysAndEnter(getwebElement(prizeTypeTexXpathSubPrize2Multiple2, LocatorType.XPATH, 20),
				GlobalVariables.testDataMap.get("SubPrizeTypeMultiple"));
		logger.info("Prize type is choosen from sub prize multiple type dropdown");
	}

	public void choosePrizeTypeSubPrizeMutiple2() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeTypeSelectorXpathSubPrizeMultiple2, LocatorType.XPATH, 10), 20);
		clickNoWait(getwebElement(prizeTypeTexXpathSubPrizeMultiple2, LocatorType.XPATH, 10), 20);
		sendKeysAndEnter(getwebElement(prizeTypeTexXpathSubPrizeMultiple2, LocatorType.XPATH, 20),
				GlobalVariables.testDataMap.get("SubPrizeTypeMultiple"));
		logger.info("Prize type is choosen from sub prize multiple type dropdown");
	}

	public void enterPrizeValueSubPrize2() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeValueSubPrize2, LocatorType.XPATH, 10), 10);
		sendKeys(getwebElement(prizeValueSubPrize2, LocatorType.XPATH, 10),
				GlobalVariables.testDataMap.get("PrizeValue"));
		logger.info("Prize value sent to value 2 text box");
	}

	public void enterPrizeValueSubPrizeMultiple2() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeValueSubPrizeMultiple2, LocatorType.XPATH, 10), 10);
		sendKeys(getwebElement(prizeValueSubPrizeMultiple2, LocatorType.XPATH, 10),
				GlobalVariables.testDataMap.get("PrizeValue"));
		logger.info("Prize value sent to value 2 text box");
	}

	public void enterPrizeValueSubPrize2Multiple() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeValueSubPrize2Multiple, LocatorType.XPATH, 10), 10);
		sendKeys(getwebElement(prizeValueSubPrize2Multiple, LocatorType.XPATH, 10),
				GlobalVariables.testDataMap.get("PrizeValue"));
		logger.info("Prize value sent to value 2 text box");
	}

	public void enterPrizeRedeemSubPrizeMultiple() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeRedeemSubPrizeMultiple, LocatorType.XPATH, 10), 10);
		sendKeys(getwebElement(prizeRedeemSubPrizeMultiple, LocatorType.XPATH, 10),
				GlobalVariables.testDataMap.get("PrizeValue"));
		logger.info("Prize value sent to value multiple text box");
	}

	public void enterPrizeRedeemSubPrize2Multiple() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeRedeemSubPrize2Multiple, LocatorType.XPATH, 10), 10);
		sendKeys(getwebElement(prizeRedeemSubPrize2Multiple, LocatorType.XPATH, 10),
				GlobalVariables.testDataMap.get("PrizeValue"));
		logger.info("Prize value sent to value multiple text box");
	}

	public void enterPrizeRedeemSubPrizeMultiple2() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeRedeemSubPrizeMultiple2, LocatorType.XPATH, 10), 10);
		sendKeys(getwebElement(prizeRedeemSubPrizeMultiple2, LocatorType.XPATH, 10),
				GlobalVariables.testDataMap.get("PrizeValue"));
		logger.info("Prize value sent to value multiple text box");
	}

	public void enterPrizeRedeemSubPrize2Multiple2() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeRedeemSubPrize2Multiple2, LocatorType.XPATH, 10), 10);
		sendKeys(getwebElement(prizeRedeemSubPrize2Multiple2, LocatorType.XPATH, 10),
				GlobalVariables.testDataMap.get("PrizeValue"));
		logger.info("Prize value sent to value multiple text box");
	}

	public void enterPrizeRedeemSubPrize2() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeRedeemSubPrize2, LocatorType.XPATH, 10), 10);
		sendKeys(getwebElement(prizeRedeemSubPrize2, LocatorType.XPATH, 10),
				GlobalVariables.testDataMap.get("RedemptionCodeOnWin"));
		logger.info("Redemption code sent to redemption code 2 text box");
	}

	public void expiresIn() throws AutomationException, IOException {
		clickNoWait(getwebElement(expiresIn, LocatorType.ID, 10), 10);
		sendKeys(getwebElement(expiresIn, LocatorType.ID, 10), "5");
		logger.info("Expires In Days entered");
	}

	public void costValue() throws AutomationException, IOException {
		clickNoWait(getwebElement(costValue, LocatorType.ID, 10), 10);
		sendKeys(getwebElement(costValue, LocatorType.ID, 10), "3");
		logger.info("Cost Value entered");
	}

	public void clickAddButton() throws AutomationException, IOException {
		clickNoWait(getwebElement(addButton, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Add Button");
	}

	public void clickAddButtonAgain() throws AutomationException, IOException {
		clickNoWait(getwebElement(addButtonAgain, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Add Button");
	}

	public void enterPrizePackageName() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizePackageName, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Prize Package name text box");
		sendKeys(getwebElement(prizePackageName, LocatorType.ID, 10), GlobalVariables.testDataMap.get("SubPrizeName"));
		logger.info("Prize Package name sent to prize Package name text box");
	}

	public void enterPrizePackageNameMultiple() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizePackageName, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Prize Package name text box");
		sendKeys(getwebElement(prizePackageName, LocatorType.ID, 10),
				GlobalVariables.testDataMap.get("SubPrizeNameMultiple1"));
		logger.info("Prize Package name sent to prize Package name text box");
	}

	public void clickPrintReceiptPrizePackage() throws AutomationException, IOException {
		clickNoWait(getwebElement(printReceiptPrizePackage, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Print Receipt in Prize Package");
	}

	public void enterReceiptMessagePrizePackage() throws AutomationException, IOException {
		clickNoWait(getwebElement(receiptMsgPrizePackage, LocatorType.ID, 10), 10);
		sendKeys(getwebElement(receiptMsgPrizePackage, LocatorType.ID, 10),
				GlobalVariables.testDataMap.get("ReceiptMessage"));
		logger.info("Receipt Message sent to Receipt Message Prize Package text box");
	}

	public void choosePrizeTypePrizePackage() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeTypeSelectorXpathPrizePackage, LocatorType.XPATH, 10), 20);
		clickNoWait(getwebElement(prizeTypeTexXpathPrizePackage2, LocatorType.XPATH, 10), 20);
		sendKeys(getwebElement(prizeTypeTexXpathPrizePackage2, LocatorType.XPATH, 10), "Point Add");
		WebElement subprizetype = GlobalVariables.webDriver
				.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input"));
		subprizetype.sendKeys(Keys.ENTER);
		logger.info("Prize type is choosen from prize package type dropdown");

	}

	public void choosePrizeTypePrizePackageMultiple() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeTypeSelectorXpathPrizePackage, LocatorType.XPATH, 10), 20);
		clickNoWait(getwebElement(prizeTypeTexXpathPrizePackage2, LocatorType.XPATH, 10), 20);
		sendKeys(getwebElement(prizeTypeTexXpathPrizePackage2, LocatorType.XPATH, 10), "Point Deduct");
		WebElement subprizetype2 = GlobalVariables.webDriver
				.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input"));
		subprizetype2.sendKeys(Keys.ENTER);
		logger.info("Prize type is choosen from prize package type dropdown");

	}

	public void enterPrizeValuePrizePackageWindow() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeValuePrizePackageWindow, LocatorType.ID, 10), 10);
		sendKeys(getwebElement(prizeValuePrizePackageWindow, LocatorType.ID, 10),
				GlobalVariables.testDataMap.get("PrizeValue"));
		logger.info("Prize value sent to value text box");
	}

	public void enterPrizeRedeemPrizePackage() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeRedemWindow, LocatorType.ID, 10), 10);
		sendKeys(getwebElement(prizeRedemWindow, LocatorType.ID, 10),
				GlobalVariables.testDataMap.get("RedemptionCodeOnWin"));
		logger.info("Redemption code sent to redemption code text box");
	}

	public void clickAddButtonWindow() throws AutomationException, IOException {
		clickNoWait(getwebElement(addButtonWindow, LocatorType.ID, 10), 20);
		logger.info("Click action performed on Add Button on window");
	}

	public void choosePrizeTypePrizePackage2() throws AutomationException, IOException {
		clickNoWait(getwebElement(prizeTypeSelectorXpathPrizePackage, LocatorType.XPATH, 10), 20);
		clickNoWait(getwebElement(prizeTypeTexXpathPrizePackage2, LocatorType.XPATH, 10), 20);
		sendKeysAndEnter(getwebElement(prizeTypeTexXpathPrizePackage2, LocatorType.XPATH, 20),
				GlobalVariables.testDataMap.get("SubPrizeType"));
		logger.info("Prize type is choosen from prize package 2 type dropdown");
	}

	public void navigateToPrizePackageFrame() throws AutomationException, IOException {
		webDriver.switchTo().frame("iframePrizePackagePopup");
		logger.info("Switched to Prize Package Frame");
	}

	public void selectDrawingEntry() throws AutomationException, IOException {
		clickNoWait(getwebElement(drawingEntry, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Drawing Entry DropDown");
		WebElement drawing = GlobalVariables.webDriver.findElement(By.id("SiteMaster_MainContent_ctl21_ddlDrawing"));
		Select s = new Select(drawing);
		s.selectByIndex(1);
		logger.info(s + "is the value chosen from the Drawing Entry DropDown");
	}

	public void enterNoOfEntries() throws AutomationException, IOException {
		clickNoWait(getwebElement(noOfEntries, LocatorType.ID, 10), 10);
		sendKeys(getwebElement(noOfEntries, LocatorType.ID, 20),
				GlobalVariables.testDataMap.get("NoOfEntries"));
		logger.info("No Of Entries sent to No Of Entries text box");
	}

	public void selectMultiplyPeriod() throws AutomationException, IOException {
		clickNoWait(getwebElement(periodDuringSwipe, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed of select Multiply Period-Period During Swipe");
	}

	public void enterMultiplier() throws AutomationException, IOException {
		clickNoWait(getwebElement(multiplier, LocatorType.ID, 10), 10);
		sendKeys(getwebElement(multiplier, LocatorType.ID, 10), "5");
		logger.info("Multiplier sent to multiplier text box");
	}

	public void enterPointLimit() throws AutomationException, IOException {
		clickNoWait(getwebElement(pointLimit, LocatorType.ID, 10), 10);
		sendKeys(getwebElement(pointLimit, LocatorType.ID, 10), "10");
		logger.info("Point Limit sent to Point Limit text box");
	}

	public void selectApplyTo() throws AutomationException, IOException {
		clickNoWait(getwebElement(pointLimit, LocatorType.ID, 10), 10);
		logger.info("click action performed on apply to");
		WebElement apply = GlobalVariables.webDriver.findElement(By.id("SiteMaster_MainContent_ctl21_ddlApplyTo"));
		Select s = new Select(apply);
		List<WebElement> list = s.getOptions();
		// Taking the count of items
		int a = list.size();
		// Using Random class to generate random values
		Random num = new Random();
		int b = num.nextInt(a);
		// Selecting value from DropDownList
		s.selectByIndex(b);
		// Selected Value
		System.out.println(apply.getAttribute("value"));
		logger.info(b + "Is the Random value chosen for apply to");
	}

	public void machineGroup() throws AutomationException, IOException {
		clickNoWait(getwebElement(machineGroup, LocatorType.ID, 10), 10);
		logger.info("click action performed on machine group");
		WebElement apply = GlobalVariables.webDriver.findElement(By.id("SiteMaster_MainContent_ctl21_ddlMachineGroup"));
		Select s = new Select(apply);
		s.selectByIndex(1);
		System.out.println(apply.getAttribute("value"));
	}

	public void selectPromo() throws AutomationException, IOException {
		clickNoWait(getwebElement(selectPromo, LocatorType.ID, 10), 10);
		logger.info("click action performed on select Promotion dropdown");
		WebElement promo = GlobalVariables.webDriver.findElement(By.id("SiteMaster_MainContent_ctl21_ddlPromotion"));
		Select s = new Select(promo);
		s.selectByIndex(1);
		System.out.println(promo.getAttribute("value"));
	}

	public void selectPromoPromo() throws AutomationException, IOException {
		clickNoWait(getwebElement(selectPromo, LocatorType.ID, 10), 10);
		logger.info("click action performed on select Promotion dropdown");
		WebElement promo = GlobalVariables.webDriver.findElement(By.id("SiteMaster_MainContent_ctl21_ddlPromotion"));
		Select s = new Select(promo);
		s.selectByVisibleText("Automation_run159");
		System.out.println(promo.getAttribute("value"));
	}
	
	public void clickMultiplyPoints() throws AutomationException, IOException {
		clickNoWait(getwebElement(multiplyPointsQueue, LocatorType.XPATH, 10), 10);
		sendKeys(getwebElement(multiplyPointsQueueHours, LocatorType.ID, 10), "2");
		logger.info("Multiply Points Queue Hours sent to textbox");
	}

	public void clickUseQualificationsPrize() throws AutomationException, IOException {
		clickNoWait(getwebElement(useQualifications, LocatorType.XPATH, 10), 10);
		logger.info("Click action on use qualifications ");
	}

	public void enterQualificationStartDataAndTimePrize() throws AutomationException, IOException {
		sendKeys(getwebElement(startDateUseQualification, LocatorType.ID, 10),
				GlobalVariables.testDataMap.get("QualificationsPrizeStartDate"));
		clickNoWait(getwebElement(startDateText, LocatorType.XPATH, 10), 10);
		String startTime = GlobalVariables.testDataMap.get("QualificationsPrizeStartTime");
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + startTime + "'",
				getwebElement(startTimeUseQualification, LocatorType.XPATH, 10));
		logger.info("Start date and time sent to start date calendar text box");
	}

	public void enterQualificationEndDataAndTimePrize() throws AutomationException, IOException {
//		sendKeys(getwebElement(endDateUseQualification, LocatorType.ID, 10),
//				GlobalVariables.testDataMap.get("QualificationsPrizeEndDate"));
		String endTime = GlobalVariables.testDataMap.get("QualificationsPrizeEndTime");
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + endTime + "'",
				getwebElement(endTimeUseQualification, LocatorType.XPATH, 10));
		logger.info("End date and time sent to end date calendar text box");
	}

	public void enterLimitPerCustomer() throws AutomationException, IOException {
		clickNoWait(getwebElement(limitPerCust, LocatorType.ID, 10), 10);
		sendKeys(getwebElement(limitPerCust, LocatorType.ID, 10), "5");
		logger.info("Enter Limit Per Customer sent to textbox");
	}

	public void enterLimitPerTimes() throws AutomationException, IOException {
		clickNoWait(getwebElement(limitPerTime, LocatorType.ID, 10), 10);
		logger.info("click action performed on Limit Per Time");
		WebElement limit = GlobalVariables.webDriver
				.findElement(By.id("SiteMaster_MainContent_PrizeQualificationForm_ddlPartCondition"));
		Select s = new Select(limit);
		List<WebElement> list = s.getOptions();
		int a = list.size();
		Random num = new Random();
		int b = num.nextInt(a);
		s.selectByIndex(b);
		String c = Integer.toString(b);
		System.out.println(limit.getAttribute("value"));
		logger.info(b + "Is the Random value chosen for limit time per");
		if (c.equals("Hour") || c.equals("Day") || c.equals("Week")) {
			clickNoWait(getwebElement(limitValue, LocatorType.ID, 10), 10);
			sendKeys(getwebElement(limitValue, LocatorType.ID, 10), "3");
			logger.info("Enter Limit Per Times Per Customer sent to textbox");
		}
	}

	public void clickGroup() throws AutomationException, IOException {
		clickNoWait(getwebElement(groupCheckbox, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Group Checkbox");
	}

	public void isClickGroup1Enabled() throws AutomationException, IOException {
		WebElement groupCheckbox1Checked = getwebElement(groupCheckbox1, LocatorType.XPATH, 10);
		waitUntilElementVisible(groupCheckbox1Checked, 10);
		clickNoWait(groupCheckbox1Checked, 10);
		System.out.println(groupCheckbox1Checked.isSelected());
		if (!(groupCheckbox1Checked.isSelected())) {
			clickNoWait(groupCheckbox1Checked, 10);
			logger.info("Click action performed on group2 checkbox");
		}
	}

	public void isErrorMsgVisible() {
		String errorMsg = gettext(getwebElement(uploadErrorMsg, LocatorType.XPATH, 10));
		System.out.println("Error Msg is" + errorMsg);
	}

	public void clickcancel() throws AutomationException, IOException {
		clickNoWait(getwebElement(cancelPrize, LocatorType.ID, 10), 10);
		logger.info("Click action performed on cancel button");
	}

	public void clickPrizeCreated() throws AutomationException, IOException {
		clickNoWait(getwebElement(createdPrize, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on created prize");
	}

	public void navigateBackToPrize() throws AutomationException, IOException {
		webDriver.switchTo().defaultContent();
		logger.info("Switched back to Prize screen");
	}

	public void clickEditReceipt() throws AutomationException, IOException {
		clickNoWait(getwebElement(editReceipt, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on edit receipt");
	}

	public void clickParticipationDate() throws AutomationException, IOException {
		clickNoWait(getwebElement(participationDate, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on participation date tag");
	}

	public void clickEditPrize() throws AutomationException, IOException {
		clickNoWait(getwebElement(editPrize, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on edit prize");
	}

	public void clickDisabledButton() throws AutomationException, IOException {
		clickNoWait(getwebElement(disabledButton, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on disabled button");
	}

	public void update() throws AutomationException, IOException {
		clickNoWait(getwebElement(update, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on update button");
	}

	public void isErrorMsg() throws AutomationException, IOException {
		String errorID = gettext(getwebElement(errorContainerId, LocatorType.ID, 10));
		System.out.println("Error Text is " + errorID);
	}

	public void clickFilter() throws AutomationException, IOException {
		clickNoWait(getwebElement(filter, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on filter");
	}

	public void selectFiler() throws AutomationException, IOException {
		WebElement key = webDriver
				.findElement(By.xpath("//*[@id=\"select2-SiteMaster_MainContent_ddlGroup-container\"]"));
		clickNoWait(getwebElement(groupDrop, LocatorType.XPATH, 10), 10);
		threadWait(2000);
		clickNoWait(getwebElement(filterText, LocatorType.XPATH, 10), 10);
		threadWait(3000);

		sendKeys(getwebElement(filterText, LocatorType.XPATH, 20), "Auto");
		threadWait(2000);
		key.sendKeys(Keys.ARROW_DOWN);
		key.sendKeys(Keys.ENTER);

	}

	public void textPrize() throws AutomationException, IOException {
		String textprize = gettext(getwebElement(prizeText, LocatorType.XPATH, 10));
		System.out.println("Prize Text on UI is " + textprize);
	}

}
