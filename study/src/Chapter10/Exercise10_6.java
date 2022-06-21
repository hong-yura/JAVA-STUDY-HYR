package Chapter10;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*
 * [10-6] 자신이 태어난 날부터 지금까지 며칠이 지났는지 계산해서 출력하시오.
 */
public class Exercise10_6 {
	public static void main(String[] args) {		
		LocalDate bday = LocalDate.of(1996, 12, 06);
		LocalDate today = LocalDate.now();
		
		System.out.println("birth day = " + bday);
		System.out.println("today	  = " + today);
		System.out.println(ChronoUnit.DAYS.between(bday, today) + " days");
	}
}
