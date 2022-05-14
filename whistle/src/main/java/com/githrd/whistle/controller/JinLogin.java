package com.githrd.whistle.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/whistle/jin/login")
public class JinLogin extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 세션객체 꺼내오기
		HttpSession session = req.getSession();
		
		// 2. 세션에서 저장된 데이터가 있는지 꺼내보기
		String sid = (String) session.getAttribute("SID");
		
		// 3. 검사하기
		if(sid != null) {
			resp.sendRedirect("/whistle/");
		} else {
		String view = "/WEB-INF/views/jin/login.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
		}
	}
}
