@tag
Feature: OrangeHRM Login With ListOfList DataTable
  I want to login into the OrangeHRM using DataTable

  @ValidInputs
  Scenario: Login with valid credentials using DataTable
    Given the user is in OrangeHRM login page
    When the user enters the valid inputs
      | Admin  | admin123 |
    Then the user should be able to login successfully and redirect to Dashboard
