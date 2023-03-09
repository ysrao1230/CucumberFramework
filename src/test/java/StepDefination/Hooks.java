package StepDefination;

import org.openqa.selenium.WebDriver;

import Base.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

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
}
