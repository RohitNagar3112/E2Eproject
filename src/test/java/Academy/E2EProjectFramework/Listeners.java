package Academy.E2EProjectFramework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import resources.Base;
import resources.ExtentReportNG;

public class Listeners extends Base implements ITestListener {
	ExtentTest test;
	ExtentReports extent =ExtentReportNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		extent.flush();
	}	

	
	
	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		WebDriver driver=null;
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());
		String testMethodName=result.getMethod().getMethodName();
		
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}
		
		catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShot(testMethodName,driver),result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 test= extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passesd");
		
	}

}
