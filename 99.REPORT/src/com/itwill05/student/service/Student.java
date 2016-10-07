package com.itwill05.student.service;


public class Student {
    private int no;
    private String name;
    private int kor;
    private int eng;
    private int math;
    private int tot;
    private double avg;
    private char grade;
    private int rank;
    public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(int no, String name, int kor, int eng, int math) {
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		rank = 1;
	}
	
//    0.�Ż���Ÿ�Է¸޽��
//    1.��������Ÿ�Է¸޽��
//    2.�������޽��
//    3.��հ��޽��
//    4.�������޽��
//    5.����,���,�������޽��
//    6.��¸޽��
    
     
    // 0.�Ż���Ÿ�Է¸޽��
    public void setInfo(int no,String name){
    	this.no=no;
    	this.name=name;
    	rank = 1;
    }
    
    //1.��������Ÿ�Է¸޽��
    public void setScore(int kor,int eng,int math){
    	this.kor=kor;
    	this.eng=eng;
    	this.math=math;
    	rank = 1;
    }
    
    //2. ���� �Ի�
    public void calculateTot(){
    	this.tot=this.kor+this.eng+this.math;
    }
    
    //3. ��հ��
    public void calculateAvg(){
    	this.avg=this.tot/3.0;
    	this.avg = ((int)(this.avg*100+0.5))/100.0;
    }
    
    //4. �������
    public void calculateGrade(){
    	
    	if(this.avg>=90){
    		this.grade='A';
    	}else if(this.avg>=80){
    		this.grade='B';
    	}else if(this.avg>=70){
    		this.grade='C';
    	}else if(this.avg>=60){
    		this.grade='D';
    	}else{
    		this.grade='F';
    	}
    }
    
    //5. ����, ���, ���� ���
    public void calculateAll(){
    	this.calculateTot();
    	this.calculateAvg();
    	this.calculateGrade();
    }
    
    
    // 6. ��� �޼ҵ�
    public static void headerPrint(){
		System.out.println("*********************************************************************");
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t����\t����");
		System.out.println("*********************************************************************");
	}
	public static void footerPrint(){
		System.out.println("*********************************************************************");
	}
    public void print(){
    	System.out.println(this.no+"\t"+this.name+"\t"+this.kor+"\t"+this.eng+"\t"+this.math+"\t"+this.tot+"\t"+this.avg+"\t"+this.grade+"\t"+this.rank);
    }
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

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}
