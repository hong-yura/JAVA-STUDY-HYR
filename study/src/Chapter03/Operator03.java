package Chapter03;

// Chapter03 연산자 연습문제 풀이
public class Operator03 {
	
	/* [3-3] 아래는 변수 num의 값에 따라 ‘양수’, ‘음수', ‘0’을 출력하는 코드이다.
	 * 삼항 연산자를 이용해서 (1)에 알맞은 코드를 넣으시오.
	 */
	public static void main(String[] args) {
		int num = 10;
		System.out.println(num == 0 ? 0 : (num > 0 ? "양수" : "음수"));	
	}

}
