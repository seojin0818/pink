package com.githrd.whistle.controller.member;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.whistle.controller.*;
import com.githrd.whistle.dao.*;

public class LoginProc implements BlpInter {

	@Override
	 public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*
		 
		 	여기에서 작업은
		 	로그인 처리 결과에 상관없이 요청이 새로 생겨야하는 작업
		 	로그인 처리에 성공한 경우에는 main.blp로 다시 요청해야 하고
		 	로그인 처리에 실패한 경우에는 /member/login.blp를 다시 요청해야 함
		 	
		 	그리고 만약 이미 로그인 한 경우는 /main.blp를 다시 요청해야 함
		 	
		 	위에서 살펴봤듯이 어떤 상황에서든 요청을 새롭게 만들어야 함
		 	따라서 리다이렉트가 되어야 함
		 	
		 */
		
		req.setAttribute("isRedirect", true);
		String view = "/whistle/main.blp";
		if(req.getSession().getAttribute("SID") != null) {
			// 이미 로그인 한 상태
			return view;
		}
		
		// 아직 로그인 되지 않은 상태
		// 할 일
		// 파라미터 받고
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		// 데이터베이스 작업을 하고 결과 받고
		MemberDao mDao = new MemberDao();
		int cnt = mDao.getLogin(id, pw);
		// 결과에 따라서 처리하고
		if(cnt == 1) {
			// 아이디와 비밀번호가 일치하는 회원이 1명 존재한다는 것이므로 로그인 처리해줌
			req.getSession().setAttribute("SID", id);
			// 세션에 데이터 기록했으면 메인 페이지로 돌려보내기
			// 메인페이지로 돌려보내는 뷰는 위에서 만들어 뒀으니 그냥 사용하면 됨
		} else {
			// 로그인 처리하지 않음
			// 정보가 정확하지 않거나 없는 회원인 경우
			view ="/whistle/member/login.blp";
		}
		return view;
	}

}
