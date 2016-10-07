package com.itwill04.student.array;

/**
 * ���࿡�� ����ϴ� ���� ��ü�� �Ϲ�ȭ�� Ŭ����
 * @author SUMIN
 * @version 0.1
 * @since 0.1
 * 
 *
 */
public class Account {
	private String no;		//���¹�ȣ
	private String ower;	//���� �� �̸�
	private int balance;	//�ܰ�
	private double iyul;	//����
	/**
	 * �⺻������ �ʱ�ȭ�� ���°�ü����
	 */
	public Account(){
		
	}
	/**
	 * 
	 * @param no ���¹�ȣ
	 * @param ower	������
	 * @param balance	�ܰ�
	 * @param iyul	����
	 */
	public Account(String no, String ower, int balance, double iyul) {
		this.no = no;
		this.ower = ower;
		this.balance = balance;
		this.iyul = iyul;
	}

	/*
	 * �Ա�
	 */
	/**
	 * �Ա� �޼ҵ�
	 * @param m
	 */
	public void saveMoney(int m){
		this.balance += m;
	}
	
	/*
	 * ���
	 */
	/**
	 * ��ݸ޼ҵ�
	 * @param m ����ҵ� ���������
	 */
	public void withdrawMoney(int m){
		if(this.balance-m < 0){
			System.out.println("�ܰ� �����Ͽ� ��� �� �� �����ϴ�.");
			return;
		}
		this.balance -= m;
	}
	
	/*
	 * ���
	 */
	/**
	 * �������� ���
	 */
	public void print(){
		System.out.println(
				this.no+"\t"+
				this.ower+"\t"+
				this.balance+"\t"+
				this.iyul);
	}
	
	
	/*
	 * Account data set
	 */
	public void setAccountData(String no, String owner, int balance, double iyul){
		this.setNo(no);
		this.setOwer(owner);
		this.setBalance(balance);
		this.setIyul(iyul);
	}
	
	
	//setter, getter
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getOwer() {
		return ower;
	}
	public void setOwer(String ower) {
		this.ower = ower;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public double getIyul() {
		return iyul;
	}
	public void setIyul(double iyul) {
		this.iyul = iyul;
	}
	

	
}
