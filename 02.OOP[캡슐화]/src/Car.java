public class Car {	//���������� class Ŭ������
	
	//������� ����, public ���� �����ִ�..
	private String no;
	private int inTime;
	private int outTime;
	private int fee;
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public int getInTime() {
		return inTime;
	}

	public void setInTime(int inTime) {
		this.inTime = inTime;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getOutTime() {
		return outTime;
	}

	public void ipCha(String no, int inT){
		this.no = no;
		this.inTime = inT;
	}
	
	public void setOutTime(int outT){
		this.outTime = outT;
	}
	
	public void calculateFee(){
		this.fee = (this.outTime - this.inTime)*1000;
	}
	
	public static void headerPrint(){
		System.out.println("*********************************************************");
		System.out.println("������ȣ\t�����ð�\t�����ð�\t�������");
	}
	
	public static void footerPrint(){
		System.out.println("*********************************************************");
	}
	
	public void print(){
		System.out.println("---------------------------------------------------------");
		System.out.println(no+"\t"+inTime+"\t\t"+outTime+"\t\t"+fee);
	}
}
