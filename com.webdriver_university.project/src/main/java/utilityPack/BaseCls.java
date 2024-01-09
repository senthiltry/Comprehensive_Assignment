package utilityPack;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseCls {

	public void navigateToUrl(WebDriver driver, String input) {
		driver.get(input);
	}

	public String verifyPageTitle(WebDriver driver) {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

	public void switchToNewWindow(WebDriver driver) {
		String parentWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> iterator = s1.iterator();
		while (iterator.hasNext()) {
			String childWindow = iterator.next();
			if (!parentWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
			}
		}
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
		hardWait(1500);
	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public String getAttributeValue(WebElement element, String attributeName) {
		String attributeValue = element.getAttribute(attributeName);
		return attributeValue;
	}

	public void hardWait(long timeInMilliSec) {
		try {
			Thread.sleep(timeInMilliSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void implicitWait(WebDriver driver, long timeInMilliSec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInMilliSec));
	}

	public void close(WebDriver driver) {
		driver.quit();
	}

}