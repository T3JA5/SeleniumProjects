$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/LoginWithData.feature");
formatter.feature({
  "name": "Login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Login in StackOverflow",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User launches chrome browser",
  "keyword": "Given "
});
formatter.step({
  "name": "User navigates to URL",
  "keyword": "When "
});
formatter.step({
  "name": "User enters username as \"\u003cemail\u003e\" and password as \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "Click on Log in",
  "keyword": "And "
});
formatter.step({
  "name": "Page titles should be \"\u003ctitle\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "name": "close browser",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "email",
        "password",
        "title"
      ]
    },
    {
      "cells": [
        "tejaslabhashetwar@gmail.com",
        "Desmond@2020",
        "Stack Overflow - Where Developers Learn, Share, \u0026 Build Careers"
      ]
    },
    {
      "cells": [
        "tejaslabhashetwar@gmail.com",
        "Desmond",
        "Stack Overflow - Where Developers Learn, Share, \u0026 Build Careers"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Login in StackOverflow",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User launches chrome browser",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinations.Steps.user_launches_chrome_browser()"
});
