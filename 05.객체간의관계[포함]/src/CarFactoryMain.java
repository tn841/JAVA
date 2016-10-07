public class CarFactoryMain {
	public static void main(String[] args) {

		Engine e3000 = new Engine("B", 3000);

		Car c1 = new Car();
		c1.setModel("�׽���");
		c1.setWheelNumber(4);
		// c1.engine = e3000; //��������� �ٷ� �����ϹǷ� �������� �߻� ��Ų��. �Ʒ� �ڵ�� ���������ν� ĸ��ȭ �Ϸ�
		c1.setEngine(e3000);

		/*
		 * �������� �˻�
		 */
		c1.getEngine().print(); // c1��ü�� ���� ��ü�� print()


		c1.print();
		
		Engine e800 = new Engine("C", 800);
		Car matiz = new Car("Matiz", e800, 4);
		matiz.getEngine().print();
		matiz.print();
		
		Car lexus = new Car("LEXUS", new Engine("X", 2800), 4);
		lexus.getEngine().print();
		lexus.print();
	}
}
