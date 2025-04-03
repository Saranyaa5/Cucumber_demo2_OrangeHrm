 #| Assign Leave  |
      #| Leave List    |
      #| Timesheets    |
      #| Apply Leave   |
      #| My Leave      |
      #| My Timesheet  |
@tag
Feature: OrangeHRM Login and Dashboard Feature
  I want to use this template for my OrangeHRM login feature file.

  @LoginAndQuickStartValidation
  Scenario Outline: Test the login functionality and verify the quick launch options in OrangeHRM
    Given the user is on the OrangeHRM login page
    When the user enters the valid username "Admin"
    And the user enters the valid password "admin123"
    And the user clicks the login button
    Then the user should be able to see the dashboard of OrangeHRM
    When the user views the quick launch section
    Then the user should see the option "<option>"

    Examples:
      | option        |
      |Asignar Permiso|
      |Listado de licencias y permisos|
      |Hojas de asistencia|
      |Solicitar Licencia/ Permiso|
      |Mis Permisos|
      |Mi hoja de asistencia|
