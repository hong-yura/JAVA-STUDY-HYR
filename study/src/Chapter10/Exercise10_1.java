package Chapter10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// [10-1] Calendar 클래스와 SimpleDateFormat 클래스를 이용해서 
// 2010년의 매월 두 번째 일요일의 날짜를 출력하시오.
public class Exercise10_1 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd은 F번째 E요일입니다.");

        for(int i = 0; i <= 11; i++) {
            for(int j = 1; j <= 31; j++) {
                cal.set(2010, i, j);
                
                Date date = cal.getTime();
                
                if(cal.get(Calendar.DAY_OF_WEEK_IN_MONTH) == 2 && cal.get(Calendar.DAY_OF_WEEK) == 1) {
                    System.out.println(sdf.format(date));
                }
                
            }
        }
	
	}

}