package Chapter09;
/*
 * [9-12] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
 */
class Exercise9_12 {	
	// getRand 메서드를 작성하시오.
	private static int getRand(int from, int to) {
		// 정수 랜덤
		// (int)Math.random() * (최대값 - 최소값 + 1) + 최소값
		return (int)(Math.random() * (Math.abs(to - from) + 1)) + Math.min(from, to);
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 20; i++) {
			System.out.print(getRand(1, -3) + ",");
		}
	}

}
