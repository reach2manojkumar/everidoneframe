package com.everi.stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.json.JSONObject;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.w3c.dom.Document;

import com.everi.Enum.LocatorType;
import com.everi.Helper.GlobalVariables;
import com.everi.exception.AutomationException;
import com.everi.page.promotion.EnrollmentPage;
import com.everi.soapservices.PromotionEndPoints;
import com.everi.util.WebServiceUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import kong.unirest.HttpResponse;
import net.minidev.json.JSONArray;

public class PromotionAPISteps {

	String promotionId = EnrollmentPage.promotionId;
	String promotionName = EnrollmentPage.promotionName;

	String playerId = GlobalVariables.testDataMap.get("PlayerId");
//	String playerId = "1000002689";
//	String playerId = "1000118117"; //exclude player

	String cardNumber = GlobalVariables.testDataMap.get("CardNumber");
	String prizeIdentity = GlobalVariables.testDataMap.get("PrizeIdentifier");
	int expectedValue = Integer.parseInt(GlobalVariables.testDataMap.get("PrizeValue"));
	int expectedQuantity = Integer.parseInt(GlobalVariables.testDataMap.get("PrizeQuantity"));
	String PromotionName = GlobalVariables.testDataMap.get("PromotionName");
	String CalendarDesc = GlobalVariables.testDataMap.get("calendarDescription");
	int RedemptionCodeOnWin = Integer.parseInt(GlobalVariables.testDataMap.get("RedemptionCodeOnWin"));
	String PrizeType = GlobalVariables.testDataMap.get("PrizeType");

	@And("User participate in promotion with {string} macaddress and has won {string}")
	public void participateInPromotion(String macAddress, String isWon) throws AutomationException, IOException {

		PromotionEndPoints promotionCalls = new PromotionEndPoints();
		// make load player call
		System.out.println("The Player ID is " + playerId);
		HttpResponse<String> loadPlayerResponse = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObj = WebServiceUtil.xmlToJSONObject(loadPlayerResponse.getBody());
		System.out.println("json is " + jsonObj);
		String extractedPlayerID = String.valueOf(WebServiceUtil.xmlToJsonPath(jsonObj, "$.PlayerResult.PlayerID"));

		System.out.println("load player call " + extractedPlayerID);
		System.out.println("promotion id captured from UI " + promotionId);
		System.out.println("RedemptionCodeOnWin value is " + RedemptionCodeOnWin);
		System.out.println("PrizeType value is " + PrizeType);

		int availablePointsBefore = (int) WebServiceUtil.xmlToJsonPath(jsonObj,
				"$.PlayerResult.PlayerFields.Fields.AvailablePoints");
		int availablePointsCompBefore = (int) WebServiceUtil.xmlToJsonPath(jsonObj,
				"$.PlayerResult.PlayerFields.Fields.CompPtBalance");

		// make getPlayerinfo call
		promotionCalls.getPlayerInfo(cardNumber, macAddress);

		// make promotion status call
		HttpResponse<String> promotionStatusResponse = promotionCalls.getPromotionStatus(extractedPlayerID, promotionId,
				macAddress);
		// JSONObject getPromotionJson =
		// WebServiceUtil.xmlToJSONObject(promotionStatusResponse.getBody());
		Document domObj = WebServiceUtil.xmlToDOM(promotionStatusResponse.getBody());
		int usedparticipation = WebServiceUtil.findElementXpathOfInt(domObj,
				"/PromotionStatusResult/Custom/Parameters/usedparticipation");
		Assert.assertEquals(0, usedparticipation);
		System.out.println("The used Participation count is " + usedparticipation);

		// make participate in promotion call
		HttpResponse<String> participateInPromotionResponse = promotionCalls.participateInPromotion(extractedPlayerID,
				promotionId, macAddress, prizeIdentity, isWon);
		JSONObject promotionParticipatedJson = WebServiceUtil.xmlToJSONObject(participateInPromotionResponse.getBody());

		if (PrizeType.equals("Point Add") || PrizeType.equals("Comp Add") || PrizeType.equals("Point Deduct")
				|| PrizeType.equals("Comp Deduct")) {
			int actualValue = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJson,
					"$.SinglePrizeResult.Prize.Value");

			Assert.assertEquals(expectedValue, actualValue);
			System.out.println("The actual prize value count is " + actualValue);
			System.out.println("The expected prize value count is " + expectedValue);
		}
		int actualQuantity = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJson,
				"$.SinglePrizeResult.Prize.Quantity");
		Assert.assertEquals(expectedQuantity, actualQuantity);
		System.out.println("The actual Quantity is " + actualQuantity);
		System.out.println("The expected Quantity is " + expectedQuantity);

		int receiptID = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJson, "$.SinglePrizeResult.ReceiptID");
		System.out.println("The Receipt ID is " + receiptID);

		// make load player call again
		System.out.println("The Player ID is " + playerId);
		HttpResponse<String> loadPlayerResponseagain = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObjAgain = WebServiceUtil.xmlToJSONObject(loadPlayerResponseagain.getBody());
		System.out.println("json is" + jsonObjAgain);
		int pointsBalance = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.PointsBalance");
		int availablePoints = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.AvailablePoints");
		String compDollarBalance = String.valueOf(
				WebServiceUtil.xmlToJsonPath(jsonObjAgain, "$.PlayerResult.PlayerFields.Fields.CompDollarBalance"));
		String compBalance = String
				.valueOf(WebServiceUtil.xmlToJsonPath(jsonObjAgain, "$.PlayerResult.PlayerFields.Fields.CompBalance"));
		int compPtBalance = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.CompPtBalance");
		String compDollarMaxRedeem = String.valueOf(
				WebServiceUtil.xmlToJsonPath(jsonObjAgain, "$.PlayerResult.PlayerFields.Fields.CompDollarMaxRedeem"));
		int pointsEarnedToday = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.PointsEarnedToday");
		System.out.println("Points Balance " + pointsBalance);
		System.out.println("Available Points " + availablePoints);
		System.out.println("Comp Dollar Balance " + compDollarBalance);
		System.out.println("Comp Balance " + compBalance);
		System.out.println("Comp Pt Balance " + compPtBalance);
		System.out.println("Comp Dollar Max Redeem " + compDollarMaxRedeem);
		System.out.println("Points Earned Today " + pointsEarnedToday);

		String PrizeType = GlobalVariables.testDataMap.get("PrizeType");
		System.out.println("Prize type is " + PrizeType);

		switch (PrizeType) {
		case ("Point Add"):
			int pointChangedPointAdd = (int) (availablePoints - availablePointsBefore);
			Assert.assertEquals(RedemptionCodeOnWin, pointChangedPointAdd);
			System.out.println("Point value updated is " + pointChangedPointAdd);
			break;

		case ("Comp Deduct"):
			int pointChangedCompDeduct = (int) (availablePointsBefore - availablePoints);
			Assert.assertEquals(0, pointChangedCompDeduct);
			System.out.println("Point value updated is " + pointChangedCompDeduct);
			break;

		case ("Point Deduct"):
			int pointChangedPointDeduct = (int) (compPtBalance - availablePointsCompBefore);
			Assert.assertEquals(RedemptionCodeOnWin, pointChangedPointDeduct);
			System.out.println("Point value updated is " + pointChangedPointDeduct);
			break;

		case ("Comp Add"):
			int pointChangedcompAdd = (int) (compPtBalance - availablePointsCompBefore);
			Assert.assertEquals(RedemptionCodeOnWin, pointChangedcompAdd);
			System.out.println("Point value updated is " + pointChangedcompAdd);
			break;

		case ("Slot Free Play"):
			System.out.println("No values are to be updated");

		}

	}

	@Then("Again participate in promotion with {string} macAddress and has won {string}")
	public void verifyOutOfPrizes(String macAddress, String isWon) throws AutomationException {
		PromotionEndPoints promotionCalls = new PromotionEndPoints();
		// make promotion status call
		HttpResponse<String> promotionStatusResponse = promotionCalls.getPromotionStatus(playerId, promotionId,
				macAddress);
		System.out.println("promotionStatusResponse is" + promotionStatusResponse.toString());
		Document domObj = WebServiceUtil.xmlToDOM(promotionStatusResponse.getBody());
		System.out.println("domObj is" + domObj.toString());

		String screenId = WebServiceUtil.findElementXpathAsString(domObj, "/PromotionStatusResult/ScreenId");
		String[] split = screenId.split("/");

		if (split[3].trim().equals("Out of Prizes")) {
			System.out.println("Out of Prizes");
		}

		else {
			System.out.println("No Error Message");
		}

		// make participate in promotion call
		HttpResponse<String> participateInPromotionResponse = promotionCalls.participateInPromotion(playerId,
				promotionId, macAddress, prizeIdentity, isWon);
		Document participateDOM = WebServiceUtil.xmlToDOM(participateInPromotionResponse.getBody());
		String participationError = WebServiceUtil.findElementXpathAsString(participateDOM,
				"/SinglePrizeResult/ErrorMessage");

		String error = participationError.trim();

		if (error.equals("An error has occurred. Please try again")) {
			System.out.println("Error Message visible");
		}

		else {
			System.out.println("No Error Message");
		}

	}

	@And("Excluded user participate in promotion with {string} macaddress and has won {string}")
	public void excludedUserParticipation(String macAddress, String isWon) throws AutomationException, IOException {

		PromotionEndPoints promotionCalls = new PromotionEndPoints();
		// make load player call
		HttpResponse<String> loadPlayerResponse = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObj = WebServiceUtil.xmlToJSONObject(loadPlayerResponse.getBody());
		String extractedPlayerID = String.valueOf(WebServiceUtil.xmlToJsonPath(jsonObj, "$.PlayerResult.PlayerID"));

		System.out.println("load player call " + extractedPlayerID);
		System.out.println("promotion id captured from UI " + promotionId);

		// make getPlayerinfo call
		promotionCalls.getPlayerInfo(cardNumber, macAddress);

		// make Get promotion call
		HttpResponse<String> getPromotionResponse = promotionCalls.getPromotions(extractedPlayerID, macAddress);
		JSONObject promtionJson = WebServiceUtil.xmlToJSONObject(getPromotionResponse.getBody());
		// to check if the given element in json path is not present

		String actualPromotionId = String.valueOf(WebServiceUtil.xmlToJsonPath(promtionJson,
				"$.PromotionsResult.Promotions.Promotion[?(@.ID == " + promotionId + ")].ID"));
		System.out.println("actualPromotionId " + actualPromotionId);

		// make promotion status call
		HttpResponse<String> promotionStatusResponse = promotionCalls.getPromotionStatus(playerId, promotionId,
				macAddress);
		System.out.println("promotionStatusResponse is" + promotionStatusResponse.toString());
		Document domObj = WebServiceUtil.xmlToDOM(promotionStatusResponse.getBody());
		System.out.println("domObj is" + domObj.toString());
		String screenId = WebServiceUtil.findElementXpathAsString(domObj, "/PromotionStatusResult/ScreenId");

		String[] split = screenId.split("/");

		if (split[3].trim().equals("No Qualification")) {
			System.out.println("No Qualification");
		} else {
			System.out.println("No Error Message");
		}
	}

	@And("dummy try by passing form url as body")
	public void participateInPromotion(String playerId, String promotionId, String isWon, String prizeIdentity,
			String macAddress) {
		PromotionEndPoints promotionCalls = new PromotionEndPoints();
		JtwigTemplate template = JtwigTemplate.classpathTemplate(
				"playerID={{playerId}}&promotionID={{promotionId}}&isWon={{isWon}}&state=&prizeIdentity={{prizeIdentity}}&macAddress={{macAddress}}");
		JtwigModel model = JtwigModel.newModel().with("country", "IN");

		template.render(model);
		String bodyParams = "playerID=1000117075&promotionID=2683&isWon=TRUE&state=&prizeIdentity=3&macAddress=aa";
		HttpResponse<String> response = promotionCalls.postCall("/ParticipateInPromotion", bodyParams);
		JSONObject jsonObj = WebServiceUtil.xmlToJSONObject(response.getBody());
		Assert.assertEquals(2, jsonObj.getInt("StatusCode"));
		Assert.assertEquals("An error has occurred. Please try again", jsonObj.getString("ErrorMessage"));

	}

	@And("User validate the enrollment group {string} macaddress and has won {string}")
	public void validateGetEligiblePrizes(String macAddress, String isWon) throws AutomationException, IOException {

		PromotionEndPoints promotionCalls = new PromotionEndPoints();
		// make load player call
		System.out.println("The Player ID is" + playerId);
		HttpResponse<String> loadPlayerResponse = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObj = WebServiceUtil.xmlToJSONObject(loadPlayerResponse.getBody());
		System.out.println("json is" + jsonObj);
		String extractedPlayerID = String.valueOf(WebServiceUtil.xmlToJsonPath(jsonObj, "$.PlayerResult.PlayerID"));

		System.out.println("load player call " + extractedPlayerID);
		System.out.println("promotion id captured from UI " + promotionId);

		// make getPlayerinfo call
		promotionCalls.getPlayerInfo(cardNumber, macAddress);

		// make GetEligiblePrizes call
		HttpResponse<String> eligiblePrizesResponse = promotionCalls.getEligiblePrizes(playerId, promotionId);
		JSONObject eligiblePrizesResponseJson = WebServiceUtil.xmlToJSONObject(eligiblePrizesResponse.getBody());
		int value = (int) WebServiceUtil.xmlToJsonPath(eligiblePrizesResponseJson,
				"$.PrizesResult.Prizes.PrizeModel.Value");
		System.out.println("The prize value count is" + value);

		// make promotion status call
		HttpResponse<String> promotionStatusResponse = promotionCalls.getPromotionStatus(extractedPlayerID, promotionId,
				macAddress);
		// JSONObject getPromotionJson =
		// WebServiceUtil.xmlToJSONObject(promotionStatusResponse.getBody());
		Document domObj = WebServiceUtil.xmlToDOM(promotionStatusResponse.getBody());
		int usedparticipation = WebServiceUtil.findElementXpathOfInt(domObj,
				"/PromotionStatusResult/Custom/Parameters/usedparticipation");
		Assert.assertEquals(0, usedparticipation);
		System.out.println("The used Participation count is" + usedparticipation);

		// make participate in promotion call
		HttpResponse<String> participateInPromotionResponse = promotionCalls.participateInPromotion(extractedPlayerID,
				promotionId, macAddress, prizeIdentity, isWon);
		JSONObject promotionParticipatedJson = WebServiceUtil.xmlToJSONObject(participateInPromotionResponse.getBody());

		int actualValue = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJson,
				"$.SinglePrizeResult.Prize.Value");
//		Assert.assertEquals(expectedValue, actualValue);
		System.out.println("The actual prize value count is" + actualValue);
//		System.out.println("The expected prize value count is" + expectedValue);

		int actualQuantity = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJson,
				"$.SinglePrizeResult.Prize.Quantity");
//		Assert.assertEquals(expectedQuantity, actualQuantity);
		System.out.println("The actual Quantity is" + actualQuantity);
//		System.out.println("The expected Quantity is" + expectedQuantity);

		int receiptID = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJson, "$.SinglePrizeResult.ReceiptID");
		System.out.println("The Receipt ID is" + receiptID);

		// make load player call again
		System.out.println("The Player ID is" + playerId);
		HttpResponse<String> loadPlayerResponseagain = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObjAgain = WebServiceUtil.xmlToJSONObject(loadPlayerResponseagain.getBody());
		System.out.println("json is" + jsonObjAgain);
		int pointsBalance = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.PointsBalance");
		int availablePoints = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.AvailablePoints");
		String compDollarBalance = String.valueOf(
				WebServiceUtil.xmlToJsonPath(jsonObjAgain, "$.PlayerResult.PlayerFields.Fields.CompDollarBalance"));
		Double compBalance = (Double) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.CompBalance");
		int compPtBalance = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.CompPtBalance");
		String compDollarMaxRedeem = String.valueOf(
				WebServiceUtil.xmlToJsonPath(jsonObjAgain, "$.PlayerResult.PlayerFields.Fields.CompDollarMaxRedeem"));
		int pointsEarnedToday = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.PointsEarnedToday");
		System.out.println("Points Balance " + pointsBalance);
		System.out.println("Available Points " + availablePoints);
		System.out.println("Comp Dollar Balance " + compDollarBalance);
		System.out.println("Comp Balance " + compBalance);
		System.out.println("Comp Pt Balance" + compPtBalance);
		System.out.println("Comp Dollar Max Redeem " + compDollarMaxRedeem);
		System.out.println("Points Earned Today" + pointsEarnedToday);

	}

	@And("User does not validate the enrollment group {string} macaddress and has won {string}")
	public void validateNotGetEligiblePrizes(String macAddress, String isWon) throws AutomationException, IOException {

		PromotionEndPoints promotionCalls = new PromotionEndPoints();
		// make load player call
		System.out.println("The Player ID is" + playerId);
		HttpResponse<String> loadPlayerResponse = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObj = WebServiceUtil.xmlToJSONObject(loadPlayerResponse.getBody());
		System.out.println("json is" + jsonObj);
		String extractedPlayerID = String.valueOf(WebServiceUtil.xmlToJsonPath(jsonObj, "$.PlayerResult.PlayerID"));

		System.out.println("load player call " + extractedPlayerID);
		System.out.println("promotion id captured from UI " + promotionId);

		// make getPlayerinfo call
		promotionCalls.getPlayerInfo(cardNumber, macAddress);

		// make GetEligiblePrizes call
		HttpResponse<String> eligiblePrizesResponse = promotionCalls.getEligiblePrizes(playerId, promotionId);
		Document domObj1 = WebServiceUtil.xmlToDOM(eligiblePrizesResponse.getBody());
		System.out.println("domObj is" + domObj1.toString());
		String value = WebServiceUtil.findElementXpathAsString(domObj1, "/PrizesResult/ErrorMessage");

		Assert.assertEquals("No prizes exist for this player and promotion", value);
		System.out.println("The value is" + value);

		// make promotion status call
		HttpResponse<String> promotionStatusResponse = promotionCalls.getPromotionStatus(extractedPlayerID, promotionId,
				macAddress);
		// JSONObject getPromotionJson =
		// WebServiceUtil.xmlToJSONObject(promotionStatusResponse.getBody());
		Document domObj = WebServiceUtil.xmlToDOM(promotionStatusResponse.getBody());
		int usedparticipation = WebServiceUtil.findElementXpathOfInt(domObj,
				"/PromotionStatusResult/Custom/Parameters/usedparticipation");

	}

	@And("Validate the post to calendar and priority {string} macaddress and has won {string}")
	public void postToCalendarPriority(String macAddress, String isWon) throws AutomationException, IOException {

		PromotionEndPoints promotionCalls = new PromotionEndPoints();
		// make load player call
		HttpResponse<String> loadPlayerResponse = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObj = WebServiceUtil.xmlToJSONObject(loadPlayerResponse.getBody());
		String extractedPlayerID = String.valueOf(WebServiceUtil.xmlToJsonPath(jsonObj, "$.PlayerResult.PlayerID"));

		System.out.println("load player call " + extractedPlayerID);
		System.out.println("promotion id captured from UI " + promotionId);

		// make getPlayerinfo call
		promotionCalls.getPlayerInfo(cardNumber, macAddress);

		// make Get promotion call
		HttpResponse<String> getPromotionResponse = promotionCalls.getPromotions(extractedPlayerID, macAddress);
		JSONObject promtionJson = WebServiceUtil.xmlToJSONObject(getPromotionResponse.getBody());
		// to check if the given element in json path is not present

		String actualPromotionId = String.valueOf(WebServiceUtil.xmlToJsonPath(promtionJson,
				"$.PromotionsResult.Promotions.Promotion[?(@.ID == " + promotionId + ")].ID"));
		System.out.println("ActualPromotionId " + actualPromotionId.replaceAll("[\\[\\]]", ""));
		System.out.println("PromotionId " + promotionId);

		if (actualPromotionId.equals(promotionId)) {
			System.out.println("Promotion ID matched");

			Document domObj = WebServiceUtil.xmlToDOM(((HttpResponse<String>) promtionJson).getBody());
			int priority = WebServiceUtil.findElementXpathOfInt(domObj,
					"/PromotionsResult.Promotions.Promotion.Priority");
			System.out.println("priority " + priority);

		}

		// make get calendar call
		HttpResponse<String> getCalendarResponse = promotionCalls.getCalendar();
		JSONObject obj = WebServiceUtil.xmlToJSONObject(getCalendarResponse.getBody());
		String postToCalendar = String
				.valueOf(WebServiceUtil.xmlToJsonPath(obj, "$.CalendarResult.Events.events.event.description"));
//		JSONArray jsonArray = postToCalendar.getJSONArray (obj, "$.CalendarResult.Events.events.event.description");

		JSONObject postToCalendar1 = new JSONObject(obj);

		org.json.JSONArray jsonArray = postToCalendar1.getJSONArray("description");

		System.out.println("Post To Calendar Description" + postToCalendar1);

		if (postToCalendar1.equals(CalendarDesc)) {
			System.out.println("Post to Calendar matched");
		}

	}

	@And("Validate the kiosk selection {string} macaddress and has won {string}")
	public void validateKiosk(String macAddress, String isWon) throws AutomationException, IOException {

		PromotionEndPoints promotionCalls = new PromotionEndPoints();
		// make load player call
		HttpResponse<String> loadPlayerResponse = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObj = WebServiceUtil.xmlToJSONObject(loadPlayerResponse.getBody());
		String extractedPlayerID = String.valueOf(WebServiceUtil.xmlToJsonPath(jsonObj, "$.PlayerResult.PlayerID"));

		System.out.println("load player call " + extractedPlayerID);
		System.out.println("promotion id captured from UI " + promotionId);

		// make getPlayerinfo call
		promotionCalls.getPlayerInfo(cardNumber, macAddress);

		// make Get promotion call
		HttpResponse<String> getPromotionResponse = promotionCalls.getPromotions(extractedPlayerID, macAddress);
		JSONObject promtionJson = WebServiceUtil.xmlToJSONObject(getPromotionResponse.getBody());
		// to check if the given element in json path is not present

		String actualPromotionId = String.valueOf(WebServiceUtil.xmlToJsonPath(promtionJson,
				"$.PromotionsResult.Promotions.Promotion[?(@.ID == " + promotionId + ")].ID"));
		System.out.println("ActualID" + actualPromotionId);
		System.out.println("ActualPromotionId " + actualPromotionId.replaceAll("[\\[\\]]", ""));
		System.out.println("PromotionId " + promotionId);

		if (actualPromotionId.equals(promotionId)) {
			System.out.println("Promotion ID matched and Kiosk is available");
		} else {
			System.out.println("Kiosk is not available");
		}

	}

	@And("Validate the exclude participant {string} macaddress and has won {string}")
	public void validateExcludeID(String macAddress, String isWon) throws AutomationException, IOException {

		PromotionEndPoints promotionCalls = new PromotionEndPoints();
		// make load player call
		HttpResponse<String> loadPlayerResponse = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObj = WebServiceUtil.xmlToJSONObject(loadPlayerResponse.getBody());
		String extractedPlayerID = String.valueOf(WebServiceUtil.xmlToJsonPath(jsonObj, "$.PlayerResult.PlayerID"));
		System.out.println("load player call " + extractedPlayerID);
		System.out.println("promotion id captured from UI " + promotionId);

		// make getPlayerinfo call
		promotionCalls.getPlayerInfo(cardNumber, macAddress);

		// make Get promotion call
		HttpResponse<String> getPromotionResponse = promotionCalls.getPromotions(extractedPlayerID, macAddress);
		JSONObject promtionJson = WebServiceUtil.xmlToJSONObject(getPromotionResponse.getBody());
		// to check if the given element in json path is not present

		String actualPromotionId = String.valueOf(WebServiceUtil.xmlToJsonPath(promtionJson,
				"$.PromotionsResult.Promotions.Promotion[?(@.ID == " + promotionId + ")].ID"));
		System.out.println("ActualID" + actualPromotionId);
		System.out.println("ActualPromotionId " + actualPromotionId.replaceAll("[\\[\\]]", ""));
		System.out.println("PromotionId " + promotionId);

		if (!actualPromotionId.equals(promotionId)) {
			System.out.println("Player ID is excluded");
		} else {
			System.out.println("Player ID is not excluded");
		}

	}

	@And("Validate the Advanced Configurations with {string} macaddress and has won {string}")
	public void advancedConfigurations(String macAddress, String isWon) throws AutomationException, IOException {

		PromotionEndPoints promotionCalls = new PromotionEndPoints();
		// make load player call
		HttpResponse<String> loadPlayerResponse = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObj = WebServiceUtil.xmlToJSONObject(loadPlayerResponse.getBody());
		String extractedPlayerID = String.valueOf(WebServiceUtil.xmlToJsonPath(jsonObj, "$.PlayerResult.PlayerID"));

		System.out.println("load player call " + extractedPlayerID);
		System.out.println("promotion id captured from UI " + promotionId);

		// make getPlayerinfo call
		promotionCalls.getPlayerInfo(cardNumber, macAddress);

		// make Get promotion call
		HttpResponse<String> getPromotionResponse = promotionCalls.getPromotions(extractedPlayerID, macAddress);
		JSONObject promtionJson = WebServiceUtil.xmlToJSONObject(getPromotionResponse.getBody());
		// to check if the given element in json path is not present

		String actualPromotionId = String.valueOf(WebServiceUtil.xmlToJsonPath(promtionJson,
				"$.PromotionsResult.Promotions.Promotion[?(@.ID == " + promotionId + ")].ID"));
		System.out.println("actualPromotionId " + actualPromotionId);

		// make promotion status call
		HttpResponse<String> promotionStatusResponse = promotionCalls.getPromotionStatus(playerId, promotionId,
				macAddress);
		System.out.println("promotionStatusResponse is" + promotionStatusResponse.toString());
		Document domObj = WebServiceUtil.xmlToDOM(promotionStatusResponse.getBody());
		System.out.println("domObj is" + domObj.toString());
		String reveal = null;
		reveal = WebServiceUtil.findElementXpathAsString(domObj, "/PromotionStatusResult/Custom/Parameters/reveal");

		if (reveal.equals("true")) {
			System.out.println("Reveal functionality available");
		} else if (reveal.equals(" ")) {
			System.out.println("Reveal functionality not available");
		}
	}

	@And("User participate in promotion twice with {string} macaddress and has won {string}")
	public void participateInPromotionTwice(String macAddress, String isWon) throws AutomationException, IOException {

		PromotionEndPoints promotionCalls = new PromotionEndPoints();
		// make load player call
		System.out.println("The Player ID is " + playerId);
		HttpResponse<String> loadPlayerResponse = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObj = WebServiceUtil.xmlToJSONObject(loadPlayerResponse.getBody());
		System.out.println("json is " + jsonObj);
		String extractedPlayerID = String.valueOf(WebServiceUtil.xmlToJsonPath(jsonObj, "$.PlayerResult.PlayerID"));

		System.out.println("load player call " + extractedPlayerID);
		System.out.println("promotion id captured from UI " + promotionId);
		System.out.println("RedemptionCodeOnWin value is " + RedemptionCodeOnWin);
		System.out.println("PrizeType value is " + PrizeType);

		int availablePointsBefore = (int) WebServiceUtil.xmlToJsonPath(jsonObj,
				"$.PlayerResult.PlayerFields.Fields.AvailablePoints");

		// make getPlayerinfo call
		promotionCalls.getPlayerInfo(cardNumber, macAddress);

		// make promotion status call
		HttpResponse<String> promotionStatusResponse = promotionCalls.getPromotionStatus(extractedPlayerID, promotionId,
				macAddress);
		Document domObj = WebServiceUtil.xmlToDOM(promotionStatusResponse.getBody());
		int usedparticipation = WebServiceUtil.findElementXpathOfInt(domObj,
				"/PromotionStatusResult/Custom/Parameters/usedparticipation");
		Assert.assertEquals(0, usedparticipation);
		System.out.println("The used Participation count is " + usedparticipation);

		// make participate in promotion call
		HttpResponse<String> participateInPromotionResponse = promotionCalls.participateInPromotion(extractedPlayerID,
				promotionId, macAddress, prizeIdentity, isWon);
		JSONObject promotionParticipatedJson = WebServiceUtil.xmlToJSONObject(participateInPromotionResponse.getBody());
		int actualValue = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJson,
				"$.SinglePrizeResult.Prize.Value");
		Assert.assertEquals(expectedValue, actualValue);
		System.out.println("The actual prize value count is " + actualValue);
		System.out.println("The expected prize value count is " + expectedValue);

		int actualQuantity = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJson,
				"$.SinglePrizeResult.Prize.Quantity");
		Assert.assertEquals(expectedQuantity, actualQuantity);
		System.out.println("The actual Quantity is " + actualQuantity);
		System.out.println("The expected Quantity is " + expectedQuantity);

		int receiptID = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJson, "$.SinglePrizeResult.ReceiptID");
		System.out.println("The Receipt ID is " + receiptID);

		// make load player call again
		System.out.println("The Player ID is " + playerId);
		HttpResponse<String> loadPlayerResponseagain = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObjAgain = WebServiceUtil.xmlToJSONObject(loadPlayerResponseagain.getBody());
		System.out.println("json is" + jsonObjAgain);
		int pointsBalance = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.PointsBalance");
		int availablePoints = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.AvailablePoints");
		String compDollarBalance = String.valueOf(
				WebServiceUtil.xmlToJsonPath(jsonObjAgain, "$.PlayerResult.PlayerFields.Fields.CompDollarBalance"));
		int compBalance = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.CompBalance");
		int compPtBalance = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.CompPtBalance");
		String compDollarMaxRedeem = String.valueOf(
				WebServiceUtil.xmlToJsonPath(jsonObjAgain, "$.PlayerResult.PlayerFields.Fields.CompDollarMaxRedeem"));
		int pointsEarnedToday = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.PointsEarnedToday");
		System.out.println("Points Balance " + pointsBalance);
		System.out.println("Available Points " + availablePoints);
		System.out.println("Comp Dollar Balance " + compDollarBalance);
		System.out.println("Comp Balance " + compBalance);
		System.out.println("Comp Pt Balance " + compPtBalance);
		System.out.println("Comp Dollar Max Redeem " + compDollarMaxRedeem);
		System.out.println("Points Earned Today " + pointsEarnedToday);

		if (PrizeType.equals("Point Add") || PrizeType.equals("Comp Add")) {
			int pointChanged = (int) (availablePoints - availablePointsBefore);
			Assert.assertEquals(RedemptionCodeOnWin, pointChanged);
			System.out.println("Point value updated is " + pointChanged);
		} else if (PrizeType.equals("Comp Deduct") || PrizeType.equals("Point Deduct")) {
			int pointChanged = (int) (availablePointsBefore - availablePoints);
			Assert.assertEquals(0, pointChanged);
			System.out.println("Point value updated is " + pointChanged);

		}

		else {

			int pointChanged = (int) (availablePoints - availablePointsBefore);
			Assert.assertEquals(RedemptionCodeOnWin, pointChanged);
			System.out.println("Point value updated is " + pointChanged);

		}

		// make load player call for second participation
		System.out.println("The Player ID is " + playerId);
		HttpResponse<String> loadPlayerResponseTwice = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObjTwiceParticipation = WebServiceUtil.xmlToJSONObject(loadPlayerResponseTwice.getBody());
		System.out.println("json is " + jsonObjTwiceParticipation);
		String extractedPlayerIDTwice = String
				.valueOf(WebServiceUtil.xmlToJsonPath(jsonObjTwiceParticipation, "$.PlayerResult.PlayerID"));

		System.out.println("load player call " + extractedPlayerIDTwice);
		System.out.println("promotion id captured from UI " + promotionId);
		System.out.println("RedemptionCodeOnWin value is " + RedemptionCodeOnWin);
		System.out.println("PrizeType value is " + PrizeType);

		int availablePointsBeforeTwice = (int) WebServiceUtil.xmlToJsonPath(jsonObj,
				"$.PlayerResult.PlayerFields.Fields.AvailablePoints");

		// make getPlayerinfo call for second participation
		promotionCalls.getPlayerInfo(cardNumber, macAddress);

		// make promotion status call
		HttpResponse<String> promotionStatusResponseTwice = promotionCalls.getPromotionStatus(extractedPlayerID,
				promotionId, macAddress);
		Document domObjTwice = WebServiceUtil.xmlToDOM(promotionStatusResponseTwice.getBody());
		int usedparticipationTwice = WebServiceUtil.findElementXpathOfInt(domObjTwice,
				"/PromotionStatusResult/Custom/Parameters/usedparticipation");
		System.out.println("The used Participation count is " + usedparticipationTwice);

		// make participate in promotion call for second participation
		HttpResponse<String> participateInPromotionResponseTwice = promotionCalls
				.participateInPromotion(extractedPlayerID, promotionId, macAddress, prizeIdentity, isWon);
		JSONObject promotionParticipatedJsonTwice = WebServiceUtil
				.xmlToJSONObject(participateInPromotionResponseTwice.getBody());
		int actualValueTwice = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJsonTwice,
				"$.SinglePrizeResult.Prize.Value");
		Assert.assertEquals(expectedValue, actualValueTwice);
		System.out.println("The actual prize value count is " + actualValueTwice);
		System.out.println("The expected prize value count is " + expectedValue);

		int actualQuantityTwice = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJsonTwice,
				"$.SinglePrizeResult.Prize.Quantity");
		Assert.assertEquals(expectedQuantity, actualQuantityTwice);
		System.out.println("The actual Quantity is " + actualQuantityTwice);
		System.out.println("The expected Quantity is " + expectedQuantity);

		int receiptIDTwice = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJsonTwice,
				"$.SinglePrizeResult.ReceiptID");
		System.out.println("The Receipt ID is " + receiptIDTwice);

		// make load player call again
		System.out.println("The Player ID is " + playerId);
		HttpResponse<String> loadPlayerResponseagainTwice = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObjAgainTwice = WebServiceUtil.xmlToJSONObject(loadPlayerResponseagainTwice.getBody());
		System.out.println("json is" + jsonObjAgainTwice);
		int pointsBalanceTwice = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgainTwice,
				"$.PlayerResult.PlayerFields.Fields.PointsBalance");
		int availablePointsTwice = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgainTwice,
				"$.PlayerResult.PlayerFields.Fields.AvailablePoints");
		String compDollarBalanceTwice = String.valueOf(WebServiceUtil.xmlToJsonPath(jsonObjAgainTwice,
				"$.PlayerResult.PlayerFields.Fields.CompDollarBalance"));
		int compBalanceTwice = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgainTwice,
				"$.PlayerResult.PlayerFields.Fields.CompBalance");
		int compPtBalanceTwice = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgainTwice,
				"$.PlayerResult.PlayerFields.Fields.CompPtBalance");
		String compDollarMaxRedeemTwice = String.valueOf(WebServiceUtil.xmlToJsonPath(jsonObjAgainTwice,
				"$.PlayerResult.PlayerFields.Fields.CompDollarMaxRedeem"));
		int pointsEarnedTodayTwice = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgainTwice,
				"$.PlayerResult.PlayerFields.Fields.PointsEarnedToday");
		System.out.println("Points Balance " + pointsBalanceTwice);
		System.out.println("Available Points " + availablePointsTwice);
		System.out.println("Comp Dollar Balance " + compDollarBalanceTwice);
		System.out.println("Comp Balance " + compBalanceTwice);
		System.out.println("Comp Pt Balance " + compPtBalanceTwice);
		System.out.println("Comp Dollar Max Redeem " + compDollarMaxRedeemTwice);
		System.out.println("Points Earned Today " + pointsEarnedTodayTwice);

		if (PrizeType.equals("Point Add") || PrizeType.equals("Comp Add")) {
			int pointChangedTwice = (int) (availablePointsTwice - availablePointsBefore);
			Assert.assertEquals((RedemptionCodeOnWin * 2), pointChangedTwice);
			System.out.println("Point value updated is " + pointChangedTwice);
		} else if (PrizeType.equals("Comp Deduct") || PrizeType.equals("Point Deduct")) {
			int pointChangedTwice = (int) (availablePointsBefore - availablePointsTwice);
			Assert.assertEquals(0, pointChangedTwice);
			System.out.println("Point value updated is " + pointChangedTwice);

		}

		else {

			int pointChanged = (int) (availablePoints - availablePointsBefore);
			Assert.assertEquals(RedemptionCodeOnWin, pointChanged);
			System.out.println("Point value updated is " + pointChanged);

		}

	}

	@And("User participate in promotion period thrice and participate with {string} macaddress and has won {string}")
	public void participateInPromotionPeriod(String macAddress, String isWon) throws AutomationException, IOException {

		PromotionEndPoints promotionCalls = new PromotionEndPoints();
		// make load player call
		System.out.println("The Player ID is " + playerId);
		HttpResponse<String> loadPlayerResponse = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObj = WebServiceUtil.xmlToJSONObject(loadPlayerResponse.getBody());
		System.out.println("json is " + jsonObj);
		String extractedPlayerID = String.valueOf(WebServiceUtil.xmlToJsonPath(jsonObj, "$.PlayerResult.PlayerID"));

		System.out.println("load player call " + extractedPlayerID);
		System.out.println("promotion id captured from UI " + promotionId);
		System.out.println("RedemptionCodeOnWin value is " + RedemptionCodeOnWin);
		System.out.println("PrizeType value is " + PrizeType);

		int availablePointsBefore = (int) WebServiceUtil.xmlToJsonPath(jsonObj,
				"$.PlayerResult.PlayerFields.Fields.AvailablePoints");

		// make getPlayerinfo call
		promotionCalls.getPlayerInfo(cardNumber, macAddress);

		// make promotion status call
		HttpResponse<String> promotionStatusResponse = promotionCalls.getPromotionStatus(extractedPlayerID, promotionId,
				macAddress);
		Document domObj = WebServiceUtil.xmlToDOM(promotionStatusResponse.getBody());
		int usedparticipation = WebServiceUtil.findElementXpathOfInt(domObj,
				"/PromotionStatusResult/Custom/Parameters/usedparticipation");
		Assert.assertEquals(0, usedparticipation);
		System.out.println("The used Participation count is " + usedparticipation);

		// make participate in promotion call
		HttpResponse<String> participateInPromotionResponse = promotionCalls.participateInPromotion(extractedPlayerID,
				promotionId, macAddress, prizeIdentity, isWon);
		JSONObject promotionParticipatedJson = WebServiceUtil.xmlToJSONObject(participateInPromotionResponse.getBody());
		int actualValue = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJson,
				"$.SinglePrizeResult.Prize.Value");
		Assert.assertEquals(expectedValue, actualValue);
		System.out.println("The actual prize value count is " + actualValue);
		System.out.println("The expected prize value count is " + expectedValue);

		int actualQuantity = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJson,
				"$.SinglePrizeResult.Prize.Quantity");
		Assert.assertEquals(expectedQuantity, actualQuantity);
		System.out.println("The actual Quantity is " + actualQuantity);
		System.out.println("The expected Quantity is " + expectedQuantity);

		int receiptID = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJson, "$.SinglePrizeResult.ReceiptID");
		System.out.println("The Receipt ID is " + receiptID);

		// make load player call again
		System.out.println("The Player ID is " + playerId);
		HttpResponse<String> loadPlayerResponseagain = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObjAgain = WebServiceUtil.xmlToJSONObject(loadPlayerResponseagain.getBody());
		System.out.println("json is" + jsonObjAgain);
		int pointsBalance = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.PointsBalance");
		int availablePoints = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.AvailablePoints");
		String compDollarBalance = String.valueOf(
				WebServiceUtil.xmlToJsonPath(jsonObjAgain, "$.PlayerResult.PlayerFields.Fields.CompDollarBalance"));
		int compBalance = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.CompBalance");
		int compPtBalance = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.CompPtBalance");
		String compDollarMaxRedeem = String.valueOf(
				WebServiceUtil.xmlToJsonPath(jsonObjAgain, "$.PlayerResult.PlayerFields.Fields.CompDollarMaxRedeem"));
		int pointsEarnedToday = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.PointsEarnedToday");
		System.out.println("Points Balance " + pointsBalance);
		System.out.println("Available Points " + availablePoints);
		System.out.println("Comp Dollar Balance " + compDollarBalance);
		System.out.println("Comp Balance " + compBalance);
		System.out.println("Comp Pt Balance " + compPtBalance);
		System.out.println("Comp Dollar Max Redeem " + compDollarMaxRedeem);
		System.out.println("Points Earned Today " + pointsEarnedToday);

		// make load player call for second participation
		System.out.println("The Player ID is " + playerId);
		HttpResponse<String> loadPlayerResponseTwice = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObjTwiceParticipation = WebServiceUtil.xmlToJSONObject(loadPlayerResponseTwice.getBody());
		System.out.println("json is " + jsonObjTwiceParticipation);
		String extractedPlayerIDTwice = String
				.valueOf(WebServiceUtil.xmlToJsonPath(jsonObjTwiceParticipation, "$.PlayerResult.PlayerID"));

		System.out.println("load player call " + extractedPlayerIDTwice);
		System.out.println("promotion id captured from UI " + promotionId);
		System.out.println("RedemptionCodeOnWin value is " + RedemptionCodeOnWin);
		System.out.println("PrizeType value is " + PrizeType);

		int availablePointsBeforeTwice = (int) WebServiceUtil.xmlToJsonPath(jsonObj,
				"$.PlayerResult.PlayerFields.Fields.AvailablePoints");

		// make getPlayerinfo call for second participation
		promotionCalls.getPlayerInfo(cardNumber, macAddress);

		// make promotion status call
		HttpResponse<String> promotionStatusResponseTwice = promotionCalls.getPromotionStatus(extractedPlayerID,
				promotionId, macAddress);
		Document domObjTwice = WebServiceUtil.xmlToDOM(promotionStatusResponseTwice.getBody());
		int usedparticipationTwice = WebServiceUtil.findElementXpathOfInt(domObjTwice,
				"/PromotionStatusResult/Custom/Parameters/usedparticipation");
		System.out.println("The used Participation count is " + usedparticipationTwice);

		// make participate in promotion call for second participation
		HttpResponse<String> participateInPromotionResponseTwice = promotionCalls
				.participateInPromotion(extractedPlayerID, promotionId, macAddress, prizeIdentity, isWon);
		JSONObject promotionParticipatedJsonTwice = WebServiceUtil
				.xmlToJSONObject(participateInPromotionResponseTwice.getBody());
		int actualValueTwice = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJsonTwice,
				"$.SinglePrizeResult.Prize.Value");
		Assert.assertEquals(expectedValue, actualValueTwice);
		System.out.println("The actual prize value count is " + actualValueTwice);
		System.out.println("The expected prize value count is " + expectedValue);

		int actualQuantityTwice = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJsonTwice,
				"$.SinglePrizeResult.Prize.Quantity");
		Assert.assertEquals(expectedQuantity, actualQuantityTwice);
		System.out.println("The actual Quantity is " + actualQuantityTwice);
		System.out.println("The expected Quantity is " + expectedQuantity);

		int receiptIDTwice = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJsonTwice,
				"$.SinglePrizeResult.ReceiptID");
		System.out.println("The Receipt ID is " + receiptIDTwice);

		// make load player call again
		System.out.println("The Player ID is " + playerId);
		HttpResponse<String> loadPlayerResponseagainTwice = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObjAgainTwice = WebServiceUtil.xmlToJSONObject(loadPlayerResponseagainTwice.getBody());
		System.out.println("json is" + jsonObjAgainTwice);
		int pointsBalanceTwice = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgainTwice,
				"$.PlayerResult.PlayerFields.Fields.PointsBalance");
		int availablePointsTwice = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgainTwice,
				"$.PlayerResult.PlayerFields.Fields.AvailablePoints");
		String compDollarBalanceTwice = String.valueOf(WebServiceUtil.xmlToJsonPath(jsonObjAgainTwice,
				"$.PlayerResult.PlayerFields.Fields.CompDollarBalance"));
		int compBalanceTwice = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgainTwice,
				"$.PlayerResult.PlayerFields.Fields.CompBalance");
		int compPtBalanceTwice = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgainTwice,
				"$.PlayerResult.PlayerFields.Fields.CompPtBalance");
		String compDollarMaxRedeemTwice = String.valueOf(WebServiceUtil.xmlToJsonPath(jsonObjAgainTwice,
				"$.PlayerResult.PlayerFields.Fields.CompDollarMaxRedeem"));
		int pointsEarnedTodayTwice = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgainTwice,
				"$.PlayerResult.PlayerFields.Fields.PointsEarnedToday");
		System.out.println("Points Balance " + pointsBalanceTwice);
		System.out.println("Available Points " + availablePointsTwice);
		System.out.println("Comp Dollar Balance " + compDollarBalanceTwice);
		System.out.println("Comp Balance " + compBalanceTwice);
		System.out.println("Comp Pt Balance " + compPtBalanceTwice);
		System.out.println("Comp Dollar Max Redeem " + compDollarMaxRedeemTwice);
		System.out.println("Points Earned Today " + pointsEarnedTodayTwice);

		// make load player call for third participation
		System.out.println("The Player ID is " + playerId);
		HttpResponse<String> loadPlayerResponseThrice = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObjThriceParticipation = WebServiceUtil.xmlToJSONObject(loadPlayerResponseThrice.getBody());
		System.out.println("json is " + jsonObjThriceParticipation);
		String extractedPlayerIDThrice = String
				.valueOf(WebServiceUtil.xmlToJsonPath(jsonObjThriceParticipation, "$.PlayerResult.PlayerID"));

		System.out.println("load player call " + extractedPlayerIDThrice);
		System.out.println("promotion id captured from UI " + promotionId);
		System.out.println("RedemptionCodeOnWin value is " + RedemptionCodeOnWin);
		System.out.println("PrizeType value is " + PrizeType);

		int availablePointsBeforeThrice = (int) WebServiceUtil.xmlToJsonPath(jsonObj,
				"$.PlayerResult.PlayerFields.Fields.AvailablePoints");

		// make getPlayerinfo call for third participation
		promotionCalls.getPlayerInfo(cardNumber, macAddress);

		// make promotion status call
		HttpResponse<String> promotionStatusResponseThrice = promotionCalls.getPromotionStatus(extractedPlayerID,
				promotionId, macAddress);
		Document domObjThrice = WebServiceUtil.xmlToDOM(promotionStatusResponseThrice.getBody());
		int usedparticipationThrice = WebServiceUtil.findElementXpathOfInt(domObjThrice,
				"/PromotionStatusResult/Custom/Parameters/usedparticipation");
		System.out.println("The used Participation count is " + usedparticipationThrice);

		String screenId = WebServiceUtil.findElementXpathAsString(domObjThrice, "/PromotionStatusResult/ScreenId");

		String[] split = screenId.split("/");

		if (split[3].trim().equals("Already Participated")) {
			System.out.println("Already Participated");
		} else {
			System.out.println("No Error Message available");
		}

	}

	@And("User participate in promotion period twice with {string} macaddress and has won {string}")
	public void participateInPromotionPeriodTwice(String macAddress, String isWon)
			throws AutomationException, IOException {

		PromotionEndPoints promotionCalls = new PromotionEndPoints();
		// make load player call
		System.out.println("The Player ID is " + playerId);
		HttpResponse<String> loadPlayerResponse = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObj = WebServiceUtil.xmlToJSONObject(loadPlayerResponse.getBody());
		System.out.println("json is " + jsonObj);
		String extractedPlayerID = String.valueOf(WebServiceUtil.xmlToJsonPath(jsonObj, "$.PlayerResult.PlayerID"));

		System.out.println("load player call " + extractedPlayerID);
		System.out.println("promotion id captured from UI " + promotionId);
		System.out.println("RedemptionCodeOnWin value is " + RedemptionCodeOnWin);
		System.out.println("PrizeType value is " + PrizeType);

		int availablePointsBefore = (int) WebServiceUtil.xmlToJsonPath(jsonObj,
				"$.PlayerResult.PlayerFields.Fields.AvailablePoints");

		// make getPlayerinfo call
		promotionCalls.getPlayerInfo(cardNumber, macAddress);

		// make promotion status call
		HttpResponse<String> promotionStatusResponse = promotionCalls.getPromotionStatus(extractedPlayerID, promotionId,
				macAddress);
		Document domObj = WebServiceUtil.xmlToDOM(promotionStatusResponse.getBody());
		int usedparticipation = WebServiceUtil.findElementXpathOfInt(domObj,
				"/PromotionStatusResult/Custom/Parameters/usedparticipation");
		Assert.assertEquals(0, usedparticipation);
		System.out.println("The used Participation count is " + usedparticipation);

		// make participate in promotion call
		HttpResponse<String> participateInPromotionResponse = promotionCalls.participateInPromotion(extractedPlayerID,
				promotionId, macAddress, prizeIdentity, isWon);
		JSONObject promotionParticipatedJson = WebServiceUtil.xmlToJSONObject(participateInPromotionResponse.getBody());
		int actualValue = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJson,
				"$.SinglePrizeResult.Prize.Value");
		Assert.assertEquals(expectedValue, actualValue);
		System.out.println("The actual prize value count is " + actualValue);
		System.out.println("The expected prize value count is " + expectedValue);

		int actualQuantity = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJson,
				"$.SinglePrizeResult.Prize.Quantity");
		Assert.assertEquals(expectedQuantity, actualQuantity);
		System.out.println("The actual Quantity is " + actualQuantity);
		System.out.println("The expected Quantity is " + expectedQuantity);

		int receiptID = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJson, "$.SinglePrizeResult.ReceiptID");
		System.out.println("The Receipt ID is " + receiptID);

		// make load player call again
		System.out.println("The Player ID is " + playerId);
		HttpResponse<String> loadPlayerResponseagain = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObjAgain = WebServiceUtil.xmlToJSONObject(loadPlayerResponseagain.getBody());
		System.out.println("json is" + jsonObjAgain);
		int pointsBalance = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.PointsBalance");
		int availablePoints = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.AvailablePoints");
		String compDollarBalance = String.valueOf(
				WebServiceUtil.xmlToJsonPath(jsonObjAgain, "$.PlayerResult.PlayerFields.Fields.CompDollarBalance"));
		int compBalance = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.CompBalance");
		int compPtBalance = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.CompPtBalance");
		String compDollarMaxRedeem = String.valueOf(
				WebServiceUtil.xmlToJsonPath(jsonObjAgain, "$.PlayerResult.PlayerFields.Fields.CompDollarMaxRedeem"));
		int pointsEarnedToday = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.PointsEarnedToday");
		System.out.println("Points Balance " + pointsBalance);
		System.out.println("Available Points " + availablePoints);
		System.out.println("Comp Dollar Balance " + compDollarBalance);
		System.out.println("Comp Balance " + compBalance);
		System.out.println("Comp Pt Balance " + compPtBalance);
		System.out.println("Comp Dollar Max Redeem " + compDollarMaxRedeem);
		System.out.println("Points Earned Today " + pointsEarnedToday);

		// make load player call for second participation
		System.out.println("The Player ID is " + playerId);
		HttpResponse<String> loadPlayerResponseTwice = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObjTwiceParticipation = WebServiceUtil.xmlToJSONObject(loadPlayerResponseTwice.getBody());
		System.out.println("json is " + jsonObjTwiceParticipation);
		String extractedPlayerIDTwice = String
				.valueOf(WebServiceUtil.xmlToJsonPath(jsonObjTwiceParticipation, "$.PlayerResult.PlayerID"));

		System.out.println("load player call " + extractedPlayerIDTwice);
		System.out.println("promotion id captured from UI " + promotionId);
		System.out.println("RedemptionCodeOnWin value is " + RedemptionCodeOnWin);
		System.out.println("PrizeType value is " + PrizeType);

		int availablePointsBeforeTwice = (int) WebServiceUtil.xmlToJsonPath(jsonObj,
				"$.PlayerResult.PlayerFields.Fields.AvailablePoints");

		// make getPlayerinfo call for second participation
		promotionCalls.getPlayerInfo(cardNumber, macAddress);

		// make promotion status call for second participation
		HttpResponse<String> promotionStatusResponseTwice = promotionCalls.getPromotionStatus(extractedPlayerID,
				promotionId, macAddress);
		Document domObjTwice = WebServiceUtil.xmlToDOM(promotionStatusResponseTwice.getBody());

		String screenId = WebServiceUtil.findElementXpathAsString(domObjTwice, "/PromotionStatusResult/ScreenId");

		String[] split = screenId.split("/");

		if (split[3].trim().equals("Already Participated")) {
			System.out.println("Already Participated");
		} else {
			System.out.println("No Error Message available");
		}

	}

	@And("User validates the prizes based on the {string} macaddress and has won {string}")
	public void validatePrizes(String macAddress, String isWon) throws AutomationException, IOException {

		PromotionEndPoints promotionCalls = new PromotionEndPoints();
		// make load player call
		System.out.println("The Player ID is " + playerId);
		HttpResponse<String> loadPlayerResponse = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObj = WebServiceUtil.xmlToJSONObject(loadPlayerResponse.getBody());
		System.out.println("json is " + jsonObj);
		String extractedPlayerID = String.valueOf(WebServiceUtil.xmlToJsonPath(jsonObj, "$.PlayerResult.PlayerID"));

		System.out.println("load player call " + extractedPlayerID);
		System.out.println("promotion id captured from UI " + promotionId);
		System.out.println("RedemptionCodeOnWin value is " + RedemptionCodeOnWin);
		System.out.println("PrizeType value is " + PrizeType);

		int availablePointsBefore = (int) WebServiceUtil.xmlToJsonPath(jsonObj,
				"$.PlayerResult.PlayerFields.Fields.AvailablePoints");

		// make getPlayerinfo call
		promotionCalls.getPlayerInfo(cardNumber, macAddress);

		// make GetPrizes call
		HttpResponse<String> getPrizesResponse = promotionCalls.getPrizes(playerId, promotionId);
		JSONObject getPrizesResponseJson = WebServiceUtil.xmlToJSONObject(getPrizesResponse.getBody());
		int value = (int) WebServiceUtil.xmlToJsonPath(getPrizesResponseJson, "$.PrizesResult.Prizes.PrizeModel.Value");
		System.out.println("The prize value count is" + value);

		// make GetEligiblePrizes call
		HttpResponse<String> eligiblePrizesResponse = promotionCalls.getEligiblePrizes(playerId, promotionId);

		JSONObject eligiblePrizesResponseJson = WebServiceUtil.xmlToJSONObject(eligiblePrizesResponse.getBody());
		Document domObjTwice = WebServiceUtil.xmlToDOM(eligiblePrizesResponse.getBody());

		String screenId = WebServiceUtil.findElementXpathAsString(domObjTwice, "/PrizesResult/ErrorMessage");

		if (screenId.equals("No prizes exist for this player and promotion")) {
			System.out.println("No prizes exist for this player and promotion");
		} else {
			System.out.println("No Error Message available");

			String valueEligible = String.valueOf(
					WebServiceUtil.xmlToJsonPath(eligiblePrizesResponseJson, "$.PrizesResult.Prizes.PrizeModel.Value"));
			System.out.println("The prize value count is" + valueEligible);

		}

	}

	@And("User participate in promotion period which is not valid and participate with {string} macaddress and has won {string}")
	public void participateInPromotionPeriodNotValid(String macAddress, String isWon)
			throws AutomationException, IOException {

		PromotionEndPoints promotionCalls = new PromotionEndPoints();
		// make load player call
		System.out.println("The Player ID is " + playerId);
		HttpResponse<String> loadPlayerResponse = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObj = WebServiceUtil.xmlToJSONObject(loadPlayerResponse.getBody());
		System.out.println("json is " + jsonObj);
		String extractedPlayerID = String.valueOf(WebServiceUtil.xmlToJsonPath(jsonObj, "$.PlayerResult.PlayerID"));

		System.out.println("load player call " + extractedPlayerID);
		System.out.println("promotion id captured from UI " + promotionId);
		System.out.println("RedemptionCodeOnWin value is " + RedemptionCodeOnWin);
		System.out.println("PrizeType value is " + PrizeType);

		int availablePointsBefore = (int) WebServiceUtil.xmlToJsonPath(jsonObj,
				"$.PlayerResult.PlayerFields.Fields.AvailablePoints");

		// make getPlayerinfo call
		promotionCalls.getPlayerInfo(cardNumber, macAddress);

		// make promotion status call
		HttpResponse<String> promotionStatusResponse = promotionCalls.getPromotionStatus(extractedPlayerID, promotionId,
				macAddress);
		Document domObj = WebServiceUtil.xmlToDOM(promotionStatusResponse.getBody());
		String screenId = WebServiceUtil.findElementXpathAsString(domObj, "/PromotionStatusResult/ScreenId");

		String[] split = screenId.split("/");

		if (split[3].trim().equals("Promotion Is Not Available")) {
			System.out.println("Promotion Is Not Available");
		} else {
			System.out.println("No Error Message available");
		}

	}

	@And("Validate the exclude participant condition with {string} macaddress and has won {string}")
	public void validateExcludeIDTc(String macAddress, String isWon) throws AutomationException, IOException {
		String playerId = GlobalVariables.testDataMap.get("PlayerIdforExcludeTC");

		PromotionEndPoints promotionCalls = new PromotionEndPoints();
		// make load player call
		HttpResponse<String> loadPlayerResponse = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObj = WebServiceUtil.xmlToJSONObject(loadPlayerResponse.getBody());
		String extractedPlayerID = String.valueOf(WebServiceUtil.xmlToJsonPath(jsonObj, "$.PlayerResult.PlayerID"));
		System.out.println("load player call " + extractedPlayerID);
		System.out.println("promotion id captured from UI " + promotionId);
		System.out.println("RedemptionCodeOnWin value is " + RedemptionCodeOnWin);
		System.out.println("PrizeType value is " + PrizeType);

		int availablePointsBefore = (int) WebServiceUtil.xmlToJsonPath(jsonObj,
				"$.PlayerResult.PlayerFields.Fields.AvailablePoints");
		int availablePointsCompBefore = (int) WebServiceUtil.xmlToJsonPath(jsonObj,
				"$.PlayerResult.PlayerFields.Fields.CompPtBalance");

		// make getPlayerinfo call
		promotionCalls.getPlayerInfo(cardNumber, macAddress);

		// make promotion status call
		HttpResponse<String> promotionStatusResponse = promotionCalls.getPromotionStatus(extractedPlayerID, promotionId,
				macAddress);
		Document domObj = WebServiceUtil.xmlToDOM(promotionStatusResponse.getBody());

		// make participate in promotion call
		HttpResponse<String> participateInPromotionResponse = promotionCalls.participateInPromotion(extractedPlayerID,
				promotionId, macAddress, prizeIdentity, isWon);
		JSONObject promotionParticipatedJson = WebServiceUtil.xmlToJSONObject(participateInPromotionResponse.getBody());
		int actualValue = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJson,
				"$.SinglePrizeResult.Prize.Value");
		Assert.assertEquals(expectedValue, actualValue);
		System.out.println("The actual prize value count is " + actualValue);
		System.out.println("The expected prize value count is " + expectedValue);

		int actualQuantity = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJson,
				"$.SinglePrizeResult.Prize.Quantity");
		Assert.assertEquals(expectedQuantity, actualQuantity);
		System.out.println("The actual Quantity is " + actualQuantity);
		System.out.println("The expected Quantity is " + expectedQuantity);

		int receiptID = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJson, "$.SinglePrizeResult.ReceiptID");
		System.out.println("The Receipt ID is " + receiptID);

		// make load player call again
		System.out.println("The Player ID is " + playerId);
		HttpResponse<String> loadPlayerResponseagain = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObjAgain = WebServiceUtil.xmlToJSONObject(loadPlayerResponseagain.getBody());
		System.out.println("json is" + jsonObjAgain);
		int pointsBalance = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.PointsBalance");
		int availablePoints = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.AvailablePoints");
		String compDollarBalance = String.valueOf(
				WebServiceUtil.xmlToJsonPath(jsonObjAgain, "$.PlayerResult.PlayerFields.Fields.CompDollarBalance"));
		int compBalance = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.CompBalance");
		int compPtBalance = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.CompPtBalance");
		String compDollarMaxRedeem = String.valueOf(
				WebServiceUtil.xmlToJsonPath(jsonObjAgain, "$.PlayerResult.PlayerFields.Fields.CompDollarMaxRedeem"));
		int pointsEarnedToday = (int) WebServiceUtil.xmlToJsonPath(jsonObjAgain,
				"$.PlayerResult.PlayerFields.Fields.PointsEarnedToday");
		System.out.println("Points Balance " + pointsBalance);
		System.out.println("Available Points " + availablePoints);
		System.out.println("Comp Dollar Balance " + compDollarBalance);
		System.out.println("Comp Balance " + compBalance);
		System.out.println("Comp Pt Balance " + compPtBalance);
		System.out.println("Comp Dollar Max Redeem " + compDollarMaxRedeem);
		System.out.println("Points Earned Today " + pointsEarnedToday);

		if (PrizeType.equals("Point Add")) {
			int pointChanged = (int) (availablePoints - availablePointsBefore);
			Assert.assertEquals(RedemptionCodeOnWin, pointChanged);
			System.out.println("Point value updated is " + pointChanged);
		} else {
			int pointChanged = (int) (availablePoints - availablePointsBefore);
			Assert.assertEquals(RedemptionCodeOnWin, pointChanged);
			System.out.println("Point value updated is " + pointChanged);
		}

	}

	@And("User participate in drawing entries and promotion with {string} macaddress and has won {string}")
	public void participateInPromotionDrawingEntries(String macAddress, String isWon)
			throws AutomationException, IOException {

		PromotionEndPoints promotionCalls = new PromotionEndPoints();

		int noOfEntries = Integer.parseInt(GlobalVariables.testDataMap.get("NoOfEntries"));
		System.out.println("The entries from testdata is " + noOfEntries);

		String drawingID = GlobalVariables.testDataMap.get("DrawingID");

		// make getDrawingEntries call
		HttpResponse<String> getDrawingResponse = promotionCalls.getDrawingEntries(playerId, drawingID);
		JSONObject jsonObjDrawing = WebServiceUtil.xmlToJSONObject(getDrawingResponse.getBody());
		System.out.println("json is " + jsonObjDrawing);

		int entriesBefore = (int) WebServiceUtil.xmlToJsonPath(jsonObjDrawing, "$.DrawingEntriesResult.NewEntries");
		System.out.println("The entries before Participation is " + entriesBefore);

		// make load player call
		System.out.println("The Player ID is " + playerId);
		HttpResponse<String> loadPlayerResponse = promotionCalls.loadPlayer(playerId);
		JSONObject jsonObj = WebServiceUtil.xmlToJSONObject(loadPlayerResponse.getBody());
		System.out.println("json is " + jsonObj);
		String extractedPlayerID = String.valueOf(WebServiceUtil.xmlToJsonPath(jsonObj, "$.PlayerResult.PlayerID"));

		System.out.println("load player call " + extractedPlayerID);
		System.out.println("promotion id captured from UI " + promotionId);
		System.out.println("RedemptionCodeOnWin value is " + RedemptionCodeOnWin);
		System.out.println("PrizeType value is " + PrizeType);

		int availablePointsBefore = (int) WebServiceUtil.xmlToJsonPath(jsonObj,
				"$.PlayerResult.PlayerFields.Fields.AvailablePoints");

		// make getPlayerinfo call
		promotionCalls.getPlayerInfo(cardNumber, macAddress);

		// make promotion status call
		HttpResponse<String> promotionStatusResponse = promotionCalls.getPromotionStatus(extractedPlayerID, promotionId,
				macAddress);
		Document domObj = WebServiceUtil.xmlToDOM(promotionStatusResponse.getBody());
		int usedparticipation = WebServiceUtil.findElementXpathOfInt(domObj,
				"/PromotionStatusResult/Custom/Parameters/usedparticipation");

		// make participate in promotion call
		HttpResponse<String> participateInPromotionResponse = promotionCalls.participateInPromotion(extractedPlayerID,
				promotionId, macAddress, prizeIdentity, isWon);
		JSONObject promotionParticipatedJson = WebServiceUtil.xmlToJSONObject(participateInPromotionResponse.getBody());

		int actualQuantity = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJson,
				"$.SinglePrizeResult.Prize.Quantity");
		Assert.assertEquals(expectedQuantity, actualQuantity);
		System.out.println("The actual Quantity is " + actualQuantity);
		System.out.println("The expected Quantity is " + expectedQuantity);

		int receiptID = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJson, "$.SinglePrizeResult.ReceiptID");
		System.out.println("The Receipt ID is " + receiptID);

		// make getDrawingEntries call again
		HttpResponse<String> getDrawingResponseAfter = promotionCalls.getDrawingEntries(playerId, drawingID);
		JSONObject jsonObjDrawingAfter = WebServiceUtil.xmlToJSONObject(getDrawingResponseAfter.getBody());
		System.out.println("json is " + jsonObjDrawingAfter);

		int entriesAfter = (int) WebServiceUtil.xmlToJsonPath(jsonObjDrawingAfter, "$.DrawingEntriesResult.NewEntries");
		System.out.println("The entries after Participation is " + entriesAfter);

		int entriesValue = (int) (entriesAfter - entriesBefore);
		System.out.println("The entries from testdata is " + noOfEntries);
		System.out.println("Point value updated is " + entriesValue);

		Assert.assertEquals(noOfEntries, entriesValue);

	}

	@And("User participate in promotion enrollment type with {string} macaddress and has won {string}")
	public void participateInPromotionPromo(String macAddress, String isWon) throws AutomationException, IOException {

		PromotionEndPoints promotionCalls = new PromotionEndPoints();

		String PlayerIdPromo = GlobalVariables.testDataMap.get("PlayerIdPromo");
		String CardNumberPromo = GlobalVariables.testDataMap.get("CardNumberPromo");

		// make load player call
		System.out.println("The Player ID is " + PlayerIdPromo);
		HttpResponse<String> loadPlayerResponse = promotionCalls.loadPlayer(PlayerIdPromo);
		JSONObject jsonObj = WebServiceUtil.xmlToJSONObject(loadPlayerResponse.getBody());
		System.out.println("json is " + jsonObj);
		String extractedPlayerIDPromo = String
				.valueOf(WebServiceUtil.xmlToJsonPath(jsonObj, "$.PlayerResult.PlayerID"));

		System.out.println("load player call " + extractedPlayerIDPromo);
		System.out.println("promotion id captured from UI " + promotionId);
		System.out.println("RedemptionCodeOnWin value is " + RedemptionCodeOnWin);
		System.out.println("PrizeType value is " + PrizeType);

		int availablePointsBefore = (int) WebServiceUtil.xmlToJsonPath(jsonObj,
				"$.PlayerResult.PlayerFields.Fields.AvailablePoints");
		int availablePointsCompBefore = (int) WebServiceUtil.xmlToJsonPath(jsonObj,
				"$.PlayerResult.PlayerFields.Fields.CompPtBalance");

		// make getPlayerinfo call
		promotionCalls.getPlayerInfo(CardNumberPromo, macAddress);

		// make promotion status call
		HttpResponse<String> promotionStatusResponse = promotionCalls.getPromotionStatus(extractedPlayerIDPromo,
				promotionId, macAddress);
		// JSONObject getPromotionJson =
		// WebServiceUtil.xmlToJSONObject(promotionStatusResponse.getBody());
		Document domObj = WebServiceUtil.xmlToDOM(promotionStatusResponse.getBody());
		int usedparticipation = WebServiceUtil.findElementXpathOfInt(domObj,
				"/PromotionStatusResult/Custom/Parameters/usedparticipation");
		System.out.println("The used Participation count is " + usedparticipation);

		// make participate in promotion call
		HttpResponse<String> participateInPromotionResponse = promotionCalls
				.participateInPromotion(extractedPlayerIDPromo, promotionId, macAddress, prizeIdentity, isWon);
		JSONObject promotionParticipatedJson = WebServiceUtil.xmlToJSONObject(participateInPromotionResponse.getBody());

		int actualQuantity = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJson,
				"$.SinglePrizeResult.Prize.Quantity");
		Assert.assertEquals(expectedQuantity, actualQuantity);
		System.out.println("The actual Quantity is " + actualQuantity);
		System.out.println("The expected Quantity is " + expectedQuantity);

		int receiptID = (int) WebServiceUtil.xmlToJsonPath(promotionParticipatedJson, "$.SinglePrizeResult.ReceiptID");
		System.out.println("The Receipt ID is " + receiptID);

	}

}
