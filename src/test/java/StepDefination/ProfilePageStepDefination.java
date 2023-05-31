package StepDefination;

import Base.BasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DashboardPage;
import pageObjects.ProfilePage;

public class ProfilePageStepDefination {

	BasePage basePage;
	DashboardPage dashboard;
	ProfilePage profilePage;

	public ProfilePageStepDefination(BasePage basePage) {
		this.basePage = basePage;
		dashboard = new DashboardPage(basePage);
		profilePage = new ProfilePage(basePage);
	}

	@When("Navigate to the Profile Page")
	public void navigate_to_the_profile_page() {
		System.out.println("Navigate to the Profile Page");
		dashboard.profileMenuNavigation();
	}

	@Then("get the user first name, last name, email and Phone Number")
	public void get_the_user_first_name_last_name_email_and_phone_number() {
		System.out.println("get the user first name, last name, email and Phone Number");
		System.out.println(profilePage.getFirstName());
		System.out.println(profilePage.getLasttName());
	}
}
