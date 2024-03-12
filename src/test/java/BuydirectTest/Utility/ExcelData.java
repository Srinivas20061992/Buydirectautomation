package BuydirectTest.Utility;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public static ArrayList<String> Getdatafromexcel(String testname) throws Exception {
		FileInputStream file = new FileInputStream("C:/Users/shashikumar/Documents/partner_data.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		int sheets = workbook.getNumberOfSheets();
		ArrayList<String> a = new ArrayList<String>();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Partner_data")) {
				XSSFSheet s = workbook.getSheetAt(i);
				Iterator<Row> row = s.iterator();
				Row firstrow = row.next();
				Iterator<Cell> cell = firstrow.cellIterator();
				int column = 0;
				int k = 0;
				while (cell.hasNext()) {
					Cell Value = cell.next();
					if (Value.getStringCellValue().equals("Consumer")) {
						column = k;
					}
					k++;
				}
				while (row.hasNext()) {
					Row r = row.next();
					if (r.getCell(column).getStringCellValue().equals(testname)) {
						Iterator<Cell> cv = r.cellIterator();

						while (cv.hasNext()) {
							Cell c = cv.next();
							if (c.getCellType().name().equals("STRING")) {
								a.add( c.getStringCellValue());
							}else if (( (c.getCellType().name().equals("FORMULA"))) )
							{
							if (HSSFDateUtil.isCellDateFormatted(c)) {
							
								Date d = c.getDateCellValue();
								System.out.println(d);
								String pattern = "dd/MMMM/yyyy";
								SimpleDateFormat df = new SimpleDateFormat(pattern);
								String dob=df.format(d);
								
								a.add(dob);
									
								/*
								 * Calendar cal = Calendar.getInstance();
								 * cal.setTimeZone(HSSFDateUtil.getExcelDate(d)); cellText =
								 * (String.valueOf(cal.get(Calendar.YEAR))).substring(2); cellText =
								 * cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" +
								 * 
								 */
								

							}
							

					
					}
							else if (c.getCellType().name().equals("NUMERIC")) {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
							

					}
				}
			}
		}

	
	}
		System.out.println(a);
		return a;
	}
}
