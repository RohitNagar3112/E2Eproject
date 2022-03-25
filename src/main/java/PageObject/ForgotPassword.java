package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPassword {
	
	public WebDriver driver;
	
	By email=By.id("user_email");
	By sendMeInstruction=By.cssSelector("[type='submit']");
	
	public ForgotPassword(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getSubmit() {
		return driver.findElement(sendMeInstruction);
	}

	


}
