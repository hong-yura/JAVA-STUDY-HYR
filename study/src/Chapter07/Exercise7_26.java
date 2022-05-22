package Chapter07;

// Exercise7_26
class Outer_26 {
	static class Inner {
		int iv = 200;
	}
}

public class Exercise7_26 {
	public static void main(String[] args) {
		Outer_26.Inner oi = new Outer_26.Inner();
		System.out.println(oi.iv);
	}
}
