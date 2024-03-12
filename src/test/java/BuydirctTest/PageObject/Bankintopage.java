package BuydirctTest.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bankintopage {

	WebDriver driver;
	public Bankintopage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="btn-banking-intro__iav")
	WebElement selectiav;
	
	@FindBy(id="btn-banking-intro__cdw")
	WebElement selectcdw;
	
	public void selectIAV()
	{
	selectiav.click();
	}
	public void selectCDW()
	{
	selectcdw.click();
	}
}
