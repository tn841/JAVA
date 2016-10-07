package com.itwill.Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ListMapMain {

	public static void main(String[] args) {
		HashMap<String, ArrayList<Student>> schoolMap;
		schoolMap=new HashMap<String, ArrayList<Student>>();
		
		ArrayList<Student> aBanList=new ArrayList<Student>();
		aBanList.add(new Student(1, "KIM", 34, 55, 90));
		aBanList.add(new Student(2, "JIM", 56, 66, 88));
		aBanList.add(new Student(3, "PIM", 88, 34, 99));
		
		ArrayList<Student> bBanList=new ArrayList<Student>();
		bBanList.add(new Student(1, "SIM", 34, 90, 44));
		bBanList.add(new Student(2, "DIM", 89, 45, 23));
		bBanList.add(new Student(3, "AIM", 23, 34, 96));
		
		ArrayList<Student> cBanList=new ArrayList<Student>();
		cBanList.add(new Student(1, "XIM", 99, 12, 78));
		cBanList.add(new Student(2, "ZIM", 33, 90, 18));
		cBanList.add(new Student(3, "YIM", 67, 23, 99));
		
		schoolMap.put("A", aBanList);
		schoolMap.put("B", bBanList);
		schoolMap.put("C", cBanList);
		
			
		
		System.out.println(">>학생 전체 출력");
		Iterator<String> banKeyIterator = schoolMap.keySet().iterator();
		
		while(banKeyIterator.hasNext()){
			String banKey = banKeyIterator.next();
			System.out.println("---------"+banKey+"반----------");
			ArrayList<Student> tempStudent = schoolMap.get(banKey);
			Iterator<Student> studentIter = tempStudent.iterator();
			while(studentIter.hasNext()){
				studentIter.next().print();
			}
		}
		
		
		System.out.println();
		System.out.println(">> C반 학생만 출력");
		ArrayList<Student> studentArrList = schoolMap.get("C");
		
		Iterator<Student> studentIter2 = studentArrList.iterator();
		while(studentIter2.hasNext()){
			studentIter2.next().print();
		}
		
		
		System.out.println();
		System.out.println(">> A반 학생 추가");
		schoolMap.get("A").add(new Student(4, "SUMIN", 100, 100, 80));
		
		
		System.out.println();
		System.out.println(">> A반 4번 학생 찾기");
		studentArrList = schoolMap.get("A");
		
		Iterator<Student> studentIter3 = studentArrList.iterator();
		while(studentIter3.hasNext()){
			Student temp = studentIter3.next();
			if(temp.getNo() == 4){
				temp.print();
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("--------------------------------------");
		System.out.println("----Map의 Map을 이용한 주차장구현-----");
		System.out.println("--------------------------------------");
		System.out.println();
		
		//전체 주차 구역을 가지는 parkMap
		HashMap<String, HashMap<String, Car>> parkMap = new HashMap<String, HashMap<String, Car>>();
		
		//주차 구역 put
		parkMap.put("여우", new HashMap<String, Car>());
		parkMap.put("토끼", new HashMap<String, Car>());
		parkMap.put("호랑이", new HashMap<String, Car>());
		
		//각 주차 구역에 차량 put (입차)
		parkMap.get("여우").put("1111", new Car("1111", 11));
		parkMap.get("여우").put("2222", new Car("2222", 1));
		parkMap.get("여우").put("3333", new Car("3333", 13));
		
		parkMap.get("토끼").put("4444", new Car("4444", 4));
		parkMap.get("토끼").put("5555", new Car("5555", 5));
		
		parkMap.get("호랑이").put("6666", new Car("6666", 9));
		
		System.out.println(">>출차 : (여우 주차장의 3333번 차량)");
		Car removedCar = parkMap.get("여우").remove("3333");
		System.out.println();
		
		//전체 차량 출력
		System.out.println(">>전체 출력");
		Iterator<String> keyIter = parkMap.keySet().iterator();
		while (keyIter.hasNext()) {
			String parkKey = keyIter.next();
			System.out.println("---------"+parkKey+"-----------");
			Iterator<String> carNumIter = parkMap.get(parkKey).keySet().iterator();
			while(carNumIter.hasNext()){
				String tempCarNo = carNumIter.next();
				parkMap.get(parkKey).get(tempCarNo).print();
			}
		}
	}

}
