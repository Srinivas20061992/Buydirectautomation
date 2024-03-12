package BuydirectTest.Utility;

import javax.sql.rowset.spi.XmlReader;

@SuppressWarnings("unused")
public class readExcel {

	public void firstrow() {
		Xls_reader read =new Xls_reader("D:/Connex Shashi/selenium/BuydirectTest/BuydirectTest/src/test/java/BuydirectTest/TestDataTest_Data.xlsx");
		
		read.getCellData("Consumerdata","fname",2);
		
	}

}
