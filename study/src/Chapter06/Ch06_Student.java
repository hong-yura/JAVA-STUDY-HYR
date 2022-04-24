package Chapter06;

public class Ch06_Student {

	public static void main(String[] args) {
		Student s = new Student("홍길동", 1, 1, 100, 60, 76);

		System.out.println("이름 : " + s.name);
		System.out.println("총점 : " + s.getTotal());
		System.out.println("평균 : " + s.getAverage());
		
		
		System.out.println(s.info());

		
	}

}

class Student {
	String name; // 학생 이름
	int ban;     // 반
	int no;      // 번호
	int kor;     // 국어 점수
	int eng;     // 영어 점수
	int math;    // 수학 점수
	
	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String info() {
		String info = name + ", " + ban + ", " + no + ", "
				+ kor + ", " + eng + ", " + math + ", "
				+ getTotal() + ", " + getAverage();
		return info;
	}

	public int getTotal() {
		int total = kor + eng + math;
		return total;
	}
	
	public String getAverage() {
		String average = String.format("%.1f", (float)getTotal() / 3);
		return average;
	}
}