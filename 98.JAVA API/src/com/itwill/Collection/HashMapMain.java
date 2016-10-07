package com.itwill.Collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapMain {

	public static void main(String[] args) {
		HashMap<String, Car> hMap = new HashMap<String, Car>();

		Car c1 = new Car("1111", 12);
		
		hMap.put(c1.getNo(), c1);
		hMap.put("2222", new Car("2222", 20));
		hMap.put("3333", new Car("3333", 21));
		hMap.put("4444", new Car("4444", 10));
		hMap.put("5555", new Car("5555", 11));
		hMap.put("6666", new Car("6666", 3));	//key에 6은 Integer로 boxing 되어 HashMap에 들어간다.
		hMap.put("7777", new Car("7777", 7));
		
		
		System.out.println(hMap.size());
		Car temp = (Car)hMap.get("2222");
		temp.print();
		
		System.out.println(hMap.keySet());	//keySet() -> Set객체로 key값 반환
		Set tempSet = hMap.keySet(); 
		Object[] obArr = tempSet.toArray();
		for (int i = 0; i < obArr.length; i++) {
			//String tempStr = (String) obArr[i];
			System.out.println(obArr[i]+" "+obArr[i].getClass());
		}
		System.out.println();
		
		
		Collection tempCollection = hMap.values();	//values() -> Collection객체로 value객체 반환 
		obArr = tempCollection.toArray();
		for (int i = 0; i < obArr.length; i++) {
			Car tempCar = (Car)obArr[i];
			tempCar.print();
		}
		
		System.out.println(hMap.entrySet());	//entrySet() -> Set객체로 key와 value 묶음 반환
		tempSet = hMap.entrySet();
		obArr = tempSet.toArray();
		for (int i = 0; i < obArr.length; i++) {
	
			System.out.println(obArr[i]+", "+obArr[i].getClass());
		}
		System.out.println();
		System.out.println();
		
		
		Set<Map.Entry<String, Car>> tempSet2 = hMap.entrySet();	//Map의 이너클래스 Entry
		obArr = tempSet2.toArray();
		for (int i = 0; i < obArr.length; i++) {
			Map.Entry<String, Car> temptemp = (Entry<String, Car>) obArr[i];
			temptemp.getValue().print();
			
		}
		
		System.out.println("------------Iteration------------");
		Set<String> keysSet = hMap.keySet();			//Map의 key값을 Set에 저장
		Iterator<String> keyIter = keysSet.iterator();	//Set의 Iterator 생성
		
		while(keyIter.hasNext()){
			hMap.get(keyIter.next()).print();	
		}
		
		
		
	
	}

}
