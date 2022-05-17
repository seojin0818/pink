package com.githrd.blpink.dao;

import java.sql.*;
import java.util.*;
import java.util.Date;

import com.githrd.blpink.db.*;
import com.githrd.blpink.sql.*;
import com.githrd.blpink.util.PageUtil;
import com.githrd.blpink.vo.*;

public class GBoardDao {
	private BlpDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private GBoardSQL gSQL;
	
	public GBoardDao() {
		// 커넥션 풀 찾고
		db = new BlpDBCP();
		gSQL = new GBoardSQL();
	}
	
	// 게시글 리스트 가져오기 전담 처리함수
	public ArrayList<BoardVO> getBoardList(){
		// 반환값 변수
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		// 커넥션
		con = db.getCon();
		
		// 질의명령
		String sql = gSQL.getSQL(gSQL.SEL_GBRD_LIST);
		
		// 명령전달도구
		pstmt = db.getPSTMT(con, sql);
		
		try {
			// 질의명령 완성하고 (페이징 처리)
			
			// 질의명령 보내고 결과 받고
			rs = pstmt.executeQuery();
			while(rs.next()) {
				// 결과 꺼내서 VO에 담고
				BoardVO bVO = new BoardVO();
				int rno = rs.getInt("rno");
				int bno = rs.getInt("gno");
				String id = rs.getString("id");
				String body = rs.getString("body");
				String avatar = rs.getString("savename");
				Date wdate = rs.getDate("wdate");
				Time wtime = rs.getTime("wdate");
				// VO를 리스트에 채우고
				bVO.setRno(rno);
				bVO.setBno(bno);
				bVO.setId(id);
				bVO.setBody(body);
				bVO.setAvatar(avatar);
				bVO.setWdate(wdate);
				bVO.setWtime(wtime);
				bVO.setSdate();
				// VO를 리스트에 담고
				list.add(bVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		// 리스트 반환하고
		return list;
	}
	
	// 작성 게시글 수 조회 전담 처리함수
	public int getWriteCount(String id) {
		// 반환값 변수
		int cnt = 0;
		
		// 커넥션
		con = db.getCon();
		
		// 질의명령
		String sql = gSQL.getSQL(gSQL.SEL_WRITE_COUNT);
		
		// 명령전달도구
		pstmt = db.getPSTMT(con, sql);
		
		try {
			// 질의명령 완성하고
			pstmt.setString(1, id);
			
			// 질의명령 보내고 결과 받고
			rs = pstmt.executeQuery();
			
			// 결과 꺼내고
			rs.next();
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		// 데이터 반환하고
		return cnt;
	}
	
	// 총 게시글 수 조회 전담 처리함수
	public int getTotal() {
		// 반환값 변수
		int cnt = 0;
		
		// 커넥션
		con = db.getCon();
		
		// 질의명령
		String sql = gSQL.getSQL(gSQL.SEL_TOTAL_CNT);
		
		// 명령전달도구
		stmt = db.getSTMT(con);
		
		try {
			// 질의명령 보내고 결과 받고
			rs = stmt.executeQuery(sql);
			
			// 결과 꺼내서 변수에 기억시키고
			rs.next();
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(stmt);
			db.close(con);
		}
		// 결과 반환해주고
		return cnt;
	}
}
