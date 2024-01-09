package cucumberRunnerPackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/featureFiles", glue = {
		"stepDefinitionsPackage" }, monochrome = true, dryRun = false, plugin = { "pretty",
				"junit:target/CucumberTestReports/JunitReport.xml", "html:target/CucumberTestReports/HTMLReport.html",
				"json:target/CucumberTestReports/cucumber.json" }, tags = ("@regression"))
public class RunnerClass extends AbstractTestNGCucumberTests {
}