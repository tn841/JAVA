package com.itwill.wrapper;


public class WrapperClass�����Ѹ޽����� {

	public static void main(String[] args) {
		
		int y = 2147483647;
		String bStr=Integer.toBinaryString(y);
		System.out.println("����:"+bStr);
		int pi=Integer.parseInt("1234542");
		String hStr = Integer.toHexString(2147483647);	
		System.out.println("16��:"+hStr);
		System.out.println(pi);
		Integer wi=new Integer("45353");
		int i1 = wi.intValue();
		Integer wi2=Integer.getInteger("654645654");
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
