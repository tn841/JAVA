
public class IfUse {

	public static void main(String[] args) {
		/*
		 * Ȧ��¦���Ǻ�
		 */
		int number = 23;

		if (number % 2 == 0) {
			System.out.println(number + " �� ¦���Դϴ�.");
		} else {
			System.out.println(number + " �� Ȧ���Դϴ�.");
		}
		/*
		 * ������ ��ȿ���Ǵ�(0~100)
		 */
		int korScore = 200;
		String msg = "";
		if (korScore >= 0 && korScore <= 100) {
			msg = korScore + " �� ��ȿ�� �����Դϴ�. ";
		} else {
			msg = korScore + " �� ��ȿ�� ������ �ƴմϴ�. ";
		}
		System.out.println(msg);

		/*
		 * 4�ǹ�������Ǵ�
		 */
		int number2 = 40;
		if ((number2 % 4) == 0) {
			System.out.println(number2 + "�� 4�� ����Դϴ�.");
		}

		/*
		 * ���⿩���Ǵ�
		 */
		int year = 2017;
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println(year + " �� �����Դϴ�");
		} else {
			System.out.println(year + " �� ����Դϴ�");
		}
		/*
		 * �ԷµǴ¹��� �Ǻ�
		 */
		char c = '�R';

		System.out.println("A = " + (int) 'A');
		System.out.println("Z = " + (int) 'Z');
		System.out.println("a = " + (int) 'a');
		System.out.println("z = " + (int) 'z');
		System.out.println("�� = " + (int) '��');
		System.out.println("�R = " + (int) '�R');
		System.out.println("�� = " + (int) '��');
		System.out.println("�� = " + (int) '��');
		System.out.println("0 = " + (int) '0');
		System.out.println("9 = " + (int) '9');

		if (c >= 'A' && c <= 'Z') {
			System.out.println("�빮���Դϴ�.");
		}
		if (c >= 'a' && c <= 'z') {
			System.out.println("�ҹ����Դϴ�.");
		}
		if (c >= '��' && c <= '�R') {
			System.out.println("�ѱ��Դϴ�.");
		}
		if (c >= '0' && c <= '9') {
			System.out.println("�����Դϴ�.");
		}

	}

}
