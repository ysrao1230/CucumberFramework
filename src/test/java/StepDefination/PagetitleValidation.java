package StepDefination;

import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import Base.BasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class PagetitleValidation {

	String greetingMessage;
	WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	BasePage basepage;

	public PagetitleValidation(BasePage basepage) {
		this.basepage = basepage;
	}

	@Given("^Open the browser$")
	public void open_the_browser() throws Throwable {
		System.out.println("Open Browser");
	}

	@When("^navigate the respected URL$")
	public void navigate_the_respected_url() throws Throwable {
		System.out.println("Navigate the Resppected URL");
	}

	@Then("^browser is launched successfully$")
	public void browser_is_launched_successfully() throws Throwable {
		System.out.println("Browser and URL launched successfully");
	}

	@Given("Login to the application with valid user name and password")
	public void login_to_the_application_with_valid_user_name_and_password(DataTable data) {
		System.out.println("Using the list of list");
		List<List<String>> d = data.asLists();
		System.out.println("username is=> " + d.get(0).get(0));
		System.out.println("password is the=> " + d.get(0).get(1));
		System.out.println("Using the Map");
		Map<String, String> map = data.asMap(String.class, String.class);
		System.out.println(map.get("Email"));
		System.out.println(map.get("Password"));
	}

	@When("Capture the page title")
	public void capture_the_page_title() {
		// Write code here that turns the phrase above into concrete actions
		dashboardPage = new DashboardPage(basepage);
		greetingMessage = dashboardPage.getDashboardMessage();
		System.out.println("Page title is:> " + greetingMessage);
	}

	@Then("Compare it with the expected value")
	public void compare_it_with_the_expected_value() {
		// Write code here that turns the phrase above into concrete actions
		// String expectredTitle = "Have a nice day at work!";
		// Assert.assertEquals(expectredTitle, greetingMessage);

		String expectedTitles[] = { "Srinivasa Rao yamalapalli good MOrning!", "Have a nice day at work!",
				"Yamalapalli Srinivasa Rao" };
		List<String> expectedTitlesList = Arrays.asList(expectedTitles);

		assertTrue(expectedTitlesList.contains((greetingMessage)));

	}

	@Then("Compare it with the expected values")
	public void compare_it_with_the_expected_values() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Compare it with the expected values");

	}

	@When("Capture the page titles")
	public void capture_the_page_titles() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Capture the Page title");
	}

	@Given("login to the Application with {string} and {string}")
	public void registering_the_application_with_and(String username, String password) throws Throwable {
		loginPage = new LoginPage(basepage);
		System.out.println("Registered user name and password are");
		System.out.println(username + " | " + password);
		loginPage.userNameInput(username);
		loginPage.passwordNameInput(password);
		loginPage.loginButtonAction();

	}

	@Then("close the dasboardpopup window")
	public void close_the_dasboardpopup_window() {
		// Write code here that turns the phrase above into concrete actions
		dashboardPage = new DashboardPage(basepage);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dashboardPage.closepopupicon();
		System.out.println("Popup  Closed successfully");
	}

	@Given("login to the Application with username and password")
	public void login_to_the_application_with_username_and_password(DataTable dataTable) {
		List<List<String>> d = dataTable.asLists();
		loginPage = new LoginPage(basepage);
		System.out.println("Registered user name and password are");
		System.out.println(d.get(0).get(0) + " | " + d.get(0).get(1));
		loginPage.userNameInput(d.get(0).get(0));
		loginPage.passwordNameInput(d.get(0).get(1));
		loginPage.loginButtonAction();
	}

}
