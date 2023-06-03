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

  Scenario Outline: Validate the APplication with the large set of data
    Given Login to the application with valid user name and password
      | yamalapalli1230@gmail.com | Admin@6765 |
    When Capture the page titles
    Then Compare it with the expected values

  @WebTesting
  Scenario Outline: Validate the application dashboard greeting message
    When Capture the page title
    And close the dasboardpopup window
    Then Compare it with the expected value

  @WebTesting
  Scenario: Closing the dashboard popup window
    Then close the dasboardpopup window

  @WebTesting
  Scenario: Getting the dashboard
    Given close the dasboardpopup window
    Then get the dashboard greeting message with the user name

  Scenario Outline: Data capturing using the examples
    Given Navigate to the application
    When enter "<Username>" and "<Password>"
    Then Logged in successfully

    Examples: 
      | Username  | Password  |
      | Username1 | Password1 |

@WebTesting
  Scenario: : Get the profile Details
    Given Navigate to the application
    When close the dasboardpopup window
    And Navigate to the Profile Page
    Then get the user first name, last name, email and Phone Number
