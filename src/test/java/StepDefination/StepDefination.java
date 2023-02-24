package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination {

	@Given("Navigate to the application")
	public void navigate_to_the_application() {
		// Write code here that turns the phrase above into concrete actions

		System.out.println("Navigation to the application");
	}

	@When("ENter user name")
	public void e_nter_user_name() {
		// Write code here that turns the phrase above into concrete actions

		System.out.println("Enter user name");
	}

	@When("Enter password")
	public void enter_password() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Enter password");
	}

	@When("click on login button")
	public void click_on_login_button() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Clcik on login button");
	}

	@Then("Dashboard page displayed")
	public void dashboard_page_displayed() {
		System.out.println("Dashboard page displayed");
	}
}
