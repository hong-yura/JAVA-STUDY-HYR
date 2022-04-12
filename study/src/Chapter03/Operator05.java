package Chapter03;

// Chapter03 연산자 연습문제 풀이
public class Operator05 {
	
	/* [3-5] 아래는 변수 num의 값 중에서 일의 자리를 1로 바꾸는 코드이다.
	 * 만일 변수 num의 값이 333이라면 331이 되고, 777이라면 771이 된다.
	 * (1)에 알맞은 코드를 넣으시오.
	 */
	public static void main(String[] args) {
		int num = 333;
		System.out.println(num / 10 * 10 + 1);
	}

}
