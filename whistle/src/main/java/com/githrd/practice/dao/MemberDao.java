package com.githrd.practice.dao;

import java.sql.*;
import java.util.*;

import com.githrd.whistle.db.*;
import com.githrd.whistle.sql.*;
import com.githrd.whistle.vo.*;

/**
 *
 * 이 클래스는 회원 관련 데이터베이스 작업을 전담해서 처리하는 클래스
 * 
 * @author	백서진
 * @since	2022.05.12
 * @version v.1.0
 * 
 * 			작업이력 ]
 * 				
 * 				2022.05.12	-	클래스 제작
 * 									담당자 ] 백서진
 * 
 */

public class MemberDao {
	
/*
	
	이 클래스는 이 클래스가 new 되는 순간 데이터베이스 작업을 할 준비가 되어있어야 함
	커넥션 풀을 찾아내서 커넥션을 꺼내올 준비가 되어있어야 함
	
 */
	
	private BlpDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private MemberSQL mSQL;
	
	public MemberDao() {
		db = new BlpDBCP();
		mSQL = new MemberSQL();
	}

	// 로그인 데이터베이스 작업 전담 처리함수
	public int getLogin(String id, String pw) {
		// 할 일
		// 반환값 변수
		int cnt = 0 ;
		
		// 커넥션
		con = db.getCon();
		
		// 질의명령
		String sql = mSQL.getSQL(mSQL.SEL_LOGIN_CNT);
		
		// 명령전달도구
		pstmt = db.getPSTMT(con, sql);
		
		try { 
			// 질의명령 완성하고
			pstmt.setString(1, id);
			pstmt.setString(1, pw);
			
			// 질의명령 보내고 결과 받고
			rs = pstmt.executeQuery();
			
			// 결과에서 데이터 꺼내고
			rs.next();
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		// 데이터 내보내고
		return cnt;
	}
	
	// 회원가입 데이터베이스 작업 전담 처리함수
	public int addMember(MemberVO mVO) {
		// 반환값 변수
		int cnt = 0;
		
		// 할 일
		// 커넥션
		con = db.getCon();
		// 질의명령
		String sql = mSQL.getSQL(mSQL.ADD_MEMBER);
		// 명령전달도구
		pstmt = db.getPSTMT(con, sql);
		// 질의명령 완성하고
		try {
			pstmt.setString(1, mVO.getName());
			pstmt.setString(2, mVO.getId());
			pstmt.setString(3, mVO.getPw());
			pstmt.setString(4, mVO.getMail());
			pstmt.setString(5, mVO.getTel());
			pstmt.setInt(6, mVO.getAno());
			pstmt.setString(7, mVO.getGen());
			// 질의명령 보내고 결과 받고
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		// 데이터 반환하고
		return cnt;
	}
	
}