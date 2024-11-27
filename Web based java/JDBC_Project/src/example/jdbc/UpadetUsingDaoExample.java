package example.jdbc;

import example.jdbc.bean.Restaurant;
import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.RestaurantDao;

public class UpadetUsingDaoExample {

	public static void main(String[] args) {
		DaoInterface<Restaurant,Integer> daoRef=new RestaurantDao();
		//obtaining a restraurant on which update is to be perfoemd
		
		Restaurant rst=daoRef.retriveOne(104);
		//changing the name and branch count using setters
		//rst.setName("New Little Italy");
		//rst.setBranchCount(20);
		rst.setCuisine("Oriental");
		//reflecting this changed state back to DB
		daoRef.update(rst);
		
		
		
		
		
		
		
		
		
	

	}

}
