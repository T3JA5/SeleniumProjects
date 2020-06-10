package testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Features//LoginWithData.feature",
		glue = "stepDefinations",
		strict = true,
		dryRun=false,
		monochrome = true,
		plugin= {"pretty", 
				"html:test-output"}
		)


public class Runner {
	

}
