
public class CarConstructorMain {

	public static void main(String[] args) {
		Car car1 = new Car("1111��11", 12, 14, 20000);
		Car car2 = new Car("2222��22", 13, 17, 40000);
		Car car3 = new Car("3333��33", 2, 5, 30000);
		Car car4 = new Car("4444��44", 1, 3, 20000);
		
		Car.headerPrint();
		car1.print();
		car2.print();
		car3.print();
		car4.print();
		Car.footerPrint();
	
	}

}
