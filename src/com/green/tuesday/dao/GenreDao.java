package com.green.tuesday.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.green.tuesday.db.DBConnection;
import com.green.tuesday.vo.ClientVo;
import com.green.tuesday.vo.GenreVo;

public class GenreDao {

	public List<GenreVo> getGenreList() {
		List<GenreVo> genreList = new ArrayList<GenreVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBConnection db = null;

		try {
			db = new DBConnection();
			conn = db.getConnection();

			String sql = "SELECT genreId, genreName, genreSeq";
			sql += " FROM genres ORDER BY genreSeq";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();			

			while (rs.next()) {
				String genreId = rs.getString("genreId");
				String genreName = rs.getString("genreName");
				int genreSeq = rs.getInt("genreSeq");
				
				GenreVo genreVo = new GenreVo(genreId, genreName, genreSeq);
				
				genreList.add(genreVo);

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

		return genreList;
	}

	public int deleteGenre(String genreId) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnection db = null;

		try {
			db = new DBConnection();
			conn = db.getConnection();

			String sql = "delete from genres where genreId = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, genreId);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			
		}			
		return result;
	}

	public GenreVo getGenre(String reqGenreId) {
		GenreVo genreVo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnection db = null;
		ResultSet rs = null;

		try {
			db = new DBConnection();
			conn = db.getConnection();

			String sql = "select genreId, genreName, genreSeq";
			sql += " From genres Where genreId = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reqGenreId);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				String genreId = rs.getString("genreId");
				String genreName = rs.getString("genreName");
				int genreSeq = rs.getInt("genreSeq");
				
				genreVo = new GenreVo(genreId, genreName, genreSeq);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}			

		return genreVo;
	}

	public int updateGenre(String genreId, String genreName) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnection db = null;

		try {
			db = new DBConnection();
			conn = db.getConnection();

			String sql = "update genres set genreName = ? where genreId = ?";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, genreName);
			pstmt.setString(2, genreId);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}			

		return result;
	}

	public int insertGenre(String genreName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		DBConnection db = null;

		int InsertResult = 0;

		try {
			db = new DBConnection();
			conn = db.getConnection();

			String sql = "insert into genres (genreId, genreName, genreSeq) "; 
			sql += " VALUES ( "; 
			sql += " ( select 'genre' || TRIM( TO_CHAR( TO_NUMBER( SUBSTR( NVL( MAX(genreId), 'genre00'), 6, 2) ) + 1, '00' ) ) from genres ), "; 
			sql += " ?, (select nvl(max(genreSeq), 0) + 1 from genres) )";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1,genreName);
			
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

}
