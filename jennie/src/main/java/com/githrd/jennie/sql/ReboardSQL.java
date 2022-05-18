package com.githrd.jennie.sql;

/*

INSERT INTO
    guestboard(gno, writer, body)
VALUES(
    (SELECT NVL(MAX(gno) + 1, 1001) from guestboard),
    (SELECT mno FROM member WHERE id = ?),
    ?
)
;

-- 댓글게시판

CREATE TABLE reboard(
    rbno NUMBER(6)
        CONSTRAINT RBRD_NO_PK PRIMARY KEY,
    upno NUMBER(6),
    rbmno NUMBER(4)
        CONSTRAINT RBRD_MNO_FK REFERENCES member(mno)
        CONSTRAINT RBRD_MNO_NN NOT NULL,
    body VARCHAR2(200 CHAR)
        CONSTRAINT RBRD_BODY_NN NOT NULL,
    wdate DATE DEFAULT sysdate
        CONSTRAINT RBRD_DATE_NN NOT NULL,
    isshow CHAR(1) DEFAULT 'Y'
        CONSTRAINT RBRD_SHOW_CK CHECK(isshow IN('Y', 'N'))
        CONSTRAINT RBRD_SHOW_NN NOT NULL
)
;

INSERT INTO
    reboard(rbno, upno, rbmno, body)
VALUES(
    (SELECT NVL(MAX(rbno) + 1, 100001) FROM reboard),
    NULL, 10000, '댓글게시판 오픈합니다.'
);

INSERT INTO
    reboard(rbno, upno, rbmno, body)
VALUES(
    (SELECT NVL(MAX(rbno) + 1, 100001) FROM reboard),
    100001, 1001, '게시판 오픈 축하합니다.'
);

INSERT INTO
    reboard(rbno, upno, rbmno, body)
VALUES(
    (SELECT NVL(MAX(rbno) + 1, 100001) FROM reboard),
    100002, 1004, '저도 오픈 축하합니다.'
);

INSERT INTO
    reboard(rbno, upno, rbmno, body)
VALUES(
    (SELECT NVL(MAX(rbno) + 1, 100001) FROM reboard),
    100002, 1002, '저두요'
);

INSERT INTO
    reboard(rbno, upno, rbmno, body)
VALUES(
    (SELECT NVL(MAX(rbno) + 1, 100001) FROM reboard),
    100001, 1005, '오픈 감축드립니다.'
);

COMMIT;

SELECT
    rno, rbno, upno, mno, id, body, savename, wdate, step 
FROM
    (
    SELECT
        ROWNUM rno, rbno, upno, mno, id, body, savename, wdate, step 
    FROM
        (
            SELECT
                rbno, NVL(upno, 0) upno, mno, id, body, savename, wdate, (level - 1) step 
            FROM
                reboard r, member m, avatar a
            WHERE
                r.isshow = 'Y'
                AND rbmno = mno
                AND avt = ano
            START WITH
                upno IS NULL
            CONNECT BY
                PRIOR rbno = upno
            ORDER SIBLINGS BY
                wdate DESC
             )
     )
WHERE
    rno BETWEEN ? AND ?
;

 */
public class ReboardSQL {
	public final int SEL_ALL_LIST		=	1001;
	public final int SEL_TOTAL_CNT		=	1002;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case SEL_ALL_LIST:
			buff.append("SELECT ");
			buff.append("   rno, rbno, upno, mno, id, body, savename, wdate, step ");
			buff.append("FROM ");
			buff.append("   ( ");
			buff.append("   SELECT ");
			buff.append("       ROWNUM rno, rbno, upno, mno, id, body, savename, wdate, step ");
			buff.append("   FROM ");
			buff.append("       ( ");
			buff.append("           SELECT ");
			buff.append("               rbno, NVL(upno, 0) upno, mno, id, body, savename, wdate, (level - 1) step ");
			buff.append("           FROM ");
			buff.append("               reboard r, member m, avatar a ");
			buff.append("           WHERE ");
			buff.append("               r.isshow = 'Y' ");
			buff.append("               AND rbmno = mno ");
			buff.append("               AND avt = ano ");
			buff.append("           START WITH ");
			buff.append("               upno IS NULL ");
			buff.append("           CONNECT BY ");
			buff.append("               PRIOR rbno = upno ");
			buff.append("           ORDER SIBLINGS BY ");
			buff.append("               wdate DESC ");
			buff.append("            ) ");
			buff.append("    ) ");
			buff.append("WHERE ");
			buff.append("   rno BETWEEN ? AND ? ");
			break;
		case SEL_TOTAL_CNT:
			buff.append("SELECT ");
			buff.append("    COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	reboard ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			break;
		}
		return buff.toString();
	}
}
