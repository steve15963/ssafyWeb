package com.ssafy.ws.step3.service;

import java.util.NoSuchElementException;

import com.ssafy.ws.step3.dao.IUserDao;
import com.ssafy.ws.step3.dao.UserDaoImpl;
import com.ssafy.ws.step3.dto.User;
import com.ssafy.ws.step3.exception.AuthenticationException;

public class UserServiceImpl implements IUserService {
	private static IUserService instance = new UserServiceImpl();
	private IUserDao db;
	private UserServiceImpl() {
		db = UserDaoImpl.getInstance();
	}
	
	public static IUserService getInstance() {
		return instance;
	}

	public static void setInstance(IUserService instance) {
		UserServiceImpl.instance = instance;
	}

	@Override
	public User login(String id, String pass) throws AuthenticationException{
		User user = db.select(id);
		if(user != null && user.getPass().equals(pass)) {
			return user;
		}
		throw new AuthenticationException();
	}

}
