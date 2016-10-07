public class VariableTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 문자('박' 'A' -> 문자데이터(리터럴))
		 */
		 
		char munja1, munja2, munja3, munja4, munja5;//변수선언
		
		munja1 ='A';
		munja2 ='박';
		munja3 ='종';
		munja4 ='환';
		munja5 ='1'; // 변수 대입
		
		/*
		 숫자 
		 
		 -정수형=(34 ,67,6 --> 정수형 리터럴)
		 
		 -실수형=()
		 */
		 
		 
		byte b;
		short s;
		int i;
		long l;// 변수 타입별 선언
		
		b=127;
		s=32767;
		i=2147483647;
		l=2147483648l; //변수타입별 대입
		
		
		 //테이터의 타입이 같은경우에는 대입가능
		 		
		 int i1=1;
		 
		//byte b1= i1; <-- 변수의 타입이 다르기때문에 대입이 불가능
		
		float f= 1.14f;
		double d=1.14;
		
		
		/*
		  논리형 (논리형 데이터(리터럴) --> true, false)
		*/
		
		boolean bool1;
		boolean bool2;
		
		bool1=true;
		bool2=false;
		
		boolean bool3=bool1;
		
		
		
		
		/*
		 * 문자열
		*/
		
		 String str1, str2, result;
		 
		 str1="오늘은 변수선언에 대해 공부해요~~";
		 str2="재미겠다~~";
		 
		result= str1+str2;
		
		
		
		 
		
		System.out.println("--------------------");
		System.out.println("munja1="+munja1);
		System.out.println("munja2="+munja2);
		System.out.println("munja3="+munja3);
		System.out.println("munja4="+munja4);
		System.out.println("munja5="+munja5);
		
		System.out.println();
		
		System.out.println("b="+b);
		System.out.println("b="+Integer.toBinaryString(b));
		System.out.println("s="+s);
		System.out.println("i="+i);
		
		System.out.println();
		
		System.out.println("i1="+i1);
		System.out.println("f="+f);
		System.out.println("d="+d);
		
		System.out.println();
		
		System.out.println("str1="+str1);
		System.out.println("str2="+str2);
		System.out.println("str1+str2="+result);
		
		System.out.println();
		
		System.out.println("bool1"+bool1);
		System.out.println("bool2"+bool2);
		System.out.println("bool3"+bool3);
		
		
		
		
		System.out.println("--------------------");
		
		
		
	}

}
