package operator;

// 3-10
public class Operator10 {

	public static void main(String[] args) {
		char ch = 'G';
		
		char lowerCase = (char)(ch >= 65 && ch <= 90 ? ch + 32 : ch);
		
		System.out.println("ch : " + ch);
		System.out.println("ch to lowerCase : " + lowerCase);
	}

}
