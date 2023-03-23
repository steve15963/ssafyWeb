package com.ssafy.ws.step3.service;

import com.ssafy.ws.step3.dto.Book;
import com.ssafy.ws.step3.exception.DuplicateExcepton;
import com.ssafy.ws.step3.exception.ISBNNotFoundException;

public interface IBookService {
	public abstract void add(Book book) throws DuplicateExcepton;
	public abstract void remove(String isbn) throws ISBNNotFoundException;
	public abstract Book[] getList();
	public abstract Book searchByIsbn(String isbn) throws ISBNNotFoundException;
	public abstract Book[] searchByTitle(String title);
	public abstract int getTotalPrice();
	public abstract double getPriceAvg();

}
