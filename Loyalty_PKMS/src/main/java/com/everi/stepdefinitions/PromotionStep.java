package com.everi.stepdefinitions;

import java.io.IOException;

import org.junit.Assert;

import com.everi.exception.AutomationException;
import com.everi.page.HomePage;
import com.everi.page.promotion.AdvancedConfigurations;
import com.everi.page.promotion.AssetsPage;
import com.everi.page.promotion.EnrollmentPage;
import com.everi.page.promotion.GatewayCallLog;
import com.everi.page.promotion.GeneralInformationPage;
import com.everi.page.promotion.PrizeDistributionReport;
import com.everi.page.promotion.PrizesPage;
import com.everi.page.promotion.ReportsAuditReport;
import com.everi.page.promotion.ReportsPlayerActivity;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.lu.a.as;

public class PromotionStep {
	GeneralInformationPage generalInfo = new GeneralInformationPage();
	EnrollmentPage enroll = new EnrollmentPage();
	AssetsPage asset = new AssetsPage();
	PrizesPage prize = new PrizesPage();
	GatewayCallLog gateway = new GatewayCallLog();
	ReportsPlayerActivity reports = new ReportsPlayerActivity();
	AdvancedConfigurations advanced = new AdvancedConfigurations();
	PrizeDistributionReport prizeReport = new PrizeDistributionReport();
	ReportsAuditReport audit = new ReportsAuditReport();
	HomePage home = new HomePage();

	@And("Fill the general information of promotion to be created")
	public void generalInformation() throws AutomationException, IOException {
		generalInfo.enterPromotionName();
		generalInfo.enterDescription();
		generalInfo.enterPriority();
		generalInfo.isInactiveSelected();
		generalInfo.isarchiveSelected();
		generalInfo.ispostToCalendarSelected();
		generalInfo.enterStartDataAndTime();
		generalInfo.enterEndDataAndTime();
		generalInfo.enterDailyTime();
		generalInfo.uploadPromotionListImage();
		generalInfo.clickCreatebtn();
		Assert.assertFalse("Field validation errors", generalInfo.isErrorPresent());
		Assert.assertTrue("Item is saved successfully", generalInfo.isItemSavedSuccessfully());
		generalInfo.clickEnrollmentTab();
		generalInfo.waitForPageLoaded("Enrollment Page");
	}

	@And("Fill the general information of promotion to be created with Post to Calendar")
	public void generalInformationPostToCalendar() throws AutomationException, IOException {
		generalInfo.enterPromotionName();
		generalInfo.enterDescription();
		generalInfo.enterPriority();
		generalInfo.isInactiveSelected();
		generalInfo.isarchiveSelected();
		generalInfo.postToCalendarSelected();
		generalInfo.postToCalendarText();
		generalInfo.enterStartDataAndTime();
		generalInfo.enterEndDataAndTime();
		generalInfo.enterDailyTime();
		generalInfo.uploadPromotionListImage();
		generalInfo.clickCreatebtn();
//		Assert.assertFalse("Field validation errors", generalInfo.isErrorPresent());
		Assert.assertTrue("Item is saved successfully", generalInfo.isItemSavedSuccessfully());
		generalInfo.clickEnrollmentTab();
		generalInfo.waitForPageLoaded("Enrollment Page");
	}

	@And("Restrict a user by excluding enrollement")
	public void excludingEnrollement() throws AutomationException, IOException {
		enroll.getPromotionId();
		enroll.clickOpenToAllExcluded();
		enroll.enterPlayerId();
		enroll.clickUnlimitedSwipes();
		enroll.clickSaveButton();
		Assert.assertTrue("Field validtion failed in enrollment form", enroll.isItemSavedSuccessfully());
		enroll.threadWait(1000);
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
	}

	@And("Create a point add type prize")
	public void createPrize() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.clickPrintReceipt();
		prize.enterReceiptMessage();
		prize.enterScreenMessage();
		prize.choosePrizeType();
		prize.threadWait(1000);
		prize.enterPrizeValue();
		prize.enterRedemptionCode();
		prize.uploadPrizeScreen();
		prize.threadWait(2000);
		prize.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());

	}

	@And("Fill the general information of promotion to be created with invalid date,add and delete period")
	public void generalInformationInvalidDate() throws AutomationException, IOException {
		generalInfo.enterPromotionName();
		generalInfo.enterDescription();
		generalInfo.enterPriority();
		generalInfo.isInactiveSelected();
		generalInfo.isarchiveSelected();
		generalInfo.ispostToCalendarSelected();
		generalInfo.enterStartDataAndTime();
		generalInfo.enterEndDataAndTime();
		generalInfo.clickAddPeriod();
		generalInfo.enterStartDataAndTime2();
		generalInfo.enterEndDataAndTime2();
		generalInfo.enterDailyTime();
		generalInfo.deleteAddPeriod();
		generalInfo.uploadPromotionListImage();
		generalInfo.clickCreatebtn();
		Assert.assertTrue("Start date should be before end date", generalInfo.isInvalidTimeErrorPresent());
	}

	@And("Fill the general information of promotion to be created without kiosk selection")
	public void generalInformationNoKiosk() throws AutomationException, IOException {
		generalInfo.enterPromotionName();
		generalInfo.enterDescription();
		generalInfo.enterPriority();
		generalInfo.isInactiveSelected();
		generalInfo.isarchiveSelected();
		generalInfo.postToCalendarSelected();
		generalInfo.postToCalendarText();
		generalInfo.threadWait(1000);
		generalInfo.enterStartDataAndTime();
		generalInfo.enterEndDataAndTime();
		generalInfo.enterDailyTime();
		generalInfo.clickDontShowPromotion();
		generalInfo.isAllKiosksSelected();
		generalInfo.uploadPromotionListImage();
		generalInfo.clickCreatebtn();
		Assert.assertTrue("No Kiosk selected", generalInfo.isNoKioskWarningDisplayed());
		generalInfo.clickEnrollmentTab();
		generalInfo.waitForPageLoaded("Enrollment Page");
	}

	@And("Fill the general information of promotion to be created with one kiosk")
	public void generalInformationOneKiosk() throws AutomationException, IOException {
		generalInfo.enterPromotionName();
		generalInfo.enterDescription();
		generalInfo.enterPriority();
		generalInfo.isInactiveSelected();
		generalInfo.isarchiveSelected();
		generalInfo.postToCalendarSelected();
		generalInfo.postToCalendarText();
		generalInfo.threadWait(1000);
		generalInfo.enterStartDataAndTime();
		generalInfo.enterEndDataAndTime();
		generalInfo.enterDailyTime();
		generalInfo.clickDontShowPromotion();
		generalInfo.isOneKiosksSelected();
		generalInfo.uploadPromotionListImage();
		generalInfo.clickCreatebtn();
		generalInfo.clickEnrollmentTab();
		generalInfo.waitForPageLoaded("Enrollment Page");
	}

	@And("Fill the general information of promotion to be created with Multiple Periods")
	public void generalInformationMultiplePeriods() throws AutomationException, IOException {
		generalInfo.enterPromotionName();
		generalInfo.enterDescription();
		generalInfo.enterPriority();
		generalInfo.isInactiveSelected();
		generalInfo.isarchiveSelected();
		generalInfo.ispostToCalendarSelected();
		generalInfo.enterStartDataAndTime();
		generalInfo.enterEndDataAndTime();
		generalInfo.clickCreateMultiplePeriods();
		generalInfo.clickCreateMultiplePeriodFriday();
		generalInfo.clickCreateButton();
		generalInfo.clickDeleteButton2();
		generalInfo.clickDeleteButton3();
		generalInfo.clickDeleteButton4();
		generalInfo.enterDailyTime();
		generalInfo.uploadPromotionListImage();
		generalInfo.clickCreatebtn();
		Assert.assertTrue("Item is saved successfully", generalInfo.isItemSavedSuccessfully());
	}

	@And("Fill the general information of promotion to be created with Invalid Image")
	public void generalInformationInvalidPromoImage() throws AutomationException, IOException {
		generalInfo.enterPromotionName();
		generalInfo.enterDescription();
		generalInfo.enterPriority();
		generalInfo.isInactiveSelected();
		generalInfo.isarchiveSelected();
		generalInfo.ispostToCalendarSelected();
		generalInfo.enterStartDataAndTime();
		generalInfo.enterEndDataAndTime();
		generalInfo.enterDailyTime();
		generalInfo.uploadInvalidPromotionListImage();
		generalInfo.clickCreatebtn();
		Assert.assertTrue("Allow only assets with extensions: .png", generalInfo.isInvalidImageErrorPresent());
	}

	@Then("Fill the general information of promotion to be created and upload Main assests")
	public void generalInformationAssets() throws AutomationException, IOException {
		generalInfo.enterPromotionName();
		generalInfo.enterDescription();
		generalInfo.enterPriority();
		generalInfo.enterStartDataAndTime();
		generalInfo.enterEndDataAndTime();
		generalInfo.enterDailyTime();
		generalInfo.uploadPromotionListImage();
		generalInfo.clickCreatebtn();
		Assert.assertTrue("Item is saved successfully", generalInfo.isItemSavedSuccessfully());
		asset.clickAssetsTab();
		asset.isGlobeavailableMain();
		asset.clickEditMainAsset();
		asset.navigateToAssetFrame();
		asset.enterAssetDescription();
		asset.uploadAssetImage();
		asset.checkMoreTimeXpath();
		asset.checkInheritSettingsXpath();
		asset.timeoutSeconds();
		asset.clickSave();
		asset.navigateBackToAsset();
		asset.isPinavailableMain();
		Assert.assertTrue("Item is saved successfully", generalInfo.isItemSavedSuccessfully());
	}

	@Then("Fill the general information of promotion to be created and upload invalid assests")
	public void generalInformationInvalidAssets() throws AutomationException, IOException {
		generalInfo.enterPromotionName();
		generalInfo.enterDescription();
		generalInfo.enterPriority();
		generalInfo.enterStartDataAndTime();
		generalInfo.enterEndDataAndTime();
		generalInfo.enterDailyTime();
		generalInfo.uploadPromotionListImage();
		generalInfo.clickCreatebtn();
		Assert.assertTrue("Item is saved successfully", generalInfo.isItemSavedSuccessfully());
		asset.clickAssetsTab();
		asset.clickEditMainAsset();
		asset.navigateToAssetFrame();
		asset.enterAssetDescription();
		asset.uploadInvalidAssetImage();
		asset.checkMoreTimeXpath();
		asset.checkInheritSettingsXpath();
		asset.timeoutSeconds();
		asset.clickSave();
		Assert.assertTrue("Allow only assets with extensions", asset.isinvalidAssestWarningmsgDisplayed());
	}

	@Then("Fill the general information of promotion to be created and upload Promotion Is Not Available assests")
	public void generalInformationPromotionIsNotAvailableAssets() throws AutomationException, IOException {
		generalInfo.enterPromotionName();
		generalInfo.enterDescription();
		generalInfo.enterPriority();
		generalInfo.enterStartDataAndTime();
		generalInfo.enterEndDataAndTime();
		generalInfo.enterDailyTime();
		generalInfo.uploadPromotionListImage();
		generalInfo.clickCreatebtn();
		Assert.assertTrue("Item is saved successfully", generalInfo.isItemSavedSuccessfully());
		asset.clickAssetsTab();
		asset.isGlobeavailablePromo();
		asset.clickEditPromoNotAvailableAsset();
		asset.navigateToAssetFrame();
		asset.enterAssetDescription();
		asset.uploadAssetPromoNotAvailableImage();
		asset.checkInheritSettingsXpath();
		asset.timeoutSeconds();
		asset.checkinheritTimeToXpath();
		asset.selectTimeOutTo();
		asset.clickSave();
		asset.navigateBackToAsset();
		asset.isPinavailablePromo();
		Assert.assertTrue("Item is saved successfully", generalInfo.isItemSavedSuccessfully());
	}

	@Then("Fill the general information of promotion to be created and upload Already Participated assests")
	public void generalInformationPromotionAlreadyParticipatedAssets() throws AutomationException, IOException {
		generalInfo.enterPromotionName();
		generalInfo.enterDescription();
		generalInfo.enterPriority();
		generalInfo.enterStartDataAndTime();
		generalInfo.enterEndDataAndTime();
		generalInfo.enterDailyTime();
		generalInfo.uploadPromotionListImage();
		generalInfo.clickCreatebtn();
		Assert.assertTrue("Item is saved successfully", generalInfo.isItemSavedSuccessfully());
		asset.clickAssetsTab();
		asset.isGlobeavailableAlready();
		asset.clickEditAlreadyParticipatedAsset();
		asset.navigateToAssetFrame();
		asset.enterAssetDescription();
		asset.uploadAssetPromoAlreadyParticipated();
		asset.checkInheritSettingsXpath();
		asset.timeoutSeconds();
		asset.checkinheritTimeToXpath();
		asset.selectTimeOutTo();
		asset.clickSave();
		asset.navigateBackToAsset();
		asset.isPinavailableAlready();
		Assert.assertTrue("Item is saved successfully", generalInfo.isItemSavedSuccessfully());
	}

	@Then("Fill the general information of promotion to be created and upload No Qualification assests")
	public void generalInformationNoQualificationAssets() throws AutomationException, IOException {
		generalInfo.enterPromotionName();
		generalInfo.enterDescription();
		generalInfo.enterPriority();
		generalInfo.enterStartDataAndTime();
		generalInfo.enterEndDataAndTime();
		generalInfo.enterDailyTime();
		generalInfo.uploadPromotionListImage();
		generalInfo.clickCreatebtn();
		Assert.assertTrue("Item is saved successfully", generalInfo.isItemSavedSuccessfully());
		asset.clickAssetsTab();
		asset.isGlobeavailableNoQuali();
		asset.clickNoQualificationAsset();
		asset.navigateToAssetFrame();
		asset.enterAssetDescription();
		asset.uploadAssetNoQualification();
		asset.checkInheritSettingsXpath();
		asset.timeoutSeconds();
		asset.checkinheritTimeToXpath();
		asset.selectTimeOutTo();
		asset.clickSave();
		asset.navigateBackToAsset();
		asset.isPinavailableNoQuali();
		Assert.assertTrue("Item is saved successfully", generalInfo.isItemSavedSuccessfully());
	}

	@Then("Fill the general information of promotion to be created and upload Out Of Prizes assests")
	public void generalInformationOutOfPrizesAssets() throws AutomationException, IOException {
		generalInfo.enterPromotionName();
		generalInfo.enterDescription();
		generalInfo.enterPriority();
		generalInfo.enterStartDataAndTime();
		generalInfo.enterEndDataAndTime();
		generalInfo.enterDailyTime();
		generalInfo.uploadPromotionListImage();
		generalInfo.clickCreatebtn();
		Assert.assertTrue("Item is saved successfully", generalInfo.isItemSavedSuccessfully());
		asset.clickAssetsTab();
		asset.isGlobeavailableOutOf();
		asset.clickEditOutOfPrizesAsset();
		asset.navigateToAssetFrame();
		asset.enterAssetDescription();
		asset.uploadAssetOutOfPrizes();
		asset.checkInheritSettingsXpath();
		asset.timeoutSeconds();
		asset.checkinheritTimeToXpath();
		asset.selectTimeOutTo();
		asset.clickSave();
		asset.navigateBackToAsset();
		asset.isPinavailableOutOf();
		Assert.assertTrue("Item is saved successfully", generalInfo.isItemSavedSuccessfully());
	}

	@And("Fill the enrollment details for the promotion")
	public void enrollmentInfo() throws AutomationException, IOException {
		enroll.getPromotionId();
		enroll.getPromotionName();
		enroll.clickOpenToAll();
		enroll.clickTierButton();
		enroll.clickUnlimitedSwipes();
		enroll.clickSaveButton();
//		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());
	}

	@And("Fill the enrollment details for the promotion with Demographics Birthday Days Before and Days After")
	public void enrollmentDemographicsDaysBefore() throws AutomationException, IOException {
		enroll.getPromotionId();
		enroll.getPromotionName();
		enroll.clickDemographics();
		enroll.clickTierButton();
		enroll.clickDaysbefore();
		enroll.fillDaysBeforeText();
		enroll.fillDaysAfterText();
		enroll.fillWithinText();
		enroll.sameMonthAnniv();
		enroll.conditionTimes();
		enroll.selectCondition();
		enroll.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());
	}

	@And("Fill the enrollment details for the promotion with Demographics Birthday Age Between")
	public void enrollmentDemographicsAgeBetween() throws AutomationException, IOException {
		enroll.getPromotionId();
		enroll.getPromotionName();
		enroll.clickDemographics();
		enroll.clickTierButton();
		enroll.clickBirthdayAge();
		enroll.fillbirthdayAgeFromText();
		enroll.fillbirthdayAgeToText();
		enroll.fillWithinText();
		enroll.clickAnnivDays();
		enroll.annivDaysBefore();
		enroll.annivDaysAfter();
		enroll.clickTimesPerRadio();
		enroll.selectConditionPerTime();
		enroll.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());
	}

	@And("Fill the enrollment details for the promotion with Import PlayerID")
	public void enrollmentPlayerId() throws AutomationException, IOException {
		enroll.getPromotionId();
		enroll.getPromotionName();
		enroll.clickImportPlayer();
		enroll.enterPlayerIdNumbers();
//		enroll.clickTierButton();
		enroll.clickUnlimitedSwipes();
		enroll.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());
		enroll.isPlayerImported();
	}

	@And("Fill the enrollment details for the promotion with OpenToAll for promo")
	public void enrollmentPlayerIdPromo() throws AutomationException, IOException {
		enroll.getPromotionId();
		enroll.getPromotionName();
		enroll.clickOpenToAll();
		enroll.clickUnlimitedSwipes();
		enroll.clickSaveButton();
	}
	
	@And("Fill the enrollment details for the promotion with Exclude PlayerID")
	public void enrollmentExcludePlayerId() throws AutomationException, IOException {
		enroll.getPromotionId();
//		enroll.clickImportPlayer();
//		enroll.enterPlayerIdNumbers();
//		enroll.clickTierButton();
//		enroll.clickUnlimitedSwipes();
//		enroll.clickSaveButton();
//		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());
//		enroll.isPlayerImported();
//		enroll.getImportedValue();
		enroll.clickOpenToAllExcluded();
		enroll.enterPlayerIdNumbersToExclude();
		enroll.clickUnlimitedSwipes();
		enroll.clickSaveButton();
//		enroll.isPlayerImported();
//		enroll.getImportedValue();

	}

	@And("Fill the add qualification values")
	public void enrollmentAddQualification() throws AutomationException, IOException {
		enroll.getPromotionId();
		enroll.clickOpenToAll();
		enroll.clickTierButton();
		enroll.clickaddQualification();
		enroll.selectQualification();
		enroll.clickPredifinedRange();
		enroll.selectPredefined();
		enroll.enteramount();
		enroll.clickUnlimitedSwipes();
		enroll.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());

	}

	@And("Fill the add qualification values with LifeTime")
	public void enrollmentAddQualificationLifeTime() throws AutomationException, IOException {
		enroll.getPromotionId();
		enroll.clickOpenToAll();
		enroll.clickTierButton();
		enroll.clickaddQualification();
		enroll.selectQualification();
		enroll.clickLifeTime();
		enroll.enteramount();
		enroll.clickUnlimitedSwipes();
		enroll.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());
	}

	@And("Fill the add qualification values again with Or")
	public void enrollmentAddQualificationAgain() throws AutomationException, IOException {
		enroll.clickaddQualification();
		enroll.threadWait(1000);
		enroll.clickOnOr();
		enroll.threadWait(1000);
		enroll.selectQualificationAgain();
		enroll.clickLifeTimeAgain();
		enroll.enteramountAgain();
		enroll.clickSaveButton();
	}

	@And("Fill the add qualification values again with and")
	public void enrollmentAddQualificationAgainAnd() throws AutomationException, IOException {
		enroll.clickaddQualification();
		enroll.threadWait(1000);
		enroll.clickOnAnd();
		enroll.threadWait(1000);
		enroll.selectQualificationAgain();
		enroll.clickLifeTimeAgain();
		enroll.enteramountAgain();
		enroll.clickSaveButton();
	}

	@And("Add Time Based Disbursement")
	public void createPrizeTime() throws AutomationException, IOException {
		prize.threadWait(2000);
		prize.clickPrizeDropDown();
		prize.enterPrizeStartDateAndTime();
		prize.enterPrizeEndDateAndTime();
		prize.enterDailyTime();
		prize.threadWait(1000);
		prize.enterStopPrize();
		prize.threadWait(1000);
		prize.clickAddDisbursement();
		prize.threadWait(1000);
		Assert.assertTrue("Prizes successfully created", enroll.isItemSavedSuccessfully());
	}

	@And("Upload prizes from excel")
	public void uploadPrize() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.threadWait(2000);
		prize.clickuploadPrize();
		prize.navigateToPrizeFrame();
		prize.clickChooseValidFile();
		prize.clickuploadbutton();
		prize.threadWait(2000);
		prize.clickSavePrize();
	}

	@And("Create Prizes, Coupons and Vouchers type prize")
	public void createPrizesCouponsVoucherTypePrize() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.clickPrintReceipt();
		prize.enterReceiptMessage();
		prize.enterScreenMessage();
		prize.choosePrizeType();
		prize.enterPrizeValue();
		prize.enterRedemptionCode();
		prize.maxTimeToClaim();
		prize.threadWait(2000);
		prize.uploadPrizeScreen();
		prize.threadWait(2000);
		prize.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());

	}

	@And("Create Prize Choice type prize")
	public void createPrizeChoice() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.clickPrintReceipt();
		prize.enterReceiptMessage();
		prize.enterScreenMessage();
		prize.choosePrizeType();
		prize.threadWait(1000);
		prize.enterPrizeValuePrizeChoice();
		prize.threadWait(2000);
		prize.clickAddSubPrize();
		prize.threadWait(2000);
		prize.enterPrizeNameSubPrize();
		prize.enterprizeScreenMsgSubPrize();
		prize.clickPrintReceiptSubPrize();
		prize.enterReceiptMessageSubPrize();
		prize.threadWait(2000);
//		prize.choosePrizeTypeSubPrize();
		prize.choosePrizeTypeSubPrizes();
		prize.threadWait(2000);
		prize.enterPrizeValueSubPrize();
		prize.enterPrizeRedeemSubPrize();
		prize.clickAddSubPrize();
		prize.enterPrizeNameSubPrize2();
		prize.enterprizeScreenMsgSubPrize2();
		prize.clickPrintReceiptSubPrize2();
		prize.enterReceiptMessageSubPrize2();
		prize.choosePrizeTypeSubPrize2();
		prize.threadWait(2000);
		prize.enterPrizeValueSubPrize2();
		prize.enterPrizeRedeemSubPrize2();
		prize.uploadPrizeScreen();
		prize.threadWait(2000);
		prize.clickSaveButton();
	}

	@And("Create Prize Point Deduct type prize")
	public void createPrizePointDeduct() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.clickPrintReceipt();
		prize.enterReceiptMessage();
		prize.enterScreenMessage();
		prize.choosePrizeType();
		prize.enterPrizeValue();
		prize.enterRedemptionCode();
		prize.threadWait(2000);
		prize.uploadPrizeScreen();
		prize.threadWait(2000);
		prize.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());

	}

	@And("Create Prize Comp Add type prize")
	public void createPrizeCompAdd() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.clickPrintReceipt();
		prize.enterReceiptMessage();
		prize.enterScreenMessage();
		prize.choosePrizeType();
		prize.enterPrizeValue();
		prize.enterRedemptionCode();
		prize.threadWait(2000);
		prize.uploadPrizeScreen();
		prize.threadWait(2000);
		prize.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());

	}

	@And("Create Prize Comp Deduct type prize")
	public void createPrizeCompDeduct() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.clickPrintReceipt();
		prize.enterReceiptMessage();
		prize.enterScreenMessage();
		prize.choosePrizeType();
		prize.enterPrizeValue();
		prize.enterRedemptionCode();
		prize.threadWait(2000);
		prize.uploadPrizeScreen();
		prize.threadWait(2000);
		prize.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());

	}

	@And("Create Prize Slot Free Play type prize")
	public void createPrizeSlotFreePlay() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.clickPrintReceipt();
		prize.enterReceiptMessage();
		prize.enterScreenMessage();
		prize.choosePrizeType();
		prize.enterPrizeValue();
		prize.enterRedemptionCode();
		prize.costValue();
		prize.threadWait(2000);
		prize.expiresIn();
		prize.threadWait(2000);
		prize.uploadPrizeScreen();
		prize.threadWait(2000);
		prize.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());
	}

	@And("Create Prize Package type prize")
	public void createPrizePackage() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.clickPrintReceipt();
		prize.enterReceiptMessage();
		prize.enterScreenMessage();
		prize.choosePrizeType();
		prize.threadWait(1000);
		prize.enterPrizeValuePrizePackage();
		prize.threadWait(2000);
		prize.clickAddButton();
		prize.navigateToPrizePackageFrame();
		prize.threadWait(2000);
		prize.enterPrizePackageName();
		prize.clickPrintReceiptPrizePackage();
		prize.enterReceiptMessagePrizePackage();
		prize.choosePrizeTypePrizePackage();
		prize.threadWait(2000);
		prize.enterPrizeValuePrizePackageWindow();
		prize.enterPrizeRedeemPrizePackage();
		prize.clickAddButtonWindow();
		prize.threadWait(3000);
		prize.uploadPrizeScreenPrizePackage();
		prize.threadWait(2000);
		prize.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());
	}

	@And("Create Prize Drawing Entry type prize")
	public void createPrizeDrawingEntry() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.clickPrintReceipt();
		prize.enterReceiptMessage();
		prize.enterScreenMessage();
		prize.choosePrizeType();
		prize.selectDrawingEntry();
		prize.enterNoOfEntries();
		prize.threadWait(2000);
		prize.uploadPrizeScreen();
		prize.threadWait(2000);
		prize.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());
	}

	@And("Create Prize Point Multiplier type prize")
	public void createPointMultiplier() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.clickPrintReceipt();
		prize.enterReceiptMessage();
		prize.enterScreenMessage();
		prize.choosePrizeType();
		prize.selectMultiplyPeriod();
		prize.enterMultiplier();
		prize.enterPointLimit();
		prize.selectApplyTo();
		prize.machineGroup();
		prize.clickMultiplyPoints();
		prize.threadWait(2000);
		prize.uploadPrizeScreen();
		prize.threadWait(2000);
		prize.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());
	}

	@And("Create Prize Promotion Enrollment type prize")
	public void createPromotionEnrollment() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.clickPrintReceipt();
		prize.enterReceiptMessage();
		prize.enterScreenMessage();
		prize.choosePrizeType();
		prize.selectPromo();
		prize.clickUseQualificationsPrize();
		prize.enterQualificationStartDataAndTimePrize();
		prize.threadWait(2000);
		prize.enterQualificationEndDataAndTimePrize();
		prize.threadWait(2000);
		prize.enterLimitPerCustomer();
		prize.threadWait(2000);
		prize.enterLimitPerTimes();
		prize.threadWait(2000);
		prize.uploadPrizeScreen();
		prize.threadWait(2000);
		prize.clickSaveButton();
		prize.threadWait(2000);
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());
	}

	@And("Create a new Prize Promotion Enrollment type prize")
	public void createPromotionEnrollmentPromo() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.clickPrintReceipt();
		prize.enterReceiptMessage();
		prize.enterScreenMessage();
		prize.choosePrizeTypePromo();
		prize.selectPromoPromo();
		prize.threadWait(2000);
		prize.uploadPrizeScreen();
		prize.threadWait(2000);
		prize.clickSaveButton();
		prize.threadWait(2000);
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());
	}

	@And("Create Prize Choice type prize multiple times")
	public void createPrizeChoiceMultiple() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.clickPrintReceipt();
		prize.enterReceiptMessage();
		prize.enterScreenMessage();
		prize.choosePrizeType();
		prize.threadWait(1000);
		prize.enterPrizeValuePrizeChoice();
		prize.threadWait(2000);
		prize.clickAddSubPrize();
		prize.threadWait(2000);
		prize.enterPrizeNameSubPrize();
		prize.enterprizeScreenMsgSubPrize();
		prize.clickPrintReceiptSubPrize();
		prize.enterReceiptMessageSubPrize();
		prize.choosePrizeTypeSubPrize();
		prize.threadWait(2000);
		prize.enterPrizeValueSubPrizeMultiple();
		prize.clickAddSubPrizeMultiple();
		prize.enterPrizeNameSubPrize2();
		prize.enterprizeScreenMsgSubPrize2();
		prize.clickPrintReceiptSubPrize2();
		prize.enterReceiptMessageSubPrize2();
		prize.threadWait(2000);
		prize.choosePrizeTypeSubPrizeMutiple();
		prize.threadWait(2000);
		prize.enterPrizeValueSubPrize2();
		prize.enterPrizeRedeemSubPrizeMultiple();
		prize.clickAddSubPrizeMultiple();
		prize.enterPrizeNameSubPrizeMultiple2();
		prize.enterprizeScreenMsgSubPrizeMultiple2();
		prize.choosePrizeTypeSubPrizeMutiple2();
		prize.threadWait(2000);
		prize.enterPrizeValueSubPrizeMultiple2();
		prize.enterPrizeRedeemSubPrize2Multiple();
		prize.threadWait(2000);
		prize.clickAddSubPrize();
		prize.threadWait(2000);
		prize.enterPrizeNameSubPrizeMultiple();
		prize.enterprizeScreenMsgSubPrizeMultiple();
		prize.choosePrizeTypeSubPrize2Mutiple();
		prize.threadWait(2000);
		prize.enterPrizeValueSubPrize2Multiple();
		prize.enterPrizeRedeemSubPrize2Multiple2();
		prize.uploadPrizeScreen();
		prize.threadWait(2000);
		prize.clickSaveButton();
	}

	@And("Upload Assign Prizes in enrollment tab with csv")
	public void assignPrizesCsv() throws AutomationException, IOException {
		generalInfo.clickEnrollmentTab();
		generalInfo.waitForPageLoaded("Enrollment Page");
		enroll.getPromotionId();
		enroll.assignPrizesButton();
		enroll.navigateToAssignPrizesFrame();
		enroll.uploadAssignCsv();
		enroll.clickSubmit();
		enroll.navigateBackToEnrollment();
		enroll.clickOpenToAll();
		enroll.clickTierButton();
		enroll.clickUnlimitedSwipes();
		enroll.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());

	}

	@And("Upload Assign Prizes in enrollment tab")
	public void assignPrizes() throws AutomationException, IOException {
		generalInfo.clickEnrollmentTab();
		generalInfo.waitForPageLoaded("Enrollment Page");
		enroll.getPromotionId();
		enroll.assignPrizesButton();
		enroll.navigateToAssignPrizesFrame();
		enroll.clickEnterText();
		enroll.enterText();
		enroll.clickSubmit();
		enroll.navigateBackToEnrollment();
		enroll.clickOpenToAll();
		enroll.clickTierButton();
		enroll.clickUnlimitedSwipes();
		enroll.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());
	}

	@And("Fill using the enrollment group with playerID")
	public void enrollmentGroupPlayerID() throws AutomationException, IOException {
		enroll.getPromotionId();
		enroll.clickUseEnrollmentGroup();
		enroll.clickPlayerID();
		enroll.clickSaveGroup();
		enroll.threadWait(1000);
		enroll.clickAddGroup();
		enroll.threadWait(2000);
		enroll.clickAddGroupName();
		enroll.addPlayerID();
		enroll.saveButton();
		enroll.threadWait(2000);
		enroll.clickAddGroup();
		enroll.threadWait(2000);
		enroll.clickAddGroupName1();
		enroll.addPlayerID1();
		enroll.saveButton();
		enroll.threadWait(2000);
		enroll.clickUnlimitedSwipes();
		enroll.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());

	}

	@And("Create a point add type prize for enrollment group")
	public void createPrizeEnrollmentGroup() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.clickGroup();
		prize.isClickGroup1Enabled();
		prize.clickPrintReceipt();
		prize.enterReceiptMessage();
		prize.enterScreenMessage();
		prize.choosePrizeType();
		prize.threadWait(1000);
		prize.enterPrizeValue();
		prize.enterRedemptionCode();
		prize.uploadPrizeScreen();
		prize.threadWait(2000);
		prize.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());

	}

	@And("Validate the filter options in the prize screen")
	public void createFilterEnrollmentGroup() throws AutomationException, IOException {
		prize.clickFilter();
		prize.selectFiler();
		prize.textPrize();
	}

	@And("Fill using the enrollment group with tier")
	public void enrollmentGroupTier() throws AutomationException, IOException {
		enroll.getPromotionId();
		enroll.clickUseEnrollmentGroup();
		enroll.threadWait(1000);
		enroll.clickTier();
		enroll.threadWait(1000);
		enroll.clickSaveGroup();
		enroll.threadWait(1000);
		enroll.clickAddGroup();
		enroll.threadWait(2000);
		enroll.clickAddGroupName();
		enroll.threadWait(1000);
		enroll.clickTier1();
		enroll.saveButton();
		enroll.threadWait(2000);
		enroll.clickAddGroup();
		enroll.threadWait(2000);
		enroll.clickAddGroupName1();
		enroll.clickTierGold();
		enroll.saveButton();
		enroll.threadWait(2000);
		enroll.clickUnlimitedSwipes();
		enroll.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());

	}

	@And("Fill using the enrollment group with qualification")
	public void enrollmentGroupQualification() throws AutomationException, IOException {
		enroll.getPromotionId();
		enroll.clickUseEnrollmentGroup();
		enroll.threadWait(1000);
		enroll.clickQualification();
		enroll.threadWait(1000);
		enroll.selectQualificationGroup();
		enroll.clickLifeTimeGroup();
		enroll.threadWait(1000);
		enroll.clickSaveGroup();
		enroll.clickAddGroup();
		enroll.threadWait(2000);
		enroll.clickAddGroupName();
		enroll.threadWait(1000);
		enroll.minValue();
		enroll.maxValue();
		enroll.saveButton();
		enroll.threadWait(2000);
		enroll.clickAddGroup();
		enroll.threadWait(2000);
		enroll.clickAddGroupName1();
		enroll.threadWait(1000);
		enroll.minValue1();
		enroll.maxValue1();
		enroll.saveButton();
		enroll.threadWait(2000);
		enroll.clickUnlimitedSwipes();
		enroll.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());
	}

	@And("Fill using the enrollment group with playerID and qualification")
	public void enrollmentGroupPlayerIDQualification() throws AutomationException, IOException {
		enroll.getPromotionId();
		enroll.clickUseEnrollmentGroup();
		enroll.clickPlayerID();
		enroll.clickQualificationGroupAdd();
		enroll.selectQualificationGroupAdd();
		enroll.clickLifeTimeGroupAdd();
		enroll.clickSaveGroup();
		enroll.threadWait(1000);
		enroll.clickAddGroup();
		enroll.threadWait(2000);
		enroll.clickAddGroupName();
		enroll.addPlayerID();
		enroll.amountAdd();
		enroll.saveButton();
		enroll.threadWait(2000);
		enroll.clickAddGroup();
		enroll.threadWait(2000);
		enroll.clickAddGroupName1();
		enroll.addPlayerID1();
		enroll.amountAdd1();
		enroll.saveButton();
		enroll.threadWait(2000);
		enroll.clickUnlimitedSwipes();
		enroll.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());

	}

	@And("Fill using the enrollment group with playerID and multiple qualification")
	public void enrollmentGroupPlayerIDQualificationMultiple() throws AutomationException, IOException {
		enroll.getPromotionId();
		enroll.clickUseEnrollmentGroup();
		enroll.clickPlayerID();
		enroll.clickQualificationGroupAdd();
		enroll.selectQualificationGroupAdd();
		enroll.clickLifeTimeGroupAdd();
		enroll.clickQualificationGroupAdd();
		enroll.selectOr();
		enroll.selectQualificationGroupAdd1();
		enroll.clickLifeTimeGroupAdd1();
		enroll.clickSaveGroup();
		enroll.threadWait(1000);
		enroll.clickAddGroup();
		enroll.threadWait(2000);
		enroll.clickAddGroupName();
		enroll.addPlayerID();
		enroll.amountAdd();
		enroll.amountAddmultiple1();
		enroll.saveButton();
		enroll.threadWait(2000);
		enroll.clickAddGroup();
		enroll.threadWait(3000);
		enroll.clickAddGroupName1();
		enroll.addPlayerID1();
		enroll.amountAdd();
		enroll.amountAddmultiple1();
		enroll.saveButton();
		enroll.threadWait(2000);
		enroll.clickUnlimitedSwipes();
		enroll.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());

	}

	@And("Fill using the enrollment group with tier and multiple qualification")
	public void enrollmentGroupTierQualificationMultiple() throws AutomationException, IOException {
		enroll.getPromotionId();
		enroll.clickUseEnrollmentGroup();
		enroll.threadWait(2000);
		enroll.clickTier();
		enroll.clickQualificationGroupAdd();
		enroll.selectQualificationGroupAdd();
		enroll.clickLifeTimeGroupAdd();
		enroll.clickQualificationGroupAdd();
		enroll.selectOr();
		enroll.selectQualificationGroupAdd1();
		enroll.clickLifeTimeGroupAdd1();
		enroll.clickSaveGroup();
		enroll.threadWait(1000);
		enroll.clickAddGroup();
		enroll.threadWait(2000);
		enroll.clickAddGroupName();
		enroll.threadWait(2000);
		enroll.clickTier1();
		enroll.amountAdd();
		enroll.amountAdd1Tier();
		enroll.saveButton();
		enroll.threadWait(2000);
		enroll.clickAddGroup();
		enroll.threadWait(2000);
		enroll.clickAddGroupName1();
		enroll.clickTierGold();
		enroll.amountAdd();
		enroll.amountAdd1Tier();
		enroll.saveButton();
		enroll.threadWait(2000);
		enroll.clickUnlimitedSwipes();
		enroll.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());

	}

	@And("Fill using the enrollment group with another tier and multiple qualification")
	public void enrollmentGroupAnotherTierQualificationMultiple() throws AutomationException, IOException {
		enroll.getPromotionId();
		enroll.clickUseEnrollmentGroup();
		enroll.threadWait(2000);
		enroll.clickTier();
		enroll.clickQualificationGroupAdd();
		enroll.selectQualificationGroupAdd();
		enroll.clickLifeTimeGroupAdd();
		enroll.clickQualificationGroupAdd();
		enroll.selectOr();
		enroll.selectQualificationGroupAdd1();
		enroll.clickLifeTimeGroupAdd1();
		enroll.clickSaveGroup();
		enroll.threadWait(1000);
		enroll.clickAddGroup();
		enroll.threadWait(2000);
		enroll.clickAddGroupName();
		enroll.threadWait(2000);
		enroll.clickTierGold();
		enroll.amountAdd();
		enroll.amountAdd1Tier();
		enroll.saveButton();
		enroll.threadWait(2000);
		enroll.clickAddGroup();
		enroll.threadWait(2000);
		enroll.clickAddGroupName1();
		enroll.clickTier1();
		enroll.amountAdd();
		enroll.amountAdd1Tier();
		enroll.saveButton();
		enroll.threadWait(2000);
		enroll.clickUnlimitedSwipes();
		enroll.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());

	}

	@And("Fill using the enrollment group with qualification and multiple qualification")
	public void enrollmentGroupQualificationQualificationMultiple() throws AutomationException, IOException {
		enroll.getPromotionId();
		enroll.clickUseEnrollmentGroup();
		enroll.threadWait(1000);
		enroll.clickQualification();
		enroll.threadWait(1000);
		enroll.selectQualificationGroup();
		enroll.clickLifeTimeGroup();
		enroll.threadWait(1000);
		enroll.clickQualificationGroupAdd();
		enroll.selectQualificationGroupAdd();
		enroll.clickLifeTimeGroupAdd();
		enroll.clickQualificationGroupAdd();
		enroll.selectOr();
		enroll.selectQualificationGroupAdd1();
		enroll.clickLifeTimeGroupAdd1();
		enroll.clickSaveGroup();
		enroll.clickAddGroup();
		enroll.threadWait(2000);
		enroll.clickAddGroupName();
		enroll.threadWait(1000);
		enroll.minValue();
		enroll.maxValue();
		enroll.amountAdd();
		enroll.amountAddmultiple1();
		enroll.saveButton();
		enroll.threadWait(2000);
		enroll.clickAddGroup();
		enroll.threadWait(2000);
		enroll.clickAddGroupName1();
		enroll.threadWait(1000);
		enroll.minValue1();
		enroll.maxValue1();
		enroll.amountAdd();
		enroll.amountAddmultiple1();
		enroll.saveButton();
		enroll.threadWait(2000);
		enroll.clickUnlimitedSwipes();
		enroll.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());

	}

	@And("Validate the Gateway call log")
	public void gatewayCallLog() throws AutomationException, IOException {
		gateway.clickGatewayTab();
		gateway.clickGatewayLink();
		gateway.threadWait(2000);
		gateway.selectMethod();
		gateway.threadWait(2000);
		gateway.clickSubmit();
		gateway.threadWait(2000);
		gateway.responseLink();
	}

	@And("Validate the Gateway call log for Demographics")
	public void gatewayCallLogDemographics() throws AutomationException, IOException {
		gateway.clickGatewayTab();
		gateway.clickGatewayLink();
		gateway.threadWait(2000);
		gateway.clickSubmit();
		gateway.threadWait(2000);
		gateway.responseLinkDemo();
	}

	@And("Validate the Gateway call log Prize Comp")
	public void gatewayCallLogPrizeComp() throws AutomationException, IOException {
		gateway.clickGatewayTab();
		gateway.clickGatewayLink();
		gateway.threadWait(2000);
		gateway.selectMethodPrizeCompAdd();
		gateway.threadWait(2000);
		gateway.clickSubmit();
		gateway.threadWait(2000);
		gateway.responseLinkPrizeCompAdd();
	}

	@And("Validate the Gateway call log for SlotFreePlay")
	public void gatewayCallLogSlotFree() throws AutomationException, IOException {
		gateway.clickGatewayTab();
		gateway.clickGatewayLink();
		gateway.threadWait(2000);
		gateway.selectMethodPrizeSlotFree();
		gateway.threadWait(2000);
		gateway.clickSubmit();
		gateway.threadWait(2000);
		gateway.responseLinkPrizeSlotFree();
	}

	@And("Create a comp deduct type prize for enrollment group")
	public void createcompdeductPrizeEnrollmentGroup() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.clickGroup();
		prize.isClickGroup1Enabled();
		prize.clickPrintReceipt();
		prize.enterReceiptMessage();
		prize.enterScreenMessage();
		prize.choosePrizeType();
		prize.threadWait(1000);
		prize.enterPrizeValue();
		prize.enterRedemptionCode();
		prize.uploadPrizeScreen();
		prize.threadWait(2000);
		prize.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());

	}

	@And("Fill using the enrollment group with playerID and not in other group and multiple qualification")
	public void enrollmentGroupPlayerIDQualificationMultipleNotOtherGroup() throws AutomationException, IOException {
		enroll.getPromotionId();
		enroll.clickUseEnrollmentGroup();
		enroll.clickPlayerID();
		enroll.clickQualificationGroupAdd();
		enroll.selectQualificationGroupAdd();
		enroll.clickLifeTimeGroupAdd();
		enroll.clickQualificationGroupAdd();
		enroll.selectOr();
		enroll.selectQualificationGroupAdd1();
		enroll.clickLifeTimeGroupAdd1();
		enroll.clickSaveGroup();
		enroll.threadWait(1000);
		enroll.clickAddGroup();
		enroll.threadWait(2000);
		enroll.clickAddGroupName();
		enroll.addPlayerID();
		enroll.amountAdd();
		enroll.amountAddmultiple1();
		enroll.saveButton();
		enroll.threadWait(2000);
		enroll.clickAddGroup();
		enroll.threadWait(2000);
		enroll.clickAddGroupName1();
		enroll.clicknotInOtherGroup();
		enroll.threadWait(2000);
		enroll.amountAdd();
		enroll.amountAddmultiple1();
		enroll.saveButton();
		enroll.threadWait(2000);
		enroll.clickUnlimitedSwipes();
		enroll.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());

	}

	@And("Validate the Player Activity Reports")
	public void playerActivityReports() throws AutomationException, IOException {
		reports.clickReportsTab();
		reports.clickPlayerActivity();
		reports.threadWait(2000);
		reports.clickSubmit();
		reports.threadWait(2000);
		reports.reportsArgs();
	}

	@And("Fill the enrollment details for the promotion with CustomQuery")
	public void enrollmentCustomQuery() throws AutomationException, IOException {
		enroll.getPromotionId();
		enroll.clickenterQueryXpath();
		enroll.enterQueryXpath();
		enroll.clickTierButton();
		enroll.clickUnlimitedSwipes();
		enroll.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());
	}

	@And("Add Advanced Configurations to reveal functionality")
	public void advancedConfig() throws AutomationException, IOException {
		advanced.clickAdvancedTab();
		advanced.clickAddInputVariable();
		advanced.enterAddVariable();
		advanced.clickStringType();
		advanced.clickAddVariableButton();
		advanced.enterrevealText();
		advanced.clickSave();

	}

	@And("Add Advanced Configurations to reveal functionality and delete")
	public void advancedConfigDelete() throws AutomationException, IOException {
		advanced.clickAdvancedTab();
		advanced.clickAddInputVariable();
		advanced.enterAddVariable();
		advanced.clickStringType();
		advanced.clickAddVariableButton();
		advanced.enterrevealText();
		advanced.clickSave();
		advanced.threadWait(1000);
		advanced.clickDeleteVariable();
		advanced.clickDeleteOkVariable();
	}

	@And("Add Advanced Configurations to prizes functionality")
	public void advancedConfigPrizes() throws AutomationException, IOException {
		advanced.clickAdvancedTab();
		advanced.clickAddInputVariable();
		advanced.enterAddVariablePrizes();
		advanced.clickAddVariableButton();
		advanced.enterPrizeText();
		advanced.threadWait(2000);
		advanced.clickSave();

	}

	@And("Add Advanced Configurations to Output functionality")
	public void advancedConfigOutput() throws AutomationException, IOException {
		advanced.clickAdvancedTab();
		advanced.clickAddOutputVariable();
		advanced.clickAddVariableButton();
		advanced.enterParticipationText();
		advanced.threadWait(2000);
		advanced.clickSave();

	}

	@And("Upload prizes from excel for PromoEnrollment with no value of prize")
	public void uploadPrizePromoEnrollment() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.threadWait(2000);
		prize.clickuploadPrize();
		prize.navigateToPrizeFrame();
		prize.clickChoosePromoEnrollInValidFile();
		prize.clickuploadbutton();
		prize.isErrorMsgVisible();
		prize.threadWait(2000);
		prize.clickcancel();
	}

	@And("Upload prizes from excel for PromoEnrollment with no promoid")
	public void uploadPrizePromoEnrollmentNoPromoid() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.threadWait(2000);
		prize.clickuploadPrize();
		prize.navigateToPrizeFrame();
		prize.clickChoosePromoEnrollNoPromoidFile();
		prize.clickuploadbutton();
		prize.isErrorMsgVisible();
		prize.threadWait(2000);
		prize.clickcancel();
	}

	@And("Upload prizes from excel for PromoEnrollment with invalid promoid")
	public void uploadPrizePromoEnrollmentInvalidPromoid() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.threadWait(2000);
		prize.clickuploadPrize();
		prize.navigateToPrizeFrame();
		prize.clickChoosePromoEnrollInvalidPromoidFile();
		prize.clickuploadbutton();
		prize.isErrorMsgVisible();
		prize.threadWait(2000);
		prize.clickcancel();
	}

	@And("Upload prizes from excel for PointAdd with No Redemption Code")
	public void uploadPrizePointAddNoRedeemCode() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.threadWait(2000);
		prize.clickuploadPrize();
		prize.navigateToPrizeFrame();
		prize.clickChoosePointAddNoRedeemCode();
		prize.clickuploadbutton();
		prize.isErrorMsgVisible();
		prize.threadWait(2000);
		prize.clickcancel();
	}

	@And("Upload prizes from excel for Prize Package")
	public void uploadPrizePackage() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.threadWait(2000);
		prize.clickuploadPrize();
		prize.navigateToPrizeFrame();
		prize.clickChoosePrizePackage();
		prize.clickuploadbutton();
		prize.threadWait(2000);
		prize.clickSavePrize();
	}

	@And("Upload prizes from excel for Prize with Enrollment Groups")
	public void uploadPrizeEnrollmentGroups() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.threadWait(2000);
		prize.clickuploadPrize();
		prize.navigateToPrizeFrame();
		prize.clickChooseEnrollmentGroups();
		prize.clickuploadbutton();
		prize.threadWait(2000);
		prize.clickSavePrize();
	}

	@And("Validate the Prize Distribution Reports")
	public void prizeDistributionReports() throws AutomationException, IOException {
		prizeReport.clickReportsTab();
		prizeReport.clickPrizeDistribution();
		prizeReport.threadWait(2000);
		prizeReport.clickSubmit();
		prizeReport.prizeArgs();
	}

	@Then("Fill the general information of promotion to be created and upload Universal Prize Assets")
	public void generalInformationPromotionUniversalPrizeAssets() throws AutomationException, IOException {
		generalInfo.enterPromotionName();
		generalInfo.enterDescription();
		generalInfo.enterPriority();
		generalInfo.enterStartDataAndTime();
		generalInfo.enterEndDataAndTime();
		generalInfo.enterDailyTime();
		generalInfo.uploadPromotionListImage();
		generalInfo.clickCreatebtn();
		Assert.assertTrue("Item is saved successfully", generalInfo.isItemSavedSuccessfully());
		asset.clickAssetsTab();
		asset.isGlobeavailableUniversal();
		asset.clickEditUniversalPrizesAsset();
		asset.navigateToAssetFrame();
		asset.enterAssetDescription();
		asset.uploadAssetUniversalPrize();
		asset.checkInheritSettingsXpath();
		asset.timeoutSeconds();
		asset.checkinheritTimeToXpath();
		asset.selectTimeOutTo();
		asset.clickSave();
		asset.navigateBackToAsset();
		asset.isPinavailableUniversal();
		Assert.assertTrue("Item is saved successfully", generalInfo.isItemSavedSuccessfully());
	}

	@And("Create Prize Package type prize with multiple sub prizes with no print receipts")
	public void createPrizePackageSubPrize() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.enterScreenMessage();
		prize.choosePrizeType();
		prize.threadWait(1000);
		prize.enterPrizeValuePrizePackage();
		prize.threadWait(2000);
		prize.clickAddButton();
		prize.navigateToPrizePackageFrame();
		prize.threadWait(2000);
		prize.enterPrizePackageName();
//		prize.clickPrintReceiptPrizePackage();
//		prize.enterReceiptMessagePrizePackage();
		prize.threadWait(2000);
		prize.choosePrizeTypePrizePackage();
		prize.threadWait(2000);
		prize.enterPrizeValuePrizePackageWindow();
		prize.enterPrizeRedeemPrizePackage();
		prize.threadWait(1000);
		prize.clickAddButtonWindow();
		prize.threadWait(2000);
		prize.navigateBackToPrize();
		prize.clickAddButtonAgain();
		prize.navigateToPrizePackageFrame();
		prize.threadWait(2000);
		prize.enterPrizePackageNameMultiple();
		prize.threadWait(2000);
		prize.choosePrizeTypePrizePackageMultiple();
		prize.enterPrizeValuePrizePackageWindow();
		prize.enterPrizeRedeemPrizePackage();
		prize.clickAddButtonWindow();
		prize.threadWait(2000);
		prize.navigateBackToPrize();
		prize.uploadPrizeScreenPrizePackage();
		prize.threadWait(2000);
		prize.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());
	}

	@And("Create Prize Package type prize with multiple sub prizes with print receipts for subprizes")
	public void createPrizePackageSubPrizeWithPrint() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.enterScreenMessage();
		prize.choosePrizeType();
		prize.threadWait(1000);
		prize.enterPrizeValuePrizePackage();
		prize.threadWait(2000);
		prize.clickAddButton();
		prize.navigateToPrizePackageFrame();
		prize.threadWait(2000);
		prize.enterPrizePackageName();
		prize.clickPrintReceiptPrizePackage();
		prize.enterReceiptMessagePrizePackage();
		prize.threadWait(2000);
		prize.choosePrizeTypePrizePackage();
		prize.threadWait(2000);
		prize.enterPrizeValuePrizePackageWindow();
		prize.enterPrizeRedeemPrizePackage();
		prize.threadWait(1000);
		prize.clickAddButtonWindow();
		prize.threadWait(2000);
		prize.navigateBackToPrize();
		prize.clickAddButtonAgain();
		prize.navigateToPrizePackageFrame();
		prize.threadWait(2000);
		prize.enterPrizePackageNameMultiple();
		prize.clickPrintReceiptPrizePackage();
		prize.enterReceiptMessagePrizePackage();
		prize.threadWait(2000);
		prize.choosePrizeTypePrizePackageMultiple();
		prize.enterPrizeValuePrizePackageWindow();
		prize.enterPrizeRedeemPrizePackage();
		prize.clickAddButtonWindow();
		prize.threadWait(2000);
		prize.navigateBackToPrize();
		prize.uploadPrizeScreenPrizePackage();
		prize.threadWait(2000);
		prize.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());
	}

	@And("Create Prize Package type prize with multiple sub prizes with print receipts for all")
	public void createPrizePackageSubPrizeWithPrintAll() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.clickPrintReceipt();
		prize.enterReceiptMessage();
		prize.enterScreenMessage();
		prize.choosePrizeType();
		prize.threadWait(1000);
		prize.enterPrizeValuePrizePackage();
		prize.threadWait(2000);
		prize.clickAddButton();
		prize.navigateToPrizePackageFrame();
		prize.threadWait(2000);
		prize.enterPrizePackageName();
		prize.clickPrintReceiptPrizePackage();
		prize.enterReceiptMessagePrizePackage();
		prize.threadWait(2000);
		prize.choosePrizeTypePrizePackage();
		prize.threadWait(2000);
		prize.enterPrizeValuePrizePackageWindow();
		prize.enterPrizeRedeemPrizePackage();
		prize.threadWait(1000);
		prize.clickAddButtonWindow();
		prize.threadWait(2000);
		prize.navigateBackToPrize();
		prize.clickAddButtonAgain();
		prize.navigateToPrizePackageFrame();
		prize.threadWait(2000);
		prize.enterPrizePackageNameMultiple();
		prize.clickPrintReceiptPrizePackage();
		prize.enterReceiptMessagePrizePackage();
		prize.threadWait(2000);
		prize.choosePrizeTypePrizePackageMultiple();
		prize.enterPrizeValuePrizePackageWindow();
		prize.enterPrizeRedeemPrizePackage();
		prize.clickAddButtonWindow();
		prize.threadWait(2000);
		prize.navigateBackToPrize();
		prize.uploadPrizeScreenPrizePackage();
		prize.threadWait(2000);
		prize.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());
	}

	@And("Create Prize Package type prize with multiple sub prizes with edit receipt")
	public void createPrizePackageSubPrizeWithEditReceipt() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.clickPrintReceipt();
		prize.enterReceiptMessage();
		prize.enterScreenMessage();
		prize.choosePrizeType();
		prize.threadWait(1000);
		prize.enterPrizeValuePrizePackage();
		prize.threadWait(2000);
		prize.clickAddButton();
		prize.navigateToPrizePackageFrame();
		prize.threadWait(2000);
		prize.enterPrizePackageName();
		prize.clickPrintReceiptPrizePackage();
		prize.enterReceiptMessagePrizePackage();
		prize.threadWait(2000);
		prize.choosePrizeTypePrizePackage();
		prize.threadWait(2000);
		prize.enterPrizeValuePrizePackageWindow();
		prize.enterPrizeRedeemPrizePackage();
		prize.threadWait(1000);
		prize.clickAddButtonWindow();
		prize.threadWait(2000);
		prize.navigateBackToPrize();
		prize.clickAddButtonAgain();
		prize.navigateToPrizePackageFrame();
		prize.threadWait(2000);
		prize.enterPrizePackageNameMultiple();
		prize.clickPrintReceiptPrizePackage();
		prize.enterReceiptMessagePrizePackage();
		prize.threadWait(2000);
		prize.choosePrizeTypePrizePackageMultiple();
		prize.enterPrizeValuePrizePackageWindow();
		prize.enterPrizeRedeemPrizePackage();
		prize.clickAddButtonWindow();
		prize.threadWait(2000);
		prize.navigateBackToPrize();
		prize.uploadPrizeScreenPrizePackage();
		prize.threadWait(2000);
		prize.clickSaveButton();
		prize.clickPrizeCreated();
		prize.threadWait(2000);
		prize.clickEditReceipt();
		prize.threadWait(2000);
		prize.clickParticipationDate();
		prize.clickSavePrize();
	}

	@And("Create Prize Package type prize with multiple sub prizes with edit prize")
	public void createPrizePackageSubPrizeWithEditPrize() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.clickPrintReceipt();
		prize.enterReceiptMessage();
		prize.enterScreenMessage();
		prize.choosePrizeType();
		prize.threadWait(1000);
		prize.enterPrizeValuePrizePackage();
		prize.threadWait(2000);
		prize.clickAddButton();
		prize.navigateToPrizePackageFrame();
		prize.threadWait(2000);
		prize.enterPrizePackageName();
		prize.clickPrintReceiptPrizePackage();
		prize.enterReceiptMessagePrizePackage();
		prize.threadWait(2000);
		prize.choosePrizeTypePrizePackage();
		prize.threadWait(2000);
		prize.enterPrizeValuePrizePackageWindow();
		prize.enterPrizeRedeemPrizePackage();
		prize.threadWait(1000);
		prize.clickAddButtonWindow();
		prize.threadWait(2000);
		prize.navigateBackToPrize();
		prize.clickAddButtonAgain();
		prize.navigateToPrizePackageFrame();
		prize.threadWait(2000);
		prize.enterPrizePackageNameMultiple();
		prize.clickPrintReceiptPrizePackage();
		prize.enterReceiptMessagePrizePackage();
		prize.threadWait(2000);
		prize.choosePrizeTypePrizePackageMultiple();
		prize.enterPrizeValuePrizePackageWindow();
		prize.enterPrizeRedeemPrizePackage();
		prize.clickAddButtonWindow();
		prize.threadWait(2000);
		prize.navigateBackToPrize();
		prize.uploadPrizeScreenPrizePackage();
		prize.threadWait(2000);
		prize.clickSaveButton();
		prize.clickPrizeCreated();
		prize.threadWait(2000);
		prize.clickEditPrize();
		prize.navigateToPrizePackageFrame();
		prize.clickDisabledButton();
		prize.update();
		prize.threadWait(2000);
		prize.navigateBackToPrize();
		prize.clickSaveButton();

	}

	@And("Create Prize Package type prize with no sub prizes")
	public void createPrizePackageNoSubPrize() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.clickPrintReceipt();
		prize.enterReceiptMessage();
		prize.enterScreenMessage();
		prize.choosePrizeType();
		prize.threadWait(1000);
		prize.enterPrizeValuePrizePackage();
		prize.threadWait(2000);
		prize.uploadPrizeScreenPrizePackage();
		prize.threadWait(2000);
		prize.clickSaveButton();
		prize.isErrorMsg();
	}

	@And("Fill the add qualification values with LifeTime and participation")
	public void enrollmentAddQualificationLifeTimeParticipation() throws AutomationException, IOException {
		enroll.getPromotionId();
		enroll.clickOpenToAll();
		enroll.clickTierButton();
		enroll.clickaddQualification();
		enroll.selectQualification();
		enroll.clickLifeTime();
		enroll.enteramount();
		enroll.selectTimesPerPeriod();
		enroll.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());
	}

	@And("Fill the general information of promotion to be created with period")
	public void generalInformationPeriod() throws AutomationException, IOException {
		generalInfo.enterPromotionName();
		generalInfo.enterDescription();
		generalInfo.enterPriority();
		generalInfo.enterStartDataAndTime();
		generalInfo.enterEndDataAndTime();
		generalInfo.clickAddPeriod();
		generalInfo.enterStartDataAndTimePeriod();
		generalInfo.enterEndDataAndTimePeriod();
		generalInfo.enterDailyTime();
		generalInfo.uploadPromotionListImage();
		generalInfo.clickCreatebtn();
		generalInfo.clickEnrollmentTab();
		generalInfo.waitForPageLoaded("Enrollment Page");
	}

	@And("Validate the Gateway call log for Promotion")
	public void gatewayCallLogPromo() throws AutomationException, IOException {
		gateway.clickGatewayTab();
		gateway.clickGatewayLink();
		gateway.threadWait(2000);
		gateway.clickSubmit();
		gateway.getValueOfLog();
	}

	@And("Fill the add qualification values with LifeTime and participation promo")
	public void enrollmentAddQualificationLifeTimeParticipationDay() throws AutomationException, IOException {
		enroll.getPromotionId();
		enroll.clickOpenToAll();
		enroll.clickTierButton();
		enroll.clickaddQualification();
		enroll.selectQualification();
		enroll.clickLifeTime();
		enroll.enteramount();
		enroll.selectTimesPerPromo();
		enroll.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());
	}

	@And("Fill the add qualification values with LifeTime and participation day")
	public void enrollmentAddQualificationLifeTimeDay() throws AutomationException, IOException {
		enroll.getPromotionId();
		enroll.clickOpenToAll();
		enroll.clickTierButton();
		enroll.clickaddQualification();
		enroll.selectQualification();
		enroll.clickLifeTime();
		enroll.enteramount();
		enroll.clickTimesPerRadio();
		enroll.clickSaveButton();
		Assert.assertTrue("Item successfully saved", enroll.isItemSavedSuccessfully());
	}

	@And("Validate the Audit Report")
	public void auditReport() throws AutomationException, IOException {
		audit.clickReportsTab();
		audit.clickAuditReport();
		audit.threadWait(2000);
		audit.clickSearch();
		audit.threadWait(2000);
		audit.createField();
	}

	@And("Create a point add type prize with qualification")
	public void createPromotionPrizeQualification() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.clickPrintReceipt();
		prize.enterReceiptMessage();
		prize.enterScreenMessage();
		prize.choosePrizeType();
		prize.threadWait(1000);
		prize.enterPrizeValue();
		prize.enterRedemptionCode();
		prize.clickUseQualificationsPrize();
		prize.enterQualificationStartDataAndTimePrize();
		prize.threadWait(2000);
		prize.enterQualificationEndDataAndTimePrize();
		prize.threadWait(2000);
		prize.enterLimitPerCustomer();
		prize.threadWait(2000);
		prize.uploadPrizeScreen();
		prize.threadWait(2000);
		prize.clickSaveButton();
		prize.threadWait(2000);
	}

	@And("Create a point add type prize with qualification start date greater")
	public void createPromotionPrizeQualificationStartDate() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.clickPrintReceipt();
		prize.enterReceiptMessage();
		prize.enterScreenMessage();
		prize.choosePrizeType();
		prize.threadWait(1000);
		prize.enterPrizeValue();
		prize.enterRedemptionCode();
		prize.clickUseQualificationsPrize();
		prize.enterQualificationStartDataAndTimePrize();
		prize.threadWait(2000);
		prize.enterQualificationEndDataAndTimePrize();
		prize.threadWait(2000);
		prize.enterLimitPerCustomer();
		prize.threadWait(2000);
		prize.uploadPrizeScreen();
		prize.threadWait(2000);
		prize.clickSaveButton();
		prize.threadWait(2000);
		Assert.assertTrue("Start date should be before end date", generalInfo.isInvalidTimeErrorPresent());

	}

	@And("Create a point add type prize with qualification start time greater")
	public void createPromotionPrizeQualificationStartTime() throws AutomationException, IOException {
		enroll.clickPrizesTab();
		enroll.waitForPageLoaded("Prizes Page");
		prize.clickCreateNewPrize();
		prize.enterPrizeName();
		prize.enterPrizeLine1();
		prize.enterPrizeLine2();
		prize.enterPrizeIdentifier();
		prize.enterQuantity();
		prize.clickEnforceQuantity();
		prize.clickPrintReceipt();
		prize.enterReceiptMessage();
		prize.enterScreenMessage();
		prize.choosePrizeType();
		prize.threadWait(1000);
		prize.enterPrizeValue();
		prize.enterRedemptionCode();
		prize.clickUseQualificationsPrize();
		prize.enterQualificationStartDataAndTimePrize();
		prize.threadWait(2000);
		prize.enterQualificationEndDataAndTimePrize();
		prize.threadWait(2000);
		prize.enterLimitPerCustomer();
		prize.threadWait(2000);
		prize.uploadPrizeScreen();
		prize.threadWait(2000);
		prize.clickSaveButton();
		prize.threadWait(2000);
		Assert.assertTrue("Start date should be before end date", generalInfo.isInvalidTimeErrorPresent());

	}
	
	@And("Fill the general information of promotion to be created for promo")
	public void generalInformationPromo() throws AutomationException, IOException {
		generalInfo.enterPromotionNamePromo();
		generalInfo.enterDescription();
		generalInfo.enterPriority();
		generalInfo.enterStartDataAndTime();
		generalInfo.enterEndDataAndTime();
		generalInfo.enterDailyTime();
		generalInfo.uploadPromotionListImage();
		generalInfo.clickCreatebtn();
		generalInfo.clickEnrollmentTab();
		generalInfo.waitForPageLoaded("Enrollment Page");
	}
	
	@And("Validate the playerID in PromoList")
	public void playerIDPromo() throws AutomationException, IOException {
		home.clickPromotionsTopNav();
		home.clickPromotionMenu();
		home.clickPromotionList();
		home.clickPromoName();
		home.scrollToPromoPlayers();
	}
}
