package extent.report;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ExtentReport {
		
	public static String capture(WebDriver driver) throws Exception {
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("E:\\Automation\\Screenshots\\" + System.currentTimeMillis() + ".png");
		String path = dest.getAbsolutePath();
		FileUtils.copyFile(scr, dest);
		return path;
	}
	
}
