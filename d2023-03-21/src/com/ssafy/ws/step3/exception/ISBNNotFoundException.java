package com.ssafy.ws.step3.exception;

/**
 *buy, sell 메소드에서 해당 도서의 ISBN이 존재하지 않을 경우 사용자 정의 예외
 * @author SSAFY
 *
 */
public class ISBNNotFoundException extends Exception {
	private String isbn;
	
	public ISBNNotFoundException() {
		super("해당 도서가 존재하지 않지 않습니다.");
	}

	public ISBNNotFoundException(String isbn) {
		super(isbn+" 도서가 존재하지 않습니다.");
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}

}
