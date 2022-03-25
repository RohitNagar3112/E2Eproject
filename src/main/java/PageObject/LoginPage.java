package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;

	By email = By.id("user_email");
	By passWord = By.id("user_password");
	By loginButton = By.name("commit");
	By forgotPassword=By.cssSelector("[href*='password/new']");

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(passWord);
	}

	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}
	
	public ForgotPassword forgorPassword() {
		 driver.findElement(forgotPassword).click();
		 ForgotPassword fp=new ForgotPassword(driver);
		 return fp;
	}

}






