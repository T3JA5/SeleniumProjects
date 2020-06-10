package testrunner;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

public class TakeScreenshot {

	public static void screenshot() throws Exception {

		File screenShotOutputFile = new File("test-output/screenshots/screenshot_" + System.currentTimeMillis() + ".png").getAbsoluteFile();
		File scrFile = ((TakesScreenshot) Steps.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, screenShotOutputFile);
		Reporter.log("<a href=/screenshots/" + screenShotOutputFile + "><img src=/screenshots/" + screenShotOutputFile + " style=width:100px;height:100px;/>" + screenShotOutputFile + "</a><br/>");

	}

}
