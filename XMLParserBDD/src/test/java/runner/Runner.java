package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\T3j45\\eclipse-workspace\\XMLParserBDD\\src\\test\\resources\\xml.feature",
		glue = "steps",
		dryRun=false,
		monochrome = true,
		plugin= {"pretty", 
				"html:test-output"}
		)

public class Runner {

}
