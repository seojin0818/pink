package com.githrd.whistle.controller.member;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.whistle.controller.BlpInter;
import com.githrd.whistle.dao.MemberDao;
import com.githrd.whistle.vo.MemberVO;

public class JoinProc implements BlpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/whistle/main.blp";
		if(req.getSession().getAttribute("SID") != null) {
			return view;
		}
		
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String mail = req.getParameter("mail");
		String tel = req.getParameter("tel");
		String gen = req.getParameter("gen");
		String sno = req.getParameter("ano");
		int ano = Integer.parseInt(sno);
		
		MemberVO mVO = new MemberVO();
		mVO.setName(name);
		mVO.setId(id);
		mVO.setPw(pw);
		mVO.setMail(mail);
		mVO.setTel(tel);
		mVO.setGen(gen);
		mVO.setAno(ano);
		
		// 데이터베이스 작업하고
		MemberDao mDao = new MemberDao();
		int cnt = mDao.addMember(mVO);
		
		if(cnt != 1) {
			view = "/whistle/member/join.blp";
		} else {
			req.getSession().setAttribute("SID", id);
		}
		return view;
	}

}
