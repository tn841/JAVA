package com.itwill05.student.service;

public class CarServiceMain {

	public static void main(String[] args) {
		CarService carServ = new CarService();
		
		
		System.out.println("1.��������ȹ��");
		int num = carServ.getParkingCount();
		System.out.println(">> "+num);
		System.out.println();
		
		System.out.println("2.�������尹��");
		num = carServ.getEmpty();
		System.out.println(">> "+num);
		System.out.println();
		
		System.out.println("3.���� (11�� ���� ��)");
		carServ.enterCar(new Car("9525", 3));
		carServ.enterCar(new Car("7936", 3));
		carServ.enterCar(new Car("4832", 4));
		carServ.enterCar(new Car("7851", 5));
		carServ.enterCar(new Car("9665", 7));
		carServ.enterCar(new Car("6666", 7));
		carServ.enterCar(new Car("1445", 8));
		carServ.enterCar(new Car("2342", 9));
		carServ.enterCar(new Car("6565", 12));
		carServ.enterCar(new Car("3336", 12));
		carServ.enterCar(new Car("5522", 14));
		System.out.println();
		
		System.out.println("4.'7936'�� ����1�� ã�Ƽ���� ");
		Car.headerPrint();
		Car findCar = carServ.getCarByNo("7936");
		findCar.print();
		Car.footerPrint();
		System.out.println();
		
		
		System.out.println("5.�����ð� 9������������ ã�Ƽ���� ");
		Car[] findCars = carServ.getCarsByInTime(9);
		CarService.print(findCars);
		System.out.println();
		
		System.out.println("6.��ü �������� ���");
		carServ.print();
		System.out.println();
		
		
		System.out.println("7.6666�� ���� 13�ÿ� ���� ������������ ��� ");
		Car culcha = carServ.culcha("6666", 13);
		Car.headerPrint();
		culcha.print();
		System.out.println();
		
		
		System.out.println("8.����ð� 15�� �����忡�ִ� ������ ���������");
		int totalFee = carServ.sumOfFee(15);
		System.out.println(">> "+totalFee);
		

	}

}
