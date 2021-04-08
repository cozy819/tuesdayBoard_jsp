package com.green.tuesday.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.tuesday.base.Action;
import com.green.tuesday.dao.ReplDao;

public class ReplDelete implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReplDao replDao = new ReplDao();

		int replNum = Integer.parseInt(request.getParameter("replNum"));
		System.out.println(replNum);		
		int deleteResult = replDao.deleteRepl(replNum);

		System.out.println("댓글삭제: " + deleteResult);		

		int songNum = Integer.parseInt(request.getParameter("songNum"));
		String strSongNum = String.valueOf(songNum);
		
		String path = "/board?cmd=ContentView&tag=admin&songNum=" + strSongNum;
			
		request.getRequestDispatcher(path).forward(request, response);

	}

}
