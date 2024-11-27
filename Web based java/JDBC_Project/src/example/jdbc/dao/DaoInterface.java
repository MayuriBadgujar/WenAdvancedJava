package example.jdbc.dao;

import java.util.Collection;

public interface DaoInterface<T, K> {
	// a Method to retrive all records
	Collection<T> retriveAll();

	// a method to retrive a single record
	// based upon its identity
	// T IS RESTAURANT
	T retriveOne(K key);

	// a method to insert a new record
	void create(T t);

	// a method update an exiting record
	// t is existing record
	void update(T t);

	// a method to delete an existing record
	void delete(K key);
}
