package com.githrd.jennie.dao;

import java.sql.*;
import java.util.*;

import com.githrd.jennie.db.*;
import com.githrd.jennie.sql.*;
import com.githrd.jennie.vo.*;
import com.githrd.jennie.util.*;

public class ReboardDao {
	private BlpDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ReboardSQL rSQL;
	
	public ReboardDao() {
		db = new BlpDBCP();
		rSQL = new ReboardSQL();
	}

	// 게시글 리스트 조회 전담 처리함수
	public ArrayList<BoardVO> getList(PageUtil page){
		// 반환값 변수
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		// 할 일
		// 커넥션
		con = db.getCon();
		
		// 질의명령
		String sql = rSQL.getSQL(rSQL.SEL_ALL_LIST);
		
		// 명령전달도구
		pstmt = db.getPSTMT(con, sql);
		
		try {
			// 질의명령 완성하고
			pstmt.setInt(1, page.getStartCont());
			pstmt.setInt(2, page.getEndCont());
			
			// 질의명령 보내고 결과 받고
			rs = pstmt.executeQuery();
			
			// 결과에서 꺼내서 VO에 담고
			while(rs.next()) {
				BoardVO bVO = new BoardVO();
				
				bVO.setRno(rs.getInt("rno"));
				bVO.setBno(rs.getInt("rbno"));
				bVO.setUpno(rs.getInt("upno"));
				bVO.setMno(rs.getInt("mno"));
				bVO.setId(rs.getString("id"));
				bVO.setBody(rs.getString("body"));
				bVO.setAvatar(rs.getString("savename"));
				bVO.setStep(rs.getInt("step"));
				bVO.setWdate(rs.getDate("wdate"));
				bVO.setWtime(rs.getTime("wdate"));
				bVO.setSdate();
				
				// VO list에 담고
				list.add(bVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		// list 반환하고
		return list;
	}
	
	// 총 게시글 수 조회 전담 처리함수
	public int getTotalCount() {
		int cnt = 0;
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.SEL_TOTAL_CNT);
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			rs.next();
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return cnt;
	}
}
