package BuydirectTest.Utility;

import java.time.Duration;
import java.util.Base64;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstractcomponent  {

	WebDriver driver;
	public Abstractcomponent(WebDriver driver)
	{
		
		this.driver=driver;
	}
	
	public void waitforelementtoappear(WebElement findby) {
		WebDriverWait ex = new WebDriverWait(driver, Duration.ofSeconds(30));
		ex.until(ExpectedConditions.visibilityOfAllElements(findby));
	}
	
	public static String randomEmail() {

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100000);
		String email = "Srinivas" + randomInt + "@Hep.com";
		return email;
	}
	public static String encryptString(String string) {     
	    byte[] bytesEncoded = Base64.getDecoder().decode(string.getBytes());
	    return (new String(bytesEncoded));
	}
}
