package com.githrd.jennie.controller.reboard;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.jennie.controller.*;
import com.githrd.jennie.dao.*;
import com.githrd.jennie.vo.*;

public class ReboardEdit implements BlpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/reboard/reboardEdit";
		
		// 할 일
		// 로그인 검사
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			req.setAttribute("isRedirect", true);
			return "/whistle/member/login.blp";
		}
		
		// 파라미터 꺼내고
		String sno = req.getParameter("bno");
		int bno = Integer.parseInt(sno);
		
		ReboardDao rDao = new ReboardDao();
		BoardVO bVO = rDao.getEditData(bno, sid);
		
		// 데이터 심고
		req.setAttribute("DATA", bVO);
		
		return view;
		
	}

}
