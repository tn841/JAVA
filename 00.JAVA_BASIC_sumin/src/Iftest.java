import java.util.Scanner;

/**
 * ��� 1. if �� -���� : stmt0; if(���ǹ� ){ //���ǹ� --> ��������Ÿ�� ��ȯ�Ǵ� ���� // Ȥ�� ����
 * ������(���) stmt1; }else{ stmt2; } stmt3;
 * 
 * ���ǵ���Ÿ�� true�ΰ�� stmt0-->stmt1-->stmt3; ���ǵ���Ÿ�� false�ΰ�� stmt0-->stmt2-->stmt3;
 * 
 * 
 */

public class Iftest {

	public static void main(String[] args) { // ����(��) ������� �⺻������ ���� �޼ҵ带 ã�Ƽ�
												// ��ɹ��� �����Ѵ�.
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
