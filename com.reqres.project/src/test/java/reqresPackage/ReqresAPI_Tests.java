package reqresPackage;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReqresAPI_Tests {

	private ExcelConfig xl;
	private String mail_Id;
	private String pass;

	@BeforeSuite
	public void configExcel() {
		String fileName = "API_TestData.xlsx";
		String sheetName = "TestData";
		xl = new ExcelConfig(fileName);
		xl.getXlSheet(sheetName);
	}

	@BeforeTest
	public void setBaseURI() {
		RestAssured.baseURI = "https://reqres.in";
	}

	@AfterSuite
	public void closeXlConnections() {
		xl.closeXl();
	}

	@Test(priority = 1)
	public void positiveCase() {
		for (int i = 1; i <= xl.getRowNum(); i++) {
			mail_Id = xl.getCellData("Email", i);
			pass = xl.getCellData("Password", i);
		}
		System.out.println("******************** Positive case ********************");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("email", mail_Id);
		jsonObject.put("password", pass);
		Response response = given().header("Content-type", "application/json").and().body(jsonObject.toString()).when()
				.post("/api/register").then().extract().response();
		int statusCode = response.statusCode();
		int responseId = response.jsonPath().getInt("id");
		String token = response.jsonPath().getString("token");
		System.out.println("Status code: " + statusCode);
		System.out.println("Response Id: " + responseId);
		System.out.println("Response Token: " + token);
		Assert.assertEquals(statusCode, 200, "Status code is Invalid!");
	}

	@Test(priority = 2)
	public void negativeCase() {
		for (int i = 1; i <= xl.getRowNum(); i++) {
			mail_Id = xl.getCellData("Email", i);
		}
		System.out.println("******************** Negative case ********************");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("email", mail_Id);
		jsonObject.put("password", "");
		Response response = given().header("Content-type", "application/json").and().body(jsonObject.toString()).when()
				.post("/api/register").then().extract().response();
		int statusCode = response.statusCode();
		String errorMsg = response.jsonPath().getString("error");
		System.out.println("Status code: " + statusCode);
		System.out.println("Error Msg: " + errorMsg);
		Assert.assertEquals(statusCode, 400, "Status code is Invalid!");
	}

}