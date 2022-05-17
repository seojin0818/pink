package com.githrd.blpink.sql;

/*

alter table guestboard
modify body varchar2(200 char);

/*
    방명록 페이지에서 필요한 데이터
        
        글번호, 작성자 아이디, 본문, 작성일, 아바타저장이름
        
        방명록 테이블 : 글번호, 본문, 작성일
        회원 테이블 : 작성자 아이디
        아바타 테이블 : 저장이름
        
    따라서 3개의 테이블을 조인해야 하고
    최종적으로 rownum을 기준으로 일부 데이터만 가져와야 하므로
    조건절에 rownum을 비교하는 구문이 포함되어야 함

-- 정렬방식은 작성일 기준 내림차순

SELECT
    gno, id, body, wdate, savename
FROM
    member m, guestboard g, avatar a
WHERE
    g.isshow = 'Y'
    AND mno = writer
    AND avt = ano
ORDER BY
    wdate DESC
;

-- ==> rownum을 붙여줌
SELECT
    ROWNUM rno, gno, id, body, wdate, savename
FROM
    (
        SELECT
            gno, id, body, wdate, savename
        FROM
            member m, guestboard g, avatar a
        WHERE
            g.isshow = 'Y'
            AND mno = writer
            AND avt = ano
        ORDER BY
            wdate DESC
    )
;

-- ==> ROWNUM을 스칼라 데이터로 만들고
SELECT
    rno, gno, id, body, wdate, savename
FROM
    (
        SELECT
            ROWNUM rno, gno, id, body, wdate, savename
        FROM
            (
                SELECT
                    gno, id, body, wdate, savename
                FROM
                    member m, guestboard g, avatar a
                WHERE
                    g.isshow = 'Y'
                    AND mno = writer
                    AND avt = ano
                ORDER BY
                    wdate DESC
             )
    )
WHERE
    rno BETWEEN 4 AND 6
;

-- 내가 작성한 방명록 글 카운트 조회

SELECT
    COUNT(*) cnt
FROM
    guestboard
WHERE
    writer = (
                SELECT
                    mno
                FROM
                    member
                WHERE
                    id = 'sjin'
            )
;

 */

public class GBoardSQL {
	public final int SEL_GBRD_LIST		=		1001;
	public final int SEL_WRITE_COUNT	=		1002;
	public final int SEL_TOTAL_CNT		=		1003;

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
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	writer = ( ");
			buff.append("				SELECT ");
			buff.append("					mno ");
			buff.append("				FROM ");
			buff.append("					member ");
			buff.append("				WHERE ");
			buff.append("					id = ? ");
			buff.append("				) ");
			break;
		case SEL_TOTAL_CNT:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	guestboard ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			break;
		}
		return buff.toString();
	}
}

