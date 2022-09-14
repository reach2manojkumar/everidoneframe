package com.everi.page;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;

import com.everi.Enum.LocatorType;
import com.everi.Helper.GlobalVariables;
import com.everi.Test.ProjectGlobalVariables;
import com.everi.exception.AutomationException;

public class HomePage extends BasePage {

	JavascriptExecutor js = (JavascriptExecutor) GlobalVariables.webDriver;

	static Logger logger = LogManager.getLogger(HomePage.class);
	private final String topNavPromotionsXpath = "//div[@id='SiteMaster_TopNav1_topMenu']//child::span/a[text()='Promotions']";
	private final String PromotionMenuXpath = "//a[@class='dir' and text()='Promotions']";
	private final String PromotionSubMenuXpath = "//ul[@class='submenu']//child::a[text()='Promotions List']";
	// ul[@class='submenu']//child::a[text()='Promotions
	// List']//parent::li//following-sibling::li[1]
	private final String createNewPromotionXpath = "(//ul[@class='submenu']//child::a[text()='Create New'])[1]";
	private final String playerIdPromo = "//*[@id=\"SiteMaster_MainContent_aenrollmentEdit\"]/../following::tbody/tr/th/span[contains(text(),\"Player IDs\")]/../following::td[1]";

	public void clickPromotionsTopNav() throws AutomationException {
		click(getwebElement(topNavPromotionsXpath, LocatorType.XPATH, 30));
		logger.info("Click action performed on promotion from top nav");
	}

	public void clickPromotionMenu() throws AutomationException {
		click(getwebElement(PromotionMenuXpath, LocatorType.XPATH, 10));
		logger.info("Click action performed on Promotions menu under promotion nav");
	}

	public void clickPromotionList() throws AutomationException {
		click(getwebElement(PromotionSubMenuXpath, LocatorType.XPATH, 10));
		logger.info("Click action performed on promotion list");
	}

	public void clickCreateNewPromotion() throws AutomationException, IOException {

		click(getwebElement(createNewPromotionXpath, LocatorType.XPATH, 10));
		logger.info("Click action performed on create new promotion");
	}

	public void clickPromoName() throws AutomationException {
		js.executeScript("window.scrollTo(0,600)");
		String promoName = GlobalVariables.testDataMap.get("PromotionName");
		String promoxpath = "//*[contains(text(),'" + promoName + "')]";
		click(getwebElement(promoxpath, LocatorType.XPATH, 10));
		logger.info("Click action performed on promotion name");
	}

	public void scrollToPromoPlayers() throws AutomationException {
		js.executeScript("window.scrollTo(0,600)");

		String playerIDpromo = GlobalVariables.testDataMap.get("PlayerIdPromo");
		System.out.println("Player ID partcipated is " + playerIDpromo);

		String playerIdPromoUI = gettext(getwebElement(playerIdPromo, LocatorType.XPATH, 10));
		System.out.println("Player ID's are " + playerIdPromoUI);

		String[] split = playerIdPromoUI.split(",");

		if (split[1].trim().equals(playerIDpromo)) {
			System.out.println("Player ID's have been added in summary section");
		}

		else {
			System.out.println("No Player ID's added into summary section");
		}

	}
}
