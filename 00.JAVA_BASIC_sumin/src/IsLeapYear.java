
public class IsLeapYear {

	public static void main(String[] args) {
		/*
		 * ���⿩�� �Ǵ��� ����Ͻÿ�(true,false)
		 * �� ���� ��� ������ 4�� ������ �������� �ش� �켱 �������� �ϰ�, 
		 * �� �� �߿��� 100���� ������ �������� �ش� ������� �ϸ�, 
		 * �� �ٸ� 400���� ������ �������� �ش� �ٽ� �������� ���Ͽ���.
		 */
		
		int year=2016;
		
		boolean condition1 = year%4 == 0;	//4�� ������ �������°�?
		boolean condition2 = (year%100 != 0) || (year%400 == 0);	//100���� ������ �������� �ʰų� �Ǵ� 400���� ������ �������°�?
		boolean isLeapYear=false;
		
		isLeapYear = condition1 && condition2;
		

		System.out.println("4�� ������ �������°�? : "+ condition1);
		System.out.println("100���� ������ �������� �ʰų� �Ǵ� 400���� ������ �������°�? : "+ condition2);		
		
		System.out.println(year +" �� �����ΰ���? "+ isLeapYear);
	}

}
