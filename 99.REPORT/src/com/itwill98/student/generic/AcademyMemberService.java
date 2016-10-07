package com.itwill98.student.generic;

import java.util.ArrayList;
import java.util.Iterator;

public class AcademyMemberService {
	private AcademyMember[] memberArray;
	private ArrayList<AcademyMember> memberList;
//	int memberCount;

	public AcademyMemberService() {
		/*
		memberArray = new AcademyMember[10];
		memberCount = 10;
		memberArray[0] = new AcademyStudent(1, "KIM", "IOT");
		memberArray[1] = new AcademyStudent(2, "HIM", "IOT");
		memberArray[2] = new AcademyStudent(3, "GIM", "JAVA");
		memberArray[3] = new AcademyGangsa(4, "YONG", "JAVA");
		memberArray[4] = new AcademyGangsa(5, "TONG", "DESIGN");
		memberArray[5] = new AcademyStaff(6, "KANG", "����");
		memberArray[6] = new AcademyStaff(7, "SANG", "ȫ��");
		memberArray[7] = new AcademyStaff(8, "FANG", "ȫ��");
		memberArray[8] = new AcademyStaff(9, "DANG", "ȫ��");
		memberArray[9] = new AcademyStaff(10, "SANG", "ȫ��");
		*/
		memberList = new ArrayList<AcademyMember>();
		memberList.add(new AcademyStudent(1, "KIM", "IOT"));
		memberList.add(new AcademyStudent(2, "AEB", "IOT"));
		memberList.add(new AcademyStaff(3, "FEC", "ȫ��"));
		memberList.add(new AcademyStaff(4, "SBN", "����"));
		memberList.add(new AcademyGangsa(5, "BDE", "IOT"));
		memberList.add(new AcademyGangsa(6, "NRR", "Java"));
	}

	public void addMember(AcademyMember addMember) {
//		if (memberArray.length >= memberCount) { // memberCount�� 10���� �ʱ�ȭ �Ǿ�����, OutOfIndex ������ �����ϱ� ���� �����̴�.
//			AcademyMember[] tmemberArray = new AcademyMember[memberArray.length + 1];	//�迭 ������ 1 �ø� �迭 ��ü ����
//			for (int i = 0; i < memberArray.length; i++) {
//				tmemberArray[i] = memberArray[i];	//���� �迭 �����͸� �״�� �����ϰ�
//			}
//			memberArray = tmemberArray;
//			memberArray[memberCount] = addMember;	// �迭�� ������ �ε����� ���ڷ� �Ѿ�� addMember��ü�� �߰��ϴ� �۾�
//			memberCount++;							// Count 1����
//		}
		memberList.add(addMember);
	}// addMember()

	public void print() {	
		for (int i = 0; i < memberList.size(); i++) {
			memberList.get(i).print();

		}
	}

	public static void print(ArrayList<AcademyMember> aList) {
		for (Iterator iterator = aList.iterator(); iterator.hasNext();) {
			AcademyMember academyMember = (AcademyMember) iterator.next();
			academyMember.print();
		}
	}

	public AcademyMember findByNo(int no) {
		AcademyMember aMember = null;
//		for (int i = 0; i < memberArray.length; i++) {
//			if (memberArray[i] != null && memberArray[i].getNo() == no) {
//				aMember = memberArray[i];
//				break;
//			}
//		}
		for (int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i).getNo() == no){
				aMember = memberList.get(i);
			}
		}
		return aMember;
	}//findByNo(int no)

	public ArrayList<AcademyMember> findByName(String name) {
//		int count = 0;
//		for (int i = 0; i < memberArray.length; i++) {
//			if (memberArray[i] != null && memberArray[i].getName().equalsIgnoreCase(name)) {
//				count++;
//			}
//		}
//
//		AcademyMember[] aMembers = new AcademyMember[count];
//		int index = 0;
//		for (int i = 0; i < memberArray.length; i++) {
//			if (memberArray[i] != null && memberArray[i].getName().equalsIgnoreCase(name)) {
//				aMembers[index++] = memberArray[i];
//			}
//		}
//		return aMembers;
		ArrayList<AcademyMember> aMembersList = new ArrayList<AcademyMember>();
		for (Iterator iterator = memberList.iterator(); iterator.hasNext();) {
			AcademyMember academyMember = (AcademyMember) iterator.next();
			if(academyMember.getName().equals(name)){
				aMembersList.add(academyMember);
			}
		}
		return aMembersList;
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
			if (memberArray[i] != null && memberArray[i] instanceof AcademyStudent) {	//����� ����ȯ�� ���ؼ��� instanceof �����ڸ� ���� Ư�� �ڽİ�ü�� �߷�����..
				AcademyStudent st = (AcademyStudent) memberArray[i];	//�θ��� Ż�� �� �ڽİ�ü -> ����� ����ȯ ���� *****���Ⱑ �ٽ�,,, instanceof�����ڸ� �̿��� Ư�� �ڽİ�ü�� �߷������� ����� ����ȯ�� �����ϴ�. (Ư�� �ڽİ�ü�� �߸��� ������ ����ȯ�� �Ұ����ϴ�.) ***********
				if(st.getClazz().equalsIgnoreCase(name))
				count++;
			}
		}
		//	System.out.println("ī��Ʈ : "+count); //�� ������ �����ϴ� ��ü�� ����� Ȯ���ϱ� ����..
		AcademyMember[] tempArr = new AcademyMember[count];	//�� for������ ã�� count��ŭ�� �迭�� ����
		int index = 0;
		for (int i = 0; i < memberArray.length; i++) {
			if (memberArray[i] != null && memberArray[i] instanceof AcademyStudent) {
				AcademyStudent st = (AcademyStudent) memberArray[i];	//�θ��� Ż�� �� �ڽİ�ü -> ����� ����ȯ ����
				if(st.getClazz().equalsIgnoreCase(name))
				tempArr[index++] = memberArray[i];
			}
		}

		return tempArr;
	}//findStudentsByName(String name)
	
	
	public AcademyMember[] findStaffsByDepart(String depart) {
		int count = 0;
		for (int i = 0; i < memberArray.length; i++) {
			if (memberArray[i] != null && memberArray[i] instanceof AcademyStaff) {	//����� ����ȯ�� ���ؼ��� instanceof �����ڸ� ���� Ư�� �ڽİ�ü�� �߷�����..
				AcademyStaff staff = (AcademyStaff) memberArray[i];	//�θ��� Ż�� �� �ڽİ�ü -> ����� ����ȯ ����
				if(staff.getDepart().equalsIgnoreCase(depart))
				count++;
			}
		}
		//System.out.println("ī��Ʈ : "+count);
		AcademyMember[] tempArr = new AcademyMember[count];
		int index = 0;
		for (int i = 0; i < memberArray.length; i++) {
			if (memberArray[i] != null && memberArray[i] instanceof AcademyStaff) {
				AcademyStaff staff = (AcademyStaff) memberArray[i];	//�θ��� Ż�� �� �ڽİ�ü -> ����� ����ȯ ����
				if(staff.getDepart().equalsIgnoreCase(depart))
				tempArr[index++] = memberArray[i];
			}
		}

		return tempArr;
	}

	public AcademyMember[] findGangsasBySubject(String subject) {
		int count = 0;
		for (int i = 0; i < memberArray.length; i++) {
			if (memberArray[i] != null && memberArray[i] instanceof AcademyGangsa) {	//����� ����ȯ�� ���ؼ��� instanceof �����ڸ� ���� Ư�� �ڽİ�ü�� �߷�����..
				AcademyGangsa gangsa = (AcademyGangsa) memberArray[i];	//�θ��� Ż�� �� �ڽİ�ü -> ����� ����ȯ ����
				if(gangsa.getSubject().equalsIgnoreCase(subject))
				count++;
			}
		}
		//System.out.println("ī��Ʈ : "+count);
		AcademyMember[] tempArr = new AcademyMember[count];
		int index = 0;
		for (int i = 0; i < memberArray.length; i++) {
			if (memberArray[i] != null && memberArray[i] instanceof AcademyGangsa) {
				AcademyGangsa gangsa = (AcademyGangsa) memberArray[i];	//�θ��� Ż�� �� �ڽİ�ü -> ����� ����ȯ ����
				if(gangsa.getSubject().equalsIgnoreCase(subject))
				tempArr[index++] = memberArray[i];
			}
		}

		return tempArr;
	}//findGangsasBySubject(String subject)



}
