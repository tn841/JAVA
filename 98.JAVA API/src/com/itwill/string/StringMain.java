package com.itwill.string;

public class StringMain {

	public static void main(String[] args) {
		/*
		 * String ��ü ����
		 */
		
		//���������
		String str1 = new String("java");
		String str2 = new String("java");
		System.out.println(str1==str2);
		
		//�Ͻ�������
		String str3 = "java";	//string���ͷ� pool�� ���´�. pool�� "java"��� ���ڿ��� �ִ��� Ȯ��, �����Ƿ� ���� 
		String str4 = "java";	//string���ͷ� pool�� "java"��� ���ڿ��� �����Ƿ� �� ��ü�� �ּҸ� ���
			//str3�� str4�� �ּҰ��� ����.
		
		System.out.println(str3==str4);
		
		
		/*
		 * String ��
		 * public int compareTo(String anotherString)
		 * 
		 * 
		 */
		
		
		System.out.println("---------String.substring()---------");
		
		String str5 = "Have a nice day!!";
		System.out.println("Have a nice day~!".substring(7));
		System.out.println("Have a nice day~!".substring(7,11));
		
		String id = "test001";
		char firstCh = id.charAt(0);
		if(firstCh >= 'a' && firstCh <= 'z'){
			System.out.println("���� �ҹ���");
		}
		
		for (int i = 0; i < id.length(); i++) {
			char temp = id.charAt(i);
			if(  (temp >= 'a' && temp <= 'z')  || (temp >= 'A' && temp <= 'Z')  || (temp >= '0' && temp <= '9')   ){
				System.out.println("�� �ҹ���, �빮��, ���� �Դϴ�."+temp);
			}
			else{
				System.out.println("��ȿ���� ����"+temp);
			}
		}
		
		
		System.out.println("---------String.split()---------");
		String cardNo = "4567-1832-4483-7486";
		String[] carNoArr = cardNo.split("-");
		
		for (int i = 0; i < carNoArr.length; i++) {
			System.out.println(carNoArr[i]);
		}
		
		
		System.out.println("---------String.toUpperCase()---------");
		String strddd = "aasdfasdf";
		System.out.println(strddd.endsWith("f"));
		
		
		char[] charArr = {'H','e','l','l','o','!'};
		String cStr = new String(charArr);
		System.out.println(cStr);
		
		
	}

}
