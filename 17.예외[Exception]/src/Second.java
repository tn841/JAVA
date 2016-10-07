import java.io.IOException;

public class Second {
	public void second() throws IOException{	
		System.out.println("\t\tSecond.second() 실행");
		Third third = new Third();
		third.third();
		System.out.println("\t\tSecond.second() 반환");
		return;
	}
}
