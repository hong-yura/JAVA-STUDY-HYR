/*
 * 홍유라_문제01
 * EMPLOYEES 테이블에서 EMPLOYEE_ID 를 조회하고 "사번"이라고 별칭을 부여한다.
 * FIRST_NAME 과 LAST_NAME 은 한 컬럼에 조회되도록 하며 "이름"이라고 별칭을 부여한다.
 * PHONE_NUMBER 컬럼을 조회할 때는 첫 번째 '.'의 앞이 011 로 시작하는 데이터만 조회한다. 별칭은 "전화번호"로 한다.
 * SALARY 컬럼을 조회할 때는 뒤에 '$' 가 표시되도록 한다.
 */
SELECT EMPLOYEE_ID AS 사번
	 , FIRST_NAME  || ' ' || LAST_NAME AS 이름
	 , PHONE_NUMBER AS 전화번호
	 , SALARY || '$' AS 급여
  FROM EMPLOYEES
 WHERE PHONE_NUMBER LIKE'011.%';

/*
 * 이보슬_문제01
 * EMPLOYEES 테이블에서 2000년대 이후에 고용되었으며 SALARY가 5000이상인 사람들의
 * 모든 정보를 출력하시오.
 * 	- FIRST_NAME과 LAST_NAME 은 NAME으로 출력한다.
 * 	- PHONE_NUMBER 는 '.' 대신 '-'으로 출력한다.
 */
SELECT EMPLOYEE_ID 
	 , FIRST_NAME || ' ' || LAST_NAME AS NAME
	 , EMAIL 
	 , PHONE_NUMBER 
	 , HIRE_DATE 
	 , JOB_ID 
	 , SALARY 
	 , COMMISSION_PCT
	 , MANAGER_ID
	 , DEPARTMENT_ID
  FROM EMPLOYEES
 WHERE HIRE_DATE >= TO_DATE(20000101)
   AND SALARY >= 5000;

/*
 * 김규연_문제01
 * 1991년 3월 1일과 1997년 02월 20일 사이에 입사한 사원이름, 급여, 입사일을 출력하시오.
 * 컬럼명은 한글로 별칭을 부여하시오.
 * (사원의 이름은 두 이름(LAST_NAME, FIRST_NAME)을 합쳐서 출력되도록 하시오.)
 */
SELECT FIRST_NAME || ' ' || LAST_NAME AS 사원이름
	 , SALARY AS 급여
	 , HIRE_DATE AS 입사일
  FROM EMPLOYEES 
 WHERE HIRE_DATE BETWEEN TO_DATE(19910301) AND TO_DATE(19970220);

/*
 * 김재은_문제01
 * DEPARTMENTS 테이블에서 DEPARTMENT_NAME이 C로 시작하거나 LOCATION_ID가 1800과 2500사이에 있는 
 * 모든 정보를 출력하라.
 * 
 * 	- 컬럼명은 모두 한글로 변경한다.
 *    (DEPARTMENT_ID -> 부서아이디, DEPARTMENT_NAME -> 부서이름
 *     MANAGER_ID -> 관리번호, LOCATION_ID -> 위치아이디)
 */
SELECT DEPARTMENT_ID AS 부서아이디
	 , DEPARTMENT_NAME AS 부서이름
	 , MANAGER_ID AS 관리번호
	 , LOCATION_ID AS 위치아이디
FROM DEPARTMENTS
WHERE DEPARTMENT_NAME LIKE 'C%' OR LOCATION_ID BETWEEN 1800 AND 2500;

SELECT * FROM DEPARTMENTS;
SELECT * FROM EMPLOYEES;
/*
 * 김경욱_문제01
 * 문제 EMPLOYEES 테이블에서 MANAGER_ID가 100, 102, 202 인 사람의 
 * NAME , EMAIL , PHONE_NUMBER , SALARY조회
 * 단, FIRST_NAME LAST_NAME 은 하나의 컬럼(EMP_NAME)으로 조회되도록함 
 */
SELECT FIRST_NAME || ' ' || LAST_NAME AS EMP_NAME
	 , EMAIL 
	 , PHONE_NUMBER 
	 , SALARY 
  FROM EMPLOYEES
 WHERE MANAGER_ID IN (100, 102, 202);
