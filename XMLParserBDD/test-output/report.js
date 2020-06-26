$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/xml.feature");
formatter.feature({
  "name": "XML Parsing",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Read Node value",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Read the XML file",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.Steps.read_the_XML_file()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Fetch the value based on inputed node",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.Steps.fetch_the_value_based_on_inputed_node()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Fetch number of parent node",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Read the XML file",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.Steps.read_the_XML_file()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Fetch number of parent node",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.Steps.fetch_number_of_parent_node()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Fetch associated child node based on parent node",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Read the XML file",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.Steps.read_the_XML_file()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Fetch number of child node and there values",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.Steps.fetch_number_of_child_node_and_there_values()"
});
formatter.result({
  "status": "passed"
});
});