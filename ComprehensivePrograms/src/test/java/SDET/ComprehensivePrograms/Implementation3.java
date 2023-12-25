package SDET.ComprehensivePrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class GetUrlAndButtonElements {
	static WebDriver driver;
	String url1 = "Why Autify";
	String url2 = "Pricing";
	String url3 = "Webinars";
	String url4 = "Resources";
	WebElement whyAutify;
	WebElement pricing;
	WebElement webinars;
	WebElement resources;
	String url = "https://autify.com/";

	public void setBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Supporting files and drivers for selenium\\Chromedriver_New\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get(url);
	}

	public WebElement verifyWhyAutifyUrl() {

		whyAutify = driver.findElement(By.xpath("//a[@href='/why-autify']"));
		if (url1.equals(whyAutify.getText()) && whyAutify.isDisplayed() == true) {
			System.out.println("Why Autify URL is displaying in the page");

		} else {
			System.out.println("Why Autify URL is not displaying in the page");
		}
		return whyAutify;
	}

	public WebElement verifypricingUrl() {

		pricing = driver.findElement(By.xpath("//a[@href='/pricing']"));
		if (url2.equals(pricing.getText()) && pricing.isDisplayed() == true) {
			System.out.println("Pricing URL is displaying in the page");
		} else {
			System.out.println("Pricing URL is not displaying in the page");
		}
		return pricing;
	}

	public WebElement verifywebinarsUrl() {
		webinars = driver.findElement(By.xpath("//a[@href='/webinars']"));
		if (url3.equals(webinars.getText()) && webinars.isDisplayed() == true) {
			System.out.println("Webinars URL is displaying in the page");
		} else {
			System.out.println("Webinars URL is not displaying in the page");
		}
		return webinars;

	}

	public WebElement verifyresourcesUrl() {
		resources = driver.findElement(By.xpath("(//a[@href='#'])[1]"));
		if (url4.equals(resources.getText()) && resources.isDisplayed() == true) {
			System.out.println("Resources URL is displaying in the page");
		} else {
			System.out.println("Resources URL is not displaying in the page");
		}
		return resources;

	}

	public void buttons_enabled() {

		WebElement button1 = driver.findElement(By.xpath("(//a[@title='Start Free Trial'])[1]"));
		if (button1.isEnabled() == true) {
			System.out.println("Start Free Trial button is enabled to click on it.");
		} else {
			System.out.println("Start Free Trial button is not enabled to click on it.");
		}
		WebElement button2 = driver.findElement(By.xpath("//a[@title='Sign in']"));
		if (button2.isEnabled() == true) {
			System.out.println("Sign in button is enabled to click on it.");
		} else {
			System.out.println("Sign in button is not enabled to click on it.");
		}

	}

	public void closeBrowser() {
		driver.quit();
	}

}

public class Implementation3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GetUrlAndButtonElements obj = new GetUrlAndButtonElements();
		obj.setBrowser();
		obj.verifyWhyAutifyUrl();
		obj.verifypricingUrl();
		obj.verifywebinarsUrl();
		obj.verifyresourcesUrl();
		obj.buttons_enabled();
		obj.closeBrowser();

	}

}
