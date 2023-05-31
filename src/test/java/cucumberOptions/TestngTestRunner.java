package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = "StepDefination", plugin = { "pretty",
		"html:target/cucumber.html", "json:target/cucumber.json", "junit:target/cucumberreport.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, tags = "@WebTesting", dryRun = true, publish = true)
public class TestngTestRunner extends AbstractTestNGCucumberTests {

	// @Override
	// @DataProvider(parallel = true)
	// public Object[][] scenarios() {
	// return super.scenarios();
	// }

}
