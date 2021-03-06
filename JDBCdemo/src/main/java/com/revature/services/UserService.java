package com.revature.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.exceptions.RegisterUserFailedException;
import com.revature.models.User;
import com.revature.repositories.IUserDao;
import com.revature.repositories.UserDao;

public class UserService {
	// Directly injecting the interface specifications and class that Service depends on
	// DEPENDENCY INJECTION
	public IUserDao udao = new UserDao();
	
	private static Logger log = Logger.getLogger(UserService.class);
	
	public User register(User u) { // if we insert a user from the console it doesn't have an id yet
		// takes in a user object
		log.info("Registering new user...");
		
		if(u.getId() != 0) {
			
			// something is wrong...
			
			// throw some custom exception
			throw new RegisterUserFailedException("Recieved User Object did not have an id of 0");
			
			
		}
		
		// if the use's id is == 0 ....		
		// calls the insert() method from the UserDao
		int generatedId = udao.insert(u);
		
		if(generatedId != -1 && generatedId != u.getId()) {
			// fairly certain that the INSERT operation was successful
			u.setId(generatedId);
		} else {
			throw new RegisterUserFailedException("Failed to insert the user.");
		}
		
		log.info("Registration of user with id " + u.getId() + " was successful.");
		return u;
	}
	
//	public User login(String username, String password) {
//		// call some dao methods that check if this user exists, maybe return an
//		// array of all and itereate through each one to check is the username and password are the same
//		
//		// use the findByUsername dao method, then check that the user has the same password as the one passed through here
//		
//	}
	
	public void printAllUsers() {
		List<User> users = udao.findAll();
		
		users.forEach(u -> System.out.println(u));
	}
	
	
}
