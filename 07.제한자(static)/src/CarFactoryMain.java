
public class CarFactoryMain {

	public static void main(String[] args) {
		Car.setCount(100);	//���� ������ ���� �۾��� �ϱ� ���� ���� �޼ҵ带 ����� ����Ѵ�.
		Car c1 = new Car();
		c1.setColor("white");
		c1.setModel("K3");
		
		Car c2 = new Car("K5", "black");
		
		Car c3 = new Car("K7", "gray");

		System.out.println("���� ���� ��� : "+Car.getCount());
	}

}
