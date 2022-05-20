package com.githrd.jennie.controller.reboard;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.jennie.controller.*;
import com.githrd.jennie.dao.*;
import com.githrd.jennie.vo.*;

public class ReboardEditProc implements BlpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 체크
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			req.setAttribute("isRedirect", true);
			return "/whistle/member/login.blp";
		}
		
		String view = "/reboard/redirect";
		
		// 파라미터 받고
		String spage = req.getParameter("nowPage");
		String sno = req.getParameter("bno");
		String body = req.getParameter("body");
		int bno = Integer.parseInt(sno);
		
		// 데이터베이스 작업하고
		ReboardDao rDao = new ReboardDao();
		int cnt = rDao.editReboard(bno, body);
		
		// 데이터 심고
		req.setAttribute("NOWPAGE", spage);
		if(cnt == 0) {
			req.setAttribute("VIEW", "/whistle/reboard/reboardEdit.blp");
		} else {
			req.setAttribute("VIEW", "/whistle/reboard/reboardList.blp");
		}
		return view;
	
	}
}
