package com.itwill.Collection;

public class MyArrays {
	public static void sort(Object[] data){
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length-1; j++) {
				Comparable current=(Comparable)data[j];	//Comparable �������̽��� �����ؾ����� �񱳰� �����ϱ� ������
														//�����ϰ��� �ϴ� ��ü�� Comparable �������̽��� ĳ���� ���ش�.
				Comparable next=(Comparable)data[j+1];
				if(current.compareTo(next)>0){	//������ Comparable �������̽��� �����Ͽ��� ������ ��ü���� compareTo()�޼ҵ�� ��
					Object temp= data[j];
					data[j]=data[j+1];
					data[j+1]=temp;
				}	
			}	 
		}
		
	}
}
