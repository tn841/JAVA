package com.itwill07.student.collection;
/**
   ���࿡�� ����ϴ� ���� ��ü�� �Ϲ�ȭ�� Ŭ����
   ���� 300��
  @author KIM
  @version 0.1
  @since 0.1
 */
public class Account implements Comparable{
	
	private String no;  //���¹�ȣ
	private String owner;//������
	private int balance;//�ܰ�
	private double iyul;//����
	
	@Override
	public int compareTo(Object o) {
		Account tempAcc = (Account)o;
		return tempAcc.getBalance()- this.balance;
	}
	
	
	/**
	 * �⺻������ �ʱ�ȭ�� ���°�ü������
	 */
	public Account() {
	
	}
	/**
	 * ���ڰ����� �ʱ�ȭ�� ���°�ü������
	 * @param no 		���¹�ȣ
	 * @param owner		������
	 * @param balance	�ܰ�
	 * @param iyul		����
	 */
	public Account(String no, String owner, int balance, double iyul) {
		
		this.no = no;
		this.owner = owner;
		this.balance = balance;
		this.iyul = iyul;
	}


	/*
	 * �Ա�
	 */
	/**
	 * �Աݸ޽��
	 * @param m �Ա��ҵ�
	 */
	public void saveMoney(int m){
		this.balance=this.balance+m;
		//this.balance+=m;
	}
	
	/*
	 * ���
	 */
	/**
	 * ��ݸ޽��
	 * @param m ����ҵ� ���������
	 */
	public boolean withdrawMoney (int m) throws BalanceException{
		boolean result = true;
		this.balance=this.balance-m;
		if(this.balance<0){
			this.balance = this.balance + m;
			result = false;
			throw new BalanceException("�ܰ� �����մϴ�.");
		}
		return result;
	}
	
	public void headerPrint(){
		System.out.println("*********************************");
		System.out.println("��ȣ\t�̸�\t�ܰ�\t����");
		System.out.println("*********************************");
	}
	public void footerPrint(){
		System.out.println("*********************************");
	}
	/**
	 * �������� ���
	 */
	public void print(){
		System.out.println(
				this.no+"\t"+
				this.owner+"\t"+
				this.balance+"\t"+
				this.iyul);
	}
	
	/*
	 * Account data set
	 */
	public void setAccountData(
			String no,String owner,int balance,double iyul){
		/*
		this.no=no;
		this.owner=owner;
		this.balance=balance;
		this.iyul=iyul;
		*/
		this.setNo(no);
		this.setOwner(owner);
		this.setBalance(balance);
		this.setIyul(iyul);
	}
	
	//setter,getter
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	/**
	 * ������ �ܰ� ��ȯ�ϴ¸޽��
	 * @return �����ܰ�
	 */
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
