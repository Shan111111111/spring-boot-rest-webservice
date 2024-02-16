package com.shantesh.springbootrestwebservice.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
	public static List<User> users = new ArrayList<>();
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

	public User deleteOne(int id) {
		Iterator iterator = users.iterator();
		while (iterator.hasNext()){
			User user = (User) iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
        return null;
    }
}
