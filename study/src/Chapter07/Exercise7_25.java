package Chapter07;

// Exercise7_25
class Outer {
	class Inner {
		int iv=100;
	}
}

public class Exercise7_25 {
	public static void main(String[] args) {
		Outer o = new Outer();
		Outer.Inner oi = o.new Inner();
		System.out.println(oi.iv);
	}
}
