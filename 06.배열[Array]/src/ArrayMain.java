/*
 �迭Ÿ��:  
      - ��������Ÿ���� ���� ����(������) �������� ����Ÿ�� 
      - �迭Ÿ�Ժ����� ��������
           ����ŸŸ��[] �̸�; 
	  - ���: 
	       1.�迭Ÿ�� ��ü�ǻ���	
		   2.�迭��ü�� �ʱ�ȭ 
      -Ư¡   
		  1.��� �迭���� ������ ���������̴�.
		    (�迭�� ��ü��.)
		  2.����Ÿ�Ը� ���ǰ������ϴ� 
		  3.���̰� �����Ǿ��ִ�. 
		 
 */
public class ArrayMain {

	public static void main(String[] args) {
		/*
		 * primitive type (�⺻�� Ÿ��) 
		 */
		int a;
		a=8080;
		/*
		 * primitive �迭type(�⺻���迭 Ÿ��)
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
		 ����: ArrayIndexOutOfBoundsException 
		 */
		//ia[5] = 99;
		
		System.out.println("------�⺻�� 1�����迭------");
		int[] korArray =new int[10];
		System.out.println(">>�ڵ��ʱ�ȭ");
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
		
		System.out.println(">>�������� ����,���:");
		
		
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












