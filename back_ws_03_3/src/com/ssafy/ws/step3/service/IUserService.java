package com.ssafy.ws.step3.service;

import com.ssafy.ws.step3.dto.User;
import com.ssafy.ws.step3.exception.AuthenticationException;

public interface IUserService {
	User login(String id, String pass) throws AuthenticationException;
}
