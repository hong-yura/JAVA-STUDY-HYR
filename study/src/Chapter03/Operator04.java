package Chapter03;

// Chapter03 연산자 연습문제 풀이
public class Operator04 {
	
	/* [3-4] 아래는 변수 num의 값 중에서 백의 자리 이하를 버리는 코드이다.
	 * 만일 변수 num의 값이 ‘456’이라면 ‘400’이 되고, ‘111’이라면 ‘100’이 된다.
	 * (1)에 알맞은 코드를 넣으시오.
	 */
	public static void main(String[] args) {
		int num = 456;
		System.out.println(num / 100 * 100);
	}

}
