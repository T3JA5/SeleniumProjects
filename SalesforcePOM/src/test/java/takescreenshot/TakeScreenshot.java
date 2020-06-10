package takescreenshot;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TakeScreenshot {

	public static void screenshot(String path, String fileType) {
		try {
			Robot rb = new Robot();

			Rectangle capture =  new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); 
			BufferedImage Image = rb.createScreenCapture(capture); 
			ImageIO.write(Image, fileType, new File(path)); 

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
