
public abstract class Employee {
	private int no;
	private String name;
	private int pay;

	public final static double INCENTIVE_RAIT = 0.1;

	public Employee() {

	}

	public Employee(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	
	/*
	 * 월급 계산 (자식 객체에서 반드시 재정의(구현)해야하는 메소드)
	 */
	public abstract void calculatePay();
	
	/*
	 * 인센티브계산(재정의금지 - 회장님 방침)
	 */
	public final int calcIncentive(){	
		this.calculatePay();	//자식 객체에서 calculatePay()를 무조건 구현할것이기 때문에 추상메소드 호출이 가능하다.
		int incentive = 0;
		if(pay >= 1000000){
			incentive = (int)(pay*Employee.INCENTIVE_RAIT);
		}
		return incentive;
	}

	public void print() {
		System.out.print(no + "\t" + name + "\t" + pay);
	}

	// getter, setter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

}
