package com.ssafy.ws.step3;

import com.ssafy.ws.step3.dto.Book;
import com.ssafy.ws.step3.exception.DuplicateExcepton;
import com.ssafy.ws.step3.exception.ISBNNotFoundException;
import com.ssafy.ws.step3.service.BookServiceImpl;
import com.ssafy.ws.step3.service.IBookService;

public class BookTest {

	public static void main(String[] args) {
		IBookService manager = BookServiceImpl.getInstance(); //Singleton Pattern
		try {
			manager.add(new Book("21424", "Java Pro","김하나",15000,"Java 기본문법"));
			manager.add(new Book("41425", "Java Pro2","김하나",25000,"Java 응용"));
			manager.add(new Book("55355","분석설계","소나무",30000,"SW 모델링"));
		}catch(DuplicateExcepton insertError) {
			exceptionHandling(insertError.getMessage());
		}
		
		display("도서 전체 목록 ");
		Book [] books = manager.getList();
		for(Book b : books)
			display(b);
		
				
		display("도서 제목포함 검색 : Java");
		books = manager.searchByTitle("Java");
		for(Book b : books)
			display(b);

			
		try {
			display(manager.searchByIsbn("21424"));
			manager.remove("21424");
		} catch (ISBNNotFoundException notFoundError) {
			exceptionHandling(notFoundError.getMessage());
		}
		
		display("21424 삭제 후 목록 ");
		books = manager.getList();
		for(Book b : books)
			display(b);
		
		System.out.println("도서 가격 총합 :"+manager.getTotalPrice());
		System.out.println("도서 가격 평균 :"+manager.getPriceAvg());

		
	}
	
	public static void display(String title) {
		System.out.println("***************** "+ title +" *****************");

	}
	public static void display(Book book) {
		System.out.println(book);
	}
	public static void exceptionHandling(String message) {
		System.out.println(message);
	}
	

}
