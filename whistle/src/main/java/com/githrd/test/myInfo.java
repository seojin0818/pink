package com.githrd.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.githrd.test.dao.MemberDao;

@WebServlet("/test/myInfo.pink")
public class myInfo extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String pmno = req.getParameter("mno");
		String pavt = req.getParameter("avt");
		String pname = req.getParameter("name");
		String pid = req.getParameter("id");
		String pmail = req.getParameter("mail");
		String ptel = req.getParameter("tel");
		String pjoindate = req.getParameter("joindate");
		String pgen = req.getParameter("gen");
		
		MemberDao mDao = new MemberDao();
		int cnt = mDao.getInfoCnt(pmno, pavt, pname, pid, pmail, ptel, pjoindate, pgen);
		
		if(cnt == 1) {
			req.getSession().setAttribute("SMNO", pmno);
			req.getSession().setAttribute("SAVT", pavt);
			req.getSession().setAttribute("SNAME", pname);
			req.getSession().setAttribute("SID", pid);
			req.getSession().setAttribute("SMAIL", pmail);
			req.getSession().setAttribute("STEL", ptel);
			req.getSession().setAttribute("SJOINDATE", pjoindate);
			req.getSession().setAttribute("SGEN", pgen);
			
			resp.sendRedirect("/whistle/test/myInfo.pink");
		}
		}

}
