
public class Car {
	private String model;
	private Engine engine;
	private int wheelNumber;

	public Car() {

	}

	public Car(String model, Engine engine, int wheelNumber) {
		this.model = model;
		this.engine = engine;
		this.wheelNumber = wheelNumber;
	}

	// method
	public void print() {
		System.out.print(model + "\t" + wheelNumber + "\t");
		engine.print(); // 엔진 객체 데이터에 대한 출력은 Car객체에서 관여하지 않는다. 엔진 겍체에서 알아서 한다.
	}

	// getter, setter
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Engine getEngine() {
		return engine;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getWheelNumber() {
		return wheelNumber;
	}

	public void setWheelNumber(int wheelNumber) {
		this.wheelNumber = wheelNumber;
	}

}
