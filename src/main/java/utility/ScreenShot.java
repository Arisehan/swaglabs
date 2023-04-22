package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	public static void takeScreenshot (String name,WebDriver driver) throws IOException {
		String dateAndTime=DateAndTime.getDateAndTime();
		File Source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destination= new File("C:\\Users\\Admin\\eclipse-workspace\\swaglabs\\SceenShot"+name+dateAndTime+".png");
		FileHandler.copy(Source, destination);
		}
}
