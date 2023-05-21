package StepDefination;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Base.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageObjects.LoginPage;
import utils.AppConfig;

public class Hooks {

	BasePage basePage;
	LoginPage loginPage;
	// WebDriver driver;
	ExtentSparkReporter extent;
	ExtentReports reports = new ExtentReports();

	public Hooks(BasePage basePage) {
		this.basePage = basePage;
		reports = new ExtentReports();
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
		extent = new ExtentSparkReporter("spark_report.html");
		reports.attachReporter(extent);
		reports.setSystemInfo("OS", "Windows-10");
		System.out.println("Start the Web  Testing using hooks \r\n");
		reports.createTest("Browser Launch").log(Status.INFO, "Launching Browser");
		basePage.browserIntialization();
		String browserMessage = "Browser " + basePage.browserName + "Launched successfully";
		reports.createTest("Browser info").log(Status.WARNING, browserMessage);
		loginPage = new LoginPage(basePage);
		loginPage.userNameInput(AppConfig.userName);
		loginPage.passwordNameInput(AppConfig.passWord);
		loginPage.loginButtonAction();
		reports.createTest("Logged In").log(Status.PASS, "Application logged successfully");
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
		reports.flush();
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			// Screenshot capturing
			File sourcePath = ((TakesScreenshot) basePage.driver).getScreenshotAs(OutputType.FILE);
			byte[] fileAttach = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileAttach, "image/png", "image");
			System.out.println("Capturing the screenshot");
		}

	}
}
