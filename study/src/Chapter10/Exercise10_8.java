package Chapter10;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
/*
 * [10-8] 서울과 뉴욕간의 시차가 얼마인지 계산하여 출력하시오.
 */
public class Exercise10_8 {
	public static void main(String[] args) {
		// ZonedDateTime = LocalDateTime + Time Zone
		ZonedDateTime zdt1 = ZonedDateTime.of(LocalDateTime.of(2016, 01, 28, 23, 01, 00), ZoneId.of("Asia/Seoul"));
		ZonedDateTime zdt2 = ZonedDateTime.of(LocalDateTime.of(2016, 01, 28, 9, 01, 00), ZoneId.of("America/New_York"));
		
		System.out.println(zdt1);
		System.out.println(zdt2);
		
		long sec1 = zdt1.getOffset().getTotalSeconds();
		long sec2 = zdt2.getOffset().getTotalSeconds();
		long diff = (sec1 - sec2) / 3600;
		
		System.out.println("sec1=" + sec1);
		System.out.println("sec2=" + sec2);
		System.out.println("diff=" + diff + "hrs");
	}
}
