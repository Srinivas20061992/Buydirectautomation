package BuydirectTest.TestClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import BuydirectTest.Utility.Abstractcomponent;
import BuydirectTest.Utility.readconfig;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {

	readconfig readconfig = new readconfig();
	public WebDriver driver;
	String username = "srinivasconnexinfo";
	String accesskey = "MsYgGHO9MYYzMlIERVlCfaSD1hfiwPOqnoJszTQXXcOvoK2szz";
	String gridURL = "@hub.lambdatest.com/wd/hub";

	public String BaseURL = readconfig.AppURL();
	public String p = readconfig.getPartnerId();
	public String partnerid = Abstractcomponent.encryptString(p);
	protected static String Status = "failed";

	@SuppressWarnings("deprecation")
	public WebDriver initializedriver() {

		String Browser = readconfig.getbrowser();
	//try {
			if (Browser.equals("chrome")) {

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				/*driver.manage().window().maximize();
				driver.get("chrome://settings/");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("chrome.settingsPrivate.setDefaultZoom(0.8)");

				ChromeOptions browserOptions = new ChromeOptions();
				browserOptions.setPlatformName("Windows 10");
				browserOptions.setBrowserVersion("121.0");
				HashMap<String, Object> ltOptions = new HashMap<String, Object>();
				ltOptions.put("username", "srinivasconnexinfo");
				ltOptions.put("accessKey", "MsYgGHO9MYYzMlIERVlCfaSD1hfiwPOqnoJszTQXXcOvoK2szz");
				ltOptions.put("visual", true);
				ltOptions.put("video", true);
				ltOptions.put("build", "Buydirect");
				ltOptions.put("project", "Test_EnrollPage");
				ltOptions.put("name", "TestAutomation");
				String[] customTags = { "log" };
				ltOptions.put("tags", customTags);
				ltOptions.put("console", "warn");
				ltOptions.put("networkThrottling", "Regular 4G");
				ltOptions.put("selenium_version", "4.0.0");
				ltOptions.put("w3c", true);
				browserOptions.setCapability("LT:Options", ltOptions);
				driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL),
						browserOptions);
			}

		} catch (Exception e) {
			System.out.println(e);
		}*/
			}

				else if (Browser.equals("edge"))

		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		return driver;
	}

	public String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//Reports//" + testcaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//Reports//" + testcaseName + ".png";

	}

	@BeforeMethod
	public void Loadingpage() {

		driver = initializedriver();

		driver.get(BaseURL + p);
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
