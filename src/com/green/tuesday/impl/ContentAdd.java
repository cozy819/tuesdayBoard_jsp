package com.green.tuesday.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.tuesday.base.Action;
import com.green.tuesday.dao.MusicDao;

public class ContentAdd implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		String tag = request.getParameter("tag");
		
		MusicDao musicDao = new MusicDao();
		
		String genreId = request.getParameter("genreId");
		
		System.out.println(genreId);
		
		String title = request.getParameter("title");
		String linkAddress = request.getParameter("linkAddress");
		String albumName = request.getParameter("albumName");
		String songName = request.getParameter("songName");
		String singer = request.getParameter("singer");
		String lyrics = request.getParameter("lyrics");
		
		int InsertResult = musicDao.addContent(genreId, title, linkAddress, albumName, songName, singer, lyrics);

		System.out.println("게시물 등록 결과: " + InsertResult);		

		String path = "";
		
		switch (tag) {
		case "admin":
			path = "/board?cmd=AdminMusicList&genreId=" + genreId;
			break;
		case "client":
			path = "/board?cmd=ClientMusicList&genreId=" + genreId;
			break;
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
