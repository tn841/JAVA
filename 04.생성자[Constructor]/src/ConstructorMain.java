
public class ConstructorMain {

	public static void main(String[] args) {
		Constructor c1 = new Constructor();
		c1.print();
		
		Constructor c2 = new Constructor(3000);
		c2.print();
		
		Constructor c3 = new Constructor(999, 555);
		c3.print();
		
		
		/*
		 * ����Ʈ ������
		 */
		DefaultConstructor dc = new DefaultConstructor();
		
		System.out.println(dc);
	}

}
