package BuydirectTest.Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import BuydirectTest.Resources.*;
import BuydirectTest.TestClass.BaseTest;

public class Listeners extends BaseTest implements ITestListener {
	ExtentTest Test;
	ExtentReports extent = ExtentReportNG.GetReportObject();



	@Override
	public void onTestStart(ITestResult result) {
		Test = extent.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Test.log(com.aventstack.extentreports.Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Test.fail(result.getThrowable());
		String FilePath = null;
		
			try {
				driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			try {
				FilePath=getScreenshot(result.getMethod().getMethodName(),driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Test.addScreenCaptureFromPath(FilePath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// not implemented
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		   
}
}
