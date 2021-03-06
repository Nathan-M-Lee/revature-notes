package com.revature.repositories;

import java.util.List;

import com.revature.models.User;
/**
 * DAO is a data access object
 * 
 * it is used to separate our persistence logic from our business logic and outline all CRUD functionality
 * @author leena
 *
 */
public interface IUserDao { // all CRUD methods
	
	int insert(User u); // we aim to return the primary key of the user inserted into the DB
	User findByUserName(String username);
	List<User> findAll();
	boolean update(User u);
	boolean delete(int id);
	
	
}
