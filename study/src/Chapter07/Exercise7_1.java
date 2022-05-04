package Chapter07;

class SutdaDeck {
	
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	SutdaDeck() {
		/* 배열 SutdaCard 를 적절히 초기화 하시오. */
		for(int i = 0; i < cards.length; i++) {
			int num = i % 10 + 1;
		    boolean isKwang = i < 10 && (num == 1 || num == 3 || num == 8);
		    
		    cards[i] = new SutdaCard(num, isKwang);
		}
	}
	
	//  배열 cards 에 담긴 카드의 위치를 뒤섞는다.
	void shuffle() {
		SutdaCard tmp;
		
		for(int i = 0; i < cards.length; i++) {
			
			int j = (int)(Math.random() * cards.length);
			
			tmp = cards[i];
			cards[i] = cards[j];
			cards[j] = tmp;
			
		}
	}
	
	//  배열 cards 에서 지정된 위치의 SutdaCard 를 반환한다.
	SutdaCard pick(int index) {
		if(index < 0 || index >= CARD_NUM) { // index 의 유효성을 검사한다.
			return null;
		}
		return this.cards[index];
	}
	
	//  배열 cards 에서 임의의 위치의 SutdaCard 를 반환한다.
	SutdaCard pick() {
		int index = (int)(Math.random() * cards.length);
		return this.cards[index];
	}
	
} // SutdaDeck

class SutdaCard {
	int num;
	boolean isKwang;
	
	SutdaCard() {
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	// info() 대신 Object 클래스의 toString() 을 오버라이딩 했다.
	public String toString() {
		return num + ( isKwang ? "K":"");
	}
}

public class Exercise7_1 {

	public static void main(String[] args) {
		
		SutdaDeck deck = new SutdaDeck();
		
		System.out.println(deck.pick(0));
		System.out.println(deck.pick());
		deck.shuffle();
		
		for(int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i] + ", ");	
		}
		
		System.out.println();
		System.out.println(deck.pick(0));
	}

}
