
public class InterfaceABImpleMain {

	public static void main(String[] args) {
		InterfaceABImpl abImpl = new InterfaceABImpl();
		abImpl.method1();
		abImpl.method2();
		abImpl.method3();
		abImpl.method4();
		abImpl.method5();
		abImpl.method6();
		
		Object obj = (Object)abImpl;	//����Ŭ������ ĳ����
		System.out.println(obj.toString());
		
		InterfaceA ia; //�������̽��� Ÿ�Լ����� �����ϴ�.
		ia = abImpl;	//�Ͻ��� ĳ����
		ia.method1();
		ia.method2();
		
		InterfaceB ib = abImpl;
		ib.method3();
		ib.method4();
		
		System.out.println("---- InterfaceA <-> InterfaceB ----");
		InterfaceA ia1 = new InterfaceABImpl();	//method1,2�� ���� �ִ�.
		
		InterfaceB ib1 = (InterfaceB)ia1;	//���� ����ȯ.. ������ method3,4�� ���� �ִ�.
		
		System.out.println("-----------Array-----------");
		InterfaceA[] iaa = new InterfaceA[2];
		InterfaceB[] iba = new InterfaceB[2];
		
		iaa[0] = new InterfaceABImpl();
		iaa[1] = new InterfaceABImpl();
		
		iba[0] = new InterfaceABImpl();
		iba[1] = new InterfaceABImpl();
		
		for (int i = 0; i < iaa.length; i++) {
			System.out.println(iaa[i]);
		}
		
		
	}

}
