package Chapter05;

import java.util.Arrays;

// Chapter05 배열 연습문제 풀이
public class Ch05_Exercise {
	
	private static void ex01() {
		/* [5-1] 다음은 배열을 선언하거나 초기화한 것이다. 잘못된 것을 고르고 그 이유를 설명하시오. */
//		a. int[] arr[];
//		b. int[] arr = {1, 2, 3,};
//		c. int[] arr = new int[5];
//		d. int[] arr =  new int[5] {1, 2, 3, 4, 5};	// {} 안의 값에 따라 크기가 정해지기 때문에 new int[]에 크기를 정할 수 없음.
//		e. int arr[5];	// 선언만 했기 때문에 배열의 크기를 정할 수 없음.
//		f. int[] arr[] = new int[3][];
	}
	
	
	private static void ex02() {
		/* [5-2] 다음과 같은 배열이 있을 때, arr[3].length의 값은 얼마인가? */
		int[][] arr = {
				{ 5, 5, 5, 5, 5},
				{ 10, 10, 10},
				{ 20, 20, 20, 20},
				{ 30, 30}
		};
		// 정답 : 2
	}
	
	
	private static void ex03() {
		/* [5-3] 배열 arr에 담긴 모든 값을 더하는 프로그램을 완성하시오. */
		int[] arr = {10, 20, 30, 40, 50};
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("sum = " + sum);
		
		// 출력 결과 : sum = 150
	}
	
	
	private static void ex04() {
		/* [5-4] 2차원 배열 arr에 담긴 모든 값의 총합과 평균을 구하는 프로그램을 완성하시오. */
		int[][] arr = {
				{5, 5, 5, 5, 5},
				{10, 10, 10, 10, 10},
				{20, 20, 20, 20, 20},
				{30, 30, 30, 30, 30}
		};
		
		int total = 0;
		float average = 0;
		int count = 0;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				total += arr[i][j];
			}
			count += arr[i].length;
		}		
		average = (float)total / (float)count;
		
		System.out.println("total = " + total);
		System.out.println("average = " + average);
	}
	
	
	private static void ex05() {
		/* [5-5] 다음은 1과 9사이의 중복되지 않은 숫자로 이루어진 3자리 숫자를 만들어내는 프로그램이다.
		 * 알맞은 코드를 넣어서 프로그램을 완성하시오.
		 */
		int[] ballArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] ball3 = new int[3];
		
		// 배열 ballArr의 임의의 요소를 골라서 위치를 바꾼다.
		for(int i = 0; i < ballArr.length; i++) {
			int j = (int)(Math.random() * ballArr.length);	// ballArr.length의 크기는 9이므로 0 ~ 8까지의 숫자가 랜덤
			int tmp = 0;
			
			// ballArr[j] 는 ballArr의 크기와 같다.
			tmp = ballArr[i];
			ballArr[i] = ballArr[j];
			ballArr[j] = tmp;
		}
		
		// 배열 ballArr의 앞에서 3개의 수를 배열 ball3로 복사한다.
		System.arraycopy(ballArr, 0, ball3, 0, 3);
		
		for(int i = 0; i < ball3.length; i++) {
			System.out.print(ball3[i]);
		}
	}
	
	private static void ex06() {
		/* [5-6] 다음은 거스름돈을 몇 개의 동전으로 지불할 수 있는지를 계산하는 문제이다.
		 * 변수 money의 금액을 동전으로 바꾸었을 때 각각 몇 개의 동전이 필요한지 계산해서 출력하라.
		 * 단, 가능한 한 적은 수의 동전으로 거슬러 주어야한다.
		 */
		int[] coinUnit = {500, 100, 50, 10};
		
		int money = 2680;
		System.out.println("money = " + money);
		
		for(int i = 0; i < coinUnit.length; i++) {
			if(money % coinUnit[i] < coinUnit[i]) {
				int num = money / coinUnit[i];
				money %= coinUnit[i];
				System.out.println(coinUnit[i] + "원 : " + num);
			}
		/* 출력 결과
		 * money = 2680
		 * 500원 : 5
		 * 100원 : 1
		 * 50원 : 1
		 * 10원 : 3
		 */
		}
	}

	
	private static void ex07() {
		/* [5-7] 문제 5-6에 동전의 개수를 추가한 프로그램이다.
		 * 커맨드라인으로부터 거슬러 줄 금액을 입력받아 계산한다. 
		 * 보유한 동전의 개수로 거스름돈을 지불할 수 없으면, ‘거스름 돈이 부족합니다.’라고 출력하고 종료한다.
		 * 지불할 돈이 충분히 있으면, 거스름돈을 지불한 만큼 가진 돈에서 빼고 남은 동전의 개수를 화면에 출력한다.
		 */
		
		

		
	}

	
	
	
	private static void ex08() {
		/* [5-8] 다음은 배열 answer에 담긴 데이터를 읽고 각 숫자의 개수를 세어서
		 * 개수만큼 ‘*’을 찍어서 그래프를 그리는 프로그램이다. 알맞은 코드를 넣어서 완성하시오.
		 */
		
		
		
		/* 출력 결과
		 * 3***
		 * 2**
		 * 2**
		 * 4****
		 */
	}

	
	private static void ex09() {
		/* [5-9] 주어진 배열을 시계방향으로 90도 회전시켜서 출력하는 프로그램을 완성하시오. */
		
		
		
	}

	
	private static void ex10() {
		/* [5-10] 다음은 알파벳과 숫자를 아래에 주어진 암호표로 암호화하는 프로그램이다.
		 * 알맞은 코드를 넣어서 완성하시오.
		 */
		
		
		/* 출력 결과
		 * src : abc123
		 * result : `~!wer
		 */
	}

	
	private static void ex11() {
		/* [5-11] 주어진 2차원 배열의 데이터보다 가로와 세로로 1이 더 큰 배열을 생성해서
		 * 배열의 행과 열의 마지막 요소에 각 열과 행의 총합을 저장하고 출력하는 프로그램이다.
		 * 알맞은 코드를 넣어서 완성하시오.
		 */
		
		

	}
	
	
	private static void ex12() {
		/* [5-12] 예제 5-23을 변경하여, 아래와 같은 결과가 나오도록 하시오. */	
		
		
	}
	
	
	private static void ex13() {
		/* [5-13] 단어의 글자위치를 섞어서 보여주고 원래의 단어를 맞추는 예제이다.
		 * 실행결과와같이 동작하도록 하시오.
		 */
		
		
		
	}
	
	
	public static void main(String[] args) {
		Ch05_Exercise exercise = new Ch05_Exercise();
		
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

	}

}
