package com.everi.soapservices;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class PromotionEndPoints {
	static Logger logger = LogManager.getLogger(PromotionEndPoints.class);

	public PromotionEndPoints() {
		Unirest.config().defaultBaseUrl("http://10.208.153.23/PKMS_PROD/webservice/webservice.asmx");

	}

	
	public HttpResponse<String> loadPlayer(String playerID) {
		System.out.println("This is load player call execution");
		String url = "/LoadPlayer";
		logger.info("url fired " + url);
		HttpResponse<String> response = Unirest.post(url).header("Content-Type", "application/x-www-form-urlencoded")
				.field("playerID", playerID).asString().ifFailure(httpResponse -> onFailure(httpResponse))
				.ifSuccess(httpResponse -> onSuccess(httpResponse));

		Assert.assertEquals(200, response.getStatus());
		return response;
	}

	public HttpResponse<String> getPlayerInfo(String cardNumber, String macAddress) {
		System.out.println("This is get player info call execution");
		String url = "/GetPlayerInfo";
		HttpResponse<String> response = Unirest.post(url).header("Content-Type", "application/x-www-form-urlencoded")
				.field("cardNumber", cardNumber).field("macAddress", macAddress).asString()
				.ifFailure(httpResponse -> onFailure(httpResponse)).ifSuccess(httpResponse -> onSuccess(httpResponse));
		Assert.assertEquals(200, response.getStatus());
		return response;
	}

	public HttpResponse<String> getPromotions(String playerID, String macAddress) {
		System.out.println("This is get promotions call execution");
		String url = "/GetPromotions";
		HttpResponse<String> response = Unirest.post(url).header("Content-Type", "application/x-www-form-urlencoded")
				.field("playerID", playerID).field("macAddress", macAddress).asString()
				.ifFailure(httpResponse -> onFailure(httpResponse)).ifSuccess(httpResponse -> onSuccess(httpResponse));
		Assert.assertEquals(200, response.getStatus());
		return response;
	}
	
	public HttpResponse<String> getPromotionStatus(String playerID, String promotionId, String macAddress) {
		System.out.println("This is get promotion status call execution");
		String url = "/GetPromotionStatus";
		List<String> ali = new ArrayList<String>();
		HttpResponse<String> response = Unirest.post(url).header("Content-Type", "application/x-www-form-urlencoded")
				.field("playerID", playerID).field("promotionId", promotionId).field("macAddress", macAddress)
				.asString().ifFailure(httpResponse -> onFailure(httpResponse))
				.ifSuccess(httpResponse -> onSuccess(httpResponse));
		Assert.assertEquals(200, response.getStatus());
		return response;
	}

	public HttpResponse<String> participateInPromotion(String playerID, String promotionID, String macAddress,
			String prizeIdentity, String isWon) {
		System.out.println("This is participate in promotion call execution");
		String url = "/ParticipateInPromotion";
		HttpResponse<String> response = Unirest.post(url).header("Content-Type", "application/x-www-form-urlencoded")
				.field("playerID", playerID).field("promotionID", promotionID).field("macAddress", macAddress)
				.field("isWon", isWon).field("prizeIdentity", prizeIdentity).field("state", "").asString()
				.ifFailure(httpResponse -> onFailure(httpResponse)).ifSuccess(httpResponse -> onSuccess(httpResponse));
		Assert.assertEquals(200, response.getStatus());
		return response;
	}
	
	public HttpResponse<String> getPrizes(String playerID, String promotionID) {
		System.out.println("This is get promotion status call execution");
		String url = "/GetPrizes";
		HttpResponse<String> response = Unirest.post(url).header("Content-Type", "application/x-www-form-urlencoded")
				.field("playerID", playerID).field("promotionID", promotionID).asString()
				.ifFailure(httpResponse -> onFailure(httpResponse)).ifSuccess(httpResponse -> onSuccess(httpResponse));
		Assert.assertEquals(200, response.getStatus());
		return response;
	}

	public void onFailure(HttpResponse<String> httpResponse) {
		logger.error(httpResponse.getStatus() + " failed http call because of : " + httpResponse.getStatusText());
		logger.error("Response header: " + httpResponse.getHeaders());
		logger.error("Response body: " + httpResponse.getBody());
	}

	public void onSuccess(HttpResponse<String> httpResponse) {
		logger.info(httpResponse.getStatus() + " successful http call");
		logger.info("Response Header: " + httpResponse.getHeaders());
		logger.info("Response body: " + httpResponse.getBody());
	}

	public HttpResponse<String> postCall(String url, String body) {
		System.out.println("This is load player call execution");
		logger.info("url fired " + url);
		HttpResponse<String> response = Unirest.post(url).header("Content-Type", "application/x-www-form-urlencoded")
				.body(body).asString().ifFailure(httpResponse -> onFailure(httpResponse))
				.ifSuccess(httpResponse -> onSuccess(httpResponse));
		return response;
		// System.out.println(response.getStatus());
		// JSONObject jsonObj = WebServiceUtil.xmlToJSONObject(response.getBody());
		// WebServiceUtil.xmlToJsonPath(jsonObj, "")
		// String extractedData = xmlPath(response.getBody(),
		// "/PlayerResult/PlayerFields/Fields/CompDollarBalance");
	}
	
	public HttpResponse<String> getEligiblePrizes(String playerID, String promotionID) {
		System.out.println("This is get promotions call execution");
		String url = "/GetEligiblePrizes";
		HttpResponse<String> response = Unirest.post(url).header("Content-Type", "application/x-www-form-urlencoded")
				.field("playerID", playerID).field("promotionID", promotionID).asString()
				.ifFailure(httpResponse -> onFailure(httpResponse)).ifSuccess(httpResponse -> onSuccess(httpResponse));
		Assert.assertEquals(200, response.getStatus());
		return response;
	}
	
	public HttpResponse<String> getCalendar() {
		System.out.println("This is get calendar call execution");
		String url = "/GetCalendar";
		logger.info("url fired " + url);
		HttpResponse<String> response = Unirest.post(url).header("Content-Type", "application/x-www-form-urlencoded")
				.asString().ifFailure(httpResponse -> onFailure(httpResponse))
				.ifSuccess(httpResponse -> onSuccess(httpResponse));
		Assert.assertEquals(200, response.getStatus());
		return response;
	}

	public HttpResponse<String> getDrawingEntries(String playerID, String drawingId) {
		System.out.println("This is get drawing entries status call execution");
		String url = "/GetDrawingEntries";
		HttpResponse<String> response = Unirest.post(url).header("Content-Type", "application/x-www-form-urlencoded")
				.field("playerID", playerID).field("drawingId", drawingId).asString()
				.ifFailure(httpResponse -> onFailure(httpResponse)).ifSuccess(httpResponse -> onSuccess(httpResponse));
		Assert.assertEquals(200, response.getStatus());
		return response;
	}
		
}
