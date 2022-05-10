package com.githrd.test.dao;

import java.sql.*;

import com.githrd.test.db.*;
import com.githrd.test.sql.*;

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
	
	public int getInfoCnt(String mno, String avt, String name, String id, String mail, String tel, String joindate, String gen) {
		int cnt = 0;
		
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_INFO);
		pstmt = db.getPstmt(con, sql);
		try {
			
			pstmt.setString(1, mno);
			pstmt.setString(2, avt);
			pstmt.setString(3, name);
			pstmt.setString(4, id);
			pstmt.setString(5, mail);
			pstmt.setString(7, tel);
			pstmt.setString(8, joindate);
			pstmt.setString(9, gen);
			
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}

}
