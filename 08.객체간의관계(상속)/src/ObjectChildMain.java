
public class ObjectChildMain {

	public static void main(String[] args) {
		ObjectChild oc = new ObjectChild();
		String str = oc.toString();
		System.out.println(str);
		
		int hashCode = oc.hashCode();
		System.out.println(hashCode);
		
		Object ob;
	}

}
