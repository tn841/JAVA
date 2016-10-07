/*
 배열타입:  
      - 같은데이타형을 가진 변수(기억장소) 여러개의 모음타입 
      - 배열타입변수의 선언형식
           데이타타입[] 이름; 
	  - 사용: 
	       1.배열타입 객체의생성	
		   2.배열객체의 초기화 
      -특징   
		  1.모든 배열형의 변수는 참조변수이다.
		    (배열은 객체다.)
		  2.같은타입만 정의가가능하다 
		  3.길이가 고정되어있다. 
		 
 */
public class ArrayMain {

	public static void main(String[] args) {
		/*
		 * primitive type (기본형 타입) 
		 */
		int a;
		a=8080;
		/*
		 * primitive 배열type(기본형배열 타입)
		 */
		int[] ia;
		ia = new int[5]; 
		//ia.0 = 1;
		ia[0] = 1;
		ia[1] = 2;
		ia[2] = 3;
		ia[3] = 4;
		ia[4] = 5;
		System.out.println("----------------");
		System.out.println(ia[0]);
		System.out.println(ia[1]);
		System.out.println(ia[2]);
		System.out.println(ia[3]);
		System.out.println(ia[4]);
		
		System.out.println("----------------");
		for (int i = 0; i < 5; i++) {
			System.out.println("ia["+i+"]="+ia[i]);
		}
		System.out.println("------array.length------");
		System.out.println("ia.length = "+ia.length);
		/*
		The final field array.length cannot be assigned
		 */
		//ia.length=8;
		for (int i = 0; i < ia.length; i++) {
			System.out.println("ia["+i+"]="+ia[i]);
		}
		/*
		 에러: ArrayIndexOutOfBoundsException 
		 */
		//ia[5] = 99;
		
		System.out.println("------기본형 1차원배열------");
		int[] korArray =new int[10];
		System.out.println(">>자동초기화");
		for (int i = 0; i < korArray.length; i++) {
			System.out.print(korArray[i]);
			if(i != korArray.length-1){
				System.out.print(",");
			}
		}
		System.out.println();
		korArray[0]=89;
		korArray[1]=45;
		korArray[2]=23;
		korArray[3]=78;
		korArray[4]=90;
		korArray[5]=81;
		korArray[6]=40;
		korArray[7]=99;
		korArray[8]=69;
		korArray[9]=34;
		for (int i = 0; i < korArray.length; i++) {
			System.out.print(korArray[i]+" ");
		}
		System.out.println();
		
		System.out.println(">>국어점수 총점,평균:");
		
		
		System.out.println("-----------char array-----------");
		char[] chArr = new char[6];
		chArr[0] = 'H';
		chArr[1] = 'e';
		chArr[2] = 'l';
		chArr[3] = 'l';
		chArr[4] = 'o';
		chArr[5] = '!';
		for(int i=0; i<chArr.length; i++){
			System.out.print(chArr[i]);
		}
		System.out.println();
		System.out.println("-----------array Initialization-----------");
		char[] chArr2 = {'h','e','l','l','o','!','\0'};
		for(int i=0; i<chArr2.length; i++){
			System.out.print(chArr2[i]);
		}
		
		
	}

}












