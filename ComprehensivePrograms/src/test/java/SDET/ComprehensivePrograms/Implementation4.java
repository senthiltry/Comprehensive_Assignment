package SDET.ComprehensivePrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

class ElementClick extends GetUrlAndButtonElements {
	
	WebElement eleWhyAutify;
	WebElement elepricing;
	WebElement eleWebinars;
	WebElement eleResources;
	String whyAutifystr = "Leading companies rely on Autify";
	String pricingStr = "Starter";
	String webinarsStr = "Webinars";
	String resourcesStr = "Autify Product Guide";

	public void SettingBrowser() {
		setBrowser();

	}

	public void whyAutify_Click() throws InterruptedException {

		eleWhyAutify = verifyWhyAutifyUrl();
		eleWhyAutify.click();
		Thread.sleep(2000);
		String pageText1=driver.findElement(By.xpath("//div[@class='container whyAutify-header']//h1")).getText();
		if(pageText1.contains(whyAutifystr)) {
			System.out.println("Why Autify URL has been clicked and control is navigated to the whyAutify page");
		}
		
	}
	public void pricing_Click() throws InterruptedException {

		elepricing = verifypricingUrl();
		elepricing.click();
		Thread.sleep(2000);
		String pageText2=driver.findElement(By.xpath("(//div[@class='heading'])[1]")).getText();
		if(pageText2.equals(pricingStr)) {
			System.out.println("Pricing URL has been clicked and control is navigated to the Pricing page");
		}
		
	}
	public void webinars_Click() throws InterruptedException {

		eleWebinars = verifywebinarsUrl();
		eleWebinars.click();
		Thread.sleep(3000);
		String pageText3=driver.findElement(By.xpath("//div[@class='container ']//h1")).getText();
		if(pageText3.equals(webinarsStr)) {
			System.out.println("Webinars URL has been clicked and control is navigated to the Webinars page");
		}
		
	}
	public void resources_Click() throws InterruptedException {

		eleResources = verifyresourcesUrl();
		eleResources.click();
		Thread.sleep(3000);
		WebElement dropdownList = driver.findElement(By.xpath("(//span[@class='menu-image-title-after menu-image-title'])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(eleResources).build().perform();
		action.click(dropdownList).perform();
		Thread.sleep(3000);
		String pageText4= driver.findElement(By.xpath("//div[@class='container container-sm']//h1")).getText();
		if(pageText4.equals(resourcesStr)) {
			System.out.println("Resources URL has been clicked and control is navigated to the Resources page");
		}
		
	}
	public void closeBrowser() {
		driver.quit();
	}
}



public class Implementation4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ElementClick obj = new ElementClick();
		obj.SettingBrowser();
		obj.whyAutify_Click();
		obj.pricing_Click();
		obj.webinars_Click();
		obj.resources_Click();
		obj.closeBrowser();
	}

}
