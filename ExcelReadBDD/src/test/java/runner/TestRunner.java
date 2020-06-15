package runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"C:\\Users\\T3j45\\git\\SeleniumProjects\\ExcelReadBDD\\src\\test\\java\\runner\\login.feature"},
		glue = {"runner"},
		strict = true,
		dryRun=false,
		monochrome = true,
		plugin= {"pretty", 
				"html:test-output"}
		)


public class TestRunner extends AbstractTestNGCucumberTests {
	
}
