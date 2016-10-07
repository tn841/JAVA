
public class Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 산술연산자
		 * -형태 +,-,*,/,%,>>,<<
		*/
		
		int a=1;
		int b=2;
		float result=0;
		
		result=a+b;
		System.out.println("a+b="+result);
		
		result=a-b;
		System.out.println("a-b="+result);
		
		result=a*b;
		System.out.println("a*b="+result);
		
		result=a/b;
		System.out.println("a/b="+result);
		
		result = 789%4;
		System.out.println("a%b="+result);
		
		int c= 1;
		
		result =c <<2;
		System.out.println("1<<<2="+result);
		
		int d=256;
		result= d >> 8;
		
		System.out.println("1>>8="+result);
		
		
		
	/*
	 * 관계(비교)연산자
	 * -형태: <,>,<=,>=.!=
	 * -관계연산의 결과값은 논리형 데이터이다(true, false)
	 */
		
	int e=10;
	int f=20;
	
	boolean result2;
	
	result2= e>f;
	System.out.println("10>20="+result2);
	
	result2= e<f;
	System.out.println("10<20="+result2);
	
	result2= e>=f;
	System.out.println("10>=20="+result2);
	
	result2= e<=f;
	System.out.println("10>=20="+result2);
	
	result2= e==f;
	System.out.println("10==20="+result2);
	
	result2= e!=f;
	System.out.println("10!=20="+result2);
	
	
	char c1,c2;
	c1='A';
	c2='B';
	
	result2= c1 < c2;
	System.out.println("A<B="+result2);
	
	char c3= 'A'+25;
	System.out.println("c3="+c3);
	
	/*

		논리연산자
		   - 형태:   ||(Logical OR) , && (Logical AND) ( |,& )
		   - 좌우측의항이 논리형(변수,수식,데이타)이다.
           - 결과도 논리형데이타이다.
		    ex> true || false, false && false

	*/

	Boolean b1=false;
	Boolean b2=false;
	Boolean b3=true;
	Boolean b4=true;
	Boolean result3;
	
	/*
	 * 논리합(or) 
	 */
	
	
	result3 = b1||b2;
	System.out.println("false||true="+result3);
	
	/*
	 * 논리곱(and)
	 */
	
	result3=b3||b4;
	System.out.println("false||true="+result3);
	
	int kor=90;
	
	Boolean isValid;
	isValid = (kor>=0) && (kor<=100);
	System.out.println(kor+"-->"+isValid);
	
	int eng=89;
	boolean isBgrade;
	
	isBgrade =eng>=80 && eng<90;
	System.out.println("eng b학점인가?"+isBgrade);
	
	int mat=99;
	int sci=67;
	boolean isPass = mat>=90 || sci>=90;
	System.out.println("합격???"+isPass);
	
	
	
	
	 
	 
	
	
		
		
	}

}
