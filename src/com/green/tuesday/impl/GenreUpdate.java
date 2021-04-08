package com.green.tuesday.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.tuesday.base.Action;
import com.green.tuesday.dao.AccountDao;
import com.green.tuesday.dao.GenreDao;

public class GenreUpdate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GenreDao genreDao = new GenreDao();
				
		String genreId = request.getParameter("genreId");
		String genreName = request.getParameter("genreName");
		
		int updateResult = genreDao.updateGenre(genreId, genreName);

		System.out.println("장르 정보 수정: " + updateResult);		
		
		String path = "/board?cmd=AdminGenreList";
		request.getRequestDispatcher(path).forward(request, response);

	}

}
