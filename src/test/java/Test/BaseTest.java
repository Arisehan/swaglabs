package Test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class BaseTest {
	public static WebDriver driver;
	public void switchToChildWindow(String expectedTitle) {
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> i=handles.iterator();
		while(i.hasNext()) {
			String Handle=i.next();
			driver.switchTo().window(Handle);
			String currentTitle=driver.getTitle();
			if(currentTitle.contains(expectedTitle)) {
				break;
			}
		}
	}

}
