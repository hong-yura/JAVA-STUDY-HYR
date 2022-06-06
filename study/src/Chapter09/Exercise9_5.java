package Chapter09;
/*
 * [9-5] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
 */
public class Exercise9_5 {
	public static int count(String src, String target) {
		int count = 0; 	// 찾은 횟수
		int pos = 0; 	// 찾기 시작할 위치
		/*
		 * 반복문을 사용해서 아래의 과정을 반복한다.
		 * 		1. src 에서 target 을 pos 의 위치부터 찾는다.
		 *   	2. 찾으면 count 의 값을 1 증가 시키고, pos 의 값을 target.length 만큼 증가시킨다.
		 *   	3. indexOf의 결과가 -1 이면 반복문을 빠져나가서 count 를 반환한다.
		 */
		
		// .indexOf(String str, int fromIndex) 는 fromIndex 위치부터 str 이 처음 등장하는 인덱스 위치를 반환한다.
		
		for(int i = 0; i < src.length(); i++) {
			pos = src.indexOf(target, pos);
			if(pos != -1) {
				count++;
				pos += target.length();				
			} else if(pos == -1) {
				break;
			}
		}
		return count;		
	}
	
	public static void main(String[] args) {
		System.out.println(count("12345AB12AB345AB", "AB"));
		System.out.println(count("12345", "AB"));
	}
}