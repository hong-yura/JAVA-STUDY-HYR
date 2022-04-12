package Chapter03;

// Chapter03 연산자 연습문제 풀이
public class Operator09 {

	/*  [3-9] 다음은 문자형 변수 ch가 영문자(대문자 또는 소문자)이거나 숫자일 때만
	 *  변수 b의 값이 true가 되도록 하는 코드이다. (1)에 알맞은 코드를 넣으시오.
	 */
	public static void main(String[] args) {
		char ch = 'z';
		boolean b = 'A' <= ch && ch <= 'Z' || 'a' <= ch && ch <= 'z' || '0' <= ch && ch <= '9' ;
		
		System.out.println(b);
		
		
	}

}
