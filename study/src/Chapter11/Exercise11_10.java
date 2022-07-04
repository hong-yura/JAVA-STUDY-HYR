package Chapter11;

import java.util.*;
/*
 * [11-10] 다음 예제의 빙고판은 1~30 사이의 숫자들로 만든 것인데, 숫자들의 위치가 잘 섞이지 않는다는 문제가 있다. 
 * 이러한 문제가 발생하는 이유와 이 문제를 개선하기 위한 방법을 설명하고,
 * 이를 개선한 새로운 코드를 작성하시오.
 */

/* 
 * 문제가 발생한 이유 : HashSet 은 저장 순서를 유지하지 않고, 중복값을 허용하지 않는다.
 * 						HashSet 에 요소를 추가할 때에는 add(), addAll() 메서드를 사용하는데,
 * 						만약 이미 저장되어 있는 중복값이 있다면 이 메서드들은 false 를 반환하여 추가 실패를 알린다.
 * 						따라서 재실행 시 반복문을 통해 1~30 사이의 랜덤 숫자를 추가하는 빙고판의 숫자는 잘 섞이지 않게 된다.
 * 개선하기 위한 방법 : 이를 개선하기 위해서는 HashSet 대신 중복을 제거하는 LinkedHashSet 을 사용해야 한다.
 */
class Exercise11_10 {
	public static void main(String[] args) {
		// Set set = new HashSet();
		Set set = new LinkedHashSet();
		int[][] board = new int[5][5];
		
		for(int i = 0; set.size() < 25; i++) {
			set.add((int)(Math.random() * 30) + 1 + ""); // 1~30 사이의 랜덤 숫자 추가
		}
		
		Iterator it = set.iterator();
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt((String)it.next()); // next()는 반환값이 Object타입이므로 형변환해서 원래 타입으로 되돌려 놓아야 함.
				System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]);
			}
			System.out.println();
		}
	} // main
}
