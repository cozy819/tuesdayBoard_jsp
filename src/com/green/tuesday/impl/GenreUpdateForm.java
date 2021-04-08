package com.green.tuesday.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.tuesday.base.Action;
import com.green.tuesday.dao.GenreDao;
import com.green.tuesday.vo.GenreVo;

public class GenreUpdateForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String genreId = request.getParameter("genreId");
		
		GenreDao genreDao = new GenreDao();
		GenreVo  genreVo  =  genreDao.getGenre(genreId);
						
		
		// 수정할 데이터 저장(attribute)
		request.setAttribute("genreVo", genreVo);
		
		// 수정할 데이터를 입력받는 화면으로 이동
		String  path  = "/views/genreUpdateForm.jsp";		
		request.getRequestDispatcher(path).forward(request,  response);

	}

}
