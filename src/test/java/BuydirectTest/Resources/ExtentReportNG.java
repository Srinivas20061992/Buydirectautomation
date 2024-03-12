package BuydirectTest.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentReportNG {

	public static  ExtentReports GetReportObject()
	{
		String Path=System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(Path);
		reporter.config().setReportName("Buydirect WebAutomation Test");
		reporter.config().setDocumentTitle("Buydirect Automation");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Srinivas");
		extent.createTest(Path);
		return extent;
	}
}
