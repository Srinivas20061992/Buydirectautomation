package BuydirectTest.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readconfig {

	Properties pro;

	public readconfig() {
		File scr = new File("./Configuration/config.properties");
		try {
			FileInputStream file = new FileInputStream(scr);
			pro = new Properties();
			try {
				pro.load(file);
			} catch (IOException e) {

				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	public String AppURL() {

		String URL = pro.getProperty("BaseURL");
		return URL;
	}

	public String getbrowser() {

		String URL = pro.getProperty("browser");
		return URL;
	}
	public String getPartnerId() {

		String partner_id = pro.getProperty("partner_id");
		return partner_id;
	}
}
