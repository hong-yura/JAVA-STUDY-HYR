package Chapter09;
/*
 * [9-6] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
 */
public class Exercise9_6 {
	public static String fillZero(String src, int length) {
		/*
		 *  fillZero 메서드를 작성하시오.
		 *  	1. src가 null 이거나 src.length()가 length와 같으면 src를 그대로 반환한다.
		 *  	2. length의 값이 0보다 같거나 작으면 빈 문자열 ("") 을 반환한다.
		 *  	3. src의 길이가 length의 값보다 크면 src를 length만큼 잘라서 반환한다.
		 *  	4. 길이가 length인 char배열을 생성한다.
		 *  	5. 4 에서 생성한 char배열을 '0'으로 채운다.
		 *  	6. src에서 문자배열을 뽑아내서 4 에서 생성한 배열에 복사한다.
		 *  	7. 4 에서 생성한 배열로 String을 생성해서 반환한다.
		 */
		
		if(src == null || src.length() == length) {
			return src;
		} else if(length <= 0) {
			return "";
		} else if(src.length() > length) {
			return src.substring(0, length);
		}
		
		char[] cArr = new char[length];
		for(int i = 0; i < cArr.length; i++) {
			cArr[i] = '0';
		}
		
//		char[] srcArr = new char[srcArr.length];
//		for(int j = 0; j < srcArr.length; j++) {
//			
//		}
//		
//		System.arraycopy(src, 0, cArr, length, src.length() - 1);
//		
//		String st = cArr;
//		return st;
		
		System.arraycopy(src.toCharArray(), 0, cArr, length - src.length(), src.length());
		// .toCharArray() - 문자열을 문자배열(char[]) 로 변환해서 반환한다.
		// src.toCharArray()의 0번 인덱스부터 cArr의 length - src.length() 위치의 인덱스로 src.length() 만큼 복사한다.
		
		return new String (cArr);
	}
	
	public static void main(String[] args) {
		String src = "12345";
		System.out.println(fillZero(src, 10));
		System.out.println(fillZero(src, -1));
		System.out.println(fillZero(src, 3));
	}
}
