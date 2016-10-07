package com.itwill.wrapper;


/*
- Wrapper Ŭ����

	�ڹٵ���Ÿ���� �⺻����Ÿ���� ���۷��� ����Ÿ ������ ���е˴ϴ�.
	�⺻����Ÿ�����δ� int,boolean,double ���� �����˴ϴ�.
	�̷��⺻ ����Ÿ���� ��ü�� ����Ҽ��ִ� ������� 
	Wrapper Ŭ������ �����˴ϴ�.
	Wrapper Ŭ������ ���������� ��ɵ��� �޼���� �����������ִٴ�
	�������ֽ��ϴ�.
	
	Integer,Boolean,Double,Character,Float,Long,Byte,Short
	
 */
public class WrapperMain {

	public static void main(String[] args) {
		/*
		 * Boxing(Wrapping)
		 *  - �⺻�� --> Wrapper
		 */
		Integer wi1 = new Integer(11);
		Integer wi2 = new Integer("11");	//���� ���ڿ��� ������ �Ľ�
		
		Boolean wb1 = new Boolean(true);
		Boolean wb2 = new Boolean("false");
		
		Double wd1 = new Double(12.2123);
		
		Character wc1 = new Character('a');
		
		/*
		 * Unboxing
		 *  - Wrapper --> �⺻��
		 */
		System.out.println(wi1.intValue());
		
		/*
		 * auto boxing
		 */
		Integer wi3 = 11;		//�ĺ��ڿ��� �ּҰ��� ����. (���� ���ͷ��� �ڵ����� Wrapping�ȴ�.)
		Boolean wb3 = true;
		Double wd3 = 123.123;
		Character wc3 = 'd';
		
		/*
		 * Auto Unboxing
		 */
		int i3 = wi3;
		boolean b3 = wb3;
		double d3 = wd3;
		char c3 = wc3;
		
		
		/***************Auto Boxing & Upper Casting*************************/
		Object[] oArr = {i3, b3, d3, c3};	//i3, b3, d3, c3�� ���� ������ Wrapper��ü�� Auto Boxing�ǰ� Object�� �������� ĳ����(upper casting)�� ����� ��Ȳ
		
		Object[] scoreArr = new Object[10];
		scoreArr[0] = 0;
		scoreArr[1] = 1;
		scoreArr[2] = 2;
		scoreArr[3] = 3;
		scoreArr[4] = 4;
		scoreArr[5] = 5;
		scoreArr[6] = 6;
		scoreArr[7] = 7;
		scoreArr[8] = 8;
		scoreArr[9] = 9;	//���� ������ ���ͷ��� Auto Boxing�ǰ� Object�� upper ĳ���õǾ� �迭�� �ּҰ��� ����ȴ�.
		
		
		/******************** Down Casting & Auto Unboxing ************************/
		int ia = (Integer)oArr[0];	//Object��ü�� oArr[0]�� Integer WrapperŬ������ ������ ĳ���õ� �� ������ ���� ia�� Auto Unboxing�ȴ�.
		int ia2 = (int)oArr[0];		//Object��ü�� oArr[0]�� �⺻�� int�� �ٷ� ĳ���� �� �� ����. 
									//���� Integer WrapperŬ������ ���� ĳ���õ� �� ������ �⺻������ Auto Unboxing���� �̷���� ������ ������ ���� ia2�� ���Եȴ�.
		
		Integer ia3 = (Integer)oArr[0];
		Integer ia4 = (int)oArr[0];	//Auto boxing��
	
		System.out.println(ia+" "+ia2+" "+ia3+" "+ia4);
		System.out.println(ia+ia2+ia3+ia4);
		
		for (int i = 0; i < scoreArr.length; i++) {
			System.out.println(scoreArr[i].getClass());
			
		}
		
	}

}
