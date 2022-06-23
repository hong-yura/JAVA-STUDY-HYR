/*
 * 홍유라_문제06
 * 
 * 1. student_t 테이블에 컬럼 2개를 추가하시오.
 * 	 - 컬럼명: stu_gender, 자료형: VARCHAR2(1 CHAR),제약조건:'남', '여' 중에 CHECK
 *     제약조건명: CK_STUDENT_T_STU_GENDER , 컬럼주석: '성별'
 *   - 컬럼명: stu_gpa, 자료형: VARCHAR2(3), 컬럼주석: '등급'
 * 
 * 2. score_t 테이블에 컬럼 2개를 추가하시오.
 *   - 컬럼명: score_total, 자료형: NUMBER DEFAULT(0), 컬럼주석: '과목점수합계'
 *   - 컬럼명: score_avg, 자료형: NUMBER DEFAULT(0), 컬럼주석: '과목점수평균'
 * 
 * 3. INSERT INTO ... VALUES 구문을 사용하여 student_t 테이블에 데이터를 추가한다.
 *   - 학번: 2201, 학생명:'김서준', 학급(반): 'C-01', 성별: '남', 등급: ''
 *   - 학번: 2202, 학생명:'송하은', 학급(반): 'C-02', 성별: '여', 등급: ''
 *   - 학번: 2203, 학생명:'이예린', 학급(반): 'C-01', 성별: '여', 등급: ''
 *   - 학번: 2204, 학생명:'박주원', 학급(반): 'C-01', 성별: '남', 등급: ''
 *   - 학번: 2205, 학생명:'최민지', 학급(반): 'C-02', 성별: '여', 등급: ''
 * 	
 * 
 * 4. 테이블의 모든 행 데이터를 한 번에 삭제하기 위한 명령어는 무엇인지 답하시오.
 * 	  또한, 해당 명령어를 실행 후 데이터를 복구할 수 있는가? 이유까지 함께 설명하시오.
 * 	  (주석으로 답을 작성하도록 한다.)
 */
-- 1. student_t 테이블에 2개 컬럼 추가
ALTER TABLE student_t ADD stu_gender VARCHAR2(1 CHAR) CONSTRAINT CK_STUDENT_T_STU_GENDER CHECK(stu_gender IN ('남', '여'));
ALTER TABLE student_t ADD stu_gpa VARCHAR2(3);

-- 2. score_t 테이블에 2개 컬럼 추가
ALTER TABLE score_t ADD score_total NUMBER DEFAULT(0);
ALTER TABLE score_t ADD score_avg NUMBER DEFAULT(0);

COMMENT ON COLUMN student_t.stu_gender IS '성별'; -- 컬럼에 주석 달기
COMMENT ON COLUMN student_t.stu_gpa IS '등급'; -- 컬럼에 주석 달기
COMMENT ON COLUMN score_t.score_total IS '과목점수합계'; -- 컬럼에 주석 달기
COMMENT ON COLUMN score_t.score_avg IS '과목점수평균'; -- 컬럼에 주석 달기

-- 3.
INSERT INTO student_t (stu_id, stu_name, class_name, stu_gender, stu_gpa) VALUES(2201, '김서준', 'C-01', '남', '');




SELECT * FROM student_t; -- 학생 정보 테이블
SELECT * FROM score_t; -- 과목 점수 테이블
SELECT * FROM USER_COL_COMMENTS WHERE TABLE_NAME = 'STUDENT_T';	-- STUDENT_T 테이블 컬럼의 주석 확인하기
SELECT * FROM USER_COL_COMMENTS WHERE TABLE_NAME = 'SCORE_T';	-- SUBJECT_T 테이블 컬럼의 주석 확인하기











