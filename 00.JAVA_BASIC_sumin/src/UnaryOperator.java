
public class UnaryOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*
		 * 단항연산
		 */
		
		int a=10;
		
		int result =+a;
		
		System.out.println("+10="+result);
		result= -a;
		System.out.println("-10="+result);
		
		int b=1;
		result= ~b;
		System.out.println("~b="+Integer.toBinaryString(result));
		
		Boolean myTurn=true;
		System.out.println("myTurn"+myTurn);
		myTurn = !myTurn;
		System.out.println("myTurn"+myTurn);
		
		/*
		 * 증감 감소 연산자 (-- ++ )
		 */
		 
		 int i=5;
		 int j=5;
		 System.out.println(i);
		 System.out.println(i++);
		 System.out.println(++i);
		 System.out.println(i++);
		 
		 
		 
		
		
		
		
	}

}
