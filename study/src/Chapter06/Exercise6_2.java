package Chapter06;

// Chapter06 객체지향 프로그래밍_1 연습문제 풀이
public class Exercise6_2 {
	
	public static void main(String[] args) {
		SutdaCard card1 = new SutdaCard(3, false);
		SutdaCard card2 = new SutdaCard();
		
		System.out.println(card1.info());
		System.out.println(card2.info());
	}
	
}

class SutdaCard {
	int num; // 카드릐 숫자(1 ~ 10 사이의 정수)
	boolean isKwang; // 광이 아니면 true, 아니면 false

	public SutdaCard() {
		this.num = 1;
		this.isKwang = true;
	}

	public SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	public String info() {
		return num + (isKwang ? "k" : "");
	}


}
