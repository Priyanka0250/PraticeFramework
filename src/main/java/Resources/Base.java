package Resources;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.TakesScreenshot;

public class Base {

	private static final String TakesScreenshot = null;
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initialize_driver() throws IOException
	{
		
	    prop=new Properties();
		FileInputStream fis=new FileInputStream("../LetsKodeIt_E2E/src/main/java/Resources/Data.properties");
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "../LetsKodeIt_E2E/chromedriver.exe");
			driver=new ChromeDriver();		
		}
		
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "../LetsKodeIt_E2E/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	
	public void getScreenShotPath(String TestcaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File scr=ts.getScreenshotAs(OutputType.FILE);
		String DestinationFile=System.getProperty("user.dir")+"\\reports\\"+TestcaseName+".png";
		FileUtils.copyFile(scr, new File(DestinationFile));
		
	}
	
	
	
}
