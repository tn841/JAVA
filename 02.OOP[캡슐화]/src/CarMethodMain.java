
public class CarMethodMain {

	public static void main(String[] args) {
		

		Car car1 = new Car();	//객체(인스턴스) 선언 및 생성
		Car car2 = new Car();
		Car car3 = new Car();
		
		//생성된 인스턴스에 데이터 입력
		car1.ipCha("23러2973", 12);
		car2.ipCha("72고7583", 13);
		car3.ipCha("94하3414", 14);
			
		
		
		//2시간 후 출차
		car1.setOutTime(15);
		car2.setOutTime(15);
		car3.setOutTime(15);
		
		
		//요금 계산
		car1.calculateFee();
		car2.calculateFee();
		car3.calculateFee();
	
		//출력
		Car.headerPrint();	//Car 클래스의 정적 메소드
		car1.print();		//car1객체의 print메소드
		car2.print();		//car2객체의 print메소드
		car3.print();		//car3객체의 print메소드
		Car.footerPrint();	//Car 클래스의 정적 메소드
		
	
	
	}

}
