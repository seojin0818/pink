package com.githrd.jennie.sql;

public class GBoardSQL {
	public final int SEL_GBRD_LIST		= 		1001;
	public final int SEL_WRITE_COUNT 	=		1002;
	public final int SEL_TOTAL_CNT		=	 	1003;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case SEL_GBRD_LIST:
			buff.append("SELECT ");
			buff.append("    rno, gno, id, body, wdate, savename ");
			buff.append("FROM ");
			buff.append("    ( ");
			buff.append("        SELECT ");
			buff.append("            ROWNUM rno, gno, id, body, wdate, savename ");
			buff.append("        FROM ");
			buff.append("            ( ");
			buff.append("                SELECT ");
			buff.append("                    gno, id, body, wdate, savename ");
			buff.append("                FROM ");
			buff.append("                    member m, guestboard g, avatar a ");
			buff.append("                WHERE ");
			buff.append("                    g.isshow = 'Y' ");
			buff.append("                    AND mno = writer ");
			buff.append("                    AND avt = ano ");
			buff.append("                ORDER BY ");
			buff.append("                    wdate DESC ");
			buff.append("            ) ");
			buff.append("    ) ");
			buff.append("WHERE ");
			buff.append("    rno BETWEEN ? AND ? ");
			break;
		case SEL_WRITE_COUNT:
			buff.append("SELECT ");
			buff.append("    COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	guestboard ");
			buff.append("WHERE ");
			buff.append("	writer = ( ");
			buff.append("				SELECT ");
			buff.append("					mno ");
			buff.append("				FROM	 ");
			buff.append("					member ");
			buff.append("				WHERE ");
			buff.append("					id = ? ");
			buff.append("					) ");
			break;
		case SEL_TOTAL_CNT:
			buff.append("SELECT ");
			buff.append("    COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	guestboard ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			break;
		}
		return buff.toString();
	}
}