package Chapter09;
/*
 * [9-10] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
 */
class Exercise9_10 {	
	/* format 메서드를 작성하시오.
	 * 	  1. length의 값이 str의 길이보다 작으면 length만큼만 잘라서 반환한다.
	 * 	  2. 1의 경우가 아니면, length크기의 char배열을 생성하고 공백으로 채운다.
	 * 	  3. 정렬조건 (alignment)의 값에 따라 문자열(str)을 복사할 위치를 결정한다.
	 * 		 (System.arraycopy() 사용)
	 * 	  4. 2에서 생성한 char배열을 문자열로 만들어서 반환한다. 
 	 */
	private static String format(String str, int length, int alignment) {
		char[] sArr = str.toCharArray();
		char[] cArr = new char[length];

		if(length < str.length()) { 
			return str.substring(0, length); // substring - end 인덱스 위치의 문자는 포함하지 않는다.(-1 아님.)
		} else {
			for(int i = 0; i < cArr.length; i++) {
				cArr[i] += ' ';
			}
		}
		
		if(alignment == 0) {
			System.arraycopy(sArr, 0, cArr, 0, sArr.length);
		} else if(alignment == 1) {
			System.arraycopy(sArr, 0, cArr, (length - str.length())/2, sArr.length);
		} else if(alignment == 2) {
			System.arraycopy(sArr, 0, cArr, (length - str.length()), sArr.length);
		}
		return new String(cArr);
	}
	
	public static void main(String[] args) {
		String str = "가나다";
		
		System.out.println(format(str, 7, 0)); // 왼쪽 정렬
		System.out.println(format(str, 7, 1)); // 가운데 정렬
		System.out.println(format(str, 7, 2)); // 오른쪽 정렬
	}
}
