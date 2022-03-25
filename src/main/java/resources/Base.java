package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

	public static WebDriver driver;
	public Properties prop;

	public WebDriver getInitializeBrowser() throws IOException

	{
		System.out.println("hello");
		prop = new Properties();

		System.out.println("path of dire " + System.getProperty("user.dir"));
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		// mvn test -Dbrowser=chrome
		 //String browser=System.getProperty("browser");
		String browser = prop.getProperty("browser");
		System.out.println(browser);

		if (browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if (browser.contains("headless")) {
				// chrome head less mode
				options.addArguments("headless");
			}
			options.setAcceptInsecureCerts(true);
			// options.setExperimentalOption("excludeSwitches",
			// Arrays.asList("disable-popup-blocking"));
			driver = new ChromeDriver(options);

		} else if (browser.equals("firefox")) {
			System.out.println("firefox code");
		}
		
		driver.manage().window().maximize();

		return driver;
	}

	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;

	}
}
