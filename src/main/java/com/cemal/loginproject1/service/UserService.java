package com.cemal.loginproject1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cemal.loginproject1.dao.model.User;

public interface UserService {

	List<User> get();

	User get(int id);

	User save(User user);

	void delete(int id);

	User findByUsername(String username);

	User findByPassword(String password);
	User findByUser(String username, String password);
	// User findById(String username);

	// public boolean findUser(String uname, String upwd);
	// public boolean save(String username, String password);

}
