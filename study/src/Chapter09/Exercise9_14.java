package Chapter09;
/*
 * [9-14] 다음은 화면으로부터 전화번호의 일부를 입력받아
 * 일치하는 전화번호를 주어진 문자열 배열에서 찾아서 출력하는 프로그램이다.
 * 알맞은 코드를 넣어 프로그램을 완성하시오.
 */
import java.util.*;
import java.util.regex.*;   

class Exercise9_14 {
	public static void main(String[] args) {
		String[] phoneNumArr = {
			"012-3456-7890",
			"099-2456-7980",
			"088-2346-9870",
			"013-3456-7890"
		};
		
		ArrayList list = new ArrayList();
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.print(">>");
			String input = s.nextLine().trim(); // 사용자 입력, 공백 제거
			
			if(input.equals("")) {
				continue;
			} else if(input.equalsIgnoreCase("Q")) {	// q 를 입력하면 종료
				System.exit(0);
			}
			
			// 알맞은 코드를 넣어 완성하시오.
			
			String sinput = ".*" + input + ".*";
			Pattern p = Pattern.compile(sinput);		  // Pattern.compile() 호출하여 Pattern p 인스턴스 생성
			
			for(int i = 0; i < phoneNumArr.length; i++) {
				String phoneChar = phoneNumArr[i];
				String data = phoneChar.replace("-","");  // '-'를 제거하기 위해, 문자열 "-" 을 "" 로 반환  
				
				Matcher m = p.matcher(data);
				
				if(m.matches()) {		// 정규식에 부합하면 list에 추가
					list.add(phoneChar);
				}
			}
			
			if(list.size() > 0) {
				System.out.println(list);
				list.clear();
			} else {
				System.out.println("일치하는 번호가 없습니다."); 
			}
		}
	} // main
}