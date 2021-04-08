package com.green.tuesday.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.tuesday.base.Action;
import com.green.tuesday.dao.GenreDao;
import com.green.tuesday.vo.GenreVo;

public class ContentAddForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tag = request.getParameter("tag");
		
		GenreDao genreDao = new GenreDao();
		
		List<GenreVo> genreList = genreDao.getGenreList();
		
		request.setAttribute("genreList", genreList);
		
		request.setAttribute("tag", tag);
		
		String path = "/views/contentAddForm.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
