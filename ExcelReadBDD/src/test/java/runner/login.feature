Feature: Login

Scenario: Login with valid credentials
	Given User launches chrome browser
	When User navigates to URL
	And User enters username and password
	And Click on Log in
	Then Check the page title
	And close browser