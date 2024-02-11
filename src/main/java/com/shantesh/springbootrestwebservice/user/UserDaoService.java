package com.shantesh.springbootrestwebservice.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int userCount = 3;

	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(34, "Eve", new Date()));
		users.add(new User(4, "Mary", new Date()));

	}

	public List<User> findAll() {
		return users;
	}

	public User saveUser(User user) {

		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

	public User findOne(int id) {

		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

}
