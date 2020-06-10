Feature: Login

Scenario Outline: Login in StackOverflow
	Given User launches chrome browser
	When User navigates to URL
	And User enters username as "<email>" and password as "<password>"
	And Click on Log in
	Then Page titles should be "<title>"
	And close browser
	
	Examples:
		|email							|password		|title																|
		|tejaslabhashetwar@gmail.com	|Desmond@2020	|Stack Overflow - Where Developers Learn, Share, & Build Careers 	|
		|tejaslabhashetwar@gmail.com	|Desmond		|Stack Overflow - Where Developers Learn, Share, & Build Careers	|	
		