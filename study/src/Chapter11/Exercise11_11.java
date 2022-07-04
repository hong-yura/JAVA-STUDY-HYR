package Chapter11;

import java.util.*;
/*
 * [11-11] 다음은 SutdaCard클래스를 HashSet에 저장하고 출력하는 예제이다.
 * HashSet에 중복된 카드가 저장되지 않도록 SutdaCard의 hashCode()를 알맞게 오버라이딩하시오.
 */
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
	
	public String toString() {
		return num + ( isKwang ? "K":"");
	}

	@Override
	public int hashCode() {
		return Objects.hash(num, isKwang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SutdaCard other = (SutdaCard) obj;
		return isKwang == other.isKwang && num == other.num;
	}
	
//	public int hashCode() {
//		return toString().hashCode(); // String 클래스의 hashCode()를 호출한다.
//	}

}


class Exercise11_11 {
	public static void main(String[] args) {
		SutdaCard c1 = new SutdaCard(3, true);
		SutdaCard c2 = new SutdaCard(3, true);
		SutdaCard c3 = new SutdaCard(1, true);
		
		HashSet set = new HashSet();
		set.add(c1);
		set.add(c2);
		set.add(c3);
		
		System.out.println(set);
	}
}
