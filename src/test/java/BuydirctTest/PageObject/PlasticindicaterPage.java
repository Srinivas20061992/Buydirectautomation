package BuydirctTest.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BuydirectTest.Utility.Abstractcomponent;

public class PlasticindicaterPage extends Abstractcomponent {
	
	WebDriver driver;

	public PlasticindicaterPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(id=("plastic-request--yes"))
	WebElement plasticrequestyes;
	
	@FindBy(id=("plastic-request--btn"))
	WebElement plasticrequestbtn;
	
	@FindBy(id=("plastic-request--no"))
	WebElement plasticrequestno;
	
	public void selectplasticrequestyes()
	{
		plasticrequestyes.click();
	}
	
	public void selectplasticrequestno()
	{
		plasticrequestno.click();
	}
	public void selectplasticrequest()
	{
		plasticrequestyes.click();
	}

}
