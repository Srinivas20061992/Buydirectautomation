package BuydirctTest.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CDW_ABA_DDA_Page {

	WebDriver driver;

	public CDW_ABA_DDA_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "RoutingNumber")
	WebElement enteraba;
	@FindBy(id = "AccountNumber")
	WebElement enterdda;
	@FindBy(id = "btnCDW")
	WebElement CDWbutton;
	public void enterABA(String aba) {
		enteraba.sendKeys(aba);
	}
	public void enterDDA(String dda) {
		enterdda.sendKeys(dda);
	}
	public void clickSubmitabadda() {
		CDWbutton.click();
	}
	
}
