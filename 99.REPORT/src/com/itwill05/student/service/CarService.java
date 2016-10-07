package com.itwill05.student.service;

/*
 * 주차장 차량관리 클래스
 * 	- Car[] 객체를 멤버변수로 가진다
 * 	- 주차서비스를 하는 클래스
 */

public class CarService {
	public static int totalSpace;		//주차장 전체 공간
	public static int totalCarCount;	//주차장에 있는 차량 댓수, 정적 변수
	public static int emptyCount; 	//주차장에 남은 자리 수, 정적 변수
	
	private Car[] carArr;	//자동차 객체들이 저장되는 자동차 배열 (주차장)

	public CarService() { // 기본 생성자로 객체 생성시 주차구역 30개
		totalSpace = 30;
		carArr = new Car[totalSpace];
	}

	public CarService(int number) {
		totalSpace = number;
		carArr = new Car[totalSpace];
	}

	public int getParkingCount() {
		return carArr.length;
	}

	public int getEmpty() {
		int empty = 0;
		for (int i = 0; i < carArr.length; i++) {
			if (carArr[i] == null) {
				empty++;
			}
		}
		return empty;
	}

	public void enterCar(Car car) {
		for (int i = 0; i < carArr.length; i++) {
			if (carArr[i] == null) {
				carArr[i] = car;
				totalCarCount++;
				break;
			}
		}
	}

	public Car getCarByNo(String string) {
		Car tempCar = null;
		for (int i = 0; i < carArr.length; i++) {
			if (carArr[i] != null && carArr[i].getNo().equals(string)) {
				tempCar = carArr[i];
			}
		}
		return tempCar;
	}

	public Car[] getCarsByInTime(int inTime) {
		int count = 0;
		for (int i = 0; i < carArr.length; i++) {
			if (carArr[i] != null && carArr[i].getInTime() >= inTime) {
				count++;
			}
		}

		Car[] tempCars = new Car[count];
		int index = 0;

		for (int i = 0; i < carArr.length; i++) {
			if (carArr[i] != null && carArr[i].getInTime() >= inTime) {
				tempCars[index++] = carArr[i];
			}
		}

		return tempCars;
	}// getCarsByInTime

	public void print() {
		Car.headerPrint();
		for (int i = 0; i < carArr.length; i++) {
			if (carArr[i] != null) {
				carArr[i].print();
			}
		}
		Car.footerPrint();
	}// print()

	public static void print(Car[] cars) {
		Car.headerPrint();
		for (int i = 0; i < cars.length; i++) {
			if (cars[i] != null) {
				cars[i].print();
			}
		}
		Car.footerPrint();
	}//print(Car[] cars)

	public Car culcha(String no, int outTime) {
		Car culchaTemp = null;
		for (int i = 0; i < carArr.length; i++) {
			if( !isNull(carArr[i]) && carArr[i].getNo().equals(no)){
				carArr[i].setOutTime(outTime);
				carArr[i].calculateFee();
				culchaTemp = carArr[i];
				carArr[i] = null;
				break;
			}
		}
		return culchaTemp;
	}
	
	public boolean isNull(Car car){
		if(car == null){
			return true;
		}
		else
			return false;
	}

	public int sumOfFee(int inTime) {
		int totalFee = 0;
		System.out.println("--------------------------------------------");
		System.out.println("번호\t입차\t출차\t요금\t"+inTime+"시 기준요금");
		System.out.println("--------------------------------------------");
		for (int i = 0; i < carArr.length; i++) {
			if( !isNull(carArr[i]) && carArr[i].getOutTime()==0){	//출차 하지 않은 차량에 대해서만,
				totalFee += (inTime - carArr[i].getInTime())*1000;
				carArr[i].printNoEnter();
				System.out.println("\t"+(inTime - carArr[i].getInTime())*1000);
			}
		}
		System.out.println("--------------------------------------------");
		return totalFee;
	}

}
