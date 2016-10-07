
public class IfUse {

	public static void main(String[] args) {
		/*
		 * 홀수짝수판별
		 */
		int number = 23;

		if (number % 2 == 0) {
			System.out.println(number + " 는 짝수입니다.");
		} else {
			System.out.println(number + " 는 홀수입니다.");
		}
		/*
		 * 점수의 유효성판단(0~100)
		 */
		int korScore = 200;
		String msg = "";
		if (korScore >= 0 && korScore <= 100) {
			msg = korScore + " 는 유효한 점수입니다. ";
		} else {
			msg = korScore + " 는 유효한 점수가 아닙니다. ";
		}
		System.out.println(msg);

		/*
		 * 4의배수여부판단
		 */
		int number2 = 40;
		if ((number2 % 4) == 0) {
			System.out.println(number2 + "은 4의 배수입니다.");
		}

		/*
		 * 윤년여부판단
		 */
		int year = 2017;
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println(year + " 는 윤년입니다");
		} else {
			System.out.println(year + " 는 평년입니다");
		}
		/*
		 * 입력되는문자 판별
		 */
		char c = '힣';

		System.out.println("A = " + (int) 'A');
		System.out.println("Z = " + (int) 'Z');
		System.out.println("a = " + (int) 'a');
		System.out.println("z = " + (int) 'z');
		System.out.println("가 = " + (int) '가');
		System.out.println("힣 = " + (int) '힣');
		System.out.println("ㄱ = " + (int) 'ㄱ');
		System.out.println("ㅎ = " + (int) 'ㅎ');
		System.out.println("0 = " + (int) '0');
		System.out.println("9 = " + (int) '9');

		if (c >= 'A' && c <= 'Z') {
			System.out.println("대문자입니다.");
		}
		if (c >= 'a' && c <= 'z') {
			System.out.println("소문자입니다.");
		}
		if (c >= '가' && c <= '힣') {
			System.out.println("한글입니다.");
		}
		if (c >= '0' && c <= '9') {
			System.out.println("숫자입니다.");
		}

	}

}
