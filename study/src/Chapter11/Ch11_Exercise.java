package Chapter11;

public class Ch11_Exercise {
	public static void main(String[] args) {
		
		/* [11-3]
		 * 다음 중 ArrayList에서 제일 비용이 많이 드는 작업은?
		 * 단, 작업도중에 ArrayList의 크기 변경이 발생하지 않는다고 가정한다.
		 * 
		 *  정답: a
		 *  ArrayList는 배열을 기반으로 하고, 배열은 크기를 변경할 수 없기 때문에
		 *  저장할 공간이 부족하면 새로운 배열을 만들고 내용을 복사해야하므로 많은 비용이 든다.
		 */
		
		/* [11-4] 
		 * LinkedList 클래스는 이름과 달리 실제로는 이중 원형 연결리스트(doubly circular linked list)로 구현되어 있다.
		 * LinkedList 인스턴스를 생성하고 11개의 요소를 추가했을 때, 이 11개의 요소 중
		 * 접근시간(access time)이 가장 오래 걸리는 요소는 몇 번째 요소인가?
		 *  - 답: 가운데 위치한 요소..
		 *  - 이유: 요소들이 서로 참조값으로 연결되어 있고, 첫 번째와 마지막 요소가 연결되어 있다.. 따라서 가장 오래 걸리는 요소는 가운데..
		 */
		
		
	}
}
