package com.green.tuesday.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.tuesday.base.Action;
import com.green.tuesday.dao.GenreDao;

public class GenreDelete implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GenreDao genreDao = new GenreDao();
		
		String genreId = request.getParameter("genreId");
		
		int deleteResult = genreDao.deleteGenre(genreId);

		System.out.println("장르삭제: " + deleteResult);		
		
		String path = "/board?cmd=AdminGenreList";
		request.getRequestDispatcher(path).forward(request, response);
	}

}
