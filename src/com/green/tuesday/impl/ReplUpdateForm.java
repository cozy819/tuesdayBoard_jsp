package com.green.tuesday.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.tuesday.base.Action;
import com.green.tuesday.dao.ReplDao;
import com.green.tuesday.vo.ReplVo;

public class ReplUpdateForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String songNum = request.getParameter("songNum");
		int replNum = Integer.parseInt(request.getParameter("replNum"));
		
		ReplDao replDao = new ReplDao();
		ReplVo  replVo  =  replDao.getRepl(replNum);
						
		
		// 수정할 데이터 저장(attribute)
		request.setAttribute("replVo", replVo);
				
		// 수정할 데이터를 입력받는 화면으로 이동
		String  path  = "/views/replUpdateForm.jsp";		
		request.getRequestDispatcher(path).forward(request,  response);

	}

}
