package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverUniversityPage {

	private WebElement element = null;

	public WebElement iframeLink(WebDriver driver, String linkName) {
		element = driver.findElement(By.xpath("//div//child::h1[text()='" + linkName + "']"));
		return element;
	}

	public WebElement iframeElement(WebDriver driver) {
		element = driver.findElement(By.xpath("//iframe[@id='frame']"));
		return element;
	}

	public WebElement imageLeftNav(WebDriver driver) {
		element = driver.findElement(By.xpath("//a//child::span[contains(@class,'left')]"));
		return element;
	}

	public WebElement imageRightNav(WebDriver driver) {
		element = driver.findElement(By.xpath("//a//child::span[contains(@class,'right')]"));
		return element;
	}

	public WebElement verifyChangedImage(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='item active']//child::img"));
		return element;
	}

}