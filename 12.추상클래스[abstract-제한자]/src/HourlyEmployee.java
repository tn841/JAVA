
public class HourlyEmployee extends Employee {
	private int workHour; // ���� �ð�
	private int payPerHour; // �ñ�

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
		System.out.println("���\t�̸�\t�޿�\t�ð�\t�ñ�");
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
