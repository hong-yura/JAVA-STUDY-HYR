package Chapter10;

import java.text.DecimalFormat;

/*
 * [10-3] 문자열 “123,456,789.5”를 소수점 첫 번째 자리에서 반올림하고,
 * 그 값을 만 단위마다 콤마(,)로 구분해서 출력하시오. 
 */
public class Exercise10_3 {

	public static void main(String[] args) {
		String data = "123,456,789.5";
		
		DecimalFormat df1 = new DecimalFormat("#,###.#");
		DecimalFormat df2 = new DecimalFormat("#,###0");	
		
		try {
			Number num = df1.parse(data); // Integer.parseint 메서드는 콤마(,)가 포함된 문자열을 숫자로 변환하지 못함.
			System.out.println("data:" + data);

			double d = num.doubleValue();
			System.out.println("반올림:" + Math.round(d));
			
			System.out.println("만단위:" + df2.format(d));
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
