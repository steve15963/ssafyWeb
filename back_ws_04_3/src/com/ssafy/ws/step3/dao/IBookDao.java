package com.ssafy.ws.step3.dao;

import java.util.List;

import com.ssafy.ws.step3.dto.Book;
import com.ssafy.ws.step3.exception.DuplicateExcepton;
import com.ssafy.ws.step3.exception.ISBNNotFoundException;

public interface IBookDao {
	void insert(Book book) throws DuplicateExcepton;
	void delete(String isbn) throws ISBNNotFoundException;
	void update(Book book) throws ISBNNotFoundException;
	List<Book> findAll();
	Book findByIsbn(String isbn) throws ISBNNotFoundException;
	List<Book> findByTitle(String title);
	int getTotalPrice();
	double getPriceAvg();
}
