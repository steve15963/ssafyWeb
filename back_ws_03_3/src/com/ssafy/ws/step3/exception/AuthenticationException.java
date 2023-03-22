package com.ssafy.ws.step3.exception;

public class AuthenticationException extends Exception {
	public AuthenticationException() {
		super("아이디와 비밀번호를 확인하세요");
	}
	
}
