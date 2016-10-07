
public class WhileNested {

	public static void main(String[] args) {
		/*
		¡Ú¡Ú¡Ú¡Ú¡Ú
		¡Ú¡Ú¡Ú¡Ú¡Ú
		¡Ú¡Ú¡Ú¡Ú¡Ú
		¡Ú¡Ú¡Ú¡Ú¡Ú
		¡Ú¡Ú¡Ú¡Ú¡Ú
		*/
		System.out.println("------------------");
		/*
		int j=0;
		while(j < 5){
			System.out.print("¡Ú");
			j++;
		}
		*/
		System.out.println();
		System.out.println("------------------");
		
		int i=0;
		while(i<5){
			int j=0;
			while(j < 5){
				System.out.print("¡Ú["+i+","+j+"]");
				j++;
			}
			System.out.println();
			i++;
		}
		
		
		
	}

}
