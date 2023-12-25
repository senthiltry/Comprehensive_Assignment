package SDET.TestNGComprehensivePrograms;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Implementation5 {

	static WebDriver driver;
	WebElement whyAutify;
	WebElement pricing;
	WebElement webinars;
	WebElement resources;

	WebElement webElement1;
	WebElement webElement2;

	String url = "https://autify.com/";

	@DataProvider(name = "getTestData_Verify")
	public Object[][] getDataVerify(Method method) {
		Object[][] dataForWhyAutify = { { "Why Autify", "//a[@href='/why-autify']" },
				{ "Pricing", "//a[@href='/pricing']" }, { "Webinars", "//a[@href='/webinars']" },
				{ "Resources", "(//a[@href='#'])[1]" },
				{ "(//a[@title='Start Free Trial'])[1]", "//a[@title='Sign in']" } };
		return dataForWhyAutify;
	}

	@DataProvider(name = "getTestData_Click")
	public Object[][] getDataClick(Method method) {
		Object[][] dataForClick = { { "//a[@href='/why-autify']", "//div[@class='container whyAutify-header']//h1" },
				{ "//a[@href='/pricing']", "(//div[@class='heading'])[1]" },
				{ "//a[@href='/webinars']", "//div[@class='container ']//h1" },
				{ "(//span[@class='menu-image-title-after menu-image-title'])[1]",
						"//div[@class='container container-sm']//h1" } };
		return dataForClick;
	}

	@BeforeSuite
	public void setBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Supporting files and drivers for selenium\\Chromedriver_New\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get(url);
	}

	@Test(dataProvider = "getTestData_Verify")
	public void verifyUrl(String str, String ele) {
		webElement1 = driver.findElement(By.xpath(ele));
		if (str.equals(webElement1.getText()) && webElement1.isDisplayed() == true) {
			System.out.println(str + " URL is displaying in the page");

		} else {
			System.out.println(str + " URL is not displaying in the page");
		}
	}

	@Test(dataProvider = "getTestData_Click")
	public void clickLinks(String ele, String str) throws InterruptedException {
		webElement2 = driver.findElement(By.xpath(ele));
		if (!(ele.equals("(//span[@class='menu-image-title-after menu-image-title'])[1]"))) {
			webElement2.click();
			Thread.sleep(2000);
			String pageText = driver.findElement(By.xpath(str)).getText();
			if (pageText.contains("Leading companies rely on Autify")) {
				System.out.println("Why Autify URL has been clicked and control is navigated to the whyAutify page");
			} else if (pageText.contains("Starter")) {
				System.out.println("Pricing URL has been clicked and control is navigated to the Pricing page");

			} else if (pageText.contains("Webinars")) {
				System.out.println("Webinars URL has been clicked and control is navigated to the Webinars page");

			}

		}

		else {
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("(//a[@href='#'])[1]"))).build().perform();
			action.click(webElement2).build().perform();
			String pageText = driver.findElement(By.xpath(str)).getText();
			if (pageText.contains("Autify Product Guide")) {
				System.out.println(
						"Resources dropdown list has been clicked and control is navigated to the Resources page");

			}

		}

	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}

}
