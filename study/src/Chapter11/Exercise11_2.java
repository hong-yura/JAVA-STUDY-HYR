package Chapter11;

import java.util.*;
/*
 * [11-2] 다음 코드의 실행결과를 적으시오.
 */
public class Exercise11_2 {
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		list.add(3);
		list.add(6);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(7);
		
		HashSet set = new HashSet(list); // 순서유지 X, 중복 X
		TreeSet tset = new TreeSet(set); // 오름차순 정렬...(2, 3, 6, 7)
		Stack stack = new Stack(); // 새로운 stack 에 저장
		stack.addAll(tset);
		
		while(!stack.empty())
		System.out.println(stack.pop()); // stack.pop() 꺼내기
		
		/*
		 * 나의 예상 실행결과
		 * 7 2 2 2 6 3 
		 */
		
		// 정답: 7 6 3 2
	}
}
