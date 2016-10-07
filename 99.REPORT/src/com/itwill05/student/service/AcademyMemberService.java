package com.itwill05.student.service;

public class AcademyMemberService {
	private AcademyMember[] memberArray;
	int memberCount;

	public AcademyMemberService() {
		memberArray = new AcademyMember[10];
		memberCount = 10;
		memberArray[0] = new AcademyStudent(1, "KIM", "IOT");
		memberArray[1] = new AcademyStudent(2, "HIM", "IOT");
		memberArray[2] = new AcademyStudent(3, "GIM", "JAVA");
		memberArray[3] = new AcademyGangsa(4, "YONG", "JAVA");
		memberArray[4] = new AcademyGangsa(5, "TONG", "DESIGN");
		memberArray[5] = new AcademyStaff(6, "KANG", "교육");
		memberArray[6] = new AcademyStaff(7, "SANG", "홍보");
		memberArray[7] = new AcademyStaff(8, "FANG", "홍보");
		memberArray[8] = new AcademyStaff(9, "DANG", "홍보");
		memberArray[9] = new AcademyStaff(10, "SANG", "홍보");
	}

	public void addMember(AcademyMember addMember) {
		if (memberArray.length >= memberCount) { // memberCount는 10으로 초기화 되었으며, OutOfIndex 오류를 방지하기 위한 변수이다.
			AcademyMember[] tmemberArray = new AcademyMember[memberArray.length + 1];	//배열 사이즈 1 늘린 배열 객체 생성
			for (int i = 0; i < memberArray.length; i++) {
				tmemberArray[i] = memberArray[i];	//기존 배열 데이터를 그대로 복사하고
			}
			memberArray = tmemberArray;
			memberArray[memberCount] = addMember;	// 배열의 마지막 인덱스에 인자로 넘어온 addMember객체를 추가하는 작업
			memberCount++;							// Count 1증가
		}
	}// addMember()

	public void print() {	
		for (int i = 0; i < memberArray.length; i++) {
			memberArray[i].print();

		}
	}

	public static void print(AcademyMember[] members) {
		for (int i = 0; i < members.length; i++) {
			if (members[i] != null) {
				members[i].print();
			}
		}
	}

	public AcademyMember findByNo(int no) {
		AcademyMember aMember = null;
		for (int i = 0; i < memberArray.length; i++) {
			if (memberArray[i] != null && memberArray[i].getNo() == no) {
				aMember = memberArray[i];
				break;
			}
		}
		return aMember;
	}//findByNo(int no)

	public AcademyMember[] findByName(String name) {
		int count = 0;
		for (int i = 0; i < memberArray.length; i++) {
			if (memberArray[i] != null && memberArray[i].getName().equalsIgnoreCase(name)) {
				count++;
			}
		}

		AcademyMember[] aMembers = new AcademyMember[count];
		int index = 0;
		for (int i = 0; i < memberArray.length; i++) {
			if (memberArray[i] != null && memberArray[i].getName().equalsIgnoreCase(name)) {
				aMembers[index++] = memberArray[i];
			}
		}
		return aMembers;
	}//findByName(String name)

	public AcademyMember[] findStudents() {
		int count = 0;
		for (int i = 0; i < memberArray.length; i++) {
			if (memberArray[i] != null && memberArray[i] instanceof AcademyStudent) {
				count++;
			}
		}
		AcademyMember[] tempArr = new AcademyMember[count];
		int index = 0;

		for (int i = 0; i < memberArray.length; i++) {
			if (memberArray[i] != null && memberArray[i] instanceof AcademyStudent) {
				tempArr[index++] = memberArray[i];
			}
		}
		return tempArr;
	}//findStudents()

	public AcademyMember[] findStaffs() {
		int count = 0;
		for (int i = 0; i < memberArray.length; i++) {
			if (memberArray[i] != null && memberArray[i] instanceof AcademyStaff) {
				count++;
			}
		}
		AcademyMember[] tempArr = new AcademyMember[count];
		int index = 0;

		for (int i = 0; i < memberArray.length; i++) {
			if (memberArray[i] != null && memberArray[i] instanceof AcademyStaff) {
				tempArr[index++] = memberArray[i];
			}
		}
		return tempArr;
	}//findStaffs()

	public AcademyMember[] findGangsas() {
		int count = 0;
		for (int i = 0; i < memberArray.length; i++) {
			if (memberArray[i] != null && memberArray[i] instanceof AcademyGangsa) {
				count++;
			}
		}
		AcademyMember[] tempArr = new AcademyMember[count];
		int index = 0;

		for (int i = 0; i < memberArray.length; i++) {
			if (memberArray[i] != null && memberArray[i] instanceof AcademyGangsa) {
				tempArr[index++] = memberArray[i];
			}
		}
		return tempArr;
	}//findGangsas()

	public AcademyMember[] findStudentsByName(String name) {
		int count = 0;
		for (int i = 0; i < memberArray.length; i++) {
			if (memberArray[i] != null && memberArray[i] instanceof AcademyStudent) {	//명시적 형변환을 위해서는 instanceof 연산자를 통해 특정 자식객체만 추려야함..
				AcademyStudent st = (AcademyStudent) memberArray[i];	//부모의 탈을 쓴 자식객체 -> 명시적 형변환 가능 *****여기가 핵심,,, instanceof연산자를 이용해 특정 자식객체를 추려야지만 명시적 형변환이 가능하다. (특정 자식객체를 추리지 않으면 형변환이 불가능하다.) ***********
				if(st.getClazz().equalsIgnoreCase(name))
				count++;
			}
		}
		//	System.out.println("카운트 : "+count); //위 조건을 만족하는 객체가 몇개인지 확인하기 위해..
		AcademyMember[] tempArr = new AcademyMember[count];	//위 for문에서 찾은 count만큼의 배열을 생성
		int index = 0;
		for (int i = 0; i < memberArray.length; i++) {
			if (memberArray[i] != null && memberArray[i] instanceof AcademyStudent) {
				AcademyStudent st = (AcademyStudent) memberArray[i];	//부모의 탈을 쓴 자식객체 -> 명시적 형변환 가능
				if(st.getClazz().equalsIgnoreCase(name))
				tempArr[index++] = memberArray[i];
			}
		}

		return tempArr;
	}//findStudentsByName(String name)
	
	
	public AcademyMember[] findStaffsByDepart(String depart) {
		int count = 0;
		for (int i = 0; i < memberArray.length; i++) {
			if (memberArray[i] != null && memberArray[i] instanceof AcademyStaff) {	//명시적 형변환을 위해서는 instanceof 연산자를 통해 특정 자식객체만 추려야함..
				AcademyStaff staff = (AcademyStaff) memberArray[i];	//부모의 탈을 쓴 자식객체 -> 명시적 형변환 가능
				if(staff.getDepart().equalsIgnoreCase(depart))
				count++;
			}
		}
		//System.out.println("카운트 : "+count);
		AcademyMember[] tempArr = new AcademyMember[count];
		int index = 0;
		for (int i = 0; i < memberArray.length; i++) {
			if (memberArray[i] != null && memberArray[i] instanceof AcademyStaff) {
				AcademyStaff staff = (AcademyStaff) memberArray[i];	//부모의 탈을 쓴 자식객체 -> 명시적 형변환 가능
				if(staff.getDepart().equalsIgnoreCase(depart))
				tempArr[index++] = memberArray[i];
			}
		}

		return tempArr;
	}

	public AcademyMember[] findGangsasBySubject(String subject) {
		int count = 0;
		for (int i = 0; i < memberArray.length; i++) {
			if (memberArray[i] != null && memberArray[i] instanceof AcademyGangsa) {	//명시적 형변환을 위해서는 instanceof 연산자를 통해 특정 자식객체만 추려야함..
				AcademyGangsa gangsa = (AcademyGangsa) memberArray[i];	//부모의 탈을 쓴 자식객체 -> 명시적 형변환 가능
				if(gangsa.getSubject().equalsIgnoreCase(subject))
				count++;
			}
		}
		//System.out.println("카운트 : "+count);
		AcademyMember[] tempArr = new AcademyMember[count];
		int index = 0;
		for (int i = 0; i < memberArray.length; i++) {
			if (memberArray[i] != null && memberArray[i] instanceof AcademyGangsa) {
				AcademyGangsa gangsa = (AcademyGangsa) memberArray[i];	//부모의 탈을 쓴 자식객체 -> 명시적 형변환 가능
				if(gangsa.getSubject().equalsIgnoreCase(subject))
				tempArr[index++] = memberArray[i];
			}
		}

		return tempArr;
	}//findGangsasBySubject(String subject)



}
