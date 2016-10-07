
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
	 * ���� ��� (�ڽ� ��ü���� �ݵ�� ������(����)�ؾ��ϴ� �޼ҵ�)
	 */
	public abstract void calculatePay();
	
	/*
	 * �μ�Ƽ����(�����Ǳ��� - ȸ��� ��ħ)
	 */
	public final int calcIncentive(){	
		this.calculatePay();	//�ڽ� ��ü���� calculatePay()�� ������ �����Ұ��̱� ������ �߻�޼ҵ� ȣ���� �����ϴ�.
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
