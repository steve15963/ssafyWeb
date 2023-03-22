package com.ssafy.ws.step3.service;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.step3.dao.BookDaoImpl;
import com.ssafy.ws.step3.dao.IBookDao;
import com.ssafy.ws.step3.dto.Book;
import com.ssafy.ws.step3.exception.DuplicateExcepton;
import com.ssafy.ws.step3.exception.ISBNNotFoundException;

/**
 * Business logic 구현 Service : Persistance Business Logic DAO 호출
 * @author SSAFY
 *
 */
public class BookServiceImpl implements IBookService {

	private IBookDao dao;
	
	//Singleton Pattern
	private static IBookService instance = new BookServiceImpl();
	private BookServiceImpl() {
		dao = BookDaoImpl.getInstance();
	}
	
	public static IBookService getInstance() {
		return instance;
	}
	@Override
	public void add(Book book) throws DuplicateExcepton {
		dao.insert(book);
	}

	@Override
	public void remove(String isbn) throws ISBNNotFoundException {
		dao.delete(isbn);
	}

	@Override
	public Book[] getList() {
		List<Book> books = dao.findAll();
		
		Book[] bookList = new Book[books.size()];
		return books.toArray(bookList);
	}

	@Override
	public Book searchByIsbn(String isbn) throws ISBNNotFoundException {
		return dao.findByIsbn(isbn);
	}

	/**
	 * 도서제목에 포함된 문자열 검색
	 * @param title:String 검색할 도서 제목
	 * @return bookList: Book[] 검색된 도서목록 
	 */
	@Override
	public Book[] searchByTitle(String title) {
		
		List<Book> bookList=dao.findByTitle(title);

		Book [] result= new Book[bookList.size()];
	
		return bookList.toArray(result);
	}

	@Override
	public int getTotalPrice() {
		return dao.getTotalPrice();
	}

	@Override
	public double getPriceAvg() {
		return dao.getPriceAvg();
	}


}
