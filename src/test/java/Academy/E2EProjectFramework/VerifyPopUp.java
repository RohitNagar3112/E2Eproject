package Academy.E2EProjectFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import resources.Base;

public class VerifyPopUp extends Base{
	public WebDriver driver;

	
	private static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void openURl() throws IOException
	{
		driver = getInitializeBrowser();
		String url = prop.getProperty("url");
		driver.get(url);

	}

	@Test
	public void homepagelanding() throws IOException, InterruptedException {
		
		log.info("rohit nagar executing case");
		// Creating object of landing page
		LandingPage lp=new LandingPage(driver);
		lp.getPopup().click();

	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
}
