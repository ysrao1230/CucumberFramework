package StepDefination;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.reporter.FileUtil;

import Base.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	BasePage basePage;
	WebDriver driver;

	public Hooks(BasePage basePage) {
		this.basePage = basePage;
	}

	@Before("@APITesting")
	public void beforeAPI() {
		System.out.println("Start the API Testing using hooks \r\n");
	}

	@After("@APITesting")
	public void afterPI() {
		System.out.println("\r\n ENd of the API Testing using hooks ");
	}

	@Before("@WebTesting")
	public void beforewebTesting() {
		System.out.println("Start the Web  Testing using hooks \r\n");
		basePage.browserIntialization("CHROME");
	}

	@After("@WebTesting")
	public void afterWebTesting() {
		System.out.println("\r\n ENd of the Web Testing using hooks");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		basePage.driver.quit();
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			// Screenshot capturing
			File sourcePath = ((TakesScreenshot) basePage.driver).getScreenshotAs(OutputType.FILE);
			byte[] fileAttach = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileAttach, "image/png", "image");
		}
		System.out.println("Capturing the screenshot");

	}
}
