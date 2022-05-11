package com.githrd.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.githrd.test.dao.*;
import com.githrd.whistle.vo.*;

@WebServlet("/test/myInfo.pink")
public class MyInfo extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 할 일
		// 1. 파라미터 꺼내고
		String sid = req.getParameter("id");
		// 2. 데이터베이스 작업해서 결과 받고
		MemberDao mDao = new MemberDao();
		
	}

}
