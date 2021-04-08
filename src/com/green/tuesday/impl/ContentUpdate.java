package com.green.tuesday.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.tuesday.base.Action;
import com.green.tuesday.dao.MusicDao;

public class ContentUpdate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		MusicDao musicDao = new MusicDao();
		
		String genreId = request.getParameter("genreId");
				
		String strSongNum = request.getParameter("songNum");
		
		int songNum = Integer.parseInt(strSongNum);	
		String title = request.getParameter("title");
		String linkAddress = request.getParameter("linkAddress");
		String albumName = request.getParameter("albumName");
		String songName = request.getParameter("songName");
		String singer = request.getParameter("singer");
		String lyrics = request.getParameter("lyrics");
		
		int InsertResult = musicDao.updateContent(songNum, genreId, title, linkAddress, albumName, songName, singer, lyrics);

		System.out.println("게시물 수정 결과: " + InsertResult);		

		String path = "/board?cmd=ContentView&tag=admin&songNum=" + strSongNum;
					
		request.getRequestDispatcher(path).forward(request, response);

	}

}
