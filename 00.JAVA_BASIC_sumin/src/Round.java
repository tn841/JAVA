
public class Round {
	public static void main(String[] args) {
		double avg = 85.56214;
		/*
		 * 다음데이타를 소수점2자리까지만 표시하시요(3째자리에서반올림)
		 * casting이용
		 */
		System.out.println("주어진 값:"+avg);
		double t1 = avg*100;
		t1 = t1 + 0.5;
		int t2 = (int)t1;
		double t3 = t2/100.0;
		

		System.out.println("소수점2자리까지 표시한 결과:"+t3);

		

		
	}
}
