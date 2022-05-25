/*

select * from fileinfo;

desc fileinfo;

INSERT INTO
    board(bno, bmno, title, body)
VALUES(
    (SELECT NVL(MAX(bno) + 1, 100001 FROM board),
    (SELECT mno FROM member WHERE id = ?),
    ?, ?
)
;

INSERT INTO
    fileinfo(fno, fbno, oriname, savename, dir, len)
VALUES(
    (SELECT NVL(MAX(bno) + 1, 10000001 FROM fileinfo),
    (
        SELECT 
            MAX(bno) 
        FROM 
            board
        WHERE
            bmno = (
                        SELECT
                            mno
                        FROM
                            member
                        WHERE
                            id = ?
                    )
            ), ?, ?, ?, ?
)
;


SELECT
    bno, title, NVL(cnt, 0) cnt
FROM
    board b,
    (
        SELECT
            fbno, COUNT(*) cnt
        FROM
            fileinfo
        WHERE
            isshow = 'Y'
        group by
            fbno
    )
WHERE
    isshow = 'Y'
    AND bno = fbno(+)
    AND bno = 100004
;

SELECT
    bno, id, title, wdate, click, cnt
FROM
(
    SELECT
        ROWNUM rno, bno, id, title, wdate, click, cnt
    FROM
        (
        SELECT
            bno, id, title, wdate, click, NVL(cnt, 0) cnt
        FROM
            board b, member m,
            (
                SELECT
                    fbno, COUNT(*) cnt
                FROM
                    fileinfo
                WHERE
                    isshow = 'Y'
                group by
                    fbno
            )
        WHERE
            bmno = mno
            AND bno = fbno(+)
            AND b.isshow = 'Y'
            AND m.isshow = 'Y'
        
        ORDER BY
            wdate DESC
        )
    )
WHERE
    rno BETWEEN ? AND ?
;

*/

package com.githrd.jennie.sql;

public class BoardSQL {
	public final int SEL_BOARD_LIST			=	1001;
	public final int SEL_TOTAL_COUNT		=	1002;
	
	public final int INSERT_BOARD			= 	3001;
	public final int INSERT_FILEINFO		= 	3002;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case INSERT_BOARD:
			buff.append("INSERT INTO ");
			buff.append("	board(bno, bmno, title, body) ");
			buff.append("VALUES( ");
			buff.append("	(SELECT NVL(MAX(bno) + 1, 100001) FROM board), ");
			buff.append("	(SELECT mno FROM member WHERE id = ? ), ");
			buff.append("	?, ? ");
			buff.append(") ");
			break;
		case INSERT_FILEINFO:
			buff.append("INSERT INTO ");
			buff.append("	fileinfo(fno, fbno, oriname, savename, dir, len) ");
			buff.append("VALUES( ");
			buff.append("	(SELECT NVL(MAX(fno) + 1, 10000001) FROM fileinfo), ");
			buff.append("	(SELECT MAX(bno) FROM board WHERE bmno = (SELECT mno FROM member WHERE id = ? )), ");
			buff.append("	?, ?, ?, ? ");
			buff.append(") ");
			break;
		case SEL_TOTAL_COUNT:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	board ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			break;
		case SEL_BOARD_LIST:
			buff.append("SELECT ");
			buff.append("    bno, id, title, wdate, click, cnt ");
			buff.append("FROM ");
			buff.append("    ( ");
			buff.append("        SELECT ");
			buff.append("            ROWNUM rno, bno, id, title, wdate, click, cnt ");
			buff.append("        FROM ");
			buff.append("            ( ");
			buff.append("                SELECT ");
			buff.append("                    bno, id, title, wdate, click, NVL(cnt, 0) cnt ");
			buff.append("                FROM ");
			buff.append("                    board b, member m, ");
			buff.append("                    ( ");
			buff.append("                        SELECT ");
			buff.append("                            fbno, COUNT(*) cnt ");
			buff.append("                        FROM ");
			buff.append("                            fileinfo ");
			buff.append("                        WHERE ");
			buff.append("                            isshow = 'Y' ");
			buff.append("                        GROUP BY ");
			buff.append("                            fbno ");
			buff.append("                    ) ");
			buff.append("                WHERE ");
			buff.append("                    bmno = mno ");
			buff.append("                    AND fbno(+) = bno ");
			buff.append("                    AND b.isshow = 'Y' ");
			buff.append("                    AND m.isshow = 'Y' ");
			buff.append("                ORDER BY ");
			buff.append("                    wdate DESC ");
			buff.append("            ) ");
			buff.append("    ) ");
			buff.append("WHERE ");
			buff.append("    rno BETWEEN ? AND ? ");
			break;
		}
		return buff.toString();
	}
}