
Feature: OrangeHRM Login With ListOfMap DataTable
  I want to test login functionality using a DataTable

  @InValidInputsDataTable
  Scenario: Login with invalid credentials using DataTable
    Given the user is in the OrangeHRM login page
    When the user enters the invalid inputs
      | username | password | error_message |
      | Admin    | admin    | Invalid credentials  |
      |saranya|saran123|Invalid credentials|
    Then the user should see the error message
