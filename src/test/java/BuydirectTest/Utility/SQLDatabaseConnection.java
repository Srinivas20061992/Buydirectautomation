package BuydirectTest.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDatabaseConnection {

	// Connect to your database.
	// Replace server name, username, and password with your credentials
	// public static String DBdata(String Query) throws Exception {
	public static String Dbdata(String query) {
		String connectionUrl = "jdbc:sqlserver://bimservicesdb-qa.database.windows.net;databaseName=BimSys;user=bimx05dbqa;password=jVs4xpUsVd35eyr5";

		String rr = null;
		try (Connection connection = DriverManager.getConnection(connectionUrl);
				Statement statement = connection.createStatement();) {
			ResultSet resultSet;
			// Create and execute a SELECT SQL statement.
			// String selectSql = "select Partner_Image_URL from [dbo].[Partner_Image] where
			// Partner_ID=127 and Partner_Image_ID=1";
			resultSet = statement.executeQuery(query);

			// data=resultSet.getString(0);
			// Print results from select statement
			while (resultSet.next()) {
				rr = resultSet.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rr;

	}
}