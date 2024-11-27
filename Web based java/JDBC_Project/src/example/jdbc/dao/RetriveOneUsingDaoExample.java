package example.jdbc.dao;

import example.jdbc.bean.Restaurant;
import example.jdbc.dao.DaoInterface;

public class RetriveOneUsingDaoExample {

	public static void main(String[] args) {
		DaoInterface<Restaurant ,Integer> daoRef=new RestaurantDao();
		Restaurant restaurantObj=daoRef.retriveOne(105);
		if(restaurantObj!=null) {
			System.out.println(restaurantObj);
		}
		else {
			System.out.println("Restaurant not exist");
		}

	}

}
