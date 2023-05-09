package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static Connection connection = null;

	{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void openConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tamirhanemdb", "root", "pwdpwd");
			System.out.println("Database bağlantısı başarılı!");
		} catch (SQLException e) {
			System.out.println("Databasee bağlantısı başarısız!");
		}
	}
	
	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("Database bağlantısı kapatıldı!");
			} catch (Exception e) {
				System.out.println("Database bağlantısı kapatılamadı!");
			}
		} else {
			System.out.println("Database bağlantısı bulunmuyor!");
		}
	}
	
	public static Connection getConnection() throws SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tamirhanemdb", "root", "pwdpwd");
		return connection;
	}



}
