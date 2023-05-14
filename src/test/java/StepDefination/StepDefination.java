package StepDefination;

import org.testng.annotations.DataProvider;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestUtils;

public class StepDefination extends TestUtils {

	@Given("^Navigate to the application$")
	public void navigate_to_the_application() throws Throwable {
		System.out.println("Navigate to the application");
	}

	@When("^ENter user name (.+)$")
	public void enter_user_name(String username) throws Throwable {
		System.out.println("User name is: " + username);
	}

	@And("^Enter password (.+)$")
	public void enter_password(String password) throws Throwable {
		System.out.println("User name is: " + password);
	}

	@And("^click on login button$")
	public void click_on_login_button() throws Throwable {
		System.out.println("CLick on login Button");
	}

	@Then("^Dashboard page displayed$")
	public void dashboard_page_displayed() throws Throwable {
		System.out.println("Dashboard page is displayed");
	}

	@When("enter {string} and {string}")
	public void enter_and(String string, String string2) {
		System.out.println(string + " | " + string2);
	}

	@Then("Logged in successfully")
	public void logged_in_successfully() {
		System.out.println("Loggedin SUccessfully");
	}

	@DataProvider // use this for Data driven framework
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtils.getTestData(0); // this will store the complete data in data[][]
		return data; // always use return in case of using data and use object[][]
	}

}