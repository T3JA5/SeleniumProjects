$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/login.feature");
formatter.feature({
  "name": "Login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Login with valid credentials",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User launches chrome browser",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefination.Steps.user_launches_chrome_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to URL",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefination.Steps.user_navigates_to_URL()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters username and password",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefination.Steps.user_enters_username_and_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Log in",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefination.Steps.click_on_Log_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check the page title",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefination.Steps.check_the_page_title()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "close browser",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefination.Steps.close_browser()"
});
formatter.result({
  "status": "passed"
});
});