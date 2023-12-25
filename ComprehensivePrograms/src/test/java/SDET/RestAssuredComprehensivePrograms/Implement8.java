package SDET.RestAssuredComprehensivePrograms;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

import org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.Test;

class MyRestAssured {

	public static void urlReceived(String currentUrl) {
		String url = currentUrl;
		Response res = RestAssured.get(url);
		int statusCode = res.getStatusCode();
		if(statusCode==200) {
			System.out.println("Status Code: " + statusCode+" [Positive test case]");
			Assert.assertEquals(statusCode, 200);
		}
		else {
			System.out.println("Status Code: " + statusCode  + " [Negative test case]");
			Assert.assertEquals(statusCode, 404);
		}
		

	}


	public static void urlReceivedWithPathParameter(String str)

	{

		// Given url = "https://restcountries.com/v3.1/currency/{currency}";
		
		RestAssured.baseURI = "https://restcountries.com/v3.1/currency";
		Response response = null;
		try {
			response = RestAssured.given()
					   .pathParam("currency", str)
					   .when()
					   .get("/{currency}");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (response.getStatusCode() == 200) {
			System.out.println("Status Code: " + response.getStatusCode() + " [Positive test case]");
			assertEquals(200, response.getStatusCode());
			
		} else {
			System.out.println("Status Code: " + response.getStatusCode() + " [Negative test case]");
			assertEquals(404, response.getStatusCode());
		}

	}
}

public class Implement8 {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Language:");
		MyRestAssured obj = new MyRestAssured();
		obj.urlReceived("https://restcountries.com/v3.1/lang/spanish");
		obj.urlReceived("https://restcountries.com/v3.1/lang/spanish1");
		
		System.out.println("Currency:");

		// Given URL in TechAcademy Site is https://restcountries.com/v3.1/lang/{currency}
		// But it should be https://restcountries.com/v3.1/currency/{currency}
		// Because we are passing the currency value (Ex:EUR) using the {currency} parameter tag
		// So i have updated the "lang" as "currency" after v3.1 in the URL 

		obj.urlReceivedWithPathParameter("EUR");
		obj.urlReceivedWithPathParameter("TEST");
	}
}
