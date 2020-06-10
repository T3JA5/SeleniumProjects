package testrunner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"LoginWithData.feature"},
		glue = {"stepDefinations"},
		strict = true,
		dryRun=false,
		monochrome = true,
		plugin= {"pretty", 
				"html:test-output"}
		)


public class Runner extends AbstractTestNGCucumberTests {
	
}
