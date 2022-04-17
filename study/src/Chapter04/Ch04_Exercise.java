package Chapter04;

// Chapter04 조건문과 반복문 연습문제 풀이
public class Ch04_Exercise {
		
	private static void ex01() {
		/* [4-1] 다음의 문장들을 조건식으로 표현하라. */
		// 1. int형 변수 x가 10보다 크고 20보다 작을 때 true인 조건식
		int x = 0;
		if(10 < x && x < 20) {
			System.out.println("true 입니다.");
		}
		
		// 2. char형 변수 ch가 공백이나 탭이 아닐 때 true인 조건식
		char ch = ' ';
		if(!(ch == ' ' || ch == '\t')) {
			System.out.println("true 입니다.");			
		}
		
		// 3. char형 변수 ch가 ‘x'또는 ’X'일 때 true인 조건식
		if(ch == 'x' || ch == 'X') {
			System.out.println("true 입니다.");
		}
		
		// 4. char형 변수 ch가 숫자(‘0’~‘9’)일 때 true인 조건식
		if('0' <= ch && ch <= '9' ) {
			System.out.println("true 입니다.");
		}
		
		// 5. char형 변수 ch가 영문자(대문자 또는 소문자)일 때 true인 조건식
		if(('A' <= ch && ch <= 'Z') || ('a' <= ch && ch <= 'z')) {
			System.out.println("true 입니다.");
		}
		
		// 6. int형 변수 year가 400으로 나눠떨어지거나 또는 4로 나눠떨어지고 100으로 나눠떨어지지않을 때 true인 조건식
		int year = 0;
		if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			System.out.println("true 입니다.");
		}
		
		// 7. boolean형 변수 powerOn가 false일 때 true인 조건식
		boolean powerOn = false;
		if(powerOn == false) {
			System.out.println("true 입니다.");
		}
		
		// 8. 문자열 참조변수 str이 “yes” 일 때 true인 조건식
		String str = "yes";
		if(str.equals("yes")) {
			System.out.println("true 입니다.");
		}
		
	}
	
	
	private static void ex02() {
		/* [4-2] 1부터 20까지의 정수 중에서 2 또는 3의 배수가 아닌 수의 총합을 구하시오. */
		int total = 0;
		for(int i = 1; i <= 20; i++) {
			if(!(i % 2 == 0 || i % 3 == 0)) {
				total += i;
			}
		} 
		System.out.printf("[4-2] 계산 결과 : %d\n", total);
		// 출력 결과 : 73		
	}
	
	
	private static void ex03() {
		/* [4-3] 1 + (1+2) + (1+2+3) + (1+2+3+4) + ... + (1+2+3+...+10) 의 결과를 계산하시오. */
		int sum = 0;
		int total1 = 0;
		for(int i = 1; i <= 10; i++) {
			sum += i;	
			total1 += sum;
		}
		System.out.printf("[4-3] 계산 결과 : %d\n", total1);
		// 출력 결과 : 220
	}
	
	
	private static void ex04() {
		/* [4-4] 1 + (-2) + 3 + (-4) + ... 과 같은 식으로 계속 더해나갔을 때,
		 * 몇까지 더해야 총합이 100 이상이 되는지 구하시오. 
		 */
		int neg = 0;	// 음수
		int pos = 0;	// 양수
		int total2 = 0;	// 총 합계
		int count = 0;	// 몇 까지 더하는가?
		
		for(int i = 1;;i++) {
			if(total2 >= 100) {
				break;
			} else {
				if(i % 2 == 0) {
					neg = -i;
					total2 += neg;
					count += 1;
				} else {
					pos = +i;
					total2 += pos;
					count += 1;
				}
			}
		}
		System.out.printf("[4-4] 총 합계 : %d\n", total2);
		System.out.printf("[4-4] 몇 까지 더해야 하는가? : %d\n", count);
	}
	
	
	private static void ex05() {
		/* [4-5] 다음의 for문을 while문으로 변경하시오. */
		for(int i = 0; i <= 10; i++) { 
			for(int j = 0; j <= i; j++)
				System.out.print("*"); 
			System.out.println();
		}
		
		int i = 0;
		while(i <= 10) {
			int j = 0;
			while(j <= i) {
				System.out.print("*");
				j++;		
			}
			System.out.println();
			i++;
		}
	}
	
	private static void ex06() {
		/* [4-6] 두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을 작성하시오. */
		int tot = 0;
		
		for(int i = 1; i <= 6; i++) {
			for(int j = 1; j <= 6; j++) {
				tot = i + j;
				if(tot == 6) {
					System.out.printf("[4-6] %d + %d = %d\n",i, j, tot);
				}
			}
		}
		/* 출력 결과
		 * [4-6] 1 + 5 = 6
		 * [4-6] 2 + 4 = 6
		 * [4-6] 3 + 3 = 6
		 * [4-6] 4 + 2 = 6
		 * [4-6] 5 + 1 = 6
		 */
	}

	
	private static void ex07() {
		/* [4-7] Math.random()을 이용해서 1부터 6사이의 임의의 정수를
		 * 변수 value에 저장하는 코드를 완성하라.
		 */
		int value = (int)(Math.random() * 6) + 1;
		/*
		 * Math.random() 은 0.0 ~ 1 사이의 실수를 랜덤으로 리턴한다. (0.0 부터 시작하며 1은 미포함)
		 * 따라서 1 ~ n개의 정수값을 리턴하고 싶을 때에는 정수로 형변환 하고 +1 해주어야 한다.(0부터 시작이기 때문에)
		 * (int)(Math.random() * n) + 1 
		 */
		
		System.out.println("[4-7] value : " + value);
		
	}

	
	
	
	private static void ex08() {
		/* [4-8]  방정식 2x + 4y = 10의 모든 해를 구하시오.
		 * 단, x와 y는 정수이고 각각의 범위는 0 <= x <= 10, 0 <= y <= 10 이다. 
		 */
		int tot = 10;
		
		for(int i = 0; i <= 10; i++) {
			for(int j = 0; j <= 10; j++) {
				tot = (2 * i) + (4 * j);
				if(tot == 10) {
					System.out.printf("[4-8] x = %d, y = %d\n",i, j);
				}
			}
		}
		/* 출력 결과
		 * [4-8] x = 1, y = 2
		 * [4-8] x = 3, y = 1
		 * [4-8] x = 5, y = 0
		 */
	}

	
	private static void ex09() {
		/* [4-9] 숫자로 이루어진 문자열 str이 있을 때,
		 * 각 자리의 합을 더한 결과를 출력하는 코드를 완성하라. 
		 * 만일 문자열이 "12345"라면, ‘1+2+3+4+5’의 결과인 15가 출력되어야 한다. 
		 */
		String str = "12345";
		int sum = 0;
		System.out.println(str.charAt(0));
		for(int i = 0; i < str.length(); i++) {
			sum += str.charAt(i) - '0';

		}
		System.out.println("[4-9] '1+2+3+4+5' = " + sum);
	}

	
	private static void ex10() {
		/* [4-10] int타입의 변수 num이 있을 때, 
		 * 각 자리의 합을 더한 결과를 출력하는 코드를 완성하라.
		 * 만일 변수 num의 값이 12345라면, ‘1+2+3+4+5’의 결과인 15를 출력하라.
		 */
		int num = 12345;
		int sum = 0;
		while(num > 0) {
			sum += num % 10;
			num /= 10;
		}
		System.out.println("[4-10] 1+2+3+4+5 = " + sum);
		/* 출력 결과
		 * [4-10] 1+2+3+4+5 = 15
		 */
	}

	
	private static void ex11() {
		/* [4-11] 피보나치(Fibonnaci) 수열은 앞의 두 수를 더해서 다음 수를 만들어 나가는 수열이다.
		 * 예를 들어 앞의 두 수가 1과 1이라면 그 다음 수는 2가 되고 그 다음 수는 1과 2를 더해서 3이 되어서
		 * 1,1,2,3,5,8,13,21,...과 같은 식으로 진행된다.
		 * 1과 1부터 시작하는 피보나치 수열의 10번째 수는 무엇인지 계산하는 프로그램을 완성하시오.
		 */
		int num1 = 1;
		int num2 = 1;
		int num3 = 0;
		System.out.print(num1 + "," + num2);
		
		// F(n) = F(n-1) + F(n-2)
		for(int i = 0; i < 8; i++) {
			num3 = num1 + num2;
			num1 = num2;
			num2 = num3;
			System.out.print("," + num3);
		}
		
		/* 출력 결과
		 * 1,1,2,3,5,8,13,21,34,55
		 */
	}
	
	
	private static void ex12() {
		/* [4-12] 구구단의 일부분을 다음과 같이 출력하시오. */	
//		for(int i = 2; i <= 9; i++) {
//			for(int j = 1; j <= 3; j++) {
//				System.out.print(i + "*" + j + "=" + i * j + "\t");
//				System.out.println();
//			}
//			System.out.println();
//		}
		
		
		for (int i = 1 ; i <= 9 ; i++) {
			for (int j = 1; j <= 3; j++) {
				int x = j + 1 + (i - 1) / 3 * 3;
				int y = i % 3 == 0 ? 3 : i % 3 ;
				
				if(x > 9) // 9단까지만 출력한다. 이 코드가 없으면 10단까지 출력된다.
					break;
				
				System.out.print(x + "*" + y + "=" + x * y + "\t"); //println이 아님에 주의
			}
			System.out.println();
			
			if(i % 3 == 0) {
				System.out.println();
			}
		}
		
	}
	
	
	private static void ex13() {
		/* [4-13] 다음은 주어진 문자열(value)이 숫자인지를 판별하는 프로그램이다. 
		 * 알맞은 코드를 넣어서 프로그램을 완성하시오.
		 */
		
		String value = "12o34";
		char ch = ' ';
		boolean isNumber = true;
		
		// 반복문과 charAt(int i)를 이용해서 문자열의 문자를
		// 하나씩 읽어서 검사한다.
		for(int i = 0; i < value.length(); i++) {
			ch = value.charAt(i);
			if(ch >= '0' && ch <='9') {
				isNumber = true;
			} else {
				isNumber = false;
				break;
			}
		}
		
		if(isNumber) {
			System.out.println(value + "는 숫자입니다.");
		} else {
			System.out.println(value + "는 숫자가 아닙니다.");
		}
		
		/* 출력 결과
		 * 12o34는 숫자가 아닙니다.
		 */
	}
	
	
	private static void ex14() {
		/* [4-14] 다음은 숫자맞추기 게임을 작성한 것이다.
		 * 1과 100사이의 값을 반복적으로 입력해서 컴퓨터가 생각한 값을 맞추면 게임이 끝난다.
		 * 사용자가 값을 입력하면, 컴퓨터는 자신이 생각한 값과 비교해서 결과를 알려준다.
		 * 사용자가 컴퓨터가 생각한 숫자를 맞추면 게임이 끝나고 몇 번 만에 숫자를 맞췄는지 알려준다.
		 * 알맞은 코드를 넣어서 프로그램을 완성하시오.
		 */	
		// 1 ~ 100 사이의 임의의 값을 얻어서 answer에 저장한다.
		int answer = (int)(Math.random() * 100) + 1;
		int input = 0;		// 사용자입력을 저장할 공간
		int count = 0;		// 시도횟수를 세기위한 변수
		
		// 화면으로 부터 사용자입력을 받기 위해서 Scanner 클래스 사용
		java.util.Scanner s = new java.util.Scanner(System.in);
		
		do {
			count++;
			System.out.print("1과 100사이의 값을 입력하세요 : "); 
			input = s.nextInt(); 	// 입력받은 값을 변수 input에 저장한다.
			
			if(input > answer) {
				System.out.println("더 작은 수를 입력하세요.");
			} else if(input < answer) {
				System.out.println("더 큰 수를 입력하세요.");
			} else {
				System.out.println("맞췄습니다.");
				System.out.println("시도횟수는" + count + "번 입니다.");
			}
			
		} while(true); // 무한반복문
	}
	
	
	private static void ex15() {
		/* [4-15] 다음은 회문수를 구하는 프로그램이다. 회문수(palindrome)란 숫자를 거꾸로 읽어도 앞으로 읽는 것과 같은 수를 말한다.
		 * 예를 들면 ‘12321’이나 ‘13531’같은 수를 말한다.
		 * 알맞은 코드를 넣어서 프로그램을 완성하시오.
		 */
		int number = 12321;
		int tmp = number;
		
		int result = 0; 	// 변수 number를 거꾸로 변환해서 담을 변수
		
		while(tmp != 0) {
			result = result * 10 + tmp % 10;
			tmp /= 10;
		}
		
		if(number == result) {
			System.out.println(number + "는 회수문 입니다.");
		} else {
			System.out.println(number + "는 회수문이 아닙니다.");			
		}
		
		/* 출력 결과
		 * 12321는 회수문 입니다.
		 */
	}
	
	
	public static void main(String[] args) {
		Ch04_Exercise exercise = new Ch04_Exercise();
		
		// exercise.ex01();
		// exercise.ex02();
		// exercise.ex03();
		// exercise.ex04();
		// exercise.ex05();
		// exercise.ex06();
		// exercise.ex07();
		// exercise.ex08();
		// exercise.ex09();
		// exercise.ex10();
		// exercise.ex11();
		// exercise.ex12();
		// exercise.ex13();
		// exercise.ex14();
		// exercise.ex15();
		
	}

}
