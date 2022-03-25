package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

	public WebDriver driver;

	By signButton = By.cssSelector("a[href*=sign_in]");
	// $x('//div[@class="sumome-react-wysiwyg-move-handle"]/div//button[contains(text(),"THANKS")]')

	private By popUp = By.xpath("//div[@class='sumome-react-wysiwyg-move-handle']/div//button[contains(text(),'THANKS')]");
	private By title = By.cssSelector(".text-center h2");
	private By navBar = By.cssSelector(".nav.navbar-nav.navbar-right");
	private By header=By.cssSelector(".video-banner h3");

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public LoginPage getSignIN() {

		driver.findElement(signButton).click();
		LoginPage l = new LoginPage(driver);
		return l;
	}

	public WebElement getTitle() {

		return driver.findElement(title);
	}

	public WebElement getNavigationBar() {
		System.out.println("Trying to identify navigation bar");
		return driver.findElement(navBar);
	}

	public int getPopUpSize() {
	/*	WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.elementToBeClickable(driver.findElement(popUp)));*/
		return driver.findElements(popUp).size();
	}
	
	public WebElement getPopup() {
		
		return driver.findElement(popUp);
	}
	
	public WebElement getHeader() {
	
		return driver.findElement(header);
	}

	
}
