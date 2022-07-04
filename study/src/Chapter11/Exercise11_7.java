package Chapter11;

import java.util.*;
/*
 * [11-7] 다음에 제시된 BanNoAscending클래스를 완성하여, ArrayList에 담긴
 * Student 인스턴스들이 반(ban)과 번호(no)로 오름차순 정렬되게 하시오.
 * (반이 같은 경우 번호를 비교해서 정렬한다.)
 */
class Student3 {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	Student3(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	int getTotal() {
		return kor + eng + math;
	}
	
	float getAverage() {
		return (int)((getTotal() / 3f) * 10 + 0.5) / 10f;
	}
	
	public String toString() {
		return name
			+ ", " + ban
			+ ", " + no
			+ ", " + kor
			+ ", " + eng
			+ ", " + math
			+ ", " + getTotal()
			+ ", " + getAverage()
			;
	}
	
} // class Student3

class BanNoAscending implements Comparator {
	public int compare(Object o1, Object o2) {
	// 알맞은 코드를 넣어 완성하시오.

		if(o1 instanceof Student3 && o2 instanceof Student3) {
			Student3 s1 = (Student3)o1;
			Student3 s2 = (Student3)o2;
			int result = s1.ban - s2.ban;
			
			if(result == 0) {
				return s1.no - s2.no; // 번호로 비교한 오름차순 정렬
			}
			return result; // 반으로 비교한 오름차순 정렬
		}
		return -1;

	}
}

class Exercise11_7 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student3("이자바", 2, 1, 70, 90, 70));
		list.add(new Student3("안자바", 2, 2, 60, 100, 80)); 
		list.add(new Student3("홍길동", 1, 3, 100, 100, 100)); 
		list.add(new Student3("남궁성", 1, 1, 90, 70, 80)); 
		list.add(new Student3("김자바", 1, 2, 80, 80, 90));
		
		Collections.sort(list, new BanNoAscending());
		
		Iterator it = list.iterator();
		
		while(it.hasNext())
			System.out.println(it.next());
	}
}
