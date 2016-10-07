
public class CarFactoryMain {

	public static void main(String[] args) {
		Car.setCount(100);	//정적 변수에 대한 작업을 하기 위해 정적 메소드를 만들어 줘야한다.
		Car c1 = new Car();
		c1.setColor("white");
		c1.setModel("K3");
		
		Car c2 = new Car("K5", "black");
		
		Car c3 = new Car("K7", "gray");

		System.out.println("차량 생산 대수 : "+Car.getCount());
	}

}
