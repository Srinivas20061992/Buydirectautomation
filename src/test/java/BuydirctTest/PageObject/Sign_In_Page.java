package BuydirctTest.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sign_In_Page {
	WebDriver driver;

	public Sign_In_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "logInEmail")
	WebElement email;
	@FindBy(id = "logInPin")
	WebElement pin;
	@FindBy(id = "btnSignIn")
	WebElement loginbutton;

	public void EnterloginEmail(String loginemail)
	{
		email.sendKeys(loginemail);
	}
	public void EnterloginPin(String loginpin)
	{
		pin.sendKeys(loginpin);
	}
	public void Submitlogin()
	{
		loginbutton.click();
	}
	
}
