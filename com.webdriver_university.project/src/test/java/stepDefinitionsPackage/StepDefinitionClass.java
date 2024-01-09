package stepDefinitionsPackage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.WebDriverUniversityPage;
import utilityPack.BaseCls;
import utilityPack.BrowserSetup;
import utilityPack.GlobalVariables;

public class StepDefinitionClass {

	BrowserSetup bs = null;
	GlobalVariables gbVar = new GlobalVariables();
	BaseCls base = new BaseCls();
	WebDriverUniversityPage page = new WebDriverUniversityPage();

	@Before
	public void setupBrowser() {
		bs = new BrowserSetup();
		gbVar.driver = bs.browserConfig(gbVar.chromeBrowserName);
		base.implicitWait(gbVar.driver, 30);
	}

	@After
	public void closeBrowser() {
		base.close(gbVar.driver);
	}

	@Given("user navigates to the application")
	public void user_navigates_to_the_application() {
		base.navigateToUrl(gbVar.driver, gbVar.url);
	}

	@And("verifies the main page title: {string}")
	public void verifies_the_main_page_title(String mainPageTitle) {
		String pageTitle = base.verifyPageTitle(gbVar.driver);
		Assert.assertEquals(mainPageTitle, pageTitle, "Page title doesn't match......");
		System.out.println("Main page title: " + pageTitle + " ---> Page verified successfully!");
	}

	@When("user clicks on {string} link")
	public void user_clicks_on_link(String linkName) {
		base.clickElement(page.iframeLink(gbVar.driver, linkName));
		base.hardWait(3000);
	}

	@Then("new tab with page title: {string} is opened")
	public void new_tab_with_page_title_is_opened(String newTabPageTitle) {
		newTabPageTitle = newTabPageTitle.replace("*", "|");
		base.switchToNewWindow(gbVar.driver);
		String pageTitle = base.verifyPageTitle(gbVar.driver);
		Assert.assertEquals(newTabPageTitle, pageTitle, "Page title doesn't match......");
		System.out.println("Second tab's page title: " + pageTitle + " ---> Page verified successfully!");
	}

	@And("user verifies the navigation through images")
	public void user_verifies_the_navigation_through_images() {
		base.switchToFrame(gbVar.driver, page.iframeElement(gbVar.driver));
		String attrValueImage1 = base.getAttributeValue(page.verifyChangedImage(gbVar.driver), "src");
		base.clickElement(page.imageRightNav(gbVar.driver));
		base.hardWait(1500);
		String attrValueImage2 = base.getAttributeValue(page.verifyChangedImage(gbVar.driver), "src");
		base.clickElement(page.imageRightNav(gbVar.driver));
		base.hardWait(1500);
		String attrValueImage3 = base.getAttributeValue(page.verifyChangedImage(gbVar.driver), "src");
		base.hardWait(1500);
		Assert.assertNotEquals(attrValueImage1, attrValueImage2, "Attribute values matched......");
		Assert.assertNotEquals(attrValueImage2, attrValueImage3, "Attribute values matched......");
		Assert.assertNotEquals(attrValueImage3, attrValueImage1, "Attribute values matched......");
		System.out.println(attrValueImage1 + "\n" + attrValueImage2 + "\n" + attrValueImage3);
	}

}