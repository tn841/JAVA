
public class IfUse {

	public static void main(String[] args) {
		/*
		 * È¦¼öÂ¦¼öÆÇº°
		 */
		int number = 23;

		if (number % 2 == 0) {
			System.out.println(number + " ´Â Â¦¼öÀÔ´Ï´Ù.");
		} else {
			System.out.println(number + " ´Â È¦¼öÀÔ´Ï´Ù.");
		}
		/*
		 * Á¡¼öÀÇ À¯È¿¼ºÆÇ´Ü(0~100)
		 */
		int korScore = 200;
		String msg = "";
		if (korScore >= 0 && korScore <= 100) {
			msg = korScore + " ´Â À¯È¿ÇÑ Á¡¼öÀÔ´Ï´Ù. ";
		} else {
			msg = korScore + " ´Â À¯È¿ÇÑ Á¡¼ö°¡ ¾Æ´Õ´Ï´Ù. ";
		}
		System.out.println(msg);

		/*
		 * 4ÀÇ¹è¼ö¿©ºÎÆÇ´Ü
		 */
		int number2 = 40;
		if ((number2 % 4) == 0) {
			System.out.println(number2 + "Àº 4ÀÇ ¹è¼öÀÔ´Ï´Ù.");
		}

		/*
		 * À±³â¿©ºÎÆÇ´Ü
		 */
		int year = 2017;
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println(year + " ´Â À±³âÀÔ´Ï´Ù");
		} else {
			System.out.println(year + " ´Â Æò³âÀÔ´Ï´Ù");
		}
		/*
		 * ÀÔ·ÂµÇ´Â¹®ÀÚ ÆÇº°
		 */
		char c = 'ÆR';

		System.out.println("A = " + (int) 'A');
		System.out.println("Z = " + (int) 'Z');
		System.out.println("a = " + (int) 'a');
		System.out.println("z = " + (int) 'z');
		System.out.println("°¡ = " + (int) '°¡');
		System.out.println("ÆR = " + (int) 'ÆR');
		System.out.println("¤¡ = " + (int) '¤¡');
		System.out.println("¤¾ = " + (int) '¤¾');
		System.out.println("0 = " + (int) '0');
		System.out.println("9 = " + (int) '9');

		if (c >= 'A' && c <= 'Z') {
			System.out.println("´ë¹®ÀÚÀÔ´Ï´Ù.");
		}
		if (c >= 'a' && c <= 'z') {
			System.out.println("¼Ò¹®ÀÚÀÔ´Ï´Ù.");
		}
		if (c >= '°¡' && c <= 'ÆR') {
			System.out.println("ÇÑ±ÛÀÔ´Ï´Ù.");
		}
		if (c >= '0' && c <= '9') {
			System.out.println("¼ýÀÚÀÔ´Ï´Ù.");
		}

	}

}
