package com.green.tuesday.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.tuesday.base.Action;
import com.green.tuesday.dao.AccountDao;

public class AccountUpdate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDao accountDao = new AccountDao();
		
		int indexNum = Integer.parseInt(request.getParameter("indexNum"));
		String clientPassword = request.getParameter("clientPassword");
		String clientEmail = request.getParameter("clientEmail");
		
		int updateResult = accountDao.updateAccount(indexNum, clientPassword, clientEmail);

		System.out.println("회원정보수정: " + updateResult);		
		
		String path = "/board?cmd=AdminAccountList";
		request.getRequestDispatcher(path).forward(request, response);
	}

}
