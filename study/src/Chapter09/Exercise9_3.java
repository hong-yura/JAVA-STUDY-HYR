package Chapter09;

import java.util.StringTokenizer;

/*
 * [9-3] 다음과 같은 실행결과가 나오도록 코드를 완성하시오.
 */
public class Exercise9_3 {
	public static void main(String[] args) {
		String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
		String path = "";
		String fileName = "";
		
		// 알맞은 코드를 넣어 완성하시오.
		// System.out.println(fullPath.length());	// fullPath 의 길이 확인
//		path = fullPath.substring(0, 14);
//		fileName = fullPath.substring(15, 36);
		
		int pos = fullPath.lastIndexOf("\\");
		
		if(pos!=-1) {
			path = fullPath.substring(0, pos);
			fileName = fullPath.substring(pos+1);
		}
		
		System.out.println("fullPath: " + fullPath);
		System.out.println("path:" + path);
		System.out.println("fileName:" + fileName);		
	}
}
