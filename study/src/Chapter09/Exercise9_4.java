package Chapter09;
/*
 * [9-4] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
 */
public class Exercise9_4 {
	static void printGraph(int[] dataArr, char ch) {
		// printGraph 메서드를 작성하시오.
		for(int i = 0; i < dataArr.length; i++) {
			for(int j = 0; j < dataArr[i]; j++) {
				System.out.print(ch);
			}
			System.out.println(dataArr[i]);
		}
	}
		
	public static void main(String[] args) {
		printGraph (new int[] {3, 7, 1, 4}, '*');		
	}
}