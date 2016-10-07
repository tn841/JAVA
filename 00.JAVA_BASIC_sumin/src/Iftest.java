import java.util.Scanner;

/**
 * 제어문 1. if 문 -형식 : stmt0; if(조건문 ){ //조건문 --> 논리형데이타가 반환되는 연산 // 혹은 논리형
 * 데이터(상수) stmt1; }else{ stmt2; } stmt3;
 * 
 * 조건데이타가 true인경우 stmt0-->stmt1-->stmt3; 조건데이타가 false인경우 stmt0-->stmt2-->stmt3;
 * 
 * 
 */

public class Iftest {

	public static void main(String[] args) { // 메인(주) 쓰레드는 기본적으로 메인 메소드를 찾아서
												// 명령문을 시작한다.
		// Scanner sc = new Scanner(System.in);

		System.out.println("stmt0");

		if (true) {
			System.out.println("stmt1-1");
		} else {
			System.out.println("stmt1-2");
		}

		if (false) {
			System.out.println("stmt2-1");
		} else {
			System.out.println("stmt2-2");
		}

		boolean condition = false;

		if (condition) {
			System.out.println("stmt3-1");
		} else {
			System.out.println("stmt3-2");
		}

		int x = 21;
		int y = 30;

		if (x > y) {
			System.out.println("stmt4-1: 12 > 30");
		} else {
			System.out.println("stmt4-2: 12 <= 30");
		}
		if (x < y) {
			System.out.println("stmt5-1: 21 < 30");
		} else {
			System.out.println("stmt5-2: 21 >= 30");
		}

		if (x == y) {
			System.out.println("stmt6: 21==30 ");
		}

		if (x != y) {
			System.out.println("stmt7: 21!=30 ");
		}

		if (x > y)
			System.out.println("stmt8: 21 > 30");
		System.out.println("stmt9: 21 > 30");

		System.out.println((int) (Math.random() * 10));

		System.out.println("stmt99");

	}

}
