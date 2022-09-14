package com.everi.stepdefinitions;

import java.io.IOException;

import org.junit.Assert;
import com.everi.Helper.GlobalVariables;
import com.everi.exception.AutomationException;
import com.everi.page.CommonPage;
import io.cucumber.java.en.*;


public class CommonSteps {
	
	@And ("Login in to PKMS system to land on home page")
	public void Login() throws AutomationException, IOException{
		CommonPage login = new CommonPage();
		login.enterUserName();
		login.enterPassword();
		login.clickSignIn();
		login.waitForPageLoaded("LoginPage");
		Assert.assertEquals("PowerKiosk Management System", login.titleVerify().trim());
	}

}
