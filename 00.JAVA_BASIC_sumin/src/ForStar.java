
public class ForStar {

	public static void main(String[] args) {
		/*
		¡Ú¡Ú¡Ú¡Ú¡Ú
		¡Ú¡Ú¡Ú¡Ú¡Ú
		¡Ú¡Ú¡Ú¡Ú¡Ú
		¡Ú¡Ú¡Ú¡Ú¡Ú
		¡Ú¡Ú¡Ú¡Ú¡Ú
		*/
		System.out.println("1.------------------------------");	
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				System.out.print("¡Ú["+i+","+j+"]");
			}
			System.out.println();
		}
		System.out.println();
		
		
		
		
		
		/*
		¡Ù¡Ú¡Ú¡Ú¡Ú
		¡Ú¡Ù¡Ú¡Ú¡Ú
		¡Ú¡Ú¡Ù¡Ú¡Ú
		¡Ú¡Ú¡Ú¡Ù¡Ú
		¡Ú¡Ú¡Ú¡Ú¡Ù
		*/
		System.out.println("2.------------------------------");	
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(i==j){
					System.out.print("¡Ù");
				}
				else{
				System.out.print("¡Ú");
				}
			}
			System.out.println();
		}
		System.out.println();
		
		
		
		
		
		/*
		¡Ú
		¡Ú¡Ú
		¡Ú¡Ú¡Ú
		¡Ú¡Ú¡Ú¡Ú
		¡Ú¡Ú¡Ú¡Ú¡Ú
		*/
		System.out.println("3.------------------------------");	
		for(int i=0;i<5;i++){
			for(int j=4-i;j<5;j++){
				System.out.print("¡Ú");
			}
			System.out.println();
		}
		System.out.println();
		
		
		
		/*
		¡Ú¡Ú¡Ú¡Ú¡Ú
		¡Ú¡Ú¡Ú¡Ú
		¡Ú¡Ú¡Ú
		¡Ú¡Ú
		¡Ú
		*/
		System.out.println("4.------------------------------");	
		for(int i=0;i<5;i++){
			for(int j=0;j<5-i;j++){
				System.out.print("¡Ú");
			}
			System.out.println();
		}
		System.out.println();
		
		
		
		/*
		¡Ú¡Ú¡Ú¡Ú¡Ú
		¡Ù¡Ú¡Ú¡Ú¡Ú
		¡Ù¡Ù¡Ú¡Ú¡Ú
		¡Ù¡Ù¡Ù¡Ú¡Ú
		¡Ù¡Ù¡Ù¡Ù¡Ú
	    */
		System.out.println("5.------------------------------");	
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(i>j){
					System.out.print("¡Ù");
				}
				else{
					System.out.print("¡Ú");
				}
			}
			System.out.println();
		}

	}//main

}
