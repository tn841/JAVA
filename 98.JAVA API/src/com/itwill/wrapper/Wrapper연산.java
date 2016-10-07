package com.itwill.wrapper;

public class Wrapper���� {
	public static void main (String[] arg){
		/*
		 * �񱳿���
		 */
		Integer wi1 = new Integer(89);	//wi1 ������������ Integer WrapperŬ���� �� �ּҰ��� ����ǹǷ� '=='�񱳿���� �ּҰ� �񱳰� �Ͼ ���̴�??? -> �׷���.
		Integer wi2 = new Integer(89);
		Integer wi3 = wi1;
		
		if(wi1 == wi2){
			System.out.println("�ּ� ����.");
		}
		else{
			System.out.println("�ּ� �ٸ���.");			
		}
		
		if(wi1 == wi3){
			System.out.println("�ּ� ����.");
		}
		else{
			System.out.println("�ּ� �ٸ���.");			
		}
		
		if(wi1 >= wi3){	// >= �����ڿ� ���� wi1�� wi3�� Auto Unboxing�ȴ�.
			System.out.println("wi1 ���� wi3���� ũ�ų� ����.");
		}
		else{
			System.out.println("wi1 ���� wi3���� �۴�.");			
		}
		
		if(wi1.equals(wi2)){
			System.out.println("���� ����.");			
		}
		else{
			System.out.println("���� �ٸ���.");			
		}
		
		if(wi1.equals(wi3)){
			System.out.println("���� ����.");			
		}
		else{
			System.out.println("���� �ٸ���.");			
		}
		
		
		int i1 = 89;
		int i2 = 100;
		int i3 = 900;
		
		if(i1 == wi1){	//Wrapper��ü�� wi1�� ���� �⺻���� �񱳿����� �ϱ����� Auto Unboxing�� �̷������.
			System.out.println("���� ����.");
		}
		else{
			System.out.println("���� �ٸ���.");
		}
		
		int y = 2147483647;
		String bStr=Integer.toBinaryString(y);
		System.out.println("����:"+bStr);
		int pi=Integer.parseInt("1234542");
		String hStr = Integer.toHexString(2147483647);	
		System.out.println("16��:"+hStr);
		System.out.println(pi);
		Integer wi=new Integer("45353");
		int i12 = wi.intValue();
		Integer wi22=Integer.getInteger("654645654");
		double pd=Double.parseDouble("3.15240");
		
		boolean b1=Boolean.parseBoolean("true");
		boolean b2=Boolean.parseBoolean("FALSE");
		
		System.out.println("--------Wrapper Character------");
		
		Character cw=new Character('��');
		char c=cw.charValue();
		char fc="���ȣ".charAt(0);
		System.out.println(">> String-->char[]");
		String str = "Hello Java!!!#$643724���ȣ���ӽ�";
		char[] getCharArray=new char[str.length()];
		str.getChars(0, str.length(), getCharArray, 0);
		for (int i = 0; i < getCharArray.length; i++) {
			System.out.print(getCharArray[i]+",");
		}
		System.out.println();
		String str2=new String(getCharArray, 0, getCharArray.length);
		System.out.println(">> char[]-->String:"+str2);
		
		for (int i = 0; i < getCharArray.length; i++) {
			char tempChar=getCharArray[i];
			
			int type=Character.getType(tempChar);
			//System.out.println(tempChar+" type:"+type);
			if(type==Character.LOWERCASE_LETTER){
				System.out.println(tempChar+" �ҹ���");
			}
			if(type==Character.UPPERCASE_LETTER){
				System.out.println(tempChar+" �빮��");
			}
			if(type==Character.CURRENCY_SYMBOL){
				System.out.println(tempChar+" ȭ��");
			}
			if(type==Character.DECIMAL_DIGIT_NUMBER){
				System.out.println(tempChar+" ����");
			}
			if(Character.isAlphabetic(tempChar)){
				System.out.println(tempChar+" ���ĺ�");
			}
			if(Character.isSpaceChar(tempChar)){
				System.out.println(tempChar+" ���鹮��");
			}
			
		}
		
		
		
	}
}
