package com.green.tuesday.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.tuesday.base.Action;
import com.green.tuesday.dao.ReplDao;

public class ReplAdd implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		String tag = request.getParameter("tag");
		
		ReplDao replDao = new ReplDao();

		int songNum = Integer.parseInt(request.getParameter("songNum"));
		String strSongNum = String.valueOf(songNum);
		String replWriter = request.getParameter("replWriter");
		String replContent = request.getParameter("replContent");
				
		int InsertResult = replDao.addRepl(songNum, replWriter, replContent);

		System.out.println("댓글달기: " + InsertResult);		

		// 페이지 이동
		String path = "";
			
		switch (tag) {
			case "admin":
				path = "/board?cmd=ContentView&tag=admin&songNum=" + strSongNum;
				break;
			case "client":
				path = "/board?cmd=ContentView&tag=client&songNum=" + strSongNum;
				break;
		}
			
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
