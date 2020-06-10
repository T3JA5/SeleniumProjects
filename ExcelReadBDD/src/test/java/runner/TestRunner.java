package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\T3j45\\eclipse-workspace\\ExcelReadBDD\\src\\test\\resources\\login.feature",
		glue = "stepDefination",
		strict = true,
		dryRun = false,
		monochrome = true,
		plugin= {"pretty", 
				"html:test-output"}
		)

public class TestRunner {
	

}
