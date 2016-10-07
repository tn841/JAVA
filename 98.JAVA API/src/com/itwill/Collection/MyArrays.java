package com.itwill.Collection;

public class MyArrays {
	public static void sort(Object[] data){
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length-1; j++) {
				Comparable current=(Comparable)data[j];	//Comparable 인터페이스를 구현해야지만 비교가 가능하기 때문에
														//정렬하고자 하는 객체를 Comparable 인터페이스로 캐스팅 해준다.
				Comparable next=(Comparable)data[j+1];
				if(current.compareTo(next)>0){	//위에서 Comparable 인터페이스를 구현하였고 구현된 객체들을 compareTo()메소드로 비교
					Object temp= data[j];
					data[j]=data[j+1];
					data[j+1]=temp;
				}	
			}	 
		}
		
	}
}
