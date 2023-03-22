package com.ssafy.ws.step3.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Driver Load하고 Connection 객체 리턴하고 반납하는 Utility 클래스
 * @author SSAFY
 *
 */
public class DBUtil {
	private final String DRIVER="com.mysql.cj.jdbc.Driver";
	private final String URL="jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC";
	private final String USER="ssafy";
	private final String PASSWORD="ssafy";
	private static DBUtil instance = new DBUtil();
	
	private DBUtil() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql Driver Load 실패!!!");
		}
	}
	
	public static DBUtil getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
//	public void close(Statement stmt, Connection con) {
//		try {
//			if( stmt != null ) stmt.close();
//			if( con != null ) con.close();
//		}catch(SQLException closeError) {
//			System.out.println("자원반납 실패 !!");
//		}
//	}
//	
//	public void close(ResultSet result, Statement stmt, Connection con) {
//		try {
//			if(result != null ) result.close();
//			if( stmt != null ) stmt.close();
//			if( con != null ) con.close();
//		}catch(SQLException closeError) {
//			System.out.println("자원반납 실패 !!");
//		}
//	}
	
	public void close(AutoCloseable... autoCloseables ) {
		for(AutoCloseable c: autoCloseables) {
				try {
					if(c!=null) c.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
