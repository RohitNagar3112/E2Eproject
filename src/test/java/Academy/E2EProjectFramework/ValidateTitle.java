package Academy.E2EProjectFramework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;
import PageObject.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {
	public WebDriver driver;
	LandingPage lp;

	private static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void openURl() throws IOException {
		driver = getInitializeBrowser();
		log.info("Driver is initilize");
		String url = prop.getProperty("url");
		driver.get(url);

	}

	@Test
	public void validateApptitle() throws IOException, InterruptedException {

		// Creating object of landing page
		lp = new LandingPage(driver);
	//	lp.getPopUp().click();
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		System.out.println(lp.getTitle().getText());
		log.info("Succesully validated Text message");

	}

	@Test
	public void validateHeader() throws IOException, InterruptedException {

		Assert.assertEquals(lp.getHeader().getText(), "An Academy to learn Everything about Testing");
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}