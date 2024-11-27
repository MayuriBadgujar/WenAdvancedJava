package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleSelectQueryExample {

	public static void main(String[] args) {
		// load driver
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/zomato";
		String uid = "root";
		String pwd = "password";
		
		Connection dbConnection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driverClassName);
			System.out.println("Driver loaded");

			// establish connection

			dbConnection = DriverManager.getConnection(url, uid, pwd);
			System.out.println("Connected to DB");

			// obtain some statement
			stmt = dbConnection.createStatement();
			System.out.println("Obtained the statement!");

			// execute sql query

			String sqlQuery = "select rest_name,rest_branch_count, rest_cuisine from  restaurant_master";
			rs = stmt.executeQuery(sqlQuery);
			System.out.println("Executed SQL SELECT query and obtained ResultSet");

			// in case of select query,obtain resultset and perform navigation
			while (rs.next()) {
				String restaurantName = rs.getString(1);
				int branchCount = rs.getInt(2);
				String restaurantCuisine = rs.getString(3);
				System.out.println(restaurantName + " : " + branchCount + " : " + restaurantCuisine);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// e.printStackTrace();
			System.out.println("Unable to load the driver");
		}

		finally {
			try {
				rs.close();
				stmt.close();
				dbConnection.close();
			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		

		// create folder download zip copy that file paste in lib folder
		// jdbc right click --build path--configure--

	}

}
