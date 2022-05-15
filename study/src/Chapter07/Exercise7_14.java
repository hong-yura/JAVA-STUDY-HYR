package Chapter07;

class _SutdaCard {
	private final int NUM;
	private final boolean IS_KWANG;
	
	_SutdaCard() {
		this(1, true);
	}
	
	_SutdaCard(int num, boolean isKwang) {
		this.NUM = num;
		this.IS_KWANG = isKwang;
	}
	
	public String toString() {
		return NUM + ( IS_KWANG ? "K":"");
	}
}

public class Exercise7_14 {
	public static void main(String args[]) {
		_SutdaCard card = new _SutdaCard(1, true);
	}
}
