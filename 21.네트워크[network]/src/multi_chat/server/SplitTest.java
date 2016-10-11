package multi_chat.server;

public class SplitTest {

	public static void main(String[] args) {
		String data = "0:¿Ö¿Û¿Ö¿Ö?";
		String[] strArr = data.split(":");
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		
	}

}
