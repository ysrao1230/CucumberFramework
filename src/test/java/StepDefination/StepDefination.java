package StepDefination;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination {

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

}