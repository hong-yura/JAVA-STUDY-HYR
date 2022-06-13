package Chapter09;
/*
 * [9-8] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
 */
// Math.round(실수) - 소수점 첫 째 자리에서 반올림하여 정수값(long)을 반환한다.
// Math.pow(밑, 지수) -  Math.pow(2, 3) = 2의 3승 = 8

class Exercise9_8 {				
	// round 메서드를 작성하시오.
	private static double round(double d, int n) {
		double x = Math.round(d * Math.pow(10, n)) / Math.pow(10, n);
		return x;
	}
	
	public static void main(String[] args) {
		System.out.println(round(3.1415, 1));
		System.out.println(round(3.1415, 2));
		System.out.println(round(3.1415, 3));
		System.out.println(round(3.1415, 4));
		System.out.println(round(3.1415, 5));
	}
}
	