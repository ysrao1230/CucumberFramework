Feature: Login Validation

Scenario: Verify the login functionality
Given Enter login payload
When user callls the login API with http reqquest
Then validate the response code as 200
And "status" in response body is "Success"
And "message" in response body is "token generated successfully."
And "statusCode" in response body is "200"
And get the token info