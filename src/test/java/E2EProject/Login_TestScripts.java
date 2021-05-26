package E2EProject;

import java.io.IOException;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Resources.Base;
import Resources.ScreenshotCapture;
import pageObjects.LandingPage;
import pageObjects.LoginPage;


public class Login_TestScripts extends Base{

    public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	
	@Test(dataProvider="data")
	public void url_hit(String username,String password) throws IOException
	{
		driver=initialize_driver();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("URL"));
		log.info("Navigated to Homepage");
		
		LandingPage LP=new LandingPage(driver);
		LP.Login().click();
		
		LoginPage Lo=new LoginPage(driver);
		Lo.Email().sendKeys(username);
		log.info("Username is Entered");
		Lo.Password().sendKeys(password);
		log.info("Password is Entered");
		ScreenshotCapture.takeScreenshot(driver, "C:\\Users\\priya\\git\\Practice_Repository\\PraticeFramework\\TC1_Login_credentials_Entered.png");
		Lo.Submit().click();
		log.info("Login Credentials Submitted");
		ScreenshotCapture.takeScreenshot(driver, "C:\\Users\\priya\\git\\Practice_Repository\\PraticeFramework\\TC1_Login_done.png");
	}
		
	@DataProvider
	public Object[][] data()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="priyanka0250verma@yahoo.com";
		data[0][1]="Priya@123";	
		data[1][0]="priyanka0250verrma@yahoo.com";
		data[1][1]="Priya@1234";	
		return data;			
	}
	
	@AfterTest
	public void close_browser()
	{
		driver.close();
		log.info("Driver is Closed");
	}
	
}
