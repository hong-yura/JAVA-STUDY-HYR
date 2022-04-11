package operator;

/*
 *  3-9
 *  다음은 문자형 변수 ch가 영문자(대문자 또는 소문자)이거나 숫자일 때만
 *  변수 b의 값이 true가 되도록 하는 코드이다.
 */

public class Operator09 {

	public static void main(String[] args) {
		char ch = 'z';
		boolean b = 'A' <= ch && ch <= 'Z' || 'a' <= ch && ch <= 'z' || '0' <= ch && ch <= '9' ;
		
		System.out.println(b);
		
		
	}

}
