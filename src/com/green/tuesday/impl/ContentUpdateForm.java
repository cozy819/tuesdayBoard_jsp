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

public class ContentUpdateForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GenreDao genreDao = new GenreDao();
		List<GenreVo> genreList = genreDao.getGenreList();
		request.setAttribute("genreList", genreList);
		
		int songNum = Integer.parseInt(request.getParameter("songNum"));
		
		MusicDao musicDao = new MusicDao();
		MusicVo  musicVo =  musicDao.getMusic(songNum);
						
		
		// 수정할 데이터 저장(attribute)
		request.setAttribute("musicVo", musicVo);
		
		// 수정할 데이터를 입력받는 화면으로 이동
		String  path  = "/views/contentUpdateForm.jsp";		
		request.getRequestDispatcher(path).forward(request,  response);

	}

}
