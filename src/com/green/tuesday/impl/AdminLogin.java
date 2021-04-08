package com.green.tuesday.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.tuesday.base.Action;
import com.green.tuesday.dao.AccountDao;

public class AdminLogin implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		
		AccountDao accountDao = new AccountDao();
		
		boolean valid = accountDao.adminLogin(userId, userPassword);
		
		String path;
		
		if (valid == true) {
			path = "/board?cmd=AdminAccountList";
		} else {
			path = "/views/logonDenied.html";
		}
		
		// 페이지 이동
		request.getRequestDispatcher(path).forward(request, response);
	}

}
