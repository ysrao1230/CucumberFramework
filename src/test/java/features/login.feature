Feature: Login Validation


Scenario Outline: Verify the login functionality
Given Enter login payload
When user callls the login API with http reqquest
Then validate the response code as 200
And "status" in response body is "Success"
And "message" in response body is "token generated successfully."
And "statusCode" in response body is "200"
And get the token info


Scenario Outline:
Validate the APplication with the large set of data

Given Login to the application with valid user name and password
|yamalapalli1230@gmail.com|Admin6765|
When Capture the page title
Then Compare it with the expected value
