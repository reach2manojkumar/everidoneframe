package com.everi.page;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.everi.Enum.LocatorType;
import com.everi.Helper.DriverHelper;
import com.everi.Helper.GlobalVariables;
import com.everi.exception.AutomationException;


public class BasePage extends DriverHelper{

	static Logger logger = LogManager.getLogger(BasePage.class);
	public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
	public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE
	public static final String ANSI_RESET = "\u001B[0m";

	public BasePage() {
		super(GlobalVariables.webDriver);
		
	}

	@Override
	public WebElement getwebElement(String locator, LocatorType locatorType) {
		return super.getwebElement(locator, locatorType);
	}


	@Override
	public WebElement getwebElement(String locator, LocatorType locatorType, long timeUnit) {
		return super.getwebElement(locator, locatorType, timeUnit);
	}
	
	@Override
	public List<WebElement> getWebElements(String locator, LocatorType locatorType, long timeUnit) {
		return super.getWebElements(locator, locatorType, timeUnit);
	}



	public void clickCancel() throws AutomationException {
		clickNoWait(getwebElement("buttonCancel", LocatorType.ID, 10), 10);
		logger.info("Clicked on cancel button of Id: buttonCancel");
	}

	public void waitForPageLoaded(String pageName) {
		WebDriver webDriver = GlobalVariables.webDriver;
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver webDriver) {
                        return ((JavascriptExecutor) webDriver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(webDriver, 30);
            wait.until(expectation);
            logger.info(pageName+"page Load completed");
        } catch (Throwable error) {
        	error.printStackTrace();
        	logger.info("Timeout waiting for the page to load "+error.getMessage());
            //Assert.fail("Timeout waiting for Page Load Request to complete. "+pageName);
        }
    }

	
	public void threadWait(int timeInMilliSeconds) {
		try {
			Thread.sleep(timeInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}		
}
