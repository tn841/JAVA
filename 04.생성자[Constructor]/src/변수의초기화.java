
public class �������ʱ�ȭ {
	public static void main(String[] args) {
		/*
		 * local variable
		 *  - �ݵ�� �ʱ�ȭ �۾��� �Ͽ����Ѵ�.
		 *  
		 */
		System.out.println("------�⺻��-----");
		/*
		 * �⺻�� ���ͷ�(����Ÿ) 23,23.8,true,'A'
		 */
		int i;
		char c;
		double d;
		boolean b;
		/*
		 The local variable i may not have been initialized 
		 */
		i=0;
		int result = i+1;
		c='A';
		
		if(i==0){
			d=1.4;
		}else{
			d=1.5;
		}
		System.out.println(result);
		System.out.println(c);
		System.out.println(d);
		System.out.println("------������-----");
		
		Car car;
		car=new Car();
		/*
		 * ������ ���ͷ�(����Ÿ) null
		 * 
		 */
		Account account=null;
		
		
		System.out.println(car);
		System.out.println(account);
		
		car.ipCha("123", 14);
		if(account == null){
			account = new Account();
		}
		account.setAccountData("1111", "KIM", 88000, 0.05);
		account.print();
		
		
		System.out.println("==========��ü�� ��==========");
		Car car1 = new Car("8888888888", 12, 17, 5000);
		Car car2 = new Car("9999999999", 16, 17, 1000);
		Car carTemp = null;
		
		carTemp = car1;
		
		if(car1 == carTemp){
			System.out.println("car1�� carTemp �ּҰ��� ����");
		}
		
		if(car1 == car2){
			System.out.println("car1�� car2 �ּҰ��� ����");
		}
		else{
			System.out.println("car1�� car2 �ּҰ��� �ٸ�");
		}
		
	
		Car.headerPrint();
		carTemp.print();
		car1.print();
		Car.footerPrint();
	
		System.out.println("=========��ü �޸� ����=========");
		car = null;
		car1 = null;
		car2 = null;
		
		
		
		
		/*
		 * �������(instance[Ŭ������ ���� �� ��ü] ����) �ʱ�ȭ 
		 * 	- ��ü ������ �⺻������ �ڵ� �ʱ�ȭ �� (��ü�� null�� �ʱ�ȭ��)
		 */
		Ŭ���� c1 = new Ŭ����();
		System.out.println(c1.�������1);
		System.out.println(c1.�������2);
		System.out.println(c1.�������3);
		System.out.println(c1.�������4);
		System.out.println(c1.�������������1);
		System.out.println(c1.�������������2);
		System.out.println(c1.�������������3);
		
		
	}
}
