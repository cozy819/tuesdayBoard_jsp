package com.green.tuesday.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.tuesday.base.Action;
import com.green.tuesday.dao.ReplDao;

public class ReplUpdate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
				
		ReplDao replDao = new ReplDao();

		String songNum = request.getParameter("songNum");
				
		int replNum = Integer.parseInt(request.getParameter("replNum"));
		String replWriter = request.getParameter("replWriter");
		String replContent = request.getParameter("replContent");
				
		int updateResult = replDao.updateRepl(replNum, replWriter, replContent);

		System.out.println("댓글수정: " + updateResult);		

		// 페이지 이동
		String path = "/board?cmd=ContentView&tag=admin&songNum=" + songNum;
			
		
			
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
