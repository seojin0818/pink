package com.githrd.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/test/avtList.pink")
public class AvtList extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 이 서블릿의 할 일은 아바타 리스트 페이지를 보여주기만 하면 됨
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/test/avtList.jsp");
		rd.forward(req, resp);
	}

}
