package utilityPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSetup {

	private WebDriver driver = null;
	GlobalVariables gv = new GlobalVariables();

	public WebDriver browserConfig(String browserName) {
		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			driver = new ChromeDriver(options);
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Browser name is Invalid!");
		}
		return driver;
	}

}