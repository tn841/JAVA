package com.itwill06.student.lotto;

public class Lotto {
	private int[] number=new int[6];
	/*
	 * ��ȣ�������
	 */
	public void generateNumber(){
		/*
		 * Math.random()
		 */
		int[] lottoArr = new int[45];
		int num=0;
		for (int i = 0; i < lottoArr.length; i++) {
			lottoArr[i] = ++num;
			//System.out.println(num);
		}//�ζ� ��ȣ ��ü�� ���� int�迭 ���� �� ����
		
		int count=0;
		while(count < 6){
			int randIndex = (int)(Math.random()*45);
			if(lottoArr[randIndex] != 0){
				number[count] = lottoArr[randIndex];
				count++;
				lottoArr[randIndex] = 0;
			}
		}
		
	}
	/*
	 * ��ȣ���
	 */
	public void print(){
		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i]);
			if(i!=(number.length-1)){
				System.out.print(",");
			}
			
		}
		System.out.println();
	}
	
}
