package Chapter03;

// Chapter03 연산자 연습문제 풀이
public class Operator06 {

	/* [3-6] 아래는 변수 num의 값보다 크면서도 가장 가까운 10의 배수에서
	 * 변수 num의 값을 뺀 나머지를 구하는 코드이다. 예를 들어, 24의 크면서도 가장 가까운 10의 배수는 30이다.
	 * 19의 경우 20이고, 81의 경우 90이 된다. 30에서 24를 뺀 나머지는 6이기 때문에
	 * 변수 num의 값이 24라면 6을 결과로 얻어야 한다. (1)에 알맞은 코드를 넣으시오. 
	 */
	public static void main(String[] args) {
		int num = 24;
		System.out.println((num / 10 + 1) * 10 - num);
	}

}
