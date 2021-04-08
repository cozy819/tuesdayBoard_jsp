package com.green.tuesday.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.tuesday.base.Action;

public class GenreCreateForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/views/genreCreateForm.html";
		
		request.getRequestDispatcher(path).forward(request, response);

	}

}
