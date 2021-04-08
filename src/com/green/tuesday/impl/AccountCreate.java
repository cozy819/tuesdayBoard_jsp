package com.green.tuesday.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.tuesday.base.Action;
import com.green.tuesday.dao.AccountDao;

public class AccountCreate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		AccountDao accountDao = new AccountDao();

		String clientId = request.getParameter("clientId");
		String clientPassword = request.getParameter("clientPassword");
		String clientEmail = request.getParameter("clientEmail");
		
		int insertResult = accountDao.insertAccount(clientId, clientPassword, clientEmail);

		System.out.println("회원가입 결과: " + insertResult);		

		String path = "/board?cmd=Home";
			
		request.getRequestDispatcher(path).forward(request, response);
		
	}
}
