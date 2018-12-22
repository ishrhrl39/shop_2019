CREATE TABLE USER(
 ID  VARCHAR(50) NOT NULL PRIMARY KEY COMMENT '아이디',
 PASS_WD VARCHAR(100) NOT NULL DEFAULT '' COMMENT '비밀번호',
 NAME VARCHAR(100)  NOT NULL DEFAULT '' COMMENT '이름',
 EMAIL VARCHAR(50) NOT NULL DEFAULT '' COMMENT '이메일',
 BIRTH VARCHAR(8)  NOT NULL DEFAULT '' COMMENT '생년월일',
 GENDER  VARCHAR(1)  NOT NULL DEFAULT 'f'  COMMENT '성별',
 TEL VARCHAR(30) NOT NULL DEFAULT '' COMMENT '연락처',
 ADULT_YN  VARCHAR(1)  NOT NULL DEFAULT '' COMMENT '19세 이상여부',
 REG_DTM VARCHAR(14) NOT NULL COMMENT '등록일자',
 UPD_DTM VARCHAR(14) NOT NULL COMMENT '수정일자',
 USE_YN  VARCHAR(1)  NOT NULL COMMENT '사용여부'
) COMMENT '회원관리';

CREATE TABLE LOGINLOG(
	ID VARCHAR(50) NOT NULL COMMENT '회원 아이디',
	LOGIN_DT VARCHAR(8) NOT NULL COMMENT '로그인 일자',
	LOGIN_TM VARCHAR(6) NOT NULL COMMENT '로그인 시간'
) COMMENT '로그인 이력';

CREATE TABLE WITHDRAW(
	WITHDRAW_CD VARCHAR(1) PRIMARY KEY COMMENT '회원탈퇴 코드',
	WITHDRAW_COMMENT VARCHAR(2000) NOT NULL DEFAULT '' COMMENT '회원탈퇴 사유내용'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '회원탈퇴 사유' ;

INSERT INTO WITHDRAW (WITHDRAW_CD, WITHDRAW_COMMENT) VALUES ('A', '다른 아이디 변경');
INSERT INTO WITHDRAW (WITHDRAW_CD, WITHDRAW_COMMENT) VALUES ('B', '컨텐츠 부족 및 구매할만한 품목 부족');
INSERT INTO WITHDRAW (WITHDRAW_CD, WITHDRAW_COMMENT) VALUES ('C', '개인정보(통신 및 신용정보)의 노출 우려');
INSERT INTO WITHDRAW (WITHDRAW_CD, WITHDRAW_COMMENT) VALUES ('D', '시스템 장애(속도저조, 낮은 에러 등)');
INSERT INTO WITHDRAW (WITHDRAW_CD, WITHDRAW_COMMENT) VALUES ('E', '이벤트 참여를 위해서 회원가입을 했기때문에');
INSERT INTO WITHDRAW (WITHDRAW_CD, WITHDRAW_COMMENT) VALUES ('F', '장기간 부재');

CREATE TABLE WITHDRAW_LOG(
	WITHDRAW_LOG_ID INT(10) PRIMARY KEY AUTO_INCREMENT COMMENT '회원탈퇴로그 ID',
	WITHDRAW_CD VARCHAR(1) NOT NULL DEFAULT 'A' COMMENT '회원탈퇴 코드',
	ID VARCHAR(50) NOT NULL COMMENT '회원아이디',
	WITHDRAW_DTM VARCHAR(14) NOT NULL COMMENT '탈퇴일시'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '회원탈퇴 기록';