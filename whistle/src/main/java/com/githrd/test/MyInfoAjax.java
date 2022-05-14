package com.githrd.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.test.dao.MemberDao;
import com.githrd.test.vo.MemberVO;

@WebServlet("/test/myInfoAjax.pink")
public class MyInfoAjax extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = (String) req.getSession().getAttribute("SID");
		if(id == null) {
			// 로그인 안한상태에서 요청한 경우...
			resp.sendRedirect("/whistle/test/login.pink");
		}
		
		// 데이터베이스 작업해서 결과 받고
		MemberDao mDao = new MemberDao();
//		MemberVO mVO = new MemberVO();
		MemberVO mVO = mDao.getMembInfo(id);
		// 응답문서 인코딩
		resp.setCharacterEncoding("UTF-8");
		// 응답 문서 만들고 (mno, name, id, mail, tel, m.gen, joindate, ano, savename)
		PrintWriter pw = resp.getWriter();
		pw.println("{");
		pw.println("\"mno\": \"" + mVO.getMno() + "\",");
		pw.println("\"name\": \"" + mVO.getName() + "\",");
		pw.println("\"id\": \"" + mVO.getId() + "\",");
		pw.println("\"mail\": \"" + mVO.getMail() + "\",");
		pw.println("\"tel\": \"" + mVO.getTel() + "\",");
		pw.println("\"gen\": \"" + mVO.getGen() + "\",");
		pw.println("\"joindate\": \"" + mVO.getJoindate() + "\",");
		pw.println("\"ano\": \"" + mVO.getAno() + "\",");
		pw.println("\"savename\": \"" + mVO.getSavename() + "\"");	
		pw.println("}");
		
	}
	

}
