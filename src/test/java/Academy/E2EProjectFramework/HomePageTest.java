package Academy.E2EProjectFramework;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.ForgotPassword;
import PageObject.LandingPage;
import PageObject.LoginPage;
import resources.Base;

public class HomePageTest extends Base {
	public WebDriver driver;

	
	private static Logger log = LogManager.getLogger(Base.class.getName());


	
	@Test(dataProvider = "getData")
	public void homepagelanding(String userName, String password, String text)
			throws IOException, InterruptedException {
		driver = getInitializeBrowser();
		String url = prop.getProperty("url");
		driver.get(url);
		// Creating object of landing page
		LandingPage lp=new LandingPage(driver);
		lp.getPopup().click();
		LoginPage l=lp.getSignIN();

		l.getEmail().sendKeys(userName);
		l.getPassword().sendKeys(password);
		log.info(text);
		l.getLoginButton().click();
		ForgotPassword fp=l.forgorPassword();
		fp.getEmail().sendKeys("abc@gmail.com");
		fp.getSubmit().click();
		
		
	}
	
	@AfterTest
	public void closeWindow()
	{
		driver.close();
	}

	
	@DataProvider
	public Object[][] getData() {
		// Row stand for how many different data types test should run
		// column stand for how many values per each test
		// Array size 5
		// 0,1,2,3,4
		Object[][] obj = new Object[1][3];
		// 0th row
		obj[0][0] = "nonrestrictionuser@qa.com";
		obj[0][1] = "123456";
		obj[0][2] = "Retricted User";
		/*// 1 st row
		obj[1][0] = "restrictionuser@qa.com@qa.com";
		obj[1][1] = "452786";
		obj[1][2] = "NonRestricted User";*/

		return obj;

	}

}
