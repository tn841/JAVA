
public class WhileUse {

	public static void main(String[] args) {

		
		/*
		 * ���ĺ� �빮����� 
		 */

		char c = 'A';
		while (c <= 'Z') {
			System.out.print(c);
			System.out.print(" ");
			if( (int)c % 5 ==4){
				System.out.println();
			}
			c++;
		}
		/*
		 << QUIZ : ���ĺ� �빮����� >> 
		 A B C D E
		 F G H I J
		 K L M..
		 */
		System.out.println();
		System.out.println();
		/*
		 * �ѱ����
		 */
		char hg='��';
		while(hg <= '�R'){
			System.out.print(hg+" ");
			if( (int)hg % 15 == 6){
				System.out.println();
			}
			hg++;
		}
		
		
	}//end main

}//end class
