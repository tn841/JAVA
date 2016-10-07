
public class HourlyEmployee extends Employee {
	private int workHour; // 일한 시간
	private int payPerHour; // 시급

	public HourlyEmployee() {

	}

	public HourlyEmployee(int no, String name, int workHour, int payPerHour) {
		super(no, name);
		this.workHour = workHour;
		this.payPerHour = payPerHour;
	}

	@Override
	public void calculatePay() {
		this.setPay(this.payPerHour * this.workHour);
	}

	@Override
	public void print() {
		super.print();
		System.out.println("\t" + workHour + "\t" + payPerHour);
	}
	
	public static void headerPrint(){
		System.out.println("------------------------------------");
		System.out.println("사번\t이름\t급여\t시간\t시급");
		System.out.println("------------------------------------");
	}

	// getter, setter
	public int getWorkHour() {
		return workHour;
	}

	public void setWorkHour(int workHour) {
		this.workHour = workHour;
	}

	public int getPayPerHour() {
		return payPerHour;
	}

	public void setPayPerHour(int payPerHour) {
		this.payPerHour = payPerHour;
	}

}
