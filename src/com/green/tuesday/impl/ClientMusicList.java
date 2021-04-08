package com.green.tuesday.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.tuesday.base.Action;
import com.green.tuesday.dao.GenreDao;
import com.green.tuesday.dao.MusicDao;
import com.green.tuesday.vo.GenreVo;
import com.green.tuesday.vo.MusicVo;

public class ClientMusicList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GenreDao genreDao = new GenreDao();
		List<GenreVo> genreList = genreDao.getGenreList(); 
		request.setAttribute("genreList", genreList);
		
		// 해당 장르의 음악 목록
		MusicDao musicDao = new MusicDao();
		String genreId = request.getParameter("genreId");
		List<MusicVo> musicList = musicDao.getMusicList(genreId);
		request.setAttribute("musicList", musicList);
		
		// 페이지 이동
		String path = "/views/clientMusicList.jsp";
		request.getRequestDispatcher(path).forward(request, response);

	}

}
