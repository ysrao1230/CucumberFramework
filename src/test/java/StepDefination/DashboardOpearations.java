package StepDefination;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardOpearations {

	@Given("Navigate to the dashboard")
	public void navigate_to_the_dashboard() {
		System.out.println("Navigate to the dashboard");
	}

	@When("capture the user name and email address")
	public void capture_the_user_name_and_email_address() {
		System.out.println("Capture the user name and email address");
	}

	@Then("compare the email address is correct or not with the profile email address")
	public void compare_the_email_address_is_correct_or_not_with_the_profile_email_address() {
		System.out.println("Compare the dashboard email with the profile email address");
		Assert.assertEquals("true", "false");
	}

}
