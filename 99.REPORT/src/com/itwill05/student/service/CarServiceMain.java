package com.itwill05.student.service;

public class CarServiceMain {

	public static void main(String[] args) {
		CarService carServ = new CarService();
		
		
		System.out.println("1.총주차구획수");
		int num = carServ.getParkingCount();
		System.out.println(">> "+num);
		System.out.println();
		
		System.out.println("2.빈주차장갯수");
		num = carServ.getEmpty();
		System.out.println(">> "+num);
		System.out.println();
		
		System.out.println("3.입차 (11대 입차 함)");
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
		
		System.out.println("4.'7936'번 차량1대 찾아서출력 ");
		Car.headerPrint();
		Car findCar = carServ.getCarByNo("7936");
		findCar.print();
		Car.footerPrint();
		System.out.println();
		
		
		System.out.println("5.입차시간 9시이후차량들 찾아서출력 ");
		Car[] findCars = carServ.getCarsByInTime(9);
		CarService.print(findCars);
		System.out.println();
		
		System.out.println("6.전체 차량정보 출력");
		carServ.print();
		System.out.println();
		
		
		System.out.println("7.6666번 차량 13시에 출차 출차차량정보 출력 ");
		Car culcha = carServ.culcha("6666", 13);
		Car.headerPrint();
		culcha.print();
		System.out.println();
		
		
		System.out.println("8.현재시간 15시 주차장에있는 차량의 요금의총합");
		int totalFee = carServ.sumOfFee(15);
		System.out.println(">> "+totalFee);
		

	}

}
