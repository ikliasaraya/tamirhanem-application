package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import helper.DbConnection;

public class User {
	
	private int userId;
	private String username;
	private String userPassword;
	private int userTypeFk;
	
	public int addDbUser() throws SQLException {
		Connection conn = DbConnection.getConnection();
		String sql = "INSERT INTO tamirhanemdb.user (user_username, user_password, user_usertypeidfk) VALUES (?, ?, ?)";
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setString(1, this.username);
		st.setString(2, this.userPassword);
		st.setInt(3, this.userTypeFk);
		
		int query = st.executeUpdate();
		conn.close();
		if(query > 0) {
			System.out.println("user olustu");
			return 1;
		}else {
			return 0;
		}
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserTypeFk() {
		return userTypeFk;
	}
	public void setUserTypeFk(int userTypeFk) {
		this.userTypeFk = userTypeFk;
	}

}
