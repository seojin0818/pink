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

/*

UPDATE
    reboard
SET
    isshow = 'N'
WHERE
    rbno = 100005
;

CREATE TABLE board(
    bno NUMBER(6)
        CONSTRAINT BRD_NO_PK PRIMARY KEY,
    bmno NUMBER(4)
        CONSTRAINT BRD_MNO_FK REFERENCES member(mno)
        CONSTRAINT BRD_MNO_NN NOT NULL,
    title VARCHAR2(30 CHAR)
        CONSTRAINT BRD_TTL_NN NOT NULL,
    body VARCHAR2(4000)
        CONSTRAINT BRD_BODY_NN NOT NULL,
    wdate DATE DEFAULT sysdate
        CONSTRAINT BRD_DATE_NN NOT NULL,
    click NUMBER(4) DEFAULT 0
        CONSTRAINT BRD_CLICK_NN NOT NULL,
    isshow CHAR(1) DEFAULT 'Y'
        CONSTRAINT BRD_SHOW_CK CHECK (isshow IN('Y', 'N'))
        CONSTRAINT BRD_SHOW_NN NOT NULL
);

CREATE TABLE fileinfo(
    fno NUMBER(8)
        CONSTRAINT FI_NO_PK PRIMARY KEY,
    fbno NUMBER(6)
        CONSTRAINT FI_BNO_FK REFERENCES board(bno)
        CONSTRAINT FI_BNO_NN NOT NULL,
    oriname VARCHAR2(50 CHAR)
        CONSTRAINT FI_ONAME_NN NOT NULL,
    savename VARCHAR2(50 CHAR)
        CONSTRAINT FI_SNAME_UK UNIQUE
        CONSTRAINT FI_SNAME_NN NOT NULL,
    dir VARCHAR2(200 CHAR)
        CONSTRAINT FI_DIR_NN NOT NULL,
    len NUMBER
        CONSTRAINT FI_LEN_NN NOT NULL,
    savedate DATE DEFAULT sysdate
        CONSTRAINT FI_SDATE_NN NOT NULL,
    isshow CHAR(1) DEFAULT 'Y'
        CONSTRAINT FI_SHOW_CK CHECK(isshow IN('Y', 'N'))
        CONSTRAINT FI_SHOW_NN NOT NULL
);

 */

public class ReboardSQL {
	public final int SEL_ALL_LIST		=	1001;
	public final int SEL_TOTAL_CNT		=	1002;
	public final int SEL_WRITER_INFO	=	1003;
	public final int SEL_REBOARD_INFO	=	1004;
	
	public final int DEL_REBOARD		=	2001;
	public final int UPDATE_REBOARD		=	2002;
	
	public final int INSERT_REBOARD		=	3001;
	
	
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
		case SEL_REBOARD_INFO:
			buff.append("SELECT ");
			buff.append("    rbno, body, wdate, mno, id, savename ");
			buff.append("FROM ");
			buff.append("	reboard r, member m, avatar a ");
			buff.append("WHERE ");
			buff.append("	r.isshow = 'Y' ");
			buff.append("	AND rbno = ? ");
			buff.append("	AND avt = ano ");
			buff.append("	AND id = ? ");
			break;
		case SEL_WRITER_INFO:
			buff.append("SELECT ");
			buff.append("    mno, savename ");
			buff.append("FROM ");
			buff.append("	member m, avatar a ");
			buff.append("WHERE ");
			buff.append("	m.isshow = 'Y' ");
			buff.append("	AND avt = ano ");
			buff.append("	AND id = ? ");
			break;
		case INSERT_REBOARD:
			buff.append("INSERT INTO ");
			buff.append("   reboard(rbno, upno, rbmno, body) ");
			buff.append("VALUES( ");
			buff.append("   (SELECT NVL(MAX(rbno) + 1, 100001) FROM reboard), ");
			buff.append("   ?, ?, ? ");
			buff.append(") ");
			break;
		case DEL_REBOARD:
			buff.append("UPDATE ");
			buff.append("   reboard ");
			buff.append("SET ");
			buff.append("   isshow = 'N' ");
			buff.append("WHERE ");
			buff.append("   rbno = ? ");
			break;
		case UPDATE_REBOARD:
			buff.append("UPDATE ");
			buff.append("   reboard ");
			buff.append("SET ");
			buff.append("   body = ? ");
			buff.append("WHERE ");
			buff.append("   rbno = ? ");
			break;
	}
		return buff.toString();
	}
}
