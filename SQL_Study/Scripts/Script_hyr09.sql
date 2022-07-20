/* 
 * 홍유라_문제09 
 * 
 * 1. 현재 세션에 부여되어진 권한을 확인해보고, CREATE VIEW 권한이 없다면 권한을 부여하시오. [사진1]
 * 
 * 2. 아래의 조건에 맞춰 V_STUDENT_T 라는 이름의 view 를 생성하시오. [사진2]
 *    - 이미 생성한 view 가 존재하면 view 를 갱신하도록 한다.
 *    - student_t 테이블의 stu_id, stu_name, class_name, stu_gender 컬럼이 조회되도록 한다.
 *    - stu_id 를 기준으로 오름차순 정렬한다.
 * 
 * 3. 위에서 생성한 V_STUDENT_T 에 값을 추가하시오. [사진3]
 *    - (2208, '김예준', 'C-01', '남')
 *    - (2209, '김진아', 'C-01', '여')
 *    - (2210, '하태민', 'C-02', '남')
 *    - (2211, '장우주', 'C-02', '남')
 * 
 * 4. 아래의 조건에 맞춰 V_STU_SCORE 라는 이름의 view 를 생성하시오. [사진4]
 *    - 이미 생성한 view 가 존재하면 view 를 갱신하도록 한다.
 *    - student_t 테이블과 score_t 테이블을 JOIN하여 
 *      stu_id, stu_name, class_name, stu_gender, math, eng, kor, java, score_total, score_avg 컬럼이 조회되도록 한다.
 */

-- 1. 현재 세션에 부여되어진 권한 확인
SELECT * FROM USER_SYS_PRIVS;

-- 2. 조건에 맞춰 V_STUDENT_T 라는 이름의 view 를 생성
CREATE OR REPLACE VIEW V_STUDENT_T
	AS SELECT STU_ID 
			, STU_NAME 
			, CLASS_NAME 
			, STU_GENDER 
	FROM STUDENT_T
   ORDER BY 1;

-- 3. V_STUDENT_T 에 값을 추가
INSERT INTO V_STUDENT_T VALUES (2208, '김예준', 'C-01', '남');
INSERT INTO V_STUDENT_T VALUES (2209, '김진아', 'C-01', '여');
INSERT INTO V_STUDENT_T VALUES (2210, '하태민', 'C-02', '남');
INSERT INTO V_STUDENT_T VALUES (2211, '장우주', 'C-02', '남');

SELECT * FROM V_STUDENT_T;

-- 4. 조건에 맞춰 V_STU_SCORE 라는 이름의 view 를 생성
CREATE OR REPLACE VIEW V_STU_SCORE
	AS SELECT ST.STU_ID
			, ST.STU_NAME
			, ST.CLASS_NAME
			, ST.STU_GENDER
			, SCT.MATH
			, SCT.ENG
			, SCT.KOR
			, SCT.JAVA
			, SCT.SCORE_TOTAL
			, SCT.SCORE_AVG
		 FROM STUDENT_T ST
		 JOIN SCORE_T SCT
		   ON ST.STU_ID = SCT.STU_ID;

SELECT * FROM V_STU_SCORE;


SELECT * FROM student_t; -- 학생 정보 테이블
SELECT * FROM score_t; -- 과목 점수 테이블
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'STUDENT_T'; -- 테이블 제약조건 확인하기
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'SCORE_T'; -- 테이블 제약조건 확인하기

/* 
 * 이보슬_문제09 
 * 
 * 1. student_tb 테이블에 값을 추가한다.
 * 		(202207, '아이유', 19, '010-2233-4912', '서울시 광진구', NULL)
 * 		(202208, '강호동', 17, '010-0292-8778', '경기도 파주시', NULL)
 * 		(202209, '김샛별', 19, '010-7789-9072', '서울시 성북구', 2)
 *		(202210, '김영철', 18, '010-9760-5674', '경기도 고양시', NULL)
 * 
 * 2. level_tb 테이블을 삭제한다.
 * 
 * 3. department_tb(소속) 테이블을 생성한다.
 * 		dept_code (소속 코드)	NUMBER		제약조건 : 기본키 
 * 		dept_evel(학년)			  NUMBER		
 * 		dept_class(반)			  NUMBER
 * 
 * 4. department_tb 테이블의 값을 추가한다.  (사진1)
 * 		(1001, 1, 1)	(1002, 1, 2) 	(1003, 1, 3) 		(2001, 2, 1)	(2002, 2, 2)
 *		(2003, 2, 3) 	(3001, 3, 1) 	(3002, 3, 2) 		(3003, 3, 3)
 * 
 * 5. teacher_tb(교사) 테이블을 생성한다. (제약조건명은 테이블명과 컬럼명을 조합하여 짓는다.)
 * 		teacher_id (교사 아이디)	NUMBER  		  제약조건 : 기본키
 * 		teacher_name(교사명)	   	VARCHAR(20) 
 * 		subject(과목)				    VARCHAR(20) 	
 * 		dept_code(담당 교실)		  VARCHAR2(10) 	제약조건 : 외래키 (department_tb의 dept_code를 참조)
 * 		charge_club(담당 동아리)	NUMBER		    제약조건 : 외래키 (club_tb 의 club_id를 참조)
 * 
 * 6. student_tb 테이블에 컬럼을 추가한다. (제약조건명은 테이블명과 컬럼명을 조합하여 짓는다.) 
 * 		teacher_id  				NUMBER 			  제약조건 : 외래키 (teacher_tb 테이블의 teacher_id 컬럼 참조)
 * 		dept_code					  NUMBER			  제약조건 : 외래키 (department 테이블의 dept_code 컬럼 참조)
 * 
 * 7. teacher_tb 테이블의 값을 추가한다. (사진2)
 * INSERT INTO TEACHER_TB VALUES (1, '한예슬', '국어', '1001', 1);
 * INSERT INTO TEACHER_TB VALUES (2, '공유', '수학', '1002', 2);
 * INSERT INTO TEACHER_TB VALUES (3, '송중기', '영어', '1003', NULL);
 * INSERT INTO TEACHER_TB VALUES (4, '박보영', '과학', '2001', NULL);
 * INSERT INTO TEACHER_TB VALUES (5, '남주혁', '한국사', '2002', NULL);
 * INSERT INTO TEACHER_TB VALUES (6, '김우빈', '물리', '2003', NULL);
 * INSERT INTO TEACHER_TB VALUES (7, '이광수', '체육', '3001', NULL);
 * INSERT INTO TEACHER_TB VALUES (8, '송지효', '음악', '3002', NULL);
 * INSERT INTO TEACHER_TB VALUES (9, '한지민', '미술', '3003', NULL);
 * 
 * 
 * 8. student_tb 테이블에 값을 추가한다. (사진3) 
 * UPDATE STUDENT_TB SET dept_code = 1001, teacher_id = 1  WHERE STU_NAME = '김태리';
 * UPDATE STUDENT_TB SET dept_code = 1001, teacher_id = 1 WHERE STU_NAME = '박보검';
 * UPDATE STUDENT_TB SET dept_code = 1002, teacher_id = 2 WHERE STU_NAME = '한소희';
 * UPDATE STUDENT_TB SET dept_code = 1003, teacher_id = 3 WHERE STU_NAME = '강호동';
 * 
 * UPDATE STUDENT_TB SET dept_code = 2001, teacher_id = 4 WHERE STU_NAME = '강동원';
 * UPDATE STUDENT_TB SET dept_code = 2002, teacher_id = 5 WHERE STU_NAME = '김영철';
 * 
 * UPDATE STUDENT_TB SET dept_code = 3001, teacher_id = 7 WHERE STU_NAME = '수지';
 * UPDATE STUDENT_TB SET dept_code = 3002, teacher_id = 8 WHERE STU_NAME = '송강';
 * UPDATE STUDENT_TB SET dept_code = 3002, teacher_id = 8 WHERE STU_NAME = '아이유';
 * UPDATE STUDENT_TB SET dept_code = 3003, teacher_id = 9 WHERE STU_NAME = '김샛별';
 *
 * 9. STUDENT_TB, DEPARTMENT_TB, TEACHER_TB 테이블을 조인하여 VIEW 테이블을 생성하시오. (사진4)
 * 		- VIEW 테이블명은 V_STUDENT_TB 로 한다.
 * 		- STU_ID, STU_NAME, STU_PHONE, STU_ADDRESS, TEACHER_NAME, DEPT_LEVEL, DEPT_CLASS 컬럼을 조회한다.
 * 
 * 10. 9번에서 생성한 V_STUDENT 테이블에서 1학년이면서 경기도에 거주하는 학생 정보를 조회하시오. (사진5)
 * 		- STU_ID, STU_NAME, STU_PHONE, STU_ADDRESS, TEACHER_NAME 컬럼을 조회하시오.
 */

-- 1. student_tb 에 값 추가
INSERT INTO student_tb VALUES (202207, '아이유', 19, '010-2233-4912', '서울시 광진구', NULL);
INSERT INTO student_tb VALUES (202208, '강호동', 17, '010-0292-8778', '경기도 파주시', NULL);
INSERT INTO student_tb VALUES (202209, '김샛별', 19, '010-7789-9072', '서울시 성북구', 2);
INSERT INTO student_tb VALUES (202210, '김영철', 18, '010-9760-5674', '경기도 고양시', NULL);

-- 2. level_tb 테이블을 삭제
DROP TABLE level_tb;

-- 3. department_tb(소속) 테이블을 생성
CREATE TABLE department_tb (
	   dept_code	NUMBER		PRIMARY KEY
	 , dept_evel	NUMBER		
	 , dept_class	NUMBER
);

-- 4. department_tb 테이블의 값을 추가
INSERT INTO department_tb VALUES (1001, 1, 1);
INSERT INTO department_tb VALUES (1002, 1, 2);
INSERT INTO department_tb VALUES (1003, 1, 3);
INSERT INTO department_tb VALUES (2001, 2, 1);
INSERT INTO department_tb VALUES (2002, 2, 2);
INSERT INTO department_tb VALUES (2003, 2, 3);
INSERT INTO department_tb VALUES (3001, 3, 1);
INSERT INTO department_tb VALUES (3002, 3, 2);
INSERT INTO department_tb VALUES (3003, 3, 3);

-- 5. teacher_tb(교사) 테이블을 생성
CREATE TABLE teacher_tb (
	   teacher_id	  NUMBER		CONSTRAINT PK_TEACHER_TB_TEACHER_ID PRIMARY KEY
	 , teacher_name	  VARCHAR(20)
	 , subject		  VARCHAR(20)
	 , dept_code	  NUMBER 
	 , charge_club	  NUMBER
	 , CONSTRAINT FK_TEACHER_TB_DEPT_CODE FOREIGN KEY(dept_code) REFERENCES department_tb(dept_code)
	 , CONSTRAINT FK_TEACHER_TB_CHARGE_CLUB FOREIGN KEY(charge_club) REFERENCES club_tb(club_id)
);

-- 6. student_tb 테이블에 컬럼을 추가한다. (제약조건명은 테이블명과 컬럼명을 조합하여 짓는다.)
ALTER TABLE student_tb ADD teacher_id NUMBER;
ALTER TABLE student_tb ADD CONSTRAINT FK_STUDENT_TB_TEACHER_ID FOREIGN KEY(teacher_id) REFERENCES teacher_tb(teacher_id);

ALTER TABLE student_tb ADD dept_code NUMBER;
ALTER TABLE student_tb ADD CONSTRAINT FK_STUDENT_TB_DEPT_CODE FOREIGN KEY(dept_code) REFERENCES department_tb(dept_code);

-- 7. teacher_tb 테이블의 값을 추가
INSERT INTO TEACHER_TB VALUES (1, '한예슬', '국어', '1001', 1);
INSERT INTO TEACHER_TB VALUES (2,   '공유', '수학', '1002', 2);
INSERT INTO TEACHER_TB VALUES (3, '송중기', '영어', '1003', NULL);
INSERT INTO TEACHER_TB VALUES (4, '박보영', '과학', '2001', NULL);
INSERT INTO TEACHER_TB VALUES (5, '남주혁', '한국사', '2002', NULL);
INSERT INTO TEACHER_TB VALUES (6, '김우빈', '물리', '2003', NULL);
INSERT INTO TEACHER_TB VALUES (7, '이광수', '체육', '3001', NULL);
INSERT INTO TEACHER_TB VALUES (8, '송지효', '음악', '3002', NULL);
INSERT INTO TEACHER_TB VALUES (9, '한지민', '미술', '3003', NULL);


-- 8. student_tb 테이블에 값을 추가
UPDATE STUDENT_TB SET dept_code = 1001, teacher_id = 1  WHERE STU_NAME = '김태리';
UPDATE STUDENT_TB SET dept_code = 1001, teacher_id = 1 WHERE STU_NAME = '박보검';
UPDATE STUDENT_TB SET dept_code = 1002, teacher_id = 2 WHERE STU_NAME = '한소희';
UPDATE STUDENT_TB SET dept_code = 1003, teacher_id = 3 WHERE STU_NAME = '강호동';

UPDATE STUDENT_TB SET dept_code = 2001, teacher_id = 4 WHERE STU_NAME = '강동원';
UPDATE STUDENT_TB SET dept_code = 2002, teacher_id = 5 WHERE STU_NAME = '김영철';

UPDATE STUDENT_TB SET dept_code = 3001, teacher_id = 7 WHERE STU_NAME = '수지';
UPDATE STUDENT_TB SET dept_code = 3002, teacher_id = 8 WHERE STU_NAME = '송강';
UPDATE STUDENT_TB SET dept_code = 3002, teacher_id = 8 WHERE STU_NAME = '아이유';
UPDATE STUDENT_TB SET dept_code = 3003, teacher_id = 9 WHERE STU_NAME = '김샛별';

-- 9. STUDENT_TB, DEPARTMENT_TB, TEACHER_TB 테이블을 조인하여 VIEW 테이블을 생성
CREATE OR REPLACE VIEW V_STUDENT_TB
AS SELECT ST.STU_ID
		, ST.STU_NAME 
		, ST.STU_PHONE 
		, DT.DEPT_LEVEL
		, DT.DEPT_CLASS
		, CT.CLUB_NAME
		, CT.CLUB_TEACHER
	 FROM STUDENT_TB ST
	 JOIN DEPARTMENT_TB DT 
	   ON ST.DEPT_CODE = DT.DEPT_CODE
	 JOIN TEACHER_TB TT
	   ON ST.TEACHER_ID = TT.TEACHER_ID
	 JOIN CLUB_TB CT 
	   ON ST.CLUB_ID = CT.CLUB_ID;
	   
SELECT * FROM V_STUDENT_TB;

-- 10. 9번에서 생성한 V_STUDENT 테이블에서 1학년이면서 경기도에 거주하는 학생 정보를 조회
CREATE OR REPLACE VIEW V_STUDENT_TB
AS SELECT ST.STU_ID
		, ST.STU_NAME 
		, ST.STU_PHONE 
		, ST.STU_ADDRESS 
		, TT.TEACHER_NAME
		, DT.DEPT_LEVEL
		, DT.DEPT_CLASS
	 FROM STUDENT_TB ST
	 LEFT JOIN DEPARTMENT_TB DT 
	USING (DEPT_CODE)
	 LEFT JOIN TEACHER_TB TT
	USING (TEACHER_ID);

SELECT * FROM V_STUDENT_TB ORDER BY 1;
-- 1학년 학생 중 STU_ADDRESS는 경기도만 출력
SELECT STU_ID
	 , STU_NAME
	 , STU_PHONE
	 , STU_ADDRESS
	 , TEACHER_NAME
  FROM V_STUDENT_TB
 WHERE DEPT_LEVEL = 1
   AND STU_ADDRESS LIKE '%경기도%';

  
/* 
 * 김규연_문제09
 * 
 * 1. 다음 조건을 확인 하고 view 테이블을 생성하세요
 * 		- view 테이블 이름 : v_pastry_chef_tb
 * 		- pastry_chef_tb 와 COMPANY_TB 조인 하세요
 * 		- 컬럼 : bread_id, pc_name, pc_company, company_address, company_phone
 * 
 * 2. bread_tb 의 bread_name 자료형을 VARCHAR2(100) 로 변경하세요.
 * 
 * 3. 각 테이블에 다음 값들을 삽입하세요.
 * 		(1) bread_tb 테이블
 * 			 - (8, 	   	사라다 고로케, 8, 도넛빵, 2800)
 * 			 - (9, 		 	 맘모스, 6, 크림빵, 4700)
 *			 - (10, 치즈만난감자그라탕, 10, 조리빵, 2200)
 *
 *		(2) pastry_chef_tb 테이블
 *			 - (6, 	안효섭, 부산시 동래구, 010-1259-8566, 20220108, 성심당)
 *			 - (10, 김선호, 서울시 노원구, 010-8952-1243, 19991228, 뚜레쥬르)
 * 
 * 4. 다음 조건에 맞춰서 사진에 맞게 출력되도록 하세요.
 * 		- bread_tb 와 v_pastry_chef_tb 을 조인하고 각 컬럼명을 부여하세요.
 * 				bread_id -> 제품번호
 *	 			bread_name -> 빵이름
 *	 			bread_type -> 빵종류
 *	 			bread_price -> 인상빵가격 (1000을 더하세요)
 *	 			pc_name -> 빵담당기사
 *	 			pc_company -> 회사이름
 *	 			company_address -> 회사주소
 *	 			company_phone -> 회사전화번호
 *		- 위의 구문을 이용하여 회사이름, 빵인상가격의 최대값, 최소값, 총합, 빵갯수가 출력되도록 하세요.
 */
SELECT * FROM BREAD_TB;
SELECT * FROM COMPANY_TB;
SELECT * FROM PASTRY_CHEF_TB;
SELECT * FROM DATE_MANAGER_TB;

DROP VIEW v_pastry_chef_tb;

CREATE OR REPLACE VIEW v_pastry_chef_tb
	AS SELECT pc.BREAD_ID 
		 	, pc.PC_NAME 
		 	, pc.PC_COMPANY 
		 	, ct.COMPANY_ADDRESS 
		 	, ct.COMPANY_PHONE 
		 FROM pastry_chef_tb pc
		 JOIN COMPANY_TB ct
		   ON pc.PC_COMPANY = ct.COMPANY_NAME

SELECT * FROM  v_pastry_chef_tb;

ALTER TABLE BREAD_TB MODIFY BREAD_NAME VARCHAR2(100);
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'BREAD_TB';

INSERT INTO BREAD_TB VALUES (8, '사라다 고로케', '8', '도넛빵', 2800);
INSERT INTO BREAD_TB VALUES (9, '맘모스', '6', '크림빵', 4700);
INSERT INTO BREAD_TB VALUES (10, '치즈만난감자그라탕', '10', '조리빵', 2200);

INSERT INTO pastry_chef_tb VALUES (6, '안효섭', '부산시 동래구', '010-1259-8566', TO_DATE(20220108), '성심당');
INSERT INTO pastry_chef_tb VALUES (10, '김선호', '서울시 노원구', '010-8952-1243', TO_DATE(19991228), '뚜레쥬르');


SELECT 회사이름
	 , MAX(인상빵가격) 최대값
	 , MIN(인상빵가격) 최소값
	 , SUM(인상빵가격) 총합
	 , COUNT(인상빵가격) 빵겟수
 FROM (SELECT BREAD_ID 제품번호
	 , BREAD_NAME 빵이름
	 , BREAD_TYPE 빵종류
	 , BREAD_PRICE + 1000 인상빵가격
	 , PC_NAME 빵담당기사
	 , PC_COMPANY 회사이름
	 , COMPANY_ADDRESS 회사주소
	 , COMPANY_PHONE 회사전화번호
 FROM BREAD_TB b
 JOIN v_pastry_chef_tb vpc
USING (BREAD_ID))
GROUP BY 회사이름;


/* 
 * 김재은_문제09
 * 
 * 1. mart_tb에 name의 제약조건을 UNIQUE로 추가하시오. (제약조건명은 계속해왔던 방식으로)
 * 
 * 2. 환불 테이블 refund_mart_tb을 생성하시오. (제약조건명은 계속해왔던 방식대로 알아서 만드시오.)
 * 		- name(VARCHAR2(20)) / buy_date(DATE) / refund_date(DATE) / progress(VARCHAR2(20))
 * 		- name은 mart_tb의 name을 참조할 수 있도록 제약조건을 설정하시오.
 * 
 * 3. v_refund_mart_tb를 생성하시오.
 * 		- 생성되어있다면 갱신하도록 하시오.
 * 		- refund_mart_tb에서 컬럼 name, refund_date, progress를 가져오도록 하시오.
 * 
 * 4. v_refund_mart_tb에 값을 추가하시오.
 * 		- ('계란30구', '20220613', '20220710'), ('새우깡', '20220709', '20220712')
 * 
 * 5. v_refund_mart_tb의 progress항목을 update하시오.	
 * 		- 이때, buy_date와 refund_date의 차이가 14이상이면 '환불불가'
 * 		  차이가 7이상이면 '환불신청접수', 그외에는 '환불처리'로 작성하시오.
 */
SELECT * FROM emp_mart_tb;
SELECT * FROM mart_tb;

-- 1. mart_tb에 name의 제약조건을 UNIQUE로 추가
ALTER TABLE mart_tb ADD CONSTRAINT UK_MART_TB_NAME UNIQUE(name); 
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'MART_TB';

-- 2. 환불 테이블 refund_mart_tb을 생성
CREATE TABLE refund_mart_tb (
	   name			VARCHAR2(20) CONSTRAINT PK_REFUND_MART_TB_NAME PRIMARY KEY
	 , buy_date		DATE
	 , refund_date	DATE
	 , progress		VARCHAR2(20)
	 , CONSTRAINT FK_MART_TB_NAME FOREIGN KEY(name) REFERENCES mart_tb(name)
);

-- 3. v_refund_mart_tb를 생성
CREATE OR REPLACE VIEW v_refund_mart_tb
	AS SELECT name, refund_date, progress
  FROM refund_mart_tb;

 -- 4. v_refund_mart_tb에 값을 추가
INSERT INTO v_refund_mart_tb VALUES ('계란30구', '20220613', '20220710');
INSERT INTO v_refund_mart_tb VALUES ('새우깡', '20220709', '20220712');

-- 5. v_refund_mart_tb의 progress항목을 update 하시오.
UPDATE v_refund_mart_tb 
   SET progress = (CASE WHEN (refund_date - buy_date) >= 14 THEN '환불불가'
   						WHEN (refund_date - buy_date) >= 7 THEN '환불신청접수'
   						ELSE '환불처리'
   						 END);
   						
SELECT * FROM v_refund_mart_tb;
