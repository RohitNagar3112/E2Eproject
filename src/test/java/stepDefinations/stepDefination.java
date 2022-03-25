package stepDefinations;

import PageObject.LandingPage;
import PageObject.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.Base;

public class stepDefination extends Base {

	@Given("^Initiate the browser with chrome$")
	public void initiate_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver = getInitializeBrowser();
	    
	}

	@Given("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_Site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	    
	}

	@Given("^Click on Login link in home page to land on Secure Sign page$")
	public void click_on_Login_link_in_home_page_to_land_on_Secure_Sign_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage lp=new LandingPage(driver);
		if(lp.getPopUpSize()>0)
		{
			lp.getPopup().click();
		}
		
		LoginPage l=lp.getSignIN();
		
	   	}

	 @When("^User enter (.+) and (.+) and logs in$")
	    public void user_enter_and_and_logs_in(String username, String password) throws Throwable {
			LandingPage lp=new LandingPage(driver);
			LoginPage l = new LoginPage(driver);
			l.getEmail().sendKeys(username);
			l.getPassword().sendKeys(password);
			l.getLoginButton().click();
	 }
	

	@Then("^Verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	   driver.close();
	}
}
