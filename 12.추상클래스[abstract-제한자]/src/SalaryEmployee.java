
public class SalaryEmployee extends Employee {
	private int annulaSalary; // ����
	private int PrintedNum;	//

	public SalaryEmployee() {

	}

	public SalaryEmployee(int no, String name, int annulaSalary) {
		super(no, name); // �θ� Ŭ������ �ִ� ����2�� ¥�� �����ڸ� �̿�
		this.annulaSalary = annulaSalary;
	}

	@Override
	public void calculatePay() {
		//super.setPay(this.annulaSalary / 12);	//super.setPay() ??? ����� ����??
		this.setPay(this.annulaSalary / 12);
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("\t"+annulaSalary);
	}
	
	public static void headerPrint(){
		System.out.println("---------------------------------");
		System.out.println("���\t�̸�\t�޿�\t����");
		System.out.println("---------------------------------");
	}

	// getter, setter
	public int getAnnulaSalary() {
		return annulaSalary;
	}

	public void setAnnulaSalary(int annulaSalary) {
		this.annulaSalary = annulaSalary;
	}

}
