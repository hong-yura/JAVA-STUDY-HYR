package Chapter02;

// Chapter02 변수 연습문제 풀이
public class Ch02_Exercise {

	public static void main(String[] args) {
		
		/* [2-1] 다음 표의 빈 칸에 8개의 기본형(primitive type)을 알맞은 자리에 넣으시오.
		 * 
		 *  | 종류 \ 크기 |   1 byte 	 |    2 byte 	|    4 byte 	|    8 byte 	|
		 *  | 	논리형	|   boolean	 |				|				|				|	
		 *  | 	문자형	|			 |	   char		|				|				|
		 *  | 	정수형	|	 byte	 |	   short	|	  int		|	  long		|
		 *  | 	실수형	|			 |				|	  float		|	  double	| 
		 */
		
		/* [2-2] 주민등록번호를 숫자로 저장하고자 한다.
		 * 이 값을 저장하기 위해서는 어떤 자료형(data type)을 선택해야 할까?
		 * regNo라는 이름의 변수를 선언하고 자신의 주민등록번호로 초기화 하는 한 줄의 코드를 적으시오.
		 */
		 long regNo = 1111112222222L;
		 
		/* [2-3] 다음의 문장에서 리터럴, 변수, 상수, 키워드를 적으시오.
		 * 
		 * - 리터럴: 100, 100L, 3.14f
		 * - 변수: i, l
		 * - 키워드: long, int, final, float
		 * - 상수: PI
		 */
		 
		 /* [2-4] 다음 중 기본형(primitive type)이 아닌 것은?
		  * 
		  * Byte -> byte
		  */
		 
		 /* [2-5] 다음 문장들의 출력결과를 적으세요. 오류가 있는 문장의 경우, 괄호 안에 '오류' 라고 적으시오. */
		 System.out.println("1" + "2");		// -> 12
		 System.out.println(true + "");		// -> true
		 System.out.println('A' + 'B');		// -> 131
		 System.out.println('1' + 2);		// -> 51
		 System.out.println('1' + '2');		// -> 99
		 System.out.println('J' + "ava");	// -> Java
		 // System.out.println(true + null);	오류
		 
		 /* [2-6] 다음 중 키워드가 아닌 것은? (모두 고르시오)
		  * 
		  * b, c, d, e
		  */
		 
		 /* [2-7] 다음 중 변수의 이름으로 사용할 수 있는 것은? (모두 고르시오)
		  * 
		  * $ystem, If, $MAX_NUM
		  */
		 
		 /* [2-8] 참조형 변수(reference type)와 같은 크기의 기본형(primitive type)은? (모두 고르시오)
		  * 
		  * int, float
		  */
		 
		 /* [2-9] 다음 중 형변환을 생략할 수 있는 것은? (모두 고르시오)
		  * 
		  * d, e
		  */
		 
		 /* [2-10] char타입의 변수에 저장될 수 있는 정수 값의 범위는?(10진수로 적으시오)
		  * 
		  * 0 ~ 65535
		  * 
		  * char는 2 byte (2 * 8 = 16 bit)이므로 ‘2의 16제곱' 개의 값을 표현할 수 있다.
		  * 2의 16제곱은 65536개이며, 0을 포함해야하므로 0~65535(모두 65536개)가 char범위가 된다.
		  */
		 
		 /* [2-11] 다음 중 변수를 잘못 초기화 한 것은? (모두 고르시오)
		  * 
		  * a. byte b = 256; 		// byte (-128~127) . 의 범위 를 넘는 값으로 초기화 할 수 없음
		  * b. char c = ''; 		// char는 반드시 한 개의 문자를 지정해야함
		  * c. char answer = 'no';  // char . 에 두 개의 문자를 저장할 수 없음
		  * d. float f = 3.14 		// 3.14 3.14d . f 는 의 생략된 형태 접미사 를 붙이거나 형변환 필요
		  */
		 
		 /* [2-12] 다음 중 main메서드의 선언부로 알맞은 것은? (모두 고르시오)
		  * 
		  * a. public static void main(String[] args)
		  * b. public static void main(String args[])
		  * c. public static void main(String[] arv) 	// args 매개변수 의 이름은 달라도 됨
		  * e. static public void main(String[] args)   // public static 과 은 위치가 바뀌어도 됨
		  */
		 
		 /* [2-13] 다음 중 타입과 기본값이 잘못 연결된 것은? (모두 고르시오)
		  *
		  * c. float - 0.0 	  // float 0.0f . 0.0 0.0d d 는 가 기본값 은 에서 접미사 가 생략된 것
		  * e. long - 0       // long 0L . 은 이 기본값
		  * f. String - "" 	  // String . null
		  */
		 
		 

	}

}
