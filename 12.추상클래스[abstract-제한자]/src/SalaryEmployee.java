
public class SalaryEmployee extends Employee {
	private int annulaSalary; // 연봉
	private int PrintedNum;	//

	public SalaryEmployee() {

	}

	public SalaryEmployee(int no, String name, int annulaSalary) {
		super(no, name); // 부모 클래스에 있는 인자2개 짜리 생성자를 이용
		this.annulaSalary = annulaSalary;
	}

	@Override
	public void calculatePay() {
		//super.setPay(this.annulaSalary / 12);	//super.setPay() ??? 결과는 같다??
		this.setPay(this.annulaSalary / 12);
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("\t"+annulaSalary);
	}
	
	public static void headerPrint(){
		System.out.println("---------------------------------");
		System.out.println("사번\t이름\t급여\t연봉");
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
