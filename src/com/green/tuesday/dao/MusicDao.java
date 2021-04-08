package com.green.tuesday.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.green.tuesday.db.DBConnection;
import com.green.tuesday.vo.MusicVo;

public class MusicDao {

	public List<MusicVo> getMusicList(String genreId) {
		List<MusicVo> musicList = new ArrayList<MusicVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBConnection db = null;

		try {
			db = new DBConnection();
			conn = db.getConnection();

			String sql = "SELECT songNum, title, albumName, singer, registerDate";
			sql += " FROM boardContent WHERE genreId = ? ORDER BY songNum";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, genreId);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int songNum = rs.getInt("songNum");
				String title = rs.getString("title");
				String albumName = rs.getString("albumName");
				String singer = rs.getString("singer");
				String registerDate = rs.getString("registerDate");

				MusicVo musicVo = new MusicVo();
				
				musicVo.setSongNum(songNum);
				musicVo.setTitle(title);
				musicVo.setAlbumName(albumName);
				musicVo.setSinger(singer);
				musicVo.setRegisterDate(registerDate);
				
				musicList.add(musicVo);

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

		return musicList;
	}

	public MusicVo getMusic(int reqSongNum) {
		MusicVo musicVo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBConnection db = null;

		try {
			db = new DBConnection();
			conn = db.getConnection();

			String sql = "SELECT songNum, genreId, title, linkAddress, albumName, songName, singer, lyrics, registerDate";
			sql += " FROM boardContent WHERE songNum = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, reqSongNum);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int songNum = rs.getInt("songNum");
				String genreId = rs.getString("genreId");
				String title = rs.getString("title");
				String linkAddress = rs.getString("linkAddress");
				String albumName = rs.getString("albumName");
				String songName = rs.getString("songName");
				String singer = rs.getString("singer");
				String lyrics = rs.getString("lyrics");
				String registerDate = rs.getString("registerDate");

				musicVo = new MusicVo(songNum, genreId, title, linkAddress, albumName, songName, singer, lyrics, registerDate);

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

		return musicVo;
	}

	public int addContent(String genreId, String title, String linkAddress, String albumName, String songName, String singer,
			String lyrics) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		DBConnection db = null;

		int InsertResult = 0;

		try {
			db = new DBConnection();
			conn = db.getConnection();

			String sql = "INSERT INTO boardContent (songNum, genreId, title, linkAddress, albumName, songName, singer, lyrics)"; 
			sql += " VALUES ( "; 
			sql += " (select nvl(max(songNum), 0) + 1 from boardContent), ";
			sql += " ?, ?, ?, ?, ?, ?, ?";
			sql += " )"; 

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, genreId);
			pstmt.setString(2, title);
			pstmt.setString(3, linkAddress);
			pstmt.setString(4, albumName);
			pstmt.setString(5, songName);
			pstmt.setString(6, singer);
			pstmt.setString(7, lyrics);

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

	public int deleteMusic(int songNum) {
		int result1 = 0;
		int result2 = 0;

		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		DBConnection db = null;

		try {
			db = new DBConnection();
			conn = db.getConnection();
			
			String sql = "delete from repls where songNum = ?";

			pstmt1 = conn.prepareStatement(sql);
			pstmt1.setInt(1, songNum);

			result1 = pstmt1.executeUpdate();
			System.out.println(result1);
			
			//--------------------------------------------------
			
			sql = "delete from boardContent where songNum = ?";

			pstmt2 = conn.prepareStatement(sql);
			pstmt2.setInt(1, songNum);

			result2 = pstmt2.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			
		}			
		return result2;
		
	}

}
