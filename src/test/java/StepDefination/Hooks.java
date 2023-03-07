package StepDefination;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

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
	}

	@After("@WebTesting")
	public void afterWebTesting() {
		System.out.println("\r\n ENd of the Web Testing using hooks");
	}
}
