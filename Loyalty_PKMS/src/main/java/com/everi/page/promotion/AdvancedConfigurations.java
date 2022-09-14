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

public class AdvancedConfigurations extends BasePage {

	static Logger logger = LogManager.getLogger(AdvancedConfigurations.class);
	public static String promotionId;
	WebDriver webDriver = GlobalVariables.webDriver;
	JavascriptExecutor js = (JavascriptExecutor) GlobalVariables.webDriver;

	private final String advancedTabXpath = "//*[contains(text(),\"Advanced Configuration\")]";
	private final String addVariableInput = "SiteMaster_MainContent_iAddInputParams";
	private final String addVariableButton = "SiteMaster_PopupContent_lbAddParam";
	private final String addVariableText = "(//*[@id=\"SiteMaster_PopupContent_tbName\"])[1]";
	private final String stringType = "//*[@id=\"SiteMaster_PopupContent_rblParamType_0\"]/../label/span";
	private final String revealText = "SiteMaster_MainContent_rInputParameters_ctl04_tbStr";
	private final String save = "(//*[@id=\"SiteMaster_MainContent_lbSubmit\"])[1]";
	private final String prizeText = "(//*[contains(text(),\"totalamount\")]/../following::tr/td)[1]/div/textarea";
	private final String addVariableOutput = "SiteMaster_MainContent_iAddOutputParams";
	private final String participation = "SiteMaster_MainContent_rOutputParams_ctl00_tbSql";
	private final String delete = "(//*[contains(text(),\"reveal\")]/following::td)[1]/div/span";

	public void clickAdvancedTab() throws AutomationException {
		clickNoWait(getwebElement(advancedTabXpath, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on the Advanced tab");
	}

	public void clickAddInputVariable() throws AutomationException {
		clickNoWait(getwebElement(addVariableInput, LocatorType.ID, 10), 10);
		logger.info("Click action performed on the Add Variable Input");
	}

	public void enterAddVariable() throws AutomationException, IOException {
		clickNoWait(getwebElement(addVariableText, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on enter Add Variable name Text box");
		threadWait(1000);
		sendKeys(getwebElement(addVariableText, LocatorType.XPATH, 10), "reveal");
		logger.info("Entered Reveal in Text box");
	}

	public void clickStringType() throws AutomationException {
		clickNoWait(getwebElement(stringType, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on the String Type");
	}

	public void clickAddVariableButton() throws AutomationException {
		clickNoWait(getwebElement(addVariableButton, LocatorType.ID, 10), 10);
		logger.info("Click action on Add Variable Button");
	}

	public void enterrevealText() throws AutomationException, IOException {
		clickNoWait(getwebElement(revealText, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Reveal name Text box");
		threadWait(1000);
		sendKeys(getwebElement(revealText, LocatorType.ID, 10), "true");
		logger.info("Entered True in Text box");
	}

	public void clickSave() throws AutomationException {
		clickNoWait(getwebElement(save, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on the save");
	}

	public void enterAddVariablePrizes() throws AutomationException, IOException {
		clickNoWait(getwebElement(addVariableText, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on enter Add Variable name Text box");
		threadWait(1000);
		sendKeys(getwebElement(addVariableText, LocatorType.XPATH, 10), "prizes");
		logger.info("Entered Prizes in Text box");
	}

	public void enterPrizeText() throws AutomationException, IOException {
		js.executeScript("window.scrollTo(0,600)");
		clickNoWait(getwebElement(prizeText, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on Prizes name Text box");
		threadWait(1000);
		String custom = GlobalVariables.testDataMap.get("CustomQuery");
		((JavascriptExecutor) GlobalVariables.webDriver).executeScript("arguments[0].value='" + custom + "'",
				getwebElement(prizeText, LocatorType.XPATH, 10));
		logger.info("Entered custom query in Text box" + custom);
	}
	
	public void clickAddOutputVariable() throws AutomationException {
		clickNoWait(getwebElement(addVariableOutput, LocatorType.ID, 10), 10);
		logger.info("Click action performed on the Add Variable Output");
	}

	public void enterParticipationText() throws AutomationException, IOException {
		js.executeScript("window.scrollTo(0,600)");
		clickNoWait(getwebElement(participation, LocatorType.ID, 10), 10);
		logger.info("Click action performed on Participation name Text box");
		threadWait(1000);
		sendKeys(getwebElement(participation, LocatorType.ID, 10), "1000118117");
		logger.info("Entered custom query in Text box" + participation);
	}

	public void clickDeleteVariable() throws AutomationException {
		js.executeScript("window.scrollTo(0,600)");
		clickNoWait(getwebElement(delete, LocatorType.XPATH, 10), 10);
		logger.info("Click action performed on the Delete");
	}

	public void clickDeleteOkVariable() throws AutomationException {
		webDriver.switchTo().alert().accept();
		logger.info("Click action performed on the Ok Delete");
	}
}
