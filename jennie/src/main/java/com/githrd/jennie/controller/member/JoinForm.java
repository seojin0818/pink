package com.githrd.jennie.controller.member;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.jennie.controller.*;
import com.githrd.jennie.dao.*;
import com.githrd.jennie.vo.*;

public class JoinForm implements BlpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/member/join";
		// 세션 검사하고
		if(req.getSession().getAttribute("SID") != null) {
			// 로그인 한 경우
			// 리다이렉트 세팅
			req.setAttribute("isRedirect", true);
			// 요청주소 반환하고
			return "/whistle/main.blp";
		}
		
		MemberDao mDao = new MemberDao();
		ArrayList<MemberVO> list = mDao.getAvtList();
		
		// 데이터 심고
		req.setAttribute("LIST", list);
		
		// 뷰 부르고
		return view;
	}

}
