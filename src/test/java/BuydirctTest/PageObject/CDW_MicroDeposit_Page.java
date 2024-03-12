package BuydirctTest.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CDW_MicroDeposit_Page {
	WebDriver driver;

	public CDW_MicroDeposit_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "DepositAmount")
	WebElement depositamount;

	@FindBy(id = "webWithDrawlAmount")
	WebElement WithdrowAmount;

	@FindBy(id = "btnAmount")
	WebElement btnAmount;

	public void Enterdepositamount(String deposit) {
		depositamount.sendKeys(deposit);
	}

	public void Enterwithdrowamount(String withdrow) {
		depositamount.sendKeys(withdrow);
	}
	
	public void submitCDWamount() {
		btnAmount.click();
	}
	
}
