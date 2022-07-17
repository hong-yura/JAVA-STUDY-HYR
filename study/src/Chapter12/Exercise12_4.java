package Chapter12;

import java.util.ArrayList;

/* [12-4]
 * 아래의 메서드는 두 개의 ArrayList를 매개변수로 받아서, 하나의 새로운 ArrayList로 병합하는 메서드이다.
 * 이를 지네릭 메서드로 변경하시오.
 */
public class Exercise12_4 {
	
	public static <T extends Product> merge(ArrayList<T> list, ArrayList<T> list2) {
			ArrayList<T> newList = new ArrayList<T>(list);
			
			newList.addAll(list2);
			
			return newList;
	}
	
}
