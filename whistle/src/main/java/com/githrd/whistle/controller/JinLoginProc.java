package com.githrd.whistle.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.test.dao.MemberDao;

@WebServlet("/whistle/jin/loginProc")
public class JinLoginProc extends HttpServlet {
   
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 세션 검사
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid != null) {
			// 이미 로그인한 경우이므로 메인으로 리다이렉트 시키기
			resp.sendRedirect("/whistle/");
			return;
		}
		
		// 할 일
		// 1. 파라미터 받기
		String pid = req.getParameter("id");
		String ppw = req.getParameter("pw");
		
		// 2. 데이터베이스 작업하기
		MemberDao mDao = new MemberDao();
		int cnt = mDao.getLoginCnt(pid, ppw);
		
		// 3. 결과 받아서 처리하기
		if(cnt == 1) {
			// 로그인 처리
			req.getSession().setAttribute("SID", pid);
			// 메인 페이지로 리다이렉트
			resp.sendRedirect("/whistle/jin/main.jsp");
		} else {
			// 로그인 페이지로 돌려보내기
			resp.sendRedirect("/whistle/jin/login");
		} 
	}

}
