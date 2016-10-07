package com.itwill04.student.array;

public class CarArrayMain {

	public static void main(String[] args) {
		//Car[] carArray = new Car[30];	//자동차 객체를 담을 배열을 선언한 것, 자동차 객체가 생성되지는 않았다.
		/*
		 * 차량번호는 중복되지 않는다.
		 */
		Car[] carArray = {
			null, null, new Car("1111", 5), null, null,
			null, null, null, null, new Car("1112", 5),
			null, null, new Car("8977", 7), null, null,
			null, new Car("1234", 10), null, null, null,
			null, null, null, null, new Car("6666", 9),
			null, null, new Car("9999", 11), null, null
		};// Car객체 30개를 가지는 배열 carArray에 드문드문 car객체가 들어가 있다.
		
		System.out.println("1. 총 주차 구획수 : ");
		System.out.println(">> "+carArray.length+"\n");
		
		
		System.out.println("2. 빈 주차 구획 갯수 : ");//꽉 찼으면 만차
		int count = 0;
		for (int i = 0; i < carArray.length; i++) {
			if(carArray[i] == null){
				count++;
			}
		}
		if(count == carArray.length){
			System.out.println("만차입니다.");
		}
		System.out.println(">> "+count+"\n");
		
	
		
		/*
		 * 입차
		 */
		System.out.println("3. 입차 : 번호='3456' 입차시간=8");
		Car car1 = new Car("3456", 8);
		for(int i=0; i<carArray.length; i++){
			if(carArray[i] == null){
				carArray[i] = car1;
				break;	//for문 돌면서 첫번째 null인곳에 차 객체를 넣고나서 for문 탈출
			}
		}//for
		System.out.println(">> 입차완료.");
		System.out.println();
		
		System.out.println("4. '8977'번 차량을 찾아서 출력");

		for (int i = 0; i < carArray.length; i++) {
			if(carArray[i] != null && carArray[i].getNo().equals("8977")){	//null이 아니고 "8977"인 객체를 찾는다.
				Car.headerPrint();
				carArray[i].print();
				Car.footerPrint();
				break;
			}
		}
		System.out.println();
		
		System.out.println("5. 입차시간이 9시이후 차량들 찾아서 출력");
		Car.headerPrint();
		for (int i = 0; i < carArray.length; i++) {
			if(carArray[i] != null && carArray[i].getInTime() > 9){
				carArray[i].print();
			}
		}
		Car.footerPrint();
		System.out.println();
		
		
		System.out.println("6. 전체 차량정보 출력 : ");
		Car.headerPrint();
		for (int i = 0; i < carArray.length; i++) {
			if(carArray[i] != null)
				carArray[i].print();
		}
		Car.footerPrint();
		System.out.println();
		
		System.out.println("7. '6666'번 차량 출차 후 해당 차량 정보 출력: ");
		Car.headerPrint();
		for (int i = 0; i < carArray.length; i++) {
			if(carArray[i] != null && carArray[i].getNo().equals("6666")){
				carArray[i].setOutTime(15);
				carArray[i].calculateFee();
				carArray[i].print();
				carArray[i] = null;	//해당 배열인덱스를 null로 비워주면 출차 프로세스 완료
				break;
			}
		}
		Car.footerPrint();
		System.out.println();
		
		System.out.println("8. 현재시간(15시) 주차장에있는 차량의 정보를 출력: ");
		Car.headerPrint();
		for (int i = 0; i < carArray.length; i++) {
			if(carArray[i] != null ){
				carArray[i].print();
			}
		}
		Car.footerPrint();
		System.out.println();
		
	
		
		
	}

}
