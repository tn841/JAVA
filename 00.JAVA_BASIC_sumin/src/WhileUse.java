
public class WhileUse {

	public static void main(String[] args) {

		
		/*
		 * 알파벳 대문자출력 
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
		 << QUIZ : 알파벳 대문자출력 >> 
		 A B C D E
		 F G H I J
		 K L M..
		 */
		System.out.println();
		System.out.println();
		/*
		 * 한글출력
		 */
		char hg='가';
		while(hg <= '힣'){
			System.out.print(hg+" ");
			if( (int)hg % 15 == 6){
				System.out.println();
			}
			hg++;
		}
		
		
	}//end main

}//end class
