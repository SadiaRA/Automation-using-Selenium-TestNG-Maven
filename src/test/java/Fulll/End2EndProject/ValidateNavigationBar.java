package Fulll.End2EndProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;

import resources.base;

public class ValidateNavigationBar extends base{
	public WebDriver driver;
	public static Logger Log= LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void Initialize() throws IOException {
		driver=InitializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void basePageNavigation() throws IOException {
	
	
		LandingPage l=new LandingPage(driver);
		if(l.getPopUpSize()>0)

		{

		l.getPopUp().click();

		}
		
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		Log.info("Validated Navigation bar");
	
		
		
		
	}
	@AfterTest
	public void CloseDriver() {
		driver.quit();
		driver=null;
	}

}
