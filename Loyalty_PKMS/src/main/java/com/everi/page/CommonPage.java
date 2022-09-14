package com.everi.page;



import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import com.everi.Enum.LocatorType;
import com.everi.Helper.DriverHelper;
import com.everi.Helper.GlobalVariables;
import com.everi.Test.ProjectGlobalVariables;
import com.everi.exception.AutomationException;
import com.everi.report.TestReport;
import com.everi.util.Util;

public class CommonPage extends BasePage {

	static Logger logger = LogManager.getLogger(CommonPage.class);
	private final String userNameId = "LoginMaster_SignInFormContent_tbUsername"; 
	private final String passwordId = "LoginMaster_SignInFormContent_tbPassword";
	private final String singInId = "LoginMaster_SignInFormContent_btSubmit";
	private final String userNameText = ProjectGlobalVariables.loyaltyProperties.getProperty("--USERNAME");
	private final String passwordText = ProjectGlobalVariables.loyaltyProperties.getProperty("--PASSWORD");

	public void enterUserName() throws AutomationException, IOException {

		sendKeys(getwebElement(userNameId, LocatorType.ID, 10), userNameText);
		logger.info("Text typed in user name text box");
	}

	public void enterPassword() throws AutomationException, IOException {

		sendKeys(getwebElement(passwordId, LocatorType.ID, 10), passwordText);
		logger.info("Text typed in password name text box");
	}

	public void clickSignIn() throws AutomationException, IOException {
		
		clickNoWait(getwebElement(singInId, LocatorType.ID, 10), 10);
		logger.info("Click action performed on sign in button");
	}

	public String titleVerify() {
		return getTitle();
	}
	
	
}
