package com.githrd.practice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.whistle.controller.BlpInter;

public class LoginForm implements BlpInter {
	
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 폼 페이지 보여주기
		String view = "/practice/login";
		
		if(req.getSession().getAttribute("SID") != null) {
			// 이미 로그인 한 경우이므로
			req.setAttribute("isRedirect", true);
			// 리다이렉트 세팅하고 (true)
			view = "/whistle/main.blp";
			// 메인 페이지로 리다이렉트 시키기
		}
		
		return view;
	}

}
