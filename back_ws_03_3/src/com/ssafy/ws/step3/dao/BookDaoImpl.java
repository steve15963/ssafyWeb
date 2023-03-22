package com.ssafy.ws.step3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.step3.dto.Book;
import com.ssafy.ws.step3.exception.DuplicateExcepton;
import com.ssafy.ws.step3.exception.ISBNNotFoundException;
import com.ssafy.ws.step3.util.DBUtil;

public class BookDaoImpl implements IBookDao {
	private static IBookDao instance = new BookDaoImpl();
	private DBUtil db;
	
	private BookDaoImpl() {
		db = DBUtil.getInstance(); //Driver Load 1번
	}

	public static IBookDao getInstance() {
		return instance;
	}

	@Override
	public void insert(Book book) throws DuplicateExcepton {
		if( isExist(book.getIsbn()) ) 
			throw new DuplicateExcepton(book.getIsbn());
		
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql ="INSERT INTO book(isbn, title,author,price,`desc`)"+
		            "       VALUES(?, ?, ?, ?, ?)";
		
		try {
			con = db.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setInt(4,  book.getPrice());
			pstmt.setString(5,  book.getDesc());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt, con);
		}

	}

	@Override
	public void delete(String isbn) throws ISBNNotFoundException {
		if(!isExist(isbn))
			throw new ISBNNotFoundException(isbn);
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql ="DELETE FROM book WHERE isbn=?";
		
		try {
			con = db.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, isbn);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt, con);
		}
		

	}

	@Override
	public void update(Book book) throws ISBNNotFoundException {
		if(!isExist(book.getIsbn()))
			throw new ISBNNotFoundException(book.getIsbn());
		
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql ="UPDATE book SET "+
		            "title=?, author=?, price=?, `desc`=? WHERE isbn=?";
		
		try {
			con = db.getConnection();
			pstmt = con.prepareStatement(sql);
			int index=1;
			pstmt.setString(index++, book.getTitle());
			pstmt.setString(index++, book.getAuthor());
			pstmt.setInt(index++,  book.getPrice());
			pstmt.setString(index++,  book.getDesc());
			pstmt.setString(index++, book.getIsbn());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt, con);
		}

	}
	@Override
	public List<Book> findAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet result=null;
		String sql ="SELECT isbn, title, author, price, `desc` "+
		            " FROM book";
		List<Book> books = new ArrayList<Book>();
		
		try {
			con = db.getConnection();
			pstmt = con.prepareStatement(sql);
				
			result = pstmt.executeQuery();
			while(result.next()) {
				books.add(new Book(
									result.getString("isbn"),
									result.getString("title"),
									result.getString("author"),
									result.getInt("price"),
									result.getString("desc")
						));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(result, pstmt, con);
		}
	
		return books;
	}

	@Override
	public Book findByIsbn(String isbn) throws ISBNNotFoundException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet result=null;
		String sql ="SELECT isbn, title, author, price, `desc` "+
		            " FROM book WHERE isbn=?";
		Book book=null;
		try {
			con = db.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, isbn);
				
			result = pstmt.executeQuery();
			if(result.next()) {
				book =new Book(
									result.getString("isbn"),
									result.getString("title"),
									result.getString("author"),
									result.getInt("price"),
									result.getString("desc")
						);
			}else {
				throw new ISBNNotFoundException(isbn);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(result, pstmt, con);
		}		
		
		return book;
	}

	@Override
	public List<Book> findByTitle(String title) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet result=null;
		String sql ="SELECT isbn, title, author, price, `desc` "+
		            " FROM book WHERE UPPER(title) like concat('%',UPPER(?),'%')";
		List<Book> books = new ArrayList<Book>();
		try {
			con = db.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
				
			result = pstmt.executeQuery();
			while(result.next()) {
				books.add(new Book(
									result.getString("isbn"),
									result.getString("title"),
									result.getString("author"),
									result.getInt("price"),
									result.getString("desc")
						));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(result, pstmt, con);
		}		
		
		return books;
	}

	@Override
	public int getTotalPrice() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet result=null;
		String sql ="SELECT sum(price) totalPrice FROM book";	
		int totalPrice=0;
		try {
			con = db.getConnection();
			pstmt = con.prepareStatement(sql);
				
			result = pstmt.executeQuery();
			if(result.next()) {
				totalPrice = result.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(result, pstmt, con);
		}		
	
		return totalPrice;
	}

	@Override
	public double getPriceAvg() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet result=null;
		String sql ="SELECT avg(price) priceAvg FROM book";	
		double priceAvg=0;
		try {
			con = db.getConnection();
			pstmt = con.prepareStatement(sql);
				
			result = pstmt.executeQuery();
			if(result.next()) {
				priceAvg = result.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(result, pstmt, con);
		}		
	
		return priceAvg;
	}
	
	private boolean isExist(String isbn) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet result=null;
		String sql="SELECT isbn FROM book WHERE isbn=?";
		boolean exist = false;
		try {
			con = db.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  isbn);
			
			result = pstmt.executeQuery();
			
			exist= result.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close(result, pstmt, con);
		}
		
		return exist;
	}


}
