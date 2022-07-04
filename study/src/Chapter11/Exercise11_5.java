package Chapter11;

import java.util.*;

/*
 * [11-5] 다음에 제시된 Student클래스가 Comparable인터페이스를 구현하도록 변경해서 이름(name)이 기본 정렬기준이 되도록 하시오.
 */
class Student1 implements Comparable {
	String name; 
	int ban;
	int no;
	int kor, eng, math;
	
	Student1(String name, int ban, int no, int kor, int eng, int math) {
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
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage();
	}
	
	public int compareTo(Object o) {
		Student1 stuName = (Student1)o;
		if(name.compareTo(stuName.name) > 0) { // 자기 자신과 비교
			return 1;
		} else if (name.compareTo(stuName.name) < 0){
			return -1;
		} return 0;
	}
}

class Exercise11_5 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student1("홍길동", 1, 1, 100, 100, 100)); 
		list.add(new Student1("남궁성", 1, 2, 90, 70, 80)); 
		list.add(new Student1("김자바", 1, 3, 80, 80, 90)); 
		list.add(new Student1("이자바", 1, 4, 70, 90, 70)); 
		list.add(new Student1("안자바", 1, 5, 60, 100, 80)); 
		
		Collections.sort(list);
		Iterator it = list.iterator();
		
		while(it.hasNext())
		System.out.println(it.next());
	}
}
