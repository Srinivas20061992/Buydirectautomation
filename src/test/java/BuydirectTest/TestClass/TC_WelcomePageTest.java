package BuydirectTest.TestClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import BuydirectTest.Utility.SQLDatabaseConnection;

public class TC_WelcomePageTest extends BaseTest {


	@Test
	public void TC0_Verify_title_of_page() {
		String e_title = "BuyDirect";
		String a_title = driver.getTitle();
		Assert.assertEquals(a_title, e_title);
		
	/*	ArrayList<String> exceptionCapture = new ArrayList<>();
	try {
			String e_title = "BuyDirect11";
			String a_title = driver.getTitle();

			System.out.printf("Title of the Page: ");
			System.out.println(a_title);
			if (a_title.equals(e_title)) {
				Status = "passed";
			}
			Assert.assertEquals(a_title, e_title);
		} catch (AssertionError e) {
			Status = "failed";
			exceptionCapture.add(e.getMessage());
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("lambda-exceptions", exceptionCapture);
		}*/
	}

	
	@Test
	public void TC1_Verify_header_logo() throws Exception {
		String query = "select Partner_Image_URL from [dbo].[Partner_Image] where Partner_ID=" + partnerid
				+ " and Partner_Image_ID=1";

		String data = SQLDatabaseConnection.Dbdata(query);

		String URL = driver.findElement(By.id("buydirectMobileLogo")).getAttribute("src");
		Assert.assertEquals(data, URL);

	}

	@Test
	public void TC2_Verify_header_image_broken() {
		WebElement image = driver.findElement(By.id("buydirectMobileLogo"));

		if (image.getAttribute("naturalWidth").equals("0")) {
			System.out.println("Image is borken");
		} else {
			System.out.println("Image is not borken");
		}

	}

	@Test
	public void TC3_Verify_partner_tender_name() throws Exception {
		String query = "select Tender_Name_header  from Partner_BuyDirect_Settings where partner_id=" + partnerid;

		String data = SQLDatabaseConnection.Dbdata(query);

		String URL = driver.findElement(By.xpath("//h5[@class='text-center mb-3']")).getText();
		Assert.assertEquals(data, URL);

	}

	@Test
	public void TC4_Verify_body_Text1() {

		String query = "SELECT SUBSTRING(Welcome_Message, 1, CHARINDEX('|', Welcome_Message)-1) FROM Partner_BuyDirect_Settings where partner_id="
				+ partnerid;

		String data = SQLDatabaseConnection.Dbdata(query);
		String Actualtext = driver.findElement(By.xpath("//div[@id='WelcomeStart']//span[1]")).getText();
		Assert.assertEquals(data, Actualtext);

	}

	@Test
	public void TC5_Verify_body_Text2() {
		String query = "SELECT SUBSTRING(Welcome_Message,CHARINDEX('|', Welcome_Message)+ 1, LEN(Welcome_Message)-CHARINDEX('|',Welcome_Message))\r\n"
				+ "FROM Partner_BuyDirect_Settings where partner_id=127;";

		String data = SQLDatabaseConnection.Dbdata(query);
		String Actualtext = driver.findElement(By.xpath("//div[@id='WelcomeStart']//span[2]")).getText();
		Assert.assertEquals(data, Actualtext);

	}

	@Test
	public void TC6_Verify_header_Text() {
		String Expected = "Welcome";
		String Actualtext = driver.findElement(By.id("headerWelcomeStart")).getText();
		Assert.assertEquals(Expected, Actualtext);
	}

}
