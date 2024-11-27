package example.jdbc;

import example.jdbc.bean.Restaurant;
import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.RestaurantDao;

public class CreateUsingDaoExample {

	public static void main(String[] args) {
	
		DaoInterface<Restaurant,Integer> daoRef=new RestaurantDao();
		Restaurant rst=new Restaurant(106,"Mianland China","chinese",5);
		daoRef.create(rst);
	}

}
