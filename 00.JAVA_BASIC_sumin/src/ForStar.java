
public class ForStar {

	public static void main(String[] args) {
		/*
		�ڡڡڡڡ�
		�ڡڡڡڡ�
		�ڡڡڡڡ�
		�ڡڡڡڡ�
		�ڡڡڡڡ�
		*/
		System.out.println("1.------------------------------");	
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				System.out.print("��["+i+","+j+"]");
			}
			System.out.println();
		}
		System.out.println();
		
		
		
		
		
		/*
		�١ڡڡڡ�
		�ڡ١ڡڡ�
		�ڡڡ١ڡ�
		�ڡڡڡ١�
		�ڡڡڡڡ�
		*/
		System.out.println("2.------------------------------");	
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(i==j){
					System.out.print("��");
				}
				else{
				System.out.print("��");
				}
			}
			System.out.println();
		}
		System.out.println();
		
		
		
		
		
		/*
		��
		�ڡ�
		�ڡڡ�
		�ڡڡڡ�
		�ڡڡڡڡ�
		*/
		System.out.println("3.------------------------------");	
		for(int i=0;i<5;i++){
			for(int j=4-i;j<5;j++){
				System.out.print("��");
			}
			System.out.println();
		}
		System.out.println();
		
		
		
		/*
		�ڡڡڡڡ�
		�ڡڡڡ�
		�ڡڡ�
		�ڡ�
		��
		*/
		System.out.println("4.------------------------------");	
		for(int i=0;i<5;i++){
			for(int j=0;j<5-i;j++){
				System.out.print("��");
			}
			System.out.println();
		}
		System.out.println();
		
		
		
		/*
		�ڡڡڡڡ�
		�١ڡڡڡ�
		�١١ڡڡ�
		�١١١ڡ�
		�١١١١�
	    */
		System.out.println("5.------------------------------");	
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(i>j){
					System.out.print("��");
				}
				else{
					System.out.print("��");
				}
			}
			System.out.println();
		}

	}//main

}
