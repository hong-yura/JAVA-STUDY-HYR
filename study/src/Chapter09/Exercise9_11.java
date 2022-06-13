package Chapter09;
/* [9-11]
 * 커맨드라인으로 2 ~ 9 사이의 두 개의 숫자를 받아서 두 숫자 사이의 구구단을 출력하는 프로그램을 작성하시오.
 * 예를 들어 3과 5를 입력하면 3단부터 5단까지 출력한다.
 */
public class Exercise9_11 {
	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 0;
		
		System.out.println("시작 단과 끝 단, 두 개의 정수를 입력해주세요.");
		num1 = Integer.parseInt(args[0]);
		num2 = Integer.parseInt(args[1]);
		
		
		if(!(2 <= num1 && num1 <= 9 && 2 <= num2 && num2 <= 9)) {
			System.out.println("단의 범위는 2와 9 사이의 값이어야 합니다.");
		}
		
		for(int i = num1; i <= num2; i++) {
			for(int j = 1; j < 10; j++) {
				System.out.println(i + "*" + j + "=" + i * j);
			}	
		}	
	}
}
