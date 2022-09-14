package com.everi.page.promotion;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.everi.Enum.LocatorType;
import com.everi.Helper.GlobalVariables;
import com.everi.exception.AutomationException;
import com.everi.page.BasePage;
//import com.thoughtworks.selenium.webdriven.commands.GetValue;

public class EnrollmentPage extends BasePage {

	static Logger logger = LogManager.getLogger(EnrollmentPage.class);
	public static String promotionId;
	public static String promotionName;
	
	WebDriver webDriver = GlobalVariables.webDriver;
	JavascriptExecutor js = (JavascriptExecutor) GlobalVariables.webDriver;

	private final String startTimeDailyId = "SiteMaster_MainContent_tcStartTime_tbTime";
	private final String importPlayerXpath = "//label[@for='SiteMaster_MainContent_PromotionEnrollment_rblEnrollmentType_0']";
	private final String enterQueryXpath = "//label[@for='SiteMaster_MainContent_PromotionEnrollment_rblEnrollmentType_1']";
	private final String openToAllXpath = "//label[@for='SiteMaster_MainContent_PromotionEnrollment_rblEnrollmentType_2']";
	private final String openToAllExcludedXpath = "//label[@for='SiteMaster_MainContent_PromotionEnrollment_rblEnrollmentType_3']";
	private final String promotionGroupXpath = "//label[@for='SiteMaster_MainContent_PromotionEnrollment_rblEnrollmentType_4']";
	private final String demoGraphicsXpath = "//label[@for='SiteMaster_MainContent_PromotionEnrollment_rblEnrollmentType_5']";
	private final String enterPlayerIdBox = "SiteMaster_MainContent_PromotionEnrollment_tbIds";
	private final String unlimitedSwipeXpath = "//label[@for='SiteMaster_MainContent_rbPartConditionUnlimited']";
	private final String submitId = "SiteMaster_MainContent_lbSubmit";
	private final String cancelId = "SiteMaster_MainContent_hlCancel";
	private final String successContainerId = "SiteMaster_flashMessage_successContainer";
	private final String errorContainerId = "SiteMaster_flashMessage_errorContainer";
	private final String prizesTabXpath = "//a[contains(@href,'PromotionPrizes')]";
	private final String addGroupBtnId = "SiteMaster_MainContent_PromotionEnrollmentGroup_lbAddGroup";
	private final String addPlayerIdToGroup = "SiteMaster_MainContent_PromotionEnrollmentGroup_tbIds";
	private final String saveGroupInfoId = "SiteMaster_MainContent_PromotionEnrollmentGroup_lbSave";
	private final String useEnrollmentXpath = "//label[@for='SiteMaster_MainContent_cbEnrollmentPromotionGroup']/span";
	private final String promotionNameId = "SiteMaster_ContentHeaderContent_lPromotionName";
	private final String tierXpath = "(//*[@id=\"SiteMaster_MainContent_PromotionEnrollment_TiersForm_cblTiers_5\"]/../label/span)[6]";
	private final String participation = "SiteMaster_MainContent_tbParticipationCriteria";
	private final String daysBeforeXpath = "//*[@id=\"SiteMaster_MainContent_PromotionEnrollment_enrollmentForm_rbDaysBeforAfter\"]/../label/span";
	private final String daysBeforeText = "SiteMaster_MainContent_PromotionEnrollment_enrollmentForm_tbDaysBefore";
	private final String daysAfterText = "SiteMaster_MainContent_PromotionEnrollment_enrollmentForm_tbDaysAfter";
	private final String withinLast = "SiteMaster_MainContent_PromotionEnrollment_enrollmentForm_tbWithinLastDays";
	private final String sameMonthAnnivXpath = "(//*[\"SiteMaster_MainContent_PromotionEnrollment_enrollmentForm_rbEnrollmentAnniversarySameMonth\"]/../span[contains(text(),\"Same Month\")])[2]";
	private final String conditionTimes = "SiteMaster_MainContent_tbPartConditionAmount";
	private final String conditionType = "SiteMaster_MainContent_ddlPartCondition";
	private final String birthdayAgeRadio = "//*[@id=\"SiteMaster_MainContent_PromotionEnrollment_enrollmentForm_rbAgeBetween\"]/../label/span";
	private final String birthdayAgeFrom = "SiteMaster_MainContent_PromotionEnrollment_enrollmentForm_tbAgeFrom";
	private final String birthdayAgeTo = "SiteMaster_MainContent_PromotionEnrollment_enrollmentForm_tbAgeTo";
	private final String annivDays = "(//*[@id=\"SiteMaster_MainContent_PromotionEnrollment_enrollmentForm_rbEnrollmentAnniversaryDaysBeforeAfter\"]/../label/span)[1]";
	private final String annivDaysBefore = "SiteMaster_MainContent_PromotionEnrollment_enrollmentForm_tbEnrollmentAnniversaryDaysBefore";
	private final String annivDaysAfter = "SiteMaster_MainContent_PromotionEnrollment_enrollmentForm_tbEnrollmentAnniversaryDaysAfter";
	private final String conditionPer = "SiteMaster_MainContent_tbPartConditionAmount2";
	private final String conditionPerTime = "SiteMaster_MainContent_tbPartConditionEvery2";
	private final String timesPerRadio = "(//*[@id=\"SiteMaster_MainContent_rbPartConditionTime\"]/../label)[1]/span";
	private final String importPlayerCount = "SiteMaster_MainContent_PromotionEnrollment_sUploadedPlayers";
	private final String addQualification = "SiteMaster_MainContent_PromotionEnrollment_lbAddQualification";
	private final String predefinedRange = "//*[@id=\"SiteMaster_MainContent_PromotionEnrollment_EnrollmentFormQualification1_ConsiderationPeriodForm_rbPredefinedRange\"]/../label/span";
	private final String amount = "SiteMaster_MainContent_PromotionEnrollment_EnrollmentFormQualification1_rAmounts_ctl00_tbAmount";
	private final String selectQualification = "SiteMaster_MainContent_PromotionEnrollment_EnrollmentFormQualification1_ddlPlayCriteria";
	private final String selectPredifined = "SiteMaster_MainContent_PromotionEnrollment_EnrollmentFormQualification1_ConsiderationPeriodForm_ddlPredefinedRang";
	private final String lifeTime = "//*[@for=\"SiteMaster_MainContent_PromotionEnrollment_EnrollmentFormQualification1_ConsiderationPeriodForm_rbLifeTime\"]/span";
	private final String orButton = "//*[@for=\"SiteMaster_MainContent_PromotionEnrollment_rblQualificationOperator_1\"]/span";
	private final String andButton = "//*[@for=\"SiteMaster_MainContent_PromotionEnrollment_rblQualificationOperator_0\"]/span";
	private final String selectQualificationAgain = "SiteMaster_MainContent_PromotionEnrollment_EnrollmentFormQualification2_ddlPlayCriteria";
	private final String lifeTimeAgain = "//*[@for=\"SiteMaster_MainContent_PromotionEnrollment_EnrollmentFormQualification2_ConsiderationPeriodForm_rbLifeTime\"]/span";
	private final String amountAgain = "SiteMaster_MainContent_PromotionEnrollment_EnrollmentFormQualification2_rAmounts_ctl00_tbAmount";
	private final String assignPrizesButton = "SiteMaster_ContentHeaderContent_lbAssignPrizesPopup";
	private final String assignUpload = "ctl00_MainContent_UploadOrEnter_fuUploadZipCodes";
	private final String submit = "//*[@id=\"ctl00_MainContent_lbSubmit\"]";
	private final String enterTextLink = "//*[contains(text(),\"enter in a text area\")]";
	private final String enterTextArea = "ctl00_MainContent_UploadOrEnter_tbEnterZipCodes";
	private final String useEnrollmentGroup = "//*[@for=\"SiteMaster_MainContent_cbEnrollmentPromotionGroup\"]/span";
	private final String clickPlayerID = "//*[contains(text(),\"Import Player IDs\")]/span";
	private final String clickTier = "//*[contains(text(),\"Tier\")]/span";
	private final String clickQualificationSegment = "//*[contains(text(),\"Qualification (Segment)\")]/span";
	private final String saveGroup = "SiteMaster_MainContent_PromotionEnrollmentGroup_lbSubmit";
	private final String addGroup = "SiteMaster_MainContent_PromotionEnrollmentGroup_lbAddGroup";
	private final String addGroupName = "SiteMaster_MainContent_PromotionEnrollmentGroup_tbGroupName";
	private final String addPlayerId = "SiteMaster_MainContent_PromotionEnrollmentGroup_tbIds";
	private final String saveButton = "SiteMaster_MainContent_PromotionEnrollmentGroup_lbSave";
	private final String tier1Group = "(//*[@id=\"SiteMaster_MainContent_PromotionEnrollmentGroup_TiersForm_cblTiers_5\"]/../label/span)[6]";
	private final String tierGoldGroup = "(//*[@id=\"SiteMaster_MainContent_PromotionEnrollmentGroup_TiersForm_cblTiers_2\"]/../label/span)[3]";
	private final String selectQualificationGroup = "SiteMaster_MainContent_PromotionEnrollmentGroup_EnrollmentGroupQualification3_ddlPlayCriteria";
	private final String lifeTimeGroup = "//*[@for=\"SiteMaster_MainContent_PromotionEnrollmentGroup_EnrollmentGroupQualification3_ConsiderationPeriodForm_rbLifeTime\"]/span";
	private final String minValue = "SiteMaster_MainContent_PromotionEnrollmentGroup_tbMinvalue";
	private final String maxValue = "SiteMaster_MainContent_PromotionEnrollmentGroup_tbMaxValue";
	private final String qualificationGroupAdd = "SiteMaster_MainContent_PromotionEnrollmentGroup_lbAddQualification";
	private final String selectQualificationGroupAdd = "SiteMaster_MainContent_PromotionEnrollmentGroup_EnrollmentGroupQualification1_ddlPlayCriteria";
	private final String lifeTimeGroupAdd = "//*[@for=\"SiteMaster_MainContent_PromotionEnrollmentGroup_EnrollmentGroupQualification1_ConsiderationPeriodForm_rbLifeTime\"]/span";
	private final String amountAdd = "SiteMaster_MainContent_PromotionEnrollmentGroup_promoQualificationAmount1_rAmounts_ctl00_tbAmount";
	private final String selectQualificationGroupAdd1 = "SiteMaster_MainContent_PromotionEnrollmentGroup_EnrollmentGroupQualification2_ddlPlayCriteria";
	private final String selectOr = "//*[@id=\"SiteMaster_MainContent_PromotionEnrollmentGroup_rblQualificationOperator_1\"]/../label/span";
	private final String lifeTimeGroupAdd1 = "//*[@for=\"SiteMaster_MainContent_PromotionEnrollmentGroup_EnrollmentGroupQualification2_ConsiderationPeriodForm_rbLifeTime\"]/span";
	private final String amountAdd1 = "SiteMaster_MainContent_PromotionEnrollmentGroup_promotionQualificationAmounts2_rAmounts_ctl00_tbAmount";
	private final String notInOtherGroup = "//*[contains(text(),\"All players not in another group\")]/span";
	private final String enterQuery = "SiteMaster_MainContent_PromotionEnrollment_tbCustomQuery";
	private final String conditionsTime = "//*[@id=\"SiteMaster_MainContent_tbPartConditionAmount\"]";

	public void clickOpenToAllExcluded() throws AutomationException, IOException {
		clickNoWait(getwebElement(openToAllExcludedXpath, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on open to all radio button");
	}

	public void clickOpenToAll() throws AutomationException, IOException {
		clickNoWait(getwebElement(openToAllXpath, LocatorType.XPATH, 20), 10);
		logger.info("Click action performed on open to all radio button");
	}

	public void enterPlayerId() throws AutomationException, IOException {
		sendKeys(getwebElement(enterPlayerIdBox, LocatorType.ID, 10), GlobalVariables.testDataMap.get("PlayerId"));
	}

	public void clickUnlimitedSwipes() throws AutomationException, IOException {
		clickNoWait(getwebElement(unlimitedSwipeXpath, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on unlimited swipes radio button");
	}

	public void clickSaveButton() throws AutomationException, IOException {
		clickNoWait(getwebElement(submitId, LocatorType.ID, 10), 10);
		logger.info("Click action performed on save button");
	}

	public void clickPrizesTab() throws AutomationException {
		clickNoWait(getwebElement(prizesTabXpath, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on prizes tab");
	}

	public boolean isItemSavedSuccessfully() {
		return getwebElement(successContainerId, LocatorType.ID, 10).isDisplayed();
	}

	public boolean isErrorPresent() {
		if (GlobalVariables.webDriver.findElements(By.id(errorContainerId)).size() > 0)
			return true; // element is present so error exist
		else
			return false; // element not present and no error
	}

	public void getPromotionId() {
		String promotionNameWithID = gettext(getwebElement(promotionNameId, LocatorType.ID, 10));
		// extract promotion id from Automation_Dryrun (2703)
		promotionId = promotionNameWithID.substring(promotionNameWithID.indexOf("(") + 1,
				promotionNameWithID.indexOf(")"));
		System.out.println("Promotion ID is " + promotionId);

	}

	public void getPromotionName() {
		String promotionNameWithID = gettext(getwebElement(promotionNameId, LocatorType.ID, 10));
		// extract promotion id from Automation_Dryrun (2703)
		promotionName = promotionNameWithID.substring(0, 17);
		System.out.println("Promotion Name is " + promotionName);
	}

	public void clickTierButton() throws AutomationException, IOException {
		clickNoWait(getwebElement(tierXpath, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Tier button");
	}

	public void participationCriteria() throws AutomationException, IOException {
		js.executeScript("window.scrollTo(0,900)");
		clickNoWait(getwebElement(participation, LocatorType.ID, 50), 50);
		js.executeScript("document.getElementById('participation').value='1000117075'");
//		sendKeys(getwebElement(participation, LocatorType.ID, 20), GlobalVariables.testDataMap.get("ParticipationCriteria"));
		logger.info("Fill participation criteria");

	}

	public void clickenterQueryXpath() throws AutomationException, IOException {
		clickNoWait(getwebElement(enterQueryXpath, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Demographics radio button");
	}

	public void enterQueryXpath() throws AutomationException, IOException {
		clickNoWait(getwebElement(enterQuery, LocatorType.ID, 10), 10);
		logger.info("Click action performed on enter query textbox");
		String custom = GlobalVariables.testDataMap.get("CustomQuery");
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + custom + "'",
				getwebElement(enterQuery, LocatorType.ID, 10));
		logger.info("Entered custom query in Text box" + custom);

	}

	public void clickDemographics() throws AutomationException, IOException {
		clickNoWait(getwebElement(demoGraphicsXpath, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Demographics radio button");
	}

	public void clickDaysbefore() throws AutomationException, IOException {
		clickNoWait(getwebElement(daysBeforeXpath, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Days before Birthday radio button");
	}

	public void fillDaysBeforeText() throws AutomationException, IOException {
		sendKeys(getwebElement(daysBeforeText, LocatorType.ID, 10), "1");
		logger.info("Days before value entered in Birthday text box");
	}

	public void fillDaysAfterText() throws AutomationException, IOException {
		sendKeys(getwebElement(daysAfterText, LocatorType.ID, 10), "20");
		logger.info("Days after value entered in Birthday text box");
	}

	public void fillWithinText() throws AutomationException, IOException {
		sendKeys(getwebElement(withinLast, LocatorType.ID, 10), "10");
		logger.info("Days within last value entered in text box");
	}

	public void sameMonthAnniv() throws AutomationException, IOException {
		clickNoWait(getwebElement(sameMonthAnnivXpath, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Same Month Anniversary radio button");
	}

	public void conditionTimes() throws AutomationException, IOException {
		sendKeys(getwebElement(conditionTimes, LocatorType.ID, 10), "2");
		logger.info("Days before value entered in text box");
	}

	public void selectCondition() throws AutomationException, IOException {
		sendKeys(getwebElement(conditionTimes, LocatorType.ID, 10), "5");
		logger.info("Condition count entered in text box");
		WebElement conditionType = GlobalVariables.webDriver
				.findElement(By.id("SiteMaster_MainContent_ddlPartCondition"));
		Select s = new Select(conditionType);
		List<WebElement> list = s.getOptions();
		// Taking the count of items
		int a = list.size();
		// Using Random class to generate random values
		Random num = new Random();
		int b = num.nextInt(a);
		// Selecting value from DropDownList
		s.selectByVisibleText("Period");
//		s.selectByIndex(b);
		// Selected Value
		System.out.println(conditionType.getAttribute("value"));
		logger.info(b + "Is the Random value chosen for Condition Type");

	}

	public void clickBirthdayAge() throws AutomationException, IOException {
		clickNoWait(getwebElement(birthdayAgeRadio, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Birthday Age Between radio button");
	}

	public void fillbirthdayAgeFromText() throws AutomationException, IOException {
		sendKeys(getwebElement(birthdayAgeFrom, LocatorType.ID, 10), "18");
		logger.info("Age from value entered in Birthday text box");
	}

	public void fillbirthdayAgeToText() throws AutomationException, IOException {
		sendKeys(getwebElement(birthdayAgeTo, LocatorType.ID, 10), "60");
		logger.info("Age to value entered in Birthday text box");
	}

	public void clickAnnivDays() throws AutomationException, IOException {
		clickNoWait(getwebElement(annivDays, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Anniversary Days Between radio button");
	}

	public void annivDaysBefore() throws AutomationException, IOException {
		sendKeys(getwebElement(annivDaysBefore, LocatorType.ID, 10), "10");
		logger.info("Anniversary Days Before value entered in text box");
	}

	public void annivDaysAfter() throws AutomationException, IOException {
		sendKeys(getwebElement(annivDaysAfter, LocatorType.ID, 10), "15");
		logger.info("Anniversary Days After value entered in text box");
	}

	public void clickTimesPerRadio() throws AutomationException, IOException {
		clickNoWait(getwebElement(timesPerRadio, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on times per radio button for every day or hour or week");
	}

	public void selectConditionPerTime() throws AutomationException, IOException {
		sendKeys(getwebElement(conditionPer, LocatorType.ID, 10), "5");
		logger.info("Condition no of times per Every count entered in text box");
		sendKeys(getwebElement(conditionPerTime, LocatorType.ID, 10), "7");
		logger.info("Condition no of times per Every period entered in text box");
		WebElement conditionType = GlobalVariables.webDriver
				.findElement(By.id("SiteMaster_MainContent_ddlPartCondition2"));
		Select s = new Select(conditionType);
		List<WebElement> list = s.getOptions();
		// Taking the count of items
		int a = list.size();
		// Using Random class to generate random values
		Random num = new Random();
		int b = num.nextInt(a);
		// Selecting value from DropDownList
		s.selectByIndex(b);
		// Selected Value
		System.out.println(conditionType.getAttribute("value"));
		logger.info(b + "Is the Random value chosen for Condition Type per every period");

	}

	public void clickImportPlayer() throws AutomationException, IOException {
		clickNoWait(getwebElement(importPlayerXpath, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Import Player ID radio button");
	}

	public void enterPlayerIdNumbers() throws AutomationException, IOException {
		clickNoWait(getwebElement(enterPlayerIdBox, LocatorType.ID, 10), 10);
		logger.info("Click action performed on enter PlayerId Text box");
		String playerId = GlobalVariables.testDataMap.get("PlayerId");
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + playerId + "'",
				getwebElement(enterPlayerIdBox, LocatorType.ID, 10));
		logger.info("Entered PlayerId in Text box" + playerId);
	}

	public void enterPlayerIdNumbersPromo() throws AutomationException, IOException {
		clickNoWait(getwebElement(enterPlayerIdBox, LocatorType.ID, 10), 10);
		logger.info("Click action performed on enter PlayerId Text box");
		String playerId = GlobalVariables.testDataMap.get("PlayerIdPromo");
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + playerId + "'",
				getwebElement(enterPlayerIdBox, LocatorType.ID, 10));
		logger.info("Entered PlayerId in Text box" + playerId);
	}
	
	public boolean isPlayerImported() {
		return getwebElement(importPlayerCount, LocatorType.ID, 10).isDisplayed();
	}

	public void getImportedValue() throws AutomationException, IOException {
		WebElement playerCount = webDriver
				.findElement(By.id("SiteMaster_MainContent_PromotionEnrollment_sUploadedPlayers"));
		logger.info("Total Imported: " + playerCount.getText());
	}

	public void enterPlayerIdNumbersToExclude() throws AutomationException, IOException {
		clickNoWait(getwebElement(enterPlayerIdBox, LocatorType.ID, 10), 10);
		logger.info("Click action performed on enter PlayerId Text box to exclude the PlayerId");
//		String playerId = GlobalVariables.testDataMap.get("PlayerId");
//		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + playerId + "'",
//				getwebElement(enterPlayerIdBox, LocatorType.ID, 10));
		sendKeys(getwebElement(enterPlayerIdBox, LocatorType.ID, 20), "1000002689");
		logger.info("Entered PlayerId is excluded from the imported playerId");
	}

	public void clickaddQualification() throws AutomationException, IOException {
		js.executeScript("window.scrollTo(0,600)");
		clickNoWait(getwebElement(addQualification, LocatorType.ID, 20), 20);
		logger.info("Click action performed on Add Qualification button");
	}

	public void selectQualification() throws AutomationException, IOException {
		clickNoWait(getwebElement(selectQualification, LocatorType.ID, 20), 20);
		logger.info("Click action performed on Select Qualification dropdown");
		WebElement qualificationType = GlobalVariables.webDriver.findElement(
				By.id("SiteMaster_MainContent_PromotionEnrollment_EnrollmentFormQualification1_ddlPlayCriteria"));
		Select s = new Select(qualificationType);
//		List<WebElement> list = s.getOptions();
		// Taking the count of items
//		int a = list.size();
//		// Using Random class to generate random values
//		Random num = new Random();
//		int b = num.nextInt(a);
//		// Selecting value from DropDownList
//		s.selectByIndex(b);
//		// Selected Value
//		System.out.println(qualificationType.getAttribute("value"));
//		logger.info(b + "Is the Random value chosen for qualification type");

		s.selectByVisibleText("Points - All");
		logger.info("Points All value selected from Drop down");
	}

	public void clickPredifinedRange() throws AutomationException, IOException {
		clickNoWait(getwebElement(predefinedRange, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Predefined Range button");
	}

	public void selectPredefined() throws AutomationException, IOException {
		clickNoWait(getwebElement(selectPredifined, LocatorType.ID, 20), 20);
		logger.info("Click action performed on Predefined dropdown");
		WebElement predefinedType = GlobalVariables.webDriver.findElement(By.id(
				"SiteMaster_MainContent_PromotionEnrollment_EnrollmentFormQualification1_ConsiderationPeriodForm_ddlPredefinedRang"));
		Select s = new Select(predefinedType);
		List<WebElement> list = s.getOptions();
		// Taking the count of items
		int a = list.size();
		// Using Random class to generate random values
		Random num = new Random();
		int b = num.nextInt(a);
		// Selecting value from DropDownList
		s.selectByIndex(b);
		// Selected Value
		System.out.println(predefinedType.getAttribute("value"));
		logger.info(b + "Is the Random value chosen for predefined type");
	}

	public void enteramount() throws AutomationException, IOException {
		clickNoWait(getwebElement(amount, LocatorType.ID, 10), 10);
		logger.info("Click action performed on amount text box");
		sendKeys(getwebElement(amount, LocatorType.ID, 20), "10");
		logger.info("Entered amount value");
	}

	public void clickLifeTime() throws AutomationException, IOException {
		clickNoWait(getwebElement(lifeTime, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on LifeTime button");
	}

	public void clickOnOr() throws AutomationException, IOException {
		clickNoWait(getwebElement(orButton, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Or button");
	}

	public void clickOnAnd() throws AutomationException, IOException {
		clickNoWait(getwebElement(andButton, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on And button");
	}

	public void selectQualificationAgain() throws AutomationException, IOException {
		clickNoWait(getwebElement(selectQualificationAgain, LocatorType.ID, 20), 20);
		logger.info("Click action performed on Select Qualification dropdown again");
		WebElement qualificationType = GlobalVariables.webDriver.findElement(
				By.id("SiteMaster_MainContent_PromotionEnrollment_EnrollmentFormQualification2_ddlPlayCriteria"));
		Select s = new Select(qualificationType);
		s.selectByVisibleText("Total Comps Earned");
		logger.info("Total Comps Earned value selected from Drop down");
	}

	public void clickLifeTimeAgain() throws AutomationException, IOException {
		clickNoWait(getwebElement(lifeTimeAgain, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on LifeTime button again");
	}

	public void enteramountAgain() throws AutomationException, IOException {
		clickNoWait(getwebElement(amountAgain, LocatorType.ID, 10), 10);
		logger.info("Click action performed on amount text box");
		sendKeys(getwebElement(amountAgain, LocatorType.ID, 20), "10");
		logger.info("Entered amount value again");
	}

	public void assignPrizesButton() throws AutomationException, IOException {
		clickNoWait(getwebElement(assignPrizesButton, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Assign Prizes button ");
	}

	public void navigateToAssignPrizesFrame() throws AutomationException, IOException {
		webDriver.switchTo().frame("popupframeFPP");
		logger.info("Switched to Assign Prizes Frame");
	}

	public void uploadAssignCsv() throws AutomationException, IOException {
		sendKeys(getwebElement(assignUpload, LocatorType.ID, 10),
				System.getProperty("user.dir") + "/src/main/resources/Prizes/AssignPrizes.csv");
		logger.info("Upload of assign prizes is completed");
		webDriver.manage().window().maximize();
		logger.info("Screen Maximized");
	}

	public void clickSubmit() throws AutomationException, IOException {
		clickNoWait(getwebElement(submit, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Submit button");
	}

	public void navigateBackToEnrollment() throws AutomationException, IOException {
		webDriver.switchTo().defaultContent();
		logger.info("Switched back to Enrollment screen");
	}

	public void clickEnterText() throws AutomationException, IOException {
		clickNoWait(getwebElement(enterTextLink, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Enter Text");
	}

	public void enterText() throws AutomationException, IOException {
		clickNoWait(getwebElement(enterTextArea, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Enter Text");
		sendKeys(getwebElement(enterTextArea, LocatorType.ID, 20), "\"1900002785\",\"1\"");
		logger.info("Entered Player ID details");
	}

	public void clickUseEnrollmentGroup() throws AutomationException, IOException {
		clickNoWait(getwebElement(useEnrollmentGroup, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Use Enrollment Group");
	}

	public void clickPlayerID() throws AutomationException, IOException {
		clickNoWait(getwebElement(clickPlayerID, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Import Player ID button");
	}

	public void clickTier() throws AutomationException, IOException {
		clickNoWait(getwebElement(clickTier, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Tier button");
	}

	public void clickQualification() throws AutomationException, IOException {
		clickNoWait(getwebElement(clickQualificationSegment, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Qualification button");

	}

	public void clickSaveGroup() throws AutomationException, IOException {
		clickNoWait(getwebElement(saveGroup, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Save Group Info button");
	}

	public void clickAddGroup() throws AutomationException, IOException {
		clickNoWait(getwebElement(addGroup, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Add Group Info button");

	}

	public void clickAddGroupName() throws AutomationException, IOException {
		clickNoWait(getwebElement(addGroupName, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Add Group Name textbox");
//		sendKeys(getwebElement(addGroupName, LocatorType.ID, 10), "AutomationGroup");
		sendKeys(getwebElement(addGroupName, LocatorType.ID, 10),
				GlobalVariables.testDataMap.get("EnrollmentGroupName"));
		logger.info("Enter Group name details");
	}

	public void addPlayerID1() throws AutomationException, IOException {
		clickNoWait(getwebElement(addPlayerId, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Add Player ID textbox");
		sendKeys(getwebElement(addPlayerId, LocatorType.ID, 20), "1000006818");
		logger.info("Enter in Player Id textbox");
	}

	public void saveButton() throws AutomationException, IOException {
		clickNoWait(getwebElement(saveButton, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Save button");

	}

	public void clickAddGroupName1() throws AutomationException, IOException {
		clickNoWait(getwebElement(addGroupName, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Add Group Name Info button");
		sendKeys(getwebElement(addGroupName, LocatorType.ID, 10),
				GlobalVariables.testDataMap.get("EnrollmentGroupName1"));
		logger.info("Enter Group name details");
	}

	public void addPlayerID() throws AutomationException, IOException {
		clickNoWait(getwebElement(addPlayerId, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Add Player ID textbox");
		String PlayerId = GlobalVariables.testDataMap.get("PlayerId");
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + PlayerId + "'",
				getwebElement(addPlayerId, LocatorType.ID, 10));
		logger.info("Enter in Player Id textbox");
	}

	public void clickTier1() throws AutomationException, IOException {
		clickNoWait(getwebElement(tier1Group, LocatorType.XPATH, 20), 20);
		logger.info("Click action performed on Tier 1 Checkbox");

	}

	public void clickTierGold() throws AutomationException, IOException {
		clickNoWait(getwebElement(tierGoldGroup, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Tier 1 Checkbox");

	}

	public void selectQualificationGroup() throws AutomationException, IOException {
		clickNoWait(getwebElement(selectQualificationGroup, LocatorType.ID, 20), 20);
		logger.info("Click action performed on Select Qualification dropdown");
		WebElement qualificationType = GlobalVariables.webDriver.findElement(
				By.id("SiteMaster_MainContent_PromotionEnrollmentGroup_EnrollmentGroupQualification3_ddlPlayCriteria"));
		Select s = new Select(qualificationType);
		s.selectByVisibleText("Points - All");
		logger.info("Points All value selected from Drop down");
	}

	public void clickLifeTimeGroup() throws AutomationException, IOException {
		clickNoWait(getwebElement(lifeTimeGroup, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on LifeTime button");
	}

	public void minValue() throws AutomationException, IOException {
		clickNoWait(getwebElement(minValue, LocatorType.ID, 10), 10);
		logger.info("Click action performed on min value");
		sendKeys(getwebElement(minValue, LocatorType.ID, 20), "1");
		logger.info("Entered min value details");
	}

	public void maxValue() throws AutomationException, IOException {
		clickNoWait(getwebElement(maxValue, LocatorType.ID, 10), 10);
		logger.info("Click action performed on max value");
		sendKeys(getwebElement(maxValue, LocatorType.ID, 20), "10");
		logger.info("Entered max value details");
	}

	public void minValue1() throws AutomationException, IOException {
		clickNoWait(getwebElement(minValue, LocatorType.ID, 10), 10);
		logger.info("Click action performed on min value");
		sendKeys(getwebElement(minValue, LocatorType.ID, 20), "2");
		logger.info("Entered min value details");
	}

	public void maxValue1() throws AutomationException, IOException {
		clickNoWait(getwebElement(maxValue, LocatorType.ID, 10), 10);
		logger.info("Click action performed on max value");
		sendKeys(getwebElement(maxValue, LocatorType.ID, 20), "12");
		logger.info("Entered max value details");
	}

	public void clickQualificationGroupAdd() throws AutomationException, IOException {
		clickNoWait(getwebElement(qualificationGroupAdd, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Qualification button");
	}

	public void selectQualificationGroupAdd() throws AutomationException, IOException {
		clickNoWait(getwebElement(selectQualificationGroupAdd, LocatorType.ID, 20), 20);
		logger.info("Click action performed on Select Qualification dropdown");
		WebElement qualificationType = GlobalVariables.webDriver.findElement(
				By.id("SiteMaster_MainContent_PromotionEnrollmentGroup_EnrollmentGroupQualification1_ddlPlayCriteria"));
		Select s = new Select(qualificationType);
		s.selectByVisibleText("Points - All");
		logger.info("Points All value selected from Drop down");
	}

	public void selectQualificationGroupAdd1() throws AutomationException, IOException {
		clickNoWait(getwebElement(selectQualificationGroupAdd1, LocatorType.ID, 20), 20);
		logger.info("Click action performed on Select Qualification dropdown");
		WebElement qualificationType = GlobalVariables.webDriver.findElement(
				By.id("SiteMaster_MainContent_PromotionEnrollmentGroup_EnrollmentGroupQualification2_ddlPlayCriteria"));
		Select s = new Select(qualificationType);
		s.selectByVisibleText("Total Comps Earned");
		logger.info("Points All value selected from Drop down");
	}

	public void clickLifeTimeGroupAdd() throws AutomationException, IOException {
		clickNoWait(getwebElement(lifeTimeGroupAdd, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on LifeTime button");
	}

	public void amountAdd() throws AutomationException, IOException {
		clickNoWait(getwebElement(amountAdd, LocatorType.ID, 10), 10);
		logger.info("Click action performed on amountAdd value");
		sendKeys(getwebElement(amountAdd, LocatorType.ID, 20), "5");
		logger.info("Entered amount add details");
	}

	public void amountAdd1() throws AutomationException, IOException {
		clickNoWait(getwebElement(amountAdd, LocatorType.ID, 10), 10);
		logger.info("Click action performed on amountAdd value");
		sendKeys(getwebElement(amountAdd, LocatorType.ID, 20), "10");
		logger.info("Entered amount add details");
	}

	public void amountAdd1Tier() throws AutomationException, IOException {
		clickNoWait(getwebElement(amountAdd1, LocatorType.ID, 10), 10);
		logger.info("Click action performed on amountAdd value");
		sendKeys(getwebElement(amountAdd1, LocatorType.ID, 20), "10");
		logger.info("Entered amount add details");
	}

	public void amountAddmultiple1() throws AutomationException, IOException {
		clickNoWait(getwebElement(amountAdd1, LocatorType.ID, 10), 10);
		logger.info("Click action performed on amountAdd value");
		sendKeys(getwebElement(amountAdd1, LocatorType.ID, 20), "10");
		logger.info("Entered amount add details");
	}

	public void selectOr() throws AutomationException, IOException {
		clickNoWait(getwebElement(selectOr, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Or button");
	}

	public void clickLifeTimeGroupAdd1() throws AutomationException, IOException {
		clickNoWait(getwebElement(lifeTimeGroupAdd1, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on LifeTime button");
	}

	public void clicknotInOtherGroup() throws AutomationException, IOException {
		clickNoWait(getwebElement(notInOtherGroup, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on not in other group button");
	}

	public void selectTimesPerPeriod() throws AutomationException, IOException {
		sendKeys(getwebElement(conditionsTime, LocatorType.XPATH, 10),
				GlobalVariables.testDataMap.get("TimesPerPeriodPromotion"));
		logger.info("Condition no of times per Every count entered in text box");
		WebElement conditionType = GlobalVariables.webDriver
				.findElement(By.xpath("//*[@id=\"SiteMaster_MainContent_ddlPartCondition\"]"));
		Select s = new Select(conditionType);
		s.selectByValue("4");
	}

	public void selectTimesPerPromo() throws AutomationException, IOException {
		sendKeys(getwebElement(conditionsTime, LocatorType.XPATH, 10),
				GlobalVariables.testDataMap.get("TimesPerPeriodPromotion"));
		logger.info("Condition no of times per Every count entered in text box");
		WebElement conditionType = GlobalVariables.webDriver
				.findElement(By.xpath("//*[@id=\"SiteMaster_MainContent_ddlPartCondition\"]"));
		Select s = new Select(conditionType);
		s.selectByValue("0");
	}
}
