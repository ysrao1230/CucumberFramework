Feature: Login Validation

  @APITesting
  Scenario: Verify the login functionality
    Given Enter login payload
    When user callls the login API with http reqquest
    Then validate the response code as 200
    And "status" in response body is "Success"
    And "message" in response body is "token generated successfully."
    And "statusCode" in response body is "200"
    And get the token info

  @APITesting
  Scenario Outline: Validate the APplication with the large set of data
    Given Login to the application with valid user name and password
      | yamalapalli1230@gmail.com | Admin@6765 |
    When Capture the page titles
    Then Compare it with the expected values

  @WebTesting
  Scenario Outline: Validate the APplication with the user name password
    Given login to the Application with "<username>" and "<password>"
    When Capture the page title
    Then Compare it with the expected value

    Examples: 
      | username                    | password      |
      | yamalapalli1230@gmail.com   | Admin@123/    |
      | rao.srinivasa@onpassive.com | Admin@123/    |