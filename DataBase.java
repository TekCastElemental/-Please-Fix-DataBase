package DataBase;

import java.sql.*;


public class DataBase {
	
	public static void main(String args[]) {
		
		final String DRIVER =
				"org.apache.derby.jdbc.EmbeddedDriver";
		final String CONNECTION =
				"jdbc:derby:AccountDatabase;create=true";
		
		try {
			Class.forName(DRIVER).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		try (Connection connection =
				DriverManager.getConnection(CONNECTION);
				
				Statement statement =
						connection.createStatement()) {
			statement.executeUpdate(
					"Create table ACCOUNTS"
					+ "(NAME VARCHAR(32) NOT NULL PRIMARY KEY, "
					+ "ADDRESS VARCHAR(32),"
					+ "BALANCE FLOAT)");
			
			statement.executeUpdate(
					"Insert into ACCOUNTS values"
					+ "Barry Burd, '222 Cyber Lane', 24.02) ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		}
	}
	

