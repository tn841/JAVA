import java.io.IOException;

public class ExceptionThrowMechanismMain {

	public static void main(String[] args) throws IOException {
		First first = new First();
		System.out.println("메인스레드 호출");
		first.first();
		System.out.println("메인스레드 반환");
	}

}
