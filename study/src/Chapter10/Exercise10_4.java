package Chapter10;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * [10-4] 화면으로부터 날짜를 “2007/05/11”의 형태로 입력받아서
 * 무슨 요일인지 출력하는 프로그램을 작성하시오.
 * 단, 입력된 날짜의 형식이 잘못된 경우 메시지를 보여주고 다시 입력받아야 한다.
 */
public class Exercise10_4 {
	public static void main(String[] args) {
		String pattern = "yyyy/MM/dd";
		DateFormat df = new SimpleDateFormat(pattern);
		Scanner sc = new Scanner(System.in);
		
		Date inDate = null;
		
		System.out.println("날짜를" + pattern + "의 형태로 입력해주세요. (입력예: 2007/05/11)");
		
		while(sc.hasNextLine()) {
			try {
				inDate = df.parse(sc.nextLine()); // 정해진 패턴대로 입력 시 Date 타입으로 변환.
				break;
			} catch (Exception e) {
				// 패턴대로 입력하지 않으면 다시 입력.
				System.out.println("날짜를" + pattern + "의 형태로 입력해주세요. (입력예: 2007/05/11)");
			}
		}
		
		String patternE = "입력하신 날짜는 E요일입니다.";
		DateFormat dfE = new SimpleDateFormat(patternE);
		
		System.out.println(dfE.format(inDate));
	}
}
