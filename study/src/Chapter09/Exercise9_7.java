package Chapter09;
/*
 * [9-7] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
 */
public class Exercise9_7 {
	
	// contains 메서드를 작성하시오.
	public static boolean contains(String src, String target) {
		if(src.indexOf(target) != -1) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(contains("12345", "23"));
		System.out.println(contains("12345", "67"));
	}
}
