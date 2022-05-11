package com.githrd.test.dao;

import java.sql.*;

import com.githrd.test.db.*;
import com.githrd.test.sql.*;
import com.githrd.test.vo.*;

public class MemberDao {
	private JennieJDBC db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private MemberSQL mSQL;
	
	public MemberDao() {
		db = new JennieJDBC();
		mSQL = new MemberSQL();
	}
	
	// 로그인 데이터베이스 작업 전담 처리함수
	public int getLoginCnt(String id, String pw) {
		// 반환값 변수
		int cnt = 0;
		// 작업 순서
		// 1. 커넥션 가져오기
		con = db.getCon();
		// 2. 질의명령 가져오기
		String sql = mSQL.getSQL(mSQL.SEL_LOGIN_CNT);
		// 3. 명령전달도구 꺼내오기
		pstmt = db.getPstmt(con, sql);
		try {
			
			// 4. 질의명령 완성하기
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			// 5. 질의명령 보내고 결과 받기
			rs = pstmt.executeQuery();
			// 6. 결과에서 데이터 꺼내기
			rs.next();
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		// 7. 데이터 반환하기
		return cnt;
	}
	
	// 아이디로 정보 조회 전담 처리함수
	public MemberVO getMembInfo(String id) {
		// 반환값 변수
		MemberVO mVO = new MemberVO();
		
		// 커넥션 연결
		con = db.getCon();
		
		// 질의명령
		String sql = mSQL.getSQL(mSQL.SEL_MEMBER_INFO);
		
		// pstmt
		pstmt = db.getPstmt(con, sql);
		
		try {
			// 질의명령 완성하고
			pstmt.setString(1, id);
			// 질의명령 보내고 결과 받고
			rs = pstmt.executeQuery();
			// 데이터 꺼내고
			rs.next();
			int mno = rs.getInt("mno");
			String name = rs.getString("name");
			String sid = rs.getString("id");
			String mail = rs.getString("mail");
			String tel = rs.getString("tel");
			String gen = rs.getString("gen");
			String joindate = rs.getString("joindate");
			int ano = rs.getInt("ano");
			String savename = rs.getString("savename");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return mVO;
	}

}
