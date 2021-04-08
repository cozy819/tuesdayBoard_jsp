package com.green.tuesday.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.tuesday.base.Action;
import com.green.tuesday.dao.MusicDao;
import com.green.tuesday.dao.ReplDao;
import com.green.tuesday.vo.MusicVo;
import com.green.tuesday.vo.ReplVo;

public class ContentView implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tag = request.getParameter("tag");
		
		int songNum = Integer.parseInt(request.getParameter("songNum"));
		
		// 음악 정보
		MusicDao musicDao = new MusicDao();
		
		MusicVo musicVo = musicDao.getMusic(songNum);
		
		request.setAttribute("musicVo", musicVo);
		
		// 댓글 리스트
		ReplDao replDao = new ReplDao();
		List<ReplVo> replList = new ArrayList<ReplVo>();
		replList = replDao.getReplList(songNum);
		
		request.setAttribute("replList", replList);
		
		
		// 페이지 이동
		String path = "";
		
		switch (tag) {
		case "admin":
			path = "/views/adminMusicView.jsp";
			break;
		case "client":
			path = "/views/clientMusicView.jsp";
			break;
		}
	
		request.getRequestDispatcher(path).forward(request, response);

	}

}
