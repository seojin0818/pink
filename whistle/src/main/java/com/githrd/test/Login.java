package com.githrd.test;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/test/login.pink")
public class Login extends HttpServlet {
	public void init() throws ServletException {
		System.out.println("##### 로그인 페이지 요청 #####");
	}
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*
		 	
		 	로그인 여부는 session 객체의 속성을 입력하는 것으로 처리하는 것이 일반적
		 	따라서 우리가 정한 속성이 session 객체에 기억되어 있다면
		 	그 사람은 로그인한 사람
		 	
		 	우리가 사용할 로그인 처리 규칙
		 	
		 		session.setAttribute("SID", id);
		 	
		 	이 때 session 객체가 필요한데 꺼내는 방법은
		 		
		 		HttpSession session = req.getSession();
		 		
		 */
		
		// 로그인 여부 검사
		// 1. 세션객체 꺼내오기
		HttpSession session = req.getSession();
		
		// 2. 세션에서 저장된 데이터가 있는지 꺼내보기
		String sid = (String)session.getAttribute("SID");
		
		// 3. 검사하기
		if(sid != null) {
			// 이 경우는 이미 세션에 데이터가 채워져 있는 경우이고
			// 그 말은 이미 로그인한 상태
			// 따라서 메인페이지(index)로 돌려보내기
			// 이 작업은 지금 요청에서 메인페이지로 보내는 요청을 다시 만드는 작업이 됨
			// 따라서 리다이렉트 하면 됨
			resp.sendRedirect("/whistle/");
		} else {
		String view = "/WEB-INF/views/test/member/login.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
		}
	}
}
