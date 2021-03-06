-- 타투 상품 테이블
CREATE TABLE TATTOO (
	ID INT(10) PRIMARY KEY AUTO_INCREMENT COMMENT '타투상품 ID',
	NM VARCHAR(100) NOT NULL DEFAULT '' COMMENT '타투상품명',
	GOODS VARCHAR(50) NOT NULL DEFAULT '' COMMENT '타투상품 부위',
	IMAGE VARCHAR(200) COMMENT '상품 메인이미지',
	PRICE INT(8) DEFAULT 0 COMMENT '타투상품 가격',
	COLOR VARCHAR(30) DEFAULT '' COMMENT '타투상품 색상',
	SALE INT(3) DEFAULT 0 COMMENT '타투상품 할인률',
	SALE_START_DT VARCHAR(8) NOT NULL DEFAULT '' COMMENT '할인 시작일자',
	SALE_END_DT VARCHAR(8) NOT NULL DEFAULT '' COMMENT '할인 종료일자',
	CONTENT LONGTEXT NOT NULL DEFAULT '' COMMENT '타투상품 내용',
	REG_DTM VARCHAR(14) NOT NULL COMMENT '등록일자',
	UPD_DTM VARCHAR(14) NOT NULL COMMENT '최종수정일자',
	DEL_YN VARCHAR(1) NOT NULL DEFAULT 'N' COMMENT '삭제여부'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '타투 상품 테이블'; 
ALTER TABLE TATTOO ADD INDEX TATTOO_IDX01 (GOODS);

-- 담당자 테이블
CREATE TABLE TATTOOIST(
	SEQ INT(10) PRIMARY KEY AUTO_INCREMENT COMMENT '담당자 ID',
	NAME VARCHAR(50) NOT NULL DEFAULT '' COMMENT '담당자 명',
	CAREER INT(3) DEFAULT 0 COMMENT '경력',
	REQ_DTM VARCHAR(14) NOT NULL COMMENT '등록일자',
	UPD_DTM VARCHAR(14) NOT NULL COMMENT '최종수정일자'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

-- 타투 색상 테이블
CREATE TABLE TATTOOCOLOR(
	SEQ INT(10) PRIMARY KEY AUTO_INCREMENT COMMENT '색상 ID',
	COLOR VARCHAR(30) DEFAULT '' COMMENT '타투상품 색상'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE PAYMENT(
	PAYMENT_SN VARCHAR(30) PRIMARY KEY COMMENT '구매번호',
	USER_ID VARCHAR(50) NOT NULL COMMENT '사용자 ID',
	TATTOO_ID INT(10) DEFAULT 0 COMMENT '상품 번호',
	TATTOO_NM VARCHAR(100) NOT NULL DEFAULT '' COMMENT '상품명',
	PRICE INT(8) DEFAULT 0 COMMENT '가격',
	COLOR VARCHAR(30) NOT NULL DEFAULT '' COMMENT '상품 색상',
	TATTOOIST_NAME VARCHAR(50) NOT NULL DEFAULT '' COMMENT '담당자명',
	RESERVED_DT VARCHAR(14) NOT NULL DEFAULT '' COMMENT '예약일시',
	PAYMENT_CMPL_YN VARCHAR(1) NOT NULL DEFAULT 'N' COMMENT '결제확정여부(N: 미확정, Y:확정)',
	REG_DTM VARCHAR(14) NOT NULL COMMENT '구매등록날짜',
	UPD_DTM VARCHAR(14) NOT NULL COMMENT '구매수정날짜'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '구매내역';

-- 무통장 입금 테이블
CREATE TABLE STL(
	STL_NO INT(10) PRIMARY KEY AUTO_INCREMENT COMMENT '결제번호',
	PAYMENT_SN VARCHAR(30) DEFAULT 0 COMMENT '구매번호',
	USER_ID VARCHAR(50) NOT NULL COMMENT '사용자 ID',
	NAME VARCHAR(50) NOT NULL DEFAULT '' COMMENT '이름',
	TEL VARCHAR(30) NOT NULL DEFAULT '' COMMENT '연락처',
	EMAIL VARCHAR(50) NOT NULL DEFAULT '' COMMENT '이메일',
	STL_MONEY INT(10) DEFAULT 0 COMMENT '입금금액',
	STL_DTM VARCHAR(14) NOT NULL COMMENT '입금신청일자'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '무통장';


-- 스케줄 테이블
CREATE TABLE TATTOO_SCHEDULE(
	RESERVED_DATE VARCHAR(8) COMMENT '예약일자',
	RESERVED_HOUR VARCHAR(2) COMMENT '예약시간',
	TATTOO_NAME VARCHAR(50) NOT NULL COMMENT '타투이스트명',
	PAYMENT_SN VARCHAR(30) NOT NULL COMMENT '구매번호',
	PRIMARY KEY (RESERVED_DATE, RESERVED_HOUR, TATTOO_NAME)	
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 장바구니 테이블
CREATE TABLE BASKET(
	BASKET_SN INT(5) PRIMARY KEY AUTO_INCREMENT COMMENT '구매번호',
	USER_ID VARCHAR(50) NOT NULL COMMENT '사용자 ID',
	TATTOO_ID INT(10) DEFAULT 0 COMMENT '상품 번호',
	COLOR VARCHAR(30) NOT NULL DEFAULT '' COMMENT '상품 색상',
	TATTOOIST_NAME VARCHAR(50) NOT NULL DEFAULT '' COMMENT '담당자명',
	REG_DTM VARCHAR(14) NOT NULL COMMENT '구매등록날짜',
	UPD_DTM VARCHAR(14) NOT NULL COMMENT '구매수정날짜'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- FAQ
CREATE TABLE FAQ(
	NO INT(5) PRIMARY KEY AUTO_INCREMENT COMMENT 'FAQ번호',
	TITLE VARCHAR(255) NOT NULL DEFAULT '' COMMENT '제목',
	CONTENT TEXT COMMENT '내용'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'FAQ';