package Chapter11;

import java.util.*;
/*
 * [11-9] 문제 11-8의 Student클래스에 반등수(classRank)를 저장하기 위한 인스턴스변수를 추가하였다.
 * 반등수를 계산하고 반과 반등수로 오름차순 정렬하여 결과를 출력하시오.
 */
class Student9 implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	int total; // 총점
	int schoolRank; // 전교등수
	int classRank; // 반등수	
	
	Student9(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		total = kor + eng + math;
	}
	
	int getTotal() {
		return total;
	}

	float getAverage() {
		return (int)((getTotal() / 3f) * 10 + 0.5) / 10f;
	}

	public int compareTo(Object o) { // 총점으로 정렬
		if(o instanceof Student9) {
			Student9 tmp = (Student9)o;
			return tmp.total - this.total;
		} else {
			return -1;
		}
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
			+ ", " + schoolRank
			+ ", " + classRank // 새로추가
			;
	}
} // class Student
	
class ClassTotalComparator implements Comparator {
	public int compare(Object o1, Object o2) {
	// 반과 반등수로 오름차순 정렬
		
		if(o1 instanceof Student9 && o2 instanceof Student9) {
			Student9 s1 = (Student9)o1;
			Student9 s2 = (Student9)o2;
			int result = s1.ban - s2.ban;
			
			if(result == 0) {
				return s1.classRank - s2.classRank; // 반등수로 비교한 오름차순 정렬
			}
			return result; // 반으로 비교한 오름차순 정렬
		}
		return -1;
		
	}
}

class Exercise11_9 {
	public static void calculateClassRank(List list) {
		// 먼저 반별 총점기준 내림차순으로 정렬한다.
		Collections.sort(list, new ClassTotalComparator());
		
		int prevBan = -1;
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();
		
		/*
		 	1. 반복문을 이용해서 list에 저장된 Student객체를 하나씩 읽는다.
		 		1.1 반이 달라지면,(ban과 prevBan이 다르면) 이전 등수(prevRank)와 이전 총점(prevTotal)을 초기화한다.
		 		1.2 총점(total)이 이전총점(prevTotal)과 같으면 이전 등수(prevRank)를 등수(classRank)로 한다.
		 		1.3 총점이 서로 다르면, 등수(classRank)의 값을 알맞게 계산해서 저장한다.
		 			이전에 동점자였다면, 그 다음 등수는 동점자의 수를 고려해야 한다.
		 			(실행결과 참고)
		 		1.4 현재 반과 총점과 등수를 이전 반(prevBan), 이전 총점(prevTotal), 이전 등수(prevRank)에 저장한다.
		 */
		int n = 0;
		for(int i = 0; i < length; i++) {
			Student9 stu = (Student9)list.get(i);
			
			if(stu.ban != prevBan) {
				prevRank = -1;
				prevTotal = -1;
				n = 0;
			}
			
			if(stu.total == prevTotal) {
				stu.classRank = prevRank;
			} else if(stu.total != prevTotal) {
				stu.classRank = n + 1; // 이전에 동점자였다면, 그 다음 등수는 동점자의 수를 고려...?
			}
			prevBan = stu.ban;
			prevTotal = stu.total;
			prevRank = stu.classRank;
			n++;
		}

	} // public static void calculateClassRank(List list) {

	public static void calculateSchoolRank(List list) {
		Collections.sort(list); // 먼저 list를 총점기준 내림차순으로 정렬한다.
		
		int prevRank = -1;  // 이전 전교등수
		int prevTotal = -1; // 이전 총점
		int length = list.size();
		
		for(int i = 0; i < length; i++) {
			Student9 stu = (Student9) list.get(i); 

			if(stu.total == prevTotal) {
				stu.schoolRank = prevRank;
			} else if(stu.total != prevTotal) {
				stu.schoolRank = i + 1; // 그 다음 등수는 동점자의 수를 고려...
			}
			prevTotal = stu.total;
			prevRank = stu.schoolRank;
		}
	}
	
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student9("이자바", 2, 1, 70, 90, 70));
		list.add(new Student9("안자바", 2, 2, 60, 100, 80)); 
		list.add(new Student9("홍길동", 1, 3, 100, 100, 100)); 
		list.add(new Student9("남궁성", 1, 1, 90, 70, 80)); 
		list.add(new Student9("김자바", 1, 2, 80, 80, 90));

		calculateSchoolRank(list);
		calculateClassRank(list);
		
		Iterator it = list.iterator();
		
		while(it.hasNext())
			System.out.println(it.next());
	}
}
