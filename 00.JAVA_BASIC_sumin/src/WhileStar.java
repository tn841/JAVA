
public class WhileStar {

	public static void main(String[] args) {
	/*
	�ڡڡڡڡ�
	�ڡڡڡڡ�
	�ڡڡڡڡ�
	�ڡڡڡڡ�
	�ڡڡڡڡ�
	*/
	System.out.println("1.-------------------");
	int i=0;
	while(i<5){
		int j=0;
		while(j<5){
			System.out.print("��["+i+","+j+"]");
			j++;
		}
		System.out.println();
		i++;
	}
	System.out.println();
	
	
	
	
	
	
	/*
	�١ڡڡڡ�
	�ڡ١ڡڡ�
	�ڡڡ١ڡ�
	�ڡڡڡ١�
	�ڡڡڡڡ�
	*/
	System.out.println("2.-------------------");
	i=0;
	while(i<5){
		int j=0;
		while(j<5){
			
			if(i==j){
				System.out.print("��["+i+","+j+"]");
			}
			else{
				System.out.print("��["+i+","+j+"]");
			}
			
			j++;
		}
		System.out.println();
		i++;
	}
	System.out.println();
	
	/*
	��
	�ڡ�
	�ڡڡ�
	�ڡڡڡ�
	�ڡڡڡڡ�
	*/
	System.out.println("3.-------------------");
	i=0;
	while(i<5){
		int j=0;
		
		while(j<i+1){
			System.out.print("��");
			j++;
		}
		
		System.out.println();
		i++;
	}
	System.out.println();
	
	
	
	
	/*
	�ڡڡڡڡ�
	�ڡڡڡ�
	�ڡڡ�
	�ڡ�
	��
	*/
	System.out.println("4.-------------------");
	i=0;
	while(i<5){
		int j=0;
		
		while(j<5-i){
			System.out.print("��");
			j++;
		}
		
		System.out.println();
		i++;
	}
	System.out.println();
	
	
	
	
	/*
	�ڡڡڡڡ�
	  �ڡڡڡ�
	    �ڡڡ�
	      �ڡ�
	        ��
	*/
	System.out.println("5.-------------------");
	i=0;
	while(i<5){
		int j=0;
		
		while(j<5){
			if(j<i){
				System.out.print("  ");
			}
			else{
				System.out.print("��");
			}
			j++;
		}
		
		System.out.println();
		i++;
	}
	System.out.println();

	}

}
