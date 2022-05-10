package com.githrd.test.sql;

public class MemberSQL {
	public final int SEL_LOGIN_CNT = 1001;
	public final int SEL_INFO = 1002;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case SEL_LOGIN_CNT:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("	AND id = ? ");
			buff.append("	AND pw = ? ");
			break;
		
		case SEL_INFO:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	isshow ='Y' ");
			buff.append("	AND mno = ? ");
			buff.append("	AND name = ? ");
			buff.append("	AND id = ? ");
			buff.append("	AND mail = ? ");
			buff.append("	AND tel = ? ");
			buff.append("	AND joindate = ? ");
			buff.append("	AND gen = ? ");
			buff.append("	AND avt = ? ");
			break;
		}
		return buff.toString();
	}
}
