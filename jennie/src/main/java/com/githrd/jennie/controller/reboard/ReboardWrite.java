package com.githrd.jennie.controller.reboard;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.jennie.controller.*;
import com.githrd.jennie.dao.*;
import com.githrd.jennie.vo.*;

public class ReboardWrite implements BlpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 체크
		String view = "/reboard/reboardWrite";
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			req.setAttribute("isRedirect", true);
			view = "/whistle/member/login.blp";
			return view;
		}
		
		// 로그인 한 경우이므로 데이터베이스에서 데이터 꺼내오기
		ReboardDao rDao = new ReboardDao();
		BoardVO bVO = rDao.getWriterInfo(sid);
		
		// 데이터 심고
		req.setAttribute("DATA", bVO);
		return view;
	}

}

