package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	private static Integer idControl = 0;
	
	static {
		users.add(new User(++idControl, "Adam", new Date()));
		users.add(new User(++idControl, "Eve", new Date()));
		users.add(new User(++idControl, "Jack", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public Optional<User> findOne(Integer id){
		return users.stream().filter(user -> user.getId() == id).findFirst();
	}
	
	public User save(User user) {
		user.setId(++idControl);
		users.add(user);
		return user;
	}
}
