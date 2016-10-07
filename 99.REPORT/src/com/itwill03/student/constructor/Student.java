package com.itwill03.student.constructor;

public class Student {
    
	//private���� ĸ��ȭ
	private int no;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
	private char grad;
	private int rank;
    
	/*
	 * Constructor
	 */
	public Student(){	//����Ʈ �����ڴ� �⺻������ ���������� (��� ����)
		
	}
	
	public Student(int no, String name, int kor, int eng, int math) {	//���ڸ� 4�� �޴� ������
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		//�����ϸ鼭 ���� ���� ������ ���� ����, ���, ������ ���� �� �ִ�.
		this.calcAll();
	}
	
	

	/*
	 * getter, setter ����
	 */
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

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public char getGrad() {
		return grad;
	}

	public void setGrad(char grad) {
		this.grad = grad;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
	
	/*
	 * ��Ÿ �޼ҵ�
	 */   
    public void calcTotal(){	//�������
    	this.total = this.kor + this.eng + this.math;
    }
    
    public void calcAvg(){		//��հ��
    	double temp = this.total / 3.0;
    	this.avg = (int) (temp*100+0.5)/100.0;
    }
    
    public void calcGrad(){		//���� ���
    	
    	if(this.avg >90){
    		grad = 'A';
    	}
    	else if(this.avg>80){
    		grad = 'B';
    	}
    	else if(this.avg>70){
    		grad = 'C';
    	}
    	else if(this.avg>60){
    		grad = 'D';
    	}
    	else{
    		grad = 'F';
    	}
    }
    
    public void calcAll(){	//����, ���, ���� �ѹ��� ���
    	this.calcTotal();
    	this.calcAvg();
    	this.calcGrad();
    }
    
    public static void headerPrint(){	//��� ���� �޼ҵ�
    	System.out.println("-------------------------------------------------------------");
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t����");
    }
    
    public static void footerPrint(){	//Ǫ�� ���� �޼ҵ�
    	System.out.println("-------------------------------------------------------------");
    }
    
    public void print(){	//���� ���� ��� �޼ҵ�
    	System.out.println(no+"\t"+name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+total+"\t"+avg+"\t"+grad+"\t");
    }
    
   
}
