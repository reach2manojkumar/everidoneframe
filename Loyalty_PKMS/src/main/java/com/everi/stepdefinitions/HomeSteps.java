package com.everi.stepdefinitions;

import java.io.IOException;

import org.junit.Assert;
import com.everi.Helper.GlobalVariables;
import com.everi.exception.AutomationException;
import com.everi.page.CommonPage;
import com.everi.page.HomePage;

import io.cucumber.java.en.*;


public class HomeSteps {
	
	@And ("Click on create new promotion")
	public void newPromtionCreation() throws AutomationException, IOException {
		HomePage home = new HomePage();
		home.clickPromotionsTopNav();
		home.clickPromotionMenu();
		home.clickCreateNewPromotion();
		home.waitForPageLoaded("PromotionPage");
	}
}
