package StepDefination;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class loginAPIcal {

	public static String BaseURL = "https://obsapi.onpassive.com";
	public static String loginPayload;
	Response req;
	String response;
	JsonPath jp;

	@Given("^Enter login payload$")
	public void enter_login_payload() throws Throwable {
		RestAssured.baseURI = BaseURL;
		loginPayload = "{\"emailId\":\"I50BSVjHhiZn%2BX%2FHTsxkirUp19xuxarvJWFwsgFYU%2Fk=\",\"password\":\"g2%2BjZFrlfRZm01HgKZQpnQ==\"}";
	}

	@When("^user callls the login API with http reqquest$")
	public void user_callls_the_login_api_with_http_reqquest() throws Throwable {
		req = given().log().all().header("Content-Type", "application/json").body(loginPayload).when().post("/login");
	}

	@Then("^validate the response code as 200$")
	public void validate_the_response_code_as_200() throws Throwable {
		response = req.then().log().all().extract().asString();
		jp = new JsonPath(response);
		String getstatus = jp.get("status");
		System.out.println(getstatus);
		System.out.println("Status code is: " + jp.getString("statusCode"));
	}

	@And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	public void something_in_response_body_is_something(String status, String expectedvalue) throws Throwable {
		jp = new JsonPath(response);
		Assert.assertEquals(jp.getString(status), expectedvalue);
	}

	@Then("{string} in the response body is {string}")
	public void in_the_response_body_is(String message, String expectedvalue) {
		jp = new JsonPath(response);
		Assert.assertEquals(jp.getString(message), expectedvalue);
	}

	@And("^get the token info$")
	public void get_the_token_info() throws Throwable {
		jp = new JsonPath(response);
		System.out.println("Application access token is: " + jp.getString("data.accessToken"));
	}

}
