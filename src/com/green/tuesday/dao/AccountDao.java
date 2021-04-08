package com.green.tuesday.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.green.tuesday.db.DBConnection;
import com.green.tuesday.vo.ClientVo;

public class AccountDao {

	// 관리자 로그인
	public boolean adminLogin(String userId, String userPassword) {
		boolean isValid = false;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBConnection db = null;

		try {
			db = new DBConnection();
			conn = db.getConnection();

			String sql = "SELECT adminPassword FROM admin_account WHERE adminId = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();			

			if(rs.next()) {
				String validPassword = rs.getString("adminPassword");

				if (userPassword.equals(validPassword) == true) {
					isValid = true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if(rs!=null)    rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

		return isValid;

	}

	
	// 회원 로그인
	public boolean clientLogin(String userId, String userPassword) {
		boolean isValid = false;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBConnection db = null;

		try {
			db = new DBConnection();
			conn = db.getConnection();

			String sql = "SELECT clientPassword FROM client_account WHERE clientId = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();			

			if(rs.next()) {
				String validPassword = rs.getString("clientPassword");

				if (userPassword.equals(validPassword) == true) {
					isValid = true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if(rs!=null)    rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

		return isValid;
	}

	
	// 회원가입
	public int insertAccount(String clientId, String clientPassword, String clientEmail) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		DBConnection db = null;

		int InsertResult = 0;

		try {
			db = new DBConnection();
			conn = db.getConnection();

			String sql = "insert into client_account (indexNum, clientId, clientPassword, clientEmail)"; 
			sql += " VALUES ( "; 
			sql += " (select nvl(max(indexNum), 0) + 1 from client_account), ?, ?, ?)"; 

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1,clientId);
			pstmt.setString(2,clientPassword);
			pstmt.setString(3,clientEmail);

			InsertResult = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			
			} catch(Exception e) {
				e.printStackTrace();
			
			}
		
		}
		return InsertResult;
	
	}


	// 회원 리스트
	public List<ClientVo> getClientList() {
		List<ClientVo> clientList = new ArrayList<ClientVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBConnection db = null;

		try {
			db = new DBConnection();
			conn = db.getConnection();

			String sql = "SELECT indexNum, clientId, clientPassword, clientEmail, registerDate, tag";
			sql += " FROM client_account ORDER BY indexNum";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();			

			while (rs.next()) {
				int indexNum = rs.getInt("indexNum");
				String clientId = rs.getString("clientId");
				String clientPassword = rs.getString("clientPassword");
				String clientEmail = rs.getString("clientEmail");
				String registerDate = rs.getString("registerDate");
				String tag = rs.getString("tag");

				ClientVo clientVo = new ClientVo(indexNum, clientId, clientPassword, clientEmail, registerDate, tag);
				
				clientList.add(clientVo);

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally {
			try {
				if(rs!=null)    rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
		
			} catch(Exception e) {
				e.printStackTrace();
			
			}
		}

		return clientList;
	}


	public int deleteAccount(int indexNum) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnection db = null;

		try {
			db = new DBConnection();
			conn = db.getConnection();

			String sql = "delete from client_account where indexNum = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, indexNum);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			
		}			
		return result;
		
	}


	public ClientVo getAccount(int reqIndexNum) {
		ClientVo clientVo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnection db = null;
		ResultSet rs = null;

		try {
			db = new DBConnection();
			conn = db.getConnection();

			String sql = "select indexNum, clientId, clientPassword, clientEmail, registerDate, tag";
			sql += " From client_account Where indexNum = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reqIndexNum);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				int indexNum = rs.getInt("indexNum");
				String clientId = rs.getString("clientId");
				String clientPassword = rs.getString("clientPassword");
				String clientEmail = rs.getString("clientEmail");
				String registerDate = rs.getString("registerDate");
				String tag = rs.getString("tag");

				clientVo = new ClientVo(indexNum, clientId, clientPassword, clientEmail, registerDate, tag);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}			

		return clientVo;
	}


	public int updateAccount(int indexNum, String clientPassword, String clientEmail) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnection db = null;

		try {
			db = new DBConnection();
			conn = db.getConnection();

			String sql = "update client_account set clientPassword = ?, clientEmail = ? where indexNum = ?";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, clientPassword);
			pstmt.setString(2, clientEmail);
			pstmt.setInt(3, indexNum);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}			

		return result;
	}




}
