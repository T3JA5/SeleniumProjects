Feature: XML Parsing

Scenario: Read Node value
	Given Read the XML file
	Then Fetch the value based on inputed node
	
Scenario: Fetch number of parent node
	Given Read the XML file
	Then Fetch number of parent node
	
Scenario: Fetch associated child node based on parent node
	Given Read the XML file
	Then Fetch number of child node and there values