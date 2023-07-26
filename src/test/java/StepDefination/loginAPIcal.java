package StepDefination;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.LoginPayload;
import pojo.LoginResponse;

public class loginAPIcal {

	private static final String emailId = "I50BSVjHhiZn%2BX%2FHTsxkirUp19xuxarvJWFwsgFYU%2Fk=";
	private static final String password = "g2%2BjZFrlfRZm01HgKZQpnQ==";
	public static String BaseURL = "https://obsapi.onpassive.com";
	LoginPayload loginPayload;
	Response req;
	LoginResponse response;
	JsonPath jp;

	@Given("^Enter login payload$")
	public void enter_login_payload() throws Throwable {
		RestAssured.baseURI = BaseURL;
		loginPayload = new LoginPayload(emailId, password);
	}

	@When("^user callls the login API with http reqquest$")
	public void user_callls_the_login_api_with_http_reqquest() throws Throwable {
		req = given().log().all().header("Content-Type", "application/json").body(loginPayload).when().post("/login");
	}

	@Then("^validate the response code as 200$")
	public void validate_the_response_code_as_200() throws Throwable {
		response = req.then().log().all().extract().as(LoginResponse.class);
		int getstatuscode = response.getStatusCode();
		System.out.println(response.getStatus());
		System.out.println("Status code is: " + getstatuscode);
	}

	@And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	public void something_in_response_body_is_something(String status, String expectedvalue) throws Throwable {
		org.testng.Assert.assertEquals(response.getStatus(), expectedvalue);

	}
	
	@Then("{string} in  the response body is {string}")
	public void in_the_response_body_is(String string, String expectedvalue) {
		org.testng.Assert.assertEquals(response.getMessage(), expectedvalue);
	}

	@And("^get the token info$")
	public void get_the_token_info() throws Throwable {
		System.out.println("Application access token is: " + response.getData().getAccessToken());
	}

}
