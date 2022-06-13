package Chapter09;
/*
 * [9-9] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
 */

//indexOf(int ch) 로 해야 하는데 indexOf(String str)로 계산하여 틀렸다...

class Exercise9_9 {	
	// delChar 메서드를 작성하시오.
	private static String delChar(String src, String delCh) {
		StringBuffer sb = new StringBuffer(src.length());
		
		// src에 delCh가 있는지 확인
		for(int i = 0; i < delCh.length(); i++) {
			char ch = delCh.charAt(i);
			
			if(src.indexOf(ch) == -1) {	
				return src;
			} else {
				int delIdx = src.indexOf(ch);
				sb.deleteCharAt(delIdx);
			}	
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5)" + " -> " + delChar("(1!2@3^4~5)", "~!@#$%^&*()"));
				System.out.println("(1 2    3   4\t5)" + " -> " + delChar("(1 2    3   4\t5)", " \t"));
	}
}
