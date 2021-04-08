package com.green.tuesday.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.tuesday.base.Action;
import com.green.tuesday.dao.MusicDao;

public class ContentDelete implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MusicDao musicDao = new MusicDao();
		
		int songNum = Integer.parseInt(request.getParameter("songNum"));
		String genreId = request.getParameter("genreId");
		
		int deleteResult = musicDao.deleteMusic(songNum);

		System.out.println("게시물삭제: " + deleteResult);		
		
		String path = "/board?cmd=AdminMusicList&genreId=" + genreId;
		request.getRequestDispatcher(path).forward(request, response);

	}

}
