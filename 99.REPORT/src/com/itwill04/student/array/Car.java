package com.itwill04.student.array;


public class Car {
	private String no;
	private int inTime;
	private int outTime;
	private int fee;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}
	public Car(String no, int inTime) {
		this.no = no;
		this.inTime = inTime;
	}
	public Car(String no, int inTime, int outTime, int fee) {
		this.no = no;
		this.inTime = inTime;
		this.outTime = outTime;
		this.fee = fee;
	}

	public void ipCha(String no,int inTime){
		this.no=no;
		this.inTime=inTime;
	}
	public void setOutTime(int outTime){
		this.outTime=outTime;
	}
	public void calculateFee(){
		this.fee=(this.outTime-this.inTime)*1000;
	} 
	public static void headerPrint(){
		System.out.println("---------------------------------");
		System.out.println("번호\t입차\t출차\t요금");
		System.out.println("---------------------------------");
	}
	public static void footerPrint(){
		System.out.println("---------------------------------");
	}
	public void print(){
		System.out.println(this.no+"\t"+this.inTime+"\t"+this.outTime+"\t"+this.fee);
	}
	//setter,getter
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
}













