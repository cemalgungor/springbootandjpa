package com.cemal.loginproject1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cemal.loginproject1.dao.model.User;
import com.cemal.loginproject1.dao.repo.UserDAO;
import com.cemal.loginproject1.dao.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Transactional
	@Override
	public List<User> get() {

		return (List<User>) userRepo.findAll();
	}

	@Transactional
	@Override
	public User get(int id) {

		return null;
	}

	@Transactional
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public User save(User user) {

		return userRepo.save(user);
	}

	@Override
	public User findByUsername(String username) {

		return userRepo.findByUsername(username);

	}

	@Override
	public User findByPassword(String password) {
		// TODO Auto-generated method stub
		return userRepo.findByPassword(password);
	}

	@Override
	public User findByUser(String username, String password) {
		// TODO Auto-generated method stub
		return userRepo.findByUser(username,password);
	}

}
