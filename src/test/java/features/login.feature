Feature: Login Validation

  Background: Application browser access
    Given Open the browser
    When navigate the respected URL
    Then browser is launched successfully

  @APITesting
  Scenario: Verify the login functionality
    Given Enter login payload
    When user callls the login API with http reqquest
    Then validate the response code as 200
    And "status" in response body is "Success"
    And "message" in response body is "token generated successfully."
    And "statusCode" in response body is "200"
    And get the token info

  @WebTesting
  Scenario Outline: Validate the APplication with the large set of data
    Given Login to the application with valid user name and password
      | yamalapalli1230@gmail.com | Admin@6765 |
    When Capture the page title
    Then Compare it with the expected value

  @WebTesting
  Scenario Outline: Validate the APplication with the user name password
    Given Registering the Application with <username> and <password>
    When Capture the page title
    Then Compare it with the expected value

    Examples: 
      | username                    | password      |
      | yamalapalli1230@gmail.com   | Admin@6765    |
      | rao.srinivasa@onpassive.com | Admin@123     |
      | raju@onpassive.com          | Admin@3747347 |
