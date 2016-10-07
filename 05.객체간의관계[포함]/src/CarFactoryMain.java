public class CarFactoryMain {
	public static void main(String[] args) {

		Engine e3000 = new Engine("B", 3000);

		Car c1 = new Car();
		c1.setModel("테슬라");
		c1.setWheelNumber(4);
		// c1.engine = e3000; //멤버변수에 바로 접근하므로 의존성을 발생 시킨다. 아래 코드로 변경함으로써 캡슐화 완료
		c1.setEngine(e3000);

		/*
		 * 차량엔진 검사
		 */
		c1.getEngine().print(); // c1객체의 엔진 객체를 print()


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
