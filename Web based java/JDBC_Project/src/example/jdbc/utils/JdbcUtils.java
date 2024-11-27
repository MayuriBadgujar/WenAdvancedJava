package example.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtils {
//this is utility class for obtaining a connection and returning the same
	public static Connection getConnection() throws Exception{
		//here "Class.forName()" is not used because it is not needed
		//the driver  gets loaded automatically
		String url = "jdbc:mysql://localhost:3306/zomato";
		String uid = "root";
		String pwd = "password";
		Connection dbConnection = DriverManager.getConnection(url, uid, pwd);
		return dbConnection;
	}
}
