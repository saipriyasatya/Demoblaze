@Test_Contact

Feature: Test Demoblaze contact scenario

  Scenario: Test contact  
    Given user is in first page
    When  user clicks contact 
    When user enters e-mail
    When user enters name
    When user enters message
    When user clicks sendmessage
    Then user clicks the pop-up
   