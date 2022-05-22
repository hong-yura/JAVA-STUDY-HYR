package Chapter07;

// Exercise7_27

class Outer_27 {
	int value = 10;
	
	class Inner {
		int value = 20;
		void method1() {
			int value = 30;
			
			System.out.println(value);
			System.out.println(this.value);
			System.out.println(Outer_27.this.value);
		}
	} // Inner클래스의 끝
} // Outer클래스의 끝

public class Exercise7_27 {
	public static void main(String[] args) { 
		/* (4) 알맞은 코드를 넣어 완성하시오. */
		Outer_27 o_27 = new Outer_27();
		Outer_27.Inner inner = o_27.new Inner();
		
		inner.method1();
	}
}
