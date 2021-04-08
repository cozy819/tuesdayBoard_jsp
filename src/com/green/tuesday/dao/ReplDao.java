package com.green.tuesday.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.green.tuesday.db.DBConnection;
import com.green.tuesday.vo.ReplVo;

public class ReplDao {

	public List<ReplVo> getReplList(int reqSongNum) {
		List<ReplVo> replList = new ArrayList<ReplVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBConnection db = null;

		try {
			db = new DBConnection();
			conn = db.getConnection();

			String sql = "SELECT replNum, songNum, replWriter, replContent, registerDate";
			sql += " FROM repls WHERE songNum = ? ORDER BY registerDate asc";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, reqSongNum);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int replNum = rs.getInt("replNum");
				int songNum = rs.getInt("songNum");
				String replWriter = rs.getString("replWriter");
				String replContent = rs.getString("replContent");
				String registerDate = rs.getString("registerDate");

				ReplVo replVo = new ReplVo(replNum, songNum, replWriter, replContent, registerDate);
				
				replList.add(replVo);
				
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

		return replList;
	}

	public int addRepl(int songNum, String replWriter, String replContent) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		DBConnection db = null;

		int insertResult = 0;

		try {
			db = new DBConnection();
			conn = db.getConnection();

			String sql = "insert into repls (replNum, songNum, replWriter, replContent) "; 
			sql += " VALUES ( "; 
			sql += " ( select nvl(max(replNum), 0) + 1 from repls ), "; 
			sql += " ?, ?, ? )";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, songNum);
			pstmt.setString(2, replWriter);
			pstmt.setString(3, replContent);
			
			insertResult = pstmt.executeUpdate();
		
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
		return insertResult;
	}

	public int deleteRepl(int replNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		DBConnection db = null;

		int deleteResult = 0;

		try {
			db = new DBConnection();
			conn = db.getConnection();

			String sql = "delete from repls Where replNum = ?"; 
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, replNum);
			
			deleteResult = pstmt.executeUpdate();
		
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
		return deleteResult;
	}

	public ReplVo getRepl(int reqReplNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ReplVo replVo = null;
		
		DBConnection db = null;

		try {
			db = new DBConnection();
			conn = db.getConnection();

			String sql = "SELECT replNum, songNum, replWriter, replContent, registerDate";
			sql += " FROM repls WHERE replNum = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, reqReplNum);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int replNum = rs.getInt("replNum");
				int songNum = rs.getInt("songNum");
				String replWriter = rs.getString("replWriter");
				String replContent = rs.getString("replContent");
				String registerDate = rs.getString("registerDate");

				replVo = new ReplVo(replNum, songNum, replWriter, replContent, registerDate);

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

		return replVo;	
	
	}

	public int updateRepl(int replNum, String replWriter, String replContent) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnection db = null;

		try {
			db = new DBConnection();
			conn = db.getConnection();

			String sql = "update repls set replWriter = ?, replContent = ? where replNum = ?";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, replWriter);
			pstmt.setString(2, replContent);
			pstmt.setInt(3, replNum);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}			

		return result;
	}

}
