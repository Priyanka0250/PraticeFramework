package Resources;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ScreenshotCapture {

	
	
	public static void takeScreenshot(WebDriver driver,String path) throws IOException
	{
		
		File scr=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scr, new File(path));
	}

	
	
}
