/*
 * 홍유라_문제05
 * 
 * 홍유라_문제04에서 만든 subject_t 테이블을 활용해 문제를 해결한다.
 * 	 1. subject_t 테이블명을 score_t 로 변경한다.
 *   2. score_t 테이블에 '과목 점수 테이블' 이라고 주석을 달아준다.
 *   3. score_t 테이블의 sub_no 컬럼명을 math 로 수정한다.
 * 		위에서 수정한 math 컬럼의 데이터 타입을 NUMBER(3) DEFAULT(0)으로 변경한다.
 *   4. score_t 테이블 eng 컬럼의 기존 제약조건을 삭제한다.
 *   5. score_t 테이블의 sub_name 컬럼명을 eng 로 수정한다.
 * 		위에서 수정한 eng 컬럼의 데이터 타입을 NUMBER(3) DEFAULT(0)으로 변경한다.
 *   6. score_t 테이블의 sub_score 컬럼을 삭제한다.
 * 	 7. score_t 테이블에 kor, java 2개의 새로운 컬럼을 추가한다.
 * 		2개 컬럼의 데이터 타입은 동일하다 -> NUMBER(3) DEFAULT(0)
 *   8. score_t 테이블 컬럼들에 주석을 달아준다.
 * 		(stu_id - '학번', math - '수학', eng - '영어', kor - '국어', java - '자바')
 *   9. math, eng, kor, java 컬럼에는 0 ~ 100 사이의 숫자만 입력 및 수정
 *      될 수 있도록 적절한 제약조건과 제약조건명을 부여한다.
 */
SELECT * FROM student_t; -- 학생 정보 테이블

-- 1. score_t 로 테이블명 변경(초기 개발 단계에서 데이터가 아예 없을때, 임의로 지은 테이블명을 바꾸고 경우 사용)
ALTER TABLE subject_t RENAME TO score_t;

-- 2. score_t 테이블에 주석달기
COMMENT ON TABLE score_t IS '과목 점수 테이블';

-- 3. score_t 테이블의 sub_no 컬럼명을 math 로 수정, 데이터 타입을 NUMBER(3)으로 변경
ALTER TABLE score_t RENAME COLUMN sub_no TO math;
ALTER TABLE score_t MODIFY math NUMBER(3) DEFAULT(0);

-- 4. eng 컬럼의 기존 제약조건을 삭제한다.
ALTER TABLE score_t DROP CONSTRAINT CK_SUBJECT_T_SUB_NAME; -- 부여해 두었던 제약조건명으로 삭제

-- 5. score_t 테이블의 sub_name 컬럼명을 eng 로 수정, 데이터 타입을 NUMBER(3)으로 변경
ALTER TABLE score_t RENAME COLUMN sub_name TO eng;
ALTER TABLE score_t MODIFY eng NUMBER(3) DEFAULT(0);

-- 6. score_t 테이블의 sub_score 컬럼을 삭제
ALTER TABLE score_t DROP COLUMN sub_score;

-- 7. score_t 테이블에 kor, java 2개의 새로운 컬럼을 추가
ALTER TABLE score_t ADD kor NUMBER(3) DEFAULT(0);
ALTER TABLE score_t ADD java NUMBER(3) DEFAULT(0);

-- 8. score_t 테이블 컬럼들에 주석을 달아준다.
COMMENT ON COLUMN score_t.stu_id IS '학번'; -- 컬럼에 주석 달기
COMMENT ON COLUMN score_t.math IS '수학';
COMMENT ON COLUMN score_t.eng IS '영어';
COMMENT ON COLUMN score_t.kor IS '국어';
COMMENT ON COLUMN score_t.java IS '자바';

-- 9. 제약조건과 제약조건명 부여
ALTER TABLE score_t MODIFY math CONSTRAINT CK_SCORE_T_MATH CHECK(math BETWEEN 0 AND 100);
ALTER TABLE score_t MODIFY eng CONSTRAINT CK_SCORE_T_ENG CHECK(eng BETWEEN 0 AND 100);
ALTER TABLE score_t MODIFY kor CONSTRAINT CK_SCORE_T_KOR CHECK(kor BETWEEN 0 AND 100);
ALTER TABLE score_t MODIFY java CONSTRAINT CK_SCORE_T_JAVA CHECK(java BETWEEN 0 AND 100);

SELECT * FROM score_t; -- 과목 점수 테이블

SELECT * FROM ALL_TAB_COMMENTS WHERE TABLE_NAME = 'SCORE_T'; -- 테이블 주석 확인
SELECT * FROM USER_COL_COMMENTS WHERE TABLE_NAME = 'SCORE_T';-- score_t 테이블의 컬럼 주석 확인하기
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'SCORE_T'; -- score_t 테이블 제약조건 확인하기
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'SCORE_T'; -- 컬럼 확인



-- 제약조건을 수정하는 명령문은 없음.
-- 제약조건을 수정하고 싶다면 삭제 후 재생성 해야 함.
ALTER TABLE subject_t DROP CONSTRAINT CK_SUBJECT_T_SUB_NAME; -- 부여해 두었던 제약조건명으로 삭제
ALTER TABLE subject_t MODIFY sub_name CONSTRAINT CK_SUBJECT_T_SUB_NAME CHECK(sub_name IN ('국어', '영어', '수학', '자바'));









/*
 * 이보슬_문제05
 * 
 * 
 */
SELECT * FROM 
SELECT * FROM 







/*
 * 김규연_문제05
 * 
 */ 
SELECT * FROM 
SELECT * FROM 








/*
 * 김재은_문제05
 * 
 * 4주차에 생성한 MART_T 테이블을 사용하여 문제를 해결하시오.
 * 1. kind 컬럼의 크기를 가변길이20자로 늘리시오.
 * 2. sort 컬럼을 추가하시오.
 *    (타입은 숫자형, 제약조건은 primary key로 부여하시오)
 * 3. sort의 제약조건명을 PK_MART_T_SORT 로 변경하시오.
 * 4. ref_mart_t 테이블의 r_bar의 제약조건명을 PK_REF_MART_T_R_BAR로 변경하시오.
 * 5. EMP_MART_T 테이블을 생성하시오.
 *    ->name(가변길이 10자),  salary(숫자), manage_sort(숫자)
 *    (manage_sort는 MART_T의 sort를 외래키로 참조하도록 하시오.)
 * 6. 각 주석을 추가로 달아준다
 * 	 - MART_T에 SORT에는 '분류코드'
 * 	 - EMP_MART_T에 NAME에는 '이름', SALARY에는 '연봉', MANAGE_SORT에는 '담당분류코드'를 작성한다.
 */
SELECT * FROM MART_T;
SELECT * FROM ref_mart_t;






