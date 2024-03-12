package BuydirectTest.TestClass;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BuydirctTest.PageObject.EnrollPage;
import BuydirctTest.PageObject.WelcomePage;
import BuydirectTest.Utility.Abstractcomponent;
import BuydirectTest.Utility.ExcelData;
import BuydirectTest.Utility.SQLDatabaseConnection;

public class TC_EnrollPageTest extends BaseTest {

	@Test
	public void TC0_Verify_title_of_page() {
		WelcomePage Welcomepage = new WelcomePage(driver);
		Welcomepage.GetStart();
		String e_title = "BuyDirect";
		String a_title = driver.getTitle();
		Assert.assertEquals(a_title, e_title);
	}

	@Test
	public void TC1_Verify_header_logo() throws Exception {
		WelcomePage Welcomepage = new WelcomePage(driver);
		Welcomepage.GetStart();
		String query = "select Partner_Image_URL from [dbo].[Partner_Image] where Partner_ID=" + partnerid
				+ " and Partner_Image_ID=1";

		String data = SQLDatabaseConnection.Dbdata(query);

		String URL = driver.findElement(By.id("buydirectMobileLogo")).getAttribute("src");
		Assert.assertEquals(data, URL);

	}

	@Test
	public void TC2_Verify_header_image_broken() {

		WelcomePage Welcomepage = new WelcomePage(driver);
		Welcomepage.GetStart();
		WebElement image = driver.findElement(By.id("buydirectMobileLogo"));

		if (image.getAttribute("naturalWidth").equals("0")) {
			System.out.println("Image is borken");
		} else {
			System.out.println("Image is not borken");
		}

	}

	@Test
	public void TC3_verify_Submit_button() throws Exception {
		WelcomePage Welcomepage = new WelcomePage(driver);
		Welcomepage.GetStart();
		ArrayList<String> data = ExcelData.Getdatafromexcel("Consumer");

		EnrollPage Enroll = new EnrollPage(driver);
		Enroll.getFirstname(data.get(1));
		Enroll.getLastname(data.get(2));
		Enroll.getemail(Abstractcomponent.randomEmail());
		Enroll.getPhonenumber(data.get(4));
		Enroll.getAddress1(data.get(5));
		Enroll.getSute(data.get(6));
		Enroll.getcity(data.get(7));
		Enroll.getstate(data.get(8));
		Enroll.getzip("15952");

		String query = "select IsDLRequired  from Partner_BuyDirect_Settings where partner_id=" + partnerid;
		System.out.println(query);
		String ss = SQLDatabaseConnection.Dbdata(query);
		
	
		if (ss.equals("1")) {
			Enroll.selectID("State ID");
			Enroll.selectdlstste("CA");
			Enroll.getDLnumber("9876542");
		}

		String[] date1 = data.get(9).split("/");
		for (int i = 0; i < date1.length; i++) {
			System.out.println(date1[i]);
		}
		Enroll.getdob(date1[1], date1[2], date1[0]);
		Enroll.getpin(data.get(11));
		Enroll.selecttearm();
		Enroll.selectsms();
		Enroll.submitenrollbutton();

		Abstractcomponent wait = new Abstractcomponent(driver);
		wait.waitforelementtoappear(driver.findElement(By.id("headerPlasticRequest")));
		String headerPlasticRequest = "Plastic";
		Assert.assertEquals(headerPlasticRequest, driver.findElement(By.id("headerPlasticRequest")).getText());

	}

}
