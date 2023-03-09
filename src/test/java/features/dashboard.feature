Feature: Dashboard operation

 
  Scenario: Validate the dash components
    Given Navigate to the dashboard
    When capture the user name and email address
    Then compare the email address is correct or not with the profile email address
