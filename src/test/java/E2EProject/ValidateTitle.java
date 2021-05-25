package E2EProject;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Resources.Base;
import Resources.ScreenshotCapture;
import junit.framework.Assert;
import pageObjects.LandingPage;

public class ValidateTitle extends Base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initialize_driver();	
		log.info("Driver is initialized");
		driver.get(prop.getProperty("URL"));
		log.info("Page is Opened");
	}
	
	
	@Test
	public void validate() throws IOException
	{
	
	LandingPage lp=new LandingPage(driver);
	ScreenshotCapture.takeScreenshot(driver, "C:\\Users\\priya\\git\\Practice_Repository\\PraticeFramework\\TC2_Search_text.png");
	String SearchText=lp.SearchCourse().getText();
	log.info("Search Text is captured");
	Assert.assertEquals("Search for a course", SearchText);
	log.info("Search text Assertion done");
	
	
	}
	
	@Test
	public void Header() throws IOException
	{

	LandingPage lp=new LandingPage(driver);
	Assert.assertTrue(lp.Header().isDisplayed());
	ScreenshotCapture.takeScreenshot(driver, "C:\\Users\\priya\\git\\Practice_Repository\\PraticeFramework\\TC3_Header.png");
	log.info("Header Assertion is done");
	
	}
	
	
	@Test
	public void HeaderLinks_Click() throws IOException
	{
		LandingPage lp=new LandingPage(driver);
		lp.HeaderLinks_Click();
		ScreenshotCapture.takeScreenshot(driver, "C:\\Users\\priya\\git\\Practice_Repository\\PraticeFramework\\TC4_HeaderLinks.png");
		log.info("Headerlinks hit successfully");		
	}
	

	@AfterSuite
	public void close_browser()
	{
		driver.close();
		log.info("Driver is Closed");
	}
	
}
