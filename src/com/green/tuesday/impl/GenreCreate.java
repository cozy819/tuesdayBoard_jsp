package com.green.tuesday.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.tuesday.base.Action;
import com.green.tuesday.dao.GenreDao;

public class GenreCreate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		GenreDao genreDao = new GenreDao();

		String genreName = request.getParameter("genreName");
				
		int InsertResult = genreDao.insertGenre(genreName);

		System.out.println("장르추가 결과: " + InsertResult);		

		if(InsertResult==1) {
			String path = "/board?cmd=AdminGenreList";
			
			request.getRequestDispatcher(path).forward(request, response);
		}
	}
}
