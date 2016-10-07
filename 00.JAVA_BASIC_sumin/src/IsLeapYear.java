
public class IsLeapYear {

	public static void main(String[] args) {
		/*
		 * 윤년여부 판단후 출력하시요(true,false)
		 * ① 서력 기원 연수가 4로 나누어 떨어지는 해는 우선 윤년으로 하고, 
		 * ② 그 중에서 100으로 나누어 떨어지는 해는 평년으로 하며, 
		 * ③ 다만 400으로 나누어 떨어지는 해는 다시 윤년으로 정하였다.
		 */
		
		int year=2016;
		
		boolean condition1 = year%4 == 0;	//4로 나누어 떨어지는가?
		boolean condition2 = (year%100 != 0) || (year%400 == 0);	//100으로 나누어 떨어지지 않거나 또는 400으로 나누어 떨어지는가?
		boolean isLeapYear=false;
		
		isLeapYear = condition1 && condition2;
		

		System.out.println("4로 나누어 떨어지는가? : "+ condition1);
		System.out.println("100으로 나누어 떨어지지 않거나 또는 400으로 나누어 떨어지는가? : "+ condition2);		
		
		System.out.println(year +" 는 윤년인가요? "+ isLeapYear);
	}

}
