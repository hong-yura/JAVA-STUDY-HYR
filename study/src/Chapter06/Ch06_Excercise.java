package Chapter06;

// Chapter06 객체지향1 연습문제 풀이
public class Ch06_Excercise {
	
	/* [6-8] 다음의 코드에 정의된 변수들을 종류별로 구분해서 적으시오.
	 * - 클래스 변수(static 변수) : kind, num, width, height	// width, height
	 * - 인스턴스 변수 : k, n									// kind, num
	 * - 지역 변수 : card										// k, n, card, args
	 */
	
	/* [6-9] 다음은 컴퓨터 게임의 병사 (marine)를 클래스로 정의한 것이다.
	 * 이 클래스의 멤버 중에 static을 붙여야 하는 것은 어떤 것들이고 그 이유는 무엇인가?
	 * (단, 모든 병사의 공격력과 방어력은 같아야 한다.)
	 * 
	 * - weapon, armor
	 * - 클래스 전체에서 공유되어야 할 변수이기 때문에..?
	 * 
	 * // 정답 
	 * 	weapon, armor - 모든 Marine인스턴스에 대해 동일한 값이어야 하므로.
	 *  weaponUp(), armorUp() - static변수에 대한 작업을 하는 메서드이므로.
	 */
	
	/*
	 * [6-18] 다음의 코드를 컴파일하면 에러가 발생한다. 컴파일 에러가 발생하는 라인과 그 이유를 설명하시오.
	 * 라인 A : 
	 * 라인 B : 
	 * 라인 D : 
	 */
	
	/*
	 * [6-19] 다음 코드의 실행 결과를 예측하여 적으시오.
	 * ABC123
	 * After change: ABC123456	// 정답: After change: ABC123
	 */
}
