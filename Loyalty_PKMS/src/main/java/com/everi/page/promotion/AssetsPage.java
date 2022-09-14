package com.everi.page.promotion;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.everi.Enum.LocatorType;
import com.everi.Helper.GlobalVariables;
import com.everi.exception.AutomationException;
import com.everi.page.BasePage;
//import com.thoughtworks.selenium.webdriven.commands.GetCssCount;

public class AssetsPage extends BasePage {

	static Logger logger = LogManager.getLogger(AssetsPage.class);
	public static String promotionId;
	WebDriver webDriver = GlobalVariables.webDriver;

	private final String assetsTabXpath = "//a[contains(@href,'PromotionAssets')]";
	private final String editMainAsset = "SiteMaster_MainContent_gvAssets_ctl02_lbEditAsset";
	private final String assetDescription = "ctl00_MainContent_tbDescription";
	private final String assetUpload = "ctl00_MainContent_fuAsset";
	private final String inheritSettingsXpath = "(//*[@id=\"ctl00_MainContent_cbInheritParentTimeout\"]/../label/span)[1]";
	private final String timeoutSeconds = "ctl00_MainContent_tbTimeout";
	private final String saveId = "ctl00_MainContent_lbSaveAsset";
	private final String useDefaultId = "SiteMaster_MainContent_gvAssets_ctl02_lbUseDefault";
	private final String invalidAssestWarningmsg = "(//*[@id=\"ctl00_MainContent_fuAsset\"]/../span)[1]";
	private final String moreTimeXpath = "(//*[@id=\"ctl00_MainContent_cbShowNeedMoreTime\"]/../label/span)[1]";
	private final String addGroupBtnId = "SiteMaster_MainContent_PromotionEnrollmentGroup_lbAddGroup";
	private final String addGroupNameId = "SiteMaster_MainContent_PromotionEnrollmentGroup_tbGroupName";
	private final String addPlayerIdToGroup = "SiteMaster_MainContent_PromotionEnrollmentGroup_tbIds";
	private final String saveGroupInfoId = "SiteMaster_MainContent_PromotionEnrollmentGroup_lbSave";
	private final String useEnrollmentXpath = "//label[@for='SiteMaster_MainContent_cbEnrollmentPromotionGroup']/span";
	private final String promotionNameId = "SiteMaster_ContentHeaderContent_lPromotionName";
	private final String promoNotAvailable = "SiteMaster_MainContent_gvAssets_ctl03_lbEditAsset";
	private final String alreadyParticipated = "SiteMaster_MainContent_gvAssets_ctl04_lbEditAsset";
	private final String noqualification = "SiteMaster_MainContent_gvAssets_ctl05_lbEditAsset";
	private final String outOfPrizes = "SiteMaster_MainContent_gvAssets_ctl06_lbEditAsset";
	private final String inheritTimeTo = "(//*[@id=\"ctl00_MainContent_cbInheritParentTimeoutTo\"]/../label/span)[1]";
	private final String timeoutTo = "ctl00_MainContent_NavigateTo_ddlNavigateTo";
	private final String universalPrize = "SiteMaster_MainContent_gvAssets_ctl03_lbEditAsset";
	
	public void clickAssetsTab() throws AutomationException, IOException {
		clickNoWait(getwebElement(assetsTabXpath, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Assets Tab Xpath");
	}

	public void isGlobeavailableMain() throws AutomationException, IOException {
		WebElement img = webDriver.findElement(By.xpath("(//*[@class=\"fa fa-globe cusor-pointer\"])[1]"));

		if (img.isDisplayed()) {
			System.out.println("Globe is present");
		} else {
			System.out.println("Globe not present");
		}
	}

	public void clickEditMainAsset() throws AutomationException, IOException {
		clickNoWait(getwebElement(editMainAsset, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Edit Main Asset");
	}

	public void navigateToAssetFrame() throws AutomationException, IOException {
		webDriver.switchTo().frame("popupframe");
		logger.info("Switched to Asset Frame");
	}

	public void enterAssetDescription() throws AutomationException, IOException {
		sendKeys(getwebElement(assetDescription, LocatorType.ID, 10),
				GlobalVariables.testDataMap.get("AssetDescription"));
		logger.info("Asset Description value entered in Text Box");
	}

	public void uploadAssetImage() throws AutomationException, IOException {
		sendKeys(getwebElement(assetUpload, LocatorType.ID, 10),
				System.getProperty("user.dir") + "/src/main/resources/Assets/main (1).swf");
		logger.info("Upload of assets is completed");
		webDriver.manage().window().maximize();
		logger.info("Screen Maximized");
	}

	public void checkInheritSettingsXpath() throws AutomationException, IOException {
		clickNoWait(getwebElement(inheritSettingsXpath, LocatorType.XPATH, 10), 10);
		logger.info("Click Inherit Settings Xpath checkbox");
	}
	
	public void timeoutSeconds() throws AutomationException, IOException {
		sendKeys(getwebElement(timeoutSeconds, LocatorType.ID, 10), "20");
		logger.info("Enter Time seconds in text box");
	}

	public void checkMoreTimeXpath() throws AutomationException, IOException {
		clickNoWait(getwebElement(moreTimeXpath, LocatorType.XPATH, 10), 10);
		logger.info("Click Need More Time Xpath checkbox");
	}

	public void clickSave() throws AutomationException, IOException {
//		JavascriptExecutor js = (JavascriptExecutor) GlobalVariables.webDriver;
//		js.executeScript("arguments[0].click();", saveId);
		webDriver.findElement(By.tagName("body")).sendKeys(Keys.F11);
		logger.info("Window Maximised");
		clickNoWait(getwebElement(saveId, LocatorType.ID, 10), 10);
		logger.info("Click Save Button");
	}

	public void navigateBackToAsset() throws AutomationException, IOException {
		webDriver.switchTo().defaultContent();
		logger.info("Switched back to Asset screen");
	}

	public boolean isUseDefaultDisplayed() {
		return getwebElement(useDefaultId, LocatorType.ID, 10).isDisplayed();
	}

	public void uploadInvalidAssetImage() throws AutomationException, IOException {
		sendKeys(getwebElement(assetUpload, LocatorType.ID, 10),
				System.getProperty("user.dir") + "/src/main/resources/Assets/pizza-and-pasta.htm");
		logger.info("Upload of Invalid assets is completed");
		webDriver.manage().window().maximize();
		logger.info("Screen Maximized");
	}

	public boolean isinvalidAssestWarningmsgDisplayed() {
		return getwebElement(invalidAssestWarningmsg, LocatorType.XPATH, 20).isDisplayed();
	}

	public void clickEditPromoNotAvailableAsset() throws AutomationException, IOException {
		clickNoWait(getwebElement(promoNotAvailable, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Edit Promotion Not available Asset");
	}

	public void clickEditAlreadyParticipatedAsset() throws AutomationException, IOException {
		clickNoWait(getwebElement(alreadyParticipated, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Edit Already Participated");
	}
	
	public void clickNoQualificationAsset() throws AutomationException, IOException {
		clickNoWait(getwebElement(noqualification, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Edit No Qualification Asset");
	}
	
	public void clickEditOutOfPrizesAsset() throws AutomationException, IOException {
		clickNoWait(getwebElement(outOfPrizes, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Edit Promotion Not available Asset");
	}
	
	public void clickEditUniversalPrizesAsset() throws AutomationException, IOException {
		clickNoWait(getwebElement(universalPrize, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Edit Universal Prizes");
	}
	
	public void uploadAssetPromoNotAvailableImage() throws AutomationException, IOException {
		sendKeys(getwebElement(assetUpload, LocatorType.ID, 10),
				System.getProperty("user.dir") + "/src/main/resources/Assets/Promotion List.swf");
		logger.info("Upload of assets is completed");
		webDriver.manage().window().maximize();
		logger.info("Screen Maximized");
	}

	public void uploadAssetPromoAlreadyParticipated() throws AutomationException, IOException {
		sendKeys(getwebElement(assetUpload, LocatorType.ID, 10),
				System.getProperty("user.dir") + "/src/main/resources/Assets/Alerts.swf");
		logger.info("Upload of assets is completed");
		webDriver.manage().window().maximize();
		logger.info("Screen Maximized");
	}

	public void uploadAssetNoQualification() throws AutomationException, IOException {
		sendKeys(getwebElement(assetUpload, LocatorType.ID, 10),
				System.getProperty("user.dir") + "/src/main/resources/Assets/NoQualification.swf");
		logger.info("Upload of assets is completed");
		webDriver.manage().window().maximize();
		logger.info("Screen Maximized");
	}

	public void uploadAssetOutOfPrizes() throws AutomationException, IOException {
		sendKeys(getwebElement(assetUpload, LocatorType.ID, 10),
				System.getProperty("user.dir") + "/src/main/resources/Assets/OutOfPrizes.swf");
		logger.info("Upload of assets is completed");
		webDriver.manage().window().maximize();
		logger.info("Screen Maximized");
	}

	public void uploadAssetUniversalPrize() throws AutomationException, IOException {
		sendKeys(getwebElement(assetUpload, LocatorType.ID, 10),
				System.getProperty("user.dir") + "/src/main/resources/Assets/UniversalPrize.swf");
		logger.info("Upload of assets is completed");
		webDriver.manage().window().maximize();
		logger.info("Screen Maximized");
	}
	
	public void checkinheritTimeToXpath() throws AutomationException, IOException {
		clickNoWait(getwebElement(inheritTimeTo, LocatorType.XPATH, 10), 10);
		logger.info("Click Inherit Settings Xpath checkbox");
	}

	public void selectTimeOutTo() throws AutomationException, IOException {
		WebElement timeOutTo = GlobalVariables.webDriver
				.findElement(By.id("ctl00_MainContent_NavigateTo_ddlNavigateTo"));
		Select s = new Select(timeOutTo);
		s.selectByVisibleText("Calendar");
		System.out.println(timeOutTo.getAttribute("value"));
	}

	public void isPinavailableMain() throws AutomationException, IOException {
		WebElement img = webDriver.findElement(By.xpath("(//*[@class=\"fa fa-thumbtack\"])[1]"));

		if (img.isDisplayed()) {
			System.out.println("Pin is present");
		} else {
			System.out.println("Pin not present");
		}
	}
	
	public void isGlobeavailablePromo() throws AutomationException, IOException {
		WebElement img = webDriver.findElement(By.xpath("(//*[@class=\"fa fa-globe cusor-pointer\"])[2]"));

		if (img.isDisplayed()) {
			System.out.println("Globe is present");
		} else {
			System.out.println("Globe not present");
		}
	}
	
	public void isPinavailablePromo() throws AutomationException, IOException {
		WebElement img = webDriver.findElement(By.xpath("(//*[@class=\"fa fa-thumbtack\"])[2]"));

		if (img.isDisplayed()) {
			System.out.println("Pin is present");
		} else {
			System.out.println("Pin not present");
		}
	}
	
	public void isGlobeavailableAlready() throws AutomationException, IOException {
		WebElement img = webDriver.findElement(By.xpath("(//*[@class=\"fa fa-globe cusor-pointer\"])[3]"));

		if (img.isDisplayed()) {
			System.out.println("Globe is present");
		} else {
			System.out.println("Globe not present");
		}
	}
	
	public void isPinavailableAlready() throws AutomationException, IOException {
		WebElement img = webDriver.findElement(By.xpath("(//*[@class=\"fa fa-thumbtack\"])[3]"));

		if (img.isDisplayed()) {
			System.out.println("Pin is present");
		} else {
			System.out.println("Pin not present");
		}
	}

	
	public void isGlobeavailableNoQuali() throws AutomationException, IOException {
		WebElement img = webDriver.findElement(By.xpath("(//*[@class=\"fa fa-globe cusor-pointer\"])[4]"));

		if (img.isDisplayed()) {
			System.out.println("Globe is present");
		} else {
			System.out.println("Globe not present");
		}
	}
	
	public void isPinavailableNoQuali() throws AutomationException, IOException {
		WebElement img = webDriver.findElement(By.xpath("(//*[@class=\"fa fa-thumbtack\"])[4]"));

		if (img.isDisplayed()) {
			System.out.println("Pin is present");
		} else {
			System.out.println("Pin not present");
		}
	}
	
	public void isGlobeavailableOutOf() throws AutomationException, IOException {
		WebElement img = webDriver.findElement(By.xpath("(//*[@class=\"fa fa-globe cusor-pointer\"])[5]"));

		if (img.isDisplayed()) {
			System.out.println("Globe is present");
		} else {
			System.out.println("Globe not present");
		}
	}
	
	public void isPinavailableOutOf() throws AutomationException, IOException {
		WebElement img = webDriver.findElement(By.xpath("(//*[@class=\"fa fa-thumbtack\"])[5]"));

		if (img.isDisplayed()) {
			System.out.println("Pin is present");
		} else {
			System.out.println("Pin not present");
		}
	}
	
	public void isGlobeavailableUniversal() throws AutomationException, IOException {
		WebElement img = webDriver.findElement(By.xpath("(//*[@class=\"fa fa-globe cusor-pointer\"])[2]"));

		if (img.isDisplayed()) {
			System.out.println("Globe is present");
		} else {
			System.out.println("Globe not present");
		}
	}
	
	public void isPinavailableUniversal() throws AutomationException, IOException {
		WebElement img = webDriver.findElement(By.xpath("(//*[@class=\"fa fa-thumbtack\"])[2]"));

		if (img.isDisplayed()) {
			System.out.println("Pin is present");
		} else {
			System.out.println("Pin not present");
		}
	}
	
	
}
