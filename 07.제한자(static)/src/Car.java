
public class Car {
	private static int count;

	private String model;
	private String color;

	public Car() {
		Car.count++;	
	}

	public Car(String model, String color) {
		Car.count++;
		this.model = model;
		this.color = color;
	}
	
	public void print(){
		System.out.println(model+"\t"+color);
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public static void setCount(int count){
		Car.count = count;
	}
	public static int getCount(){
		return Car.count;
	}


}
