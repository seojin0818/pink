package com.githrd.whistle.controller.member;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.whistle.controller.BlpInter;
import com.githrd.whistle.dao.*;
import com.githrd.whistle.vo.*;

public class MemberList implements BlpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/member/memberList";
		// 데이터베이스에 리스트 가져오고
		MemberDao mDao = new MemberDao();
		ArrayList<MemberVO> list = mDao.getMemberList();
		
		// 데이터 심고
		req.setAttribute("LIST", list);
		return view;
	}

}
