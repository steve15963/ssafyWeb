package com.ssafy.ws.step3.exception;

public class DuplicateExcepton extends Exception {

	public DuplicateExcepton() {
		super("존재하는 도서입니다.");
		// TODO Auto-generated constructor stub
	}

	public DuplicateExcepton(String isbn) {
		super(isbn+" 도서는 존재합니다.");
		// TODO Auto-generated constructor stub
	}

}
