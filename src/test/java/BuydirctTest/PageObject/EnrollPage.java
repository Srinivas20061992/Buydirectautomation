package BuydirctTest.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BuydirectTest.Utility.Abstractcomponent;

public class EnrollPage extends Abstractcomponent {

	WebDriver driver;

	public EnrollPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "firstname")
	WebElement firstname;

	@FindBy(id = "lastname")
	WebElement lastname;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "phone")
	WebElement phone;

	@FindBy(id = "address")
	WebElement address;

	@FindBy(id = "suite")
	WebElement suite;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "state")
	WebElement state;

	@FindBy(id = "zip")
	WebElement zip;
	@FindBy(id = "dateofbirth")
	WebElement dateofbirth;
	@FindBy(id = "Createpin")
	WebElement Createpin;

	@FindBy(xpath = "//select[@class='picker__select--year']")
	WebElement wait1;

	@FindBy(xpath = "//div//select[@class='picker__select--year']")
	WebElement selectyear;

	@FindBy(xpath = "//select[@class='picker__select--month']")
	WebElement selectmonth;

	@FindBy(xpath = "//div//select[@class='picker__select--month']")
	WebElement monthwait;

	@FindBy(id = "term")
	WebElement Clickterm;

	@FindBy(id = "notifications")
	WebElement clicknotifications;

	@FindBy(id = "btnEnroll")
	WebElement btnEnroll;

	@FindBy(id = "SelectID")
	WebElement SelectIDN;
	
	@FindBy(id="stateissued")
	WebElement stateissued;
	
	@FindBy(id="number")
	WebElement dlnumber;
	
	public void getFirstname(String fname) {
		firstname.sendKeys(fname);
	}

	public void getLastname(String Lastname) {
		lastname.sendKeys(Lastname);
	}

	public void getemail(String gmail) {
		email.sendKeys(gmail);
	}

	public void getPhonenumber(String phonenumber) {
		phone.sendKeys(phonenumber);
	}

	public void getAddress1(String address1) {
		address.sendKeys(address1);
	}

	public void getSute(String suiteid) {
		suite.sendKeys(suiteid);
	}

	public void getcity(String cityname) {
		city.sendKeys(cityname);
	}

	public void getstate(String statename) {

		Select ss = new Select(state);
		ss.selectByValue(statename);
	}

	public void getzip(String zipid) {
		zip.sendKeys(zipid);
	}

	public void selectID(String id) {
		Select ss = new Select(SelectIDN);
		ss.selectByIndex(0);;
	}
	
	public void selectdlstste(String DLid) {
		Select ss = new Select(stateissued);
		ss.selectByValue(DLid);
	}
	public void getDLnumber(String Dlnumber)
	{
		dlnumber.sendKeys(Dlnumber);
	}

	public void getdob(String month, String year, String day) {

		dateofbirth.click();

		waitforelementtoappear(wait1);

		wait1.click();

		WebElement years = selectyear;
		Select years1 = new Select(years);
		years1.selectByValue(year);

		selectmonth.click();

		waitforelementtoappear(monthwait);
		WebElement months = monthwait;
		Select monthaa = new Select(months);
		monthaa.selectByVisibleText(month);

		List<WebElement> days = driver.findElements(By.xpath("//div[@class='picker__day picker__day--infocus']"));

		for (int i = 0; i < days.size(); i++) {

			String ss = days.get(i).getText();
			if (ss.equals(day)) {
				days.get(i).click();
				break;
			}

		}

	}

	public void getpin(String pin) {
		Createpin.sendKeys(pin);
	}

	public void selecttearm() {
		Clickterm.click();
	}

	public void selectsms() {
		clicknotifications.click();
		;
	}

	public void submitenrollbutton() {
		btnEnroll.click();
	}

}
