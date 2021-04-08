package com.green.tuesday.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.tuesday.base.Action;
import com.green.tuesday.dao.AccountDao;
import com.green.tuesday.vo.ClientVo;

public class AccountUpdateForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int indexNum = Integer.parseInt(request.getParameter("indexNum"));
		
		AccountDao accountDao =  new AccountDao();
		ClientVo  clientVo  =  accountDao.getAccount(indexNum);
						
		
		// 수정할 데이터 저장(attribute)
		request.setAttribute("clientVo", clientVo);
		
		// 수정할 데이터를 입력받는 화면으로 이동
		String  path  = "/views/accountUpdateForm.jsp";		
		request.getRequestDispatcher(path).forward(request,  response);

	}

}
