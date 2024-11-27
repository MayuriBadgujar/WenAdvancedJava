package example.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import example.jdbc.bean.Restaurant;
import example.jdbc.utils.JdbcUtils;

public class RestaurantDao implements DaoInterface<Restaurant, Integer> {

	@Override
	public Collection<Restaurant> retriveAll() {
//	this method connect to db faces all records ,converts them into java 
//		objects of restaurant class ,puts those objects into some
//		collection and returns the collection
		// creating an empty arraylist:allReastaurant name
		Collection<Restaurant> allRestaurant = new ArrayList<Restaurant>();
		String sqlQuery = "select * from  restaurant_master";

		try (
				// OPENING THE RESOURCE USING TRY with resources so that they get closed
				// automatically
				Connection conn = JdbcUtils.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery)) {
			while (rs.next()) {

				int restaurantId = rs.getInt(1);
				String restaurantName = rs.getString(2);
				int branchCount = rs.getInt(4);
				String restaurantCuisine = rs.getString(3);

				Restaurant rst = new Restaurant(restaurantId, restaurantName, restaurantCuisine, branchCount);
				allRestaurant.add(rst);
			}
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
		return allRestaurant;
	}

	@Override
	public Restaurant retriveOne(Integer id) {
		Restaurant foundRestaurant = null;
		String sqlQuery = "select * from restaurant_master where  rest_id=?";
		try (Connection conn = JdbcUtils.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sqlQuery);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				int restaurantId = rs.getInt(1);
				String restaurantName = rs.getString(2);
				int branchCount = rs.getInt(4);
				String restaurantCuisine = rs.getString(3);
				foundRestaurant = new Restaurant(restaurantId, restaurantName, restaurantCuisine, branchCount);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return foundRestaurant;
	}

	@Override
	public void create(Restaurant newRestaurant) {
		// this method accepts a "Restaurant" object :newRestaurant and stpores
		// it as a record in the DB table
		String sqlQuery = "insert into restaurant_master values(?,?,?,?)";

		try (Connection conn = JdbcUtils.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sqlQuery);) {
			// Extracting the values from restaurant object:newRestaurant using getter
			// method
			int restaurantId = newRestaurant.getRestaurantId();
			String resturantName = newRestaurant.getName();
			String restaurantCusine = newRestaurant.getCuisine();
			int restaurantBranchCount = newRestaurant.getBranchCount();

			// substituting these values in place of "?' using PreparedStatement
			pstmt.setInt(1, restaurantId);
			pstmt.setString(2, resturantName);
			pstmt.setString(3, restaurantCusine);
			pstmt.setInt(4, restaurantBranchCount);

			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount + " Record inserted");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void update(Restaurant modifiedRestaurant) {
		// This method receives the modified state of the restaurant
		// object : modifiedRestaurant and reflects that state into db
		String sqlQuery = "update restaurant_master set rest_name=?,rest_cuisine=?,rest_branch_count=? where rest_id=?";
		try (Connection conn = JdbcUtils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery);) {
			// capturing the modified state of reastaurant object:modifiedRestaurant
			// using getter methods
			int restaurantId = modifiedRestaurant.getRestaurantId();
			String resturantName = modifiedRestaurant.getName();
			String restaurantCusine = modifiedRestaurant.getCuisine();
			int restaurantBranchCount = modifiedRestaurant.getBranchCount();

			// substituting these values in place of "?' using PreparedStatement
			pstmt.setInt(4, restaurantId);
			pstmt.setString(1, resturantName);
			pstmt.setString(2, restaurantCusine);
			pstmt.setInt(3, restaurantBranchCount);

			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount + " Record inserted");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
//		This method performs record deletion agianst identity
		
		String sqlQuery="delete from restaurant_master where rest_id=?";
		try (Connection conn = JdbcUtils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery);) {
			pstmt.setInt(1, id);
			int updateCount=pstmt.executeUpdate();
			System.out.println(updateCount+"Record deleted");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
