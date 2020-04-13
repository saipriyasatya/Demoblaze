@Test_Login
Feature: Test Demoblaze Login Page

  Scenario Outline: Test login with valid credentials
    Given user in demoblaze homepage
    When user enters  "<usernameNumber>"
    When user clicks login user should be able to login
    Then Browser should be closed
    
   
Examples: 
      | usernameNumber |
      |              1 |