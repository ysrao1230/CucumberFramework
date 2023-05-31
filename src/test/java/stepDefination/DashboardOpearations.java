package stepDefination;

import org.junit.Assert;

import Base.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DashboardPage;

public class DashboardOpearations {

	BasePage basepage;
	DashboardPage dashboardPage;

	public DashboardOpearations(BasePage basepage) {
		this.basepage = basepage;
	}

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

	@Then("^get the dashboard greeting message with the user name$")
	public void get_the_dashboard_greeting_message_with_the_user_name() throws Throwable {
		dashboardPage = new DashboardPage(basepage);
		System.out.println("Dashboard greeting message with person name is:=>"
				+ dashboardPage.gettingTheGreetingMessageWithUserName());

	}

}
