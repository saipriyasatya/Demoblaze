$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("contactTest.feature");
formatter.feature({
  "line": 3,
  "name": "Test Demoblaze contact scenario",
  "description": "",
  "id": "test-demoblaze-contact-scenario",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Test_Contact"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Test contact",
  "description": "",
  "id": "test-demoblaze-contact-scenario;test-contact",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "user is in first page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user clicks contact",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user enters e-mail",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "user enters name",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "user enters message",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "user clicks sendmessage",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "user clicks the pop-up",
  "keyword": "Then "
});
formatter.match({
  "location": "Contact_StepDefinition.user_is_in_first_page()"
});
formatter.result({
  "duration": 11618445798,
  "status": "passed"
});
formatter.match({
  "location": "Contact_StepDefinition.user_clicks_contact()"
});
formatter.result({
  "duration": 2420897977,
  "status": "passed"
});
formatter.match({
  "location": "Contact_StepDefinition.user_enters_e_mail()"
});
formatter.result({
  "duration": 1903538742,
  "status": "passed"
});
formatter.match({
  "location": "Contact_StepDefinition.user_enters_name()"
});
formatter.result({
  "duration": 347656828,
  "status": "passed"
});
formatter.match({
  "location": "Contact_StepDefinition.user_enters_message()"
});
formatter.result({
  "duration": 967777421,
  "status": "passed"
});
formatter.match({
  "location": "Contact_StepDefinition.user_clicks_sendmessage()"
});
formatter.result({
  "duration": 322526464,
  "status": "passed"
});
formatter.match({
  "location": "Contact_StepDefinition.user_clicks_the_pop_up()"
});
formatter.result({
  "duration": 1296933026,
  "status": "passed"
});
});