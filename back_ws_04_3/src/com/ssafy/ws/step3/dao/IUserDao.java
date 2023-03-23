package com.ssafy.ws.step3.dao;

import com.ssafy.ws.step3.dto.User;

public interface IUserDao {
	User select(String id);
	
}
