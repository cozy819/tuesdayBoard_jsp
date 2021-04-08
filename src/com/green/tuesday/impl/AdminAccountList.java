package com.green.tuesday.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.tuesday.base.Action;
import com.green.tuesday.dao.AccountDao;
import com.green.tuesday.vo.ClientVo;

public class AdminAccountList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDao accountDao = new AccountDao();
		
		List<ClientVo> clientList = accountDao.getClientList();
		
		request.setAttribute("clientList", clientList);
		
		String path = "/views/adminAccountList.jsp";
		request.getRequestDispatcher(path).forward(request, response);

	}

}
