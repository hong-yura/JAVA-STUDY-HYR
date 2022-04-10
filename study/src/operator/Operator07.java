package operator;

// 3-7 화씨 -> 섭씨 변환
// C = 5 / 9 × (F - 32)
public class Operator07 {

	public static void main(String[] args) {
		int fahrenheit = 100;
		float celcius = (int)((float)5 / 9 * (fahrenheit - 32) * 100 + 0.5) / 100f;

		System.out.println("Fahrenheit : " + fahrenheit);
		System.out.println("Celcius : " + celcius);
	}

}
