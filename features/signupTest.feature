@Test_signup
Feature: Test Demoblaze SignUp 

  Scenario Outline: Test SignUp with valid credentials
    Given Open chrome and navigate to url
    When user enters valid "<usernameNumber>"
    When user clicks signup user should be able to SignUp
    When user handles popup
    Then Browser is closed
    
    
    Examples: 
      | usernameNumber |
      |              1 |
    

