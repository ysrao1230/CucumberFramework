package StepDefination;

import java.util.List;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PagetitleValidation {

	String pageTitle;

	@Given("Login to the application with valid user name and password")
	public void login_to_the_application_with_valid_user_name_and_password(DataTable data) {
		List<List<String>> d = data.asLists();
		System.out.println("username is=> " + d.get(0).get(0));
		System.out.println("password is the=> " + d.get(0).get(1));
	}

	@When("Capture the page title")
	public void capture_the_page_title() {
		// Write code here that turns the phrase above into concrete actions
		pageTitle = "Yamalapalli";
		System.out.println("Page title is:> " + pageTitle);
	}

	@Then("Compare it with the expected value")
	public void compare_it_with_the_expected_value() {
		// Write code here that turns the phrase above into concrete actions
		String expectredTitle = "Yamalapalli";
		Assert.assertEquals(expectredTitle, pageTitle);

	}

}
