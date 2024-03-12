package BuydirctTest.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomeBackPage {

	WebDriver driver;
	
	public WelcomeBackPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="btnContinue")
	WebElement welcomeback;
	
	public void welcomeback()
	{
		welcomeback.click();
	}
}
