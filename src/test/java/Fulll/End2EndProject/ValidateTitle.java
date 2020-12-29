package Fulll.End2EndProject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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

public class ValidateTitle extends base{
	public WebDriver driver;
	public static Logger Log= LogManager.getLogger(ValidateTitle.class.getName());
	
	@Test
	public void ValidateApptitle() throws IOException {
		driver=InitializeDriver();
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
	
		LandingPage l=new LandingPage(driver);
		if(l.getPopUpSize()>0)

		{

		l.getPopUp().click();

		}
		
		AssertJUnit.assertEquals("FEATURED COURSES",l.getTitle().getText());
	Log.info("Validated title");
		
		
		
	}
	@AfterTest
	public void CloseDriver() {
		driver.close();
	
	}

}
