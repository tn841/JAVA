package com.itwill03.student.constructor;
public class Car {	//접근제한자 class 클래스명
	
	//멤버변수 선언, private으로 캡슐화
	private String no;
	private int inTime;
	private int outTime;
	private int fee;
	
	
	/*
	 * constructor
	 */
	public Car(){}
	
	public Car(String no, int inTime) {
		this.no = no;
		this.inTime = inTime;
	}



	/*
	 * getter, setter
	 */
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

	
	
	/*
	 * 기타 메소드
	 */
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
		System.out.println("차량번호\t입차시간\t출차시간\t주차요금");
	}
	
	public static void footerPrint(){
		System.out.println("*********************************************************");
	}
	
	public void print(){
		System.out.println("---------------------------------------------------------");
		System.out.println(no+"\t"+inTime+"\t\t"+outTime+"\t\t"+fee);
	}
}
