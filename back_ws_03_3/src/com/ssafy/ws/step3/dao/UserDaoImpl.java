package com.ssafy.ws.step3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.ws.step3.dto.User;
import com.ssafy.ws.step3.util.DBUtil;

public class UserDaoImpl implements IUserDao {
	private static IUserDao instance = new UserDaoImpl();
	private DBUtil database;
	private UserDaoImpl() {
		database = DBUtil.getInstance();
	}
	public static IUserDao getInstance() {
		return instance;
	}
	
	public User select(String id) {
		String sql = "SELECT * FROM user WHERE id=?";
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		User user = null;
		try {
			con = database.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeQuery();
			if(result.next()) {
				user = new User(
						result.getString("id"),
						result.getString("pass"),
						result.getString("name"),
						result.getString("rec_id")
				);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			database.close(result,pstmt,result);
		}
		return user;
	}
	public static void main(String args[]) {
		IUserDao  userDao = UserDaoImpl.getInstance();
		System.out.println(userDao.select("ssafy"));
	}
}
