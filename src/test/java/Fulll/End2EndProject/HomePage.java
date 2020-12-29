package Fulll.End2EndProject;


import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class HomePage extends base {
	public static Logger Log= LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password) throws IOException, InterruptedException {
		driver=InitializeDriver();
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
		
		LandingPage l=new LandingPage(driver);
		if(l.getPopUpSize()>0)

		{

		l.getPopUp().click();

		}
		l.getLogin().click();
		LoginPage lp= new LoginPage(driver);
		Thread.sleep(5000);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
		Log.info("Home Page successful");
		
		
		
		
	}
	@AfterTest
	public void CloseDriver() {
		driver.quit();
		driver=null;
	}
	@DataProvider
	public Object[][] getData()
	{
		// Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		// Array size is 2
		// 0,1
		Object[][] data=new Object[2][2];
		//0th row
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		
		//1st row
		data[1][0]="restricteduser@qw.com";
		data[1][1]="456788";
		
		
		return data;
		
		
		
		
		
		
	}

}
