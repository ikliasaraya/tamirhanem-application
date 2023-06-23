package model;

import java.security.KeyStore.PrivateKeyEntry;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import helper.DbConnection;

public class Session {
	private int sessionId;
	private int sessionUserIdFk;
	private Date sessionDate;
	private int sessionUserTypeIdFk;
	
	public int getSessionUserTypeIdFk() {
		return sessionUserTypeIdFk;
	}

	public void setSessionUserTypeIdFk(int sessionUserTypeIdFk) {
		this.sessionUserTypeIdFk = sessionUserTypeIdFk;
	}

	public void addDbSession() throws SQLException {
		Connection conn = DbConnection.getConnection();
        String sql = "INSERT INTO session (session_useridfk, session_usertypefk) VALUES (?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, this.sessionUserIdFk);
        statement.setInt(2, this.sessionUserTypeIdFk);
        
        int query = statement.executeUpdate();
        if (query > 0) {
        	System.out.println(this.sessionUserIdFk + " giris yapti" + "usertype: " + this.sessionUserTypeIdFk);
        }
        conn.close();
	}
	
	public int getSessionId() {
		return sessionId;
	}
	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}
	public int getSessionUserIdFk() {
		return sessionUserIdFk;
	}
	public void setSessionUserIdFk(int sessionUserIdFk) {
		this.sessionUserIdFk = sessionUserIdFk;
	}
	public Date getSessionDate() {
		return sessionDate;
	}
	public void setSessionDate(Date sessionDate) {
		this.sessionDate = sessionDate;
	}
	
}
