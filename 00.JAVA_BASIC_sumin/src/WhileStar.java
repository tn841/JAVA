
public class WhileStar {

	public static void main(String[] args) {
	/*
	¡Ú¡Ú¡Ú¡Ú¡Ú
	¡Ú¡Ú¡Ú¡Ú¡Ú
	¡Ú¡Ú¡Ú¡Ú¡Ú
	¡Ú¡Ú¡Ú¡Ú¡Ú
	¡Ú¡Ú¡Ú¡Ú¡Ú
	*/
	System.out.println("1.-------------------");
	int i=0;
	while(i<5){
		int j=0;
		while(j<5){
			System.out.print("¡Ú["+i+","+j+"]");
			j++;
		}
		System.out.println();
		i++;
	}
	System.out.println();
	
	
	
	
	
	
	/*
	¡Ù¡Ú¡Ú¡Ú¡Ú
	¡Ú¡Ù¡Ú¡Ú¡Ú
	¡Ú¡Ú¡Ù¡Ú¡Ú
	¡Ú¡Ú¡Ú¡Ù¡Ú
	¡Ú¡Ú¡Ú¡Ú¡Ù
	*/
	System.out.println("2.-------------------");
	i=0;
	while(i<5){
		int j=0;
		while(j<5){
			
			if(i==j){
				System.out.print("¡Ù["+i+","+j+"]");
			}
			else{
				System.out.print("¡Ú["+i+","+j+"]");
			}
			
			j++;
		}
		System.out.println();
		i++;
	}
	System.out.println();
	
	/*
	¡Ú
	¡Ú¡Ú
	¡Ú¡Ú¡Ú
	¡Ú¡Ú¡Ú¡Ú
	¡Ú¡Ú¡Ú¡Ú¡Ú
	*/
	System.out.println("3.-------------------");
	i=0;
	while(i<5){
		int j=0;
		
		while(j<i+1){
			System.out.print("¡Ú");
			j++;
		}
		
		System.out.println();
		i++;
	}
	System.out.println();
	
	
	
	
	/*
	¡Ú¡Ú¡Ú¡Ú¡Ú
	¡Ú¡Ú¡Ú¡Ú
	¡Ú¡Ú¡Ú
	¡Ú¡Ú
	¡Ú
	*/
	System.out.println("4.-------------------");
	i=0;
	while(i<5){
		int j=0;
		
		while(j<5-i){
			System.out.print("¡Ú");
			j++;
		}
		
		System.out.println();
		i++;
	}
	System.out.println();
	
	
	
	
	/*
	¡Ú¡Ú¡Ú¡Ú¡Ú
	  ¡Ú¡Ú¡Ú¡Ú
	    ¡Ú¡Ú¡Ú
	      ¡Ú¡Ú
	        ¡Ú
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
				System.out.print("¡Ú");
			}
			j++;
		}
		
		System.out.println();
		i++;
	}
	System.out.println();

	}

}
