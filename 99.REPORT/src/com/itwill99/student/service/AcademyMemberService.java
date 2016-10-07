package com.itwill99.student.service;

/*
 AcademyMember �迭�� ����ΰ�����
 AcademyMember���� �����ϴ� ��������� Ŭ����
 */
public class AcademyMemberService {
	private AcademyMember[] memberArray;
	
	public AcademyMemberService() {
		memberArray = new AcademyMember[11];
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
		memberArray[10] = new AcademyOperator(11, "OP", "PC����");
	}
	/*
	public void addMember(AcademyMember addMember){
		
	}
	*/
	public void print(){
		for (int i = 0; i < memberArray.length; i++) {
			memberArray[i].print();
		}
	}
	/*
	 * 0.AcademyMember(AcademyStudent,AcademyStaff,AcademyGangsa)�߰�"
	 * 1.AcademyMember��ü��±�� 
	 * 2.��ȣ �Է¹޾� AcademyMember 1�� ��ȯ 
	 * 3.�̸� �Է¹޾� AcademyMember �� ��ȯ 
	 * 4.AcademyStudent�� ��ȯ 
	 * 5.AcademyStaff �� ��ȯ
	 * 6.AcademyGangsa �� ��ȯ 
	 * 7.��  �̸� �Է¹޾� �˻��� AcademyStudent �� ��ȯ 
	 * 8.�μ��̸� �Է¹޾� �˻��� AcademyStaff   �� ��ȯ 
	 * 9.�����̸� �Է¹޾� �˻��� AcademyGansa   �� ��ȯ
	 */
	
	/*
	  4.AcademyStudent�� ��ȯ 
	  5.AcademyStaff �� ��ȯ
	  6.AcademyGangsa �� ��ȯ 
	 */
	public AcademyMember[] findAcademyMembers(int memberType){
		int count=0;
		for (int i = 0; i < memberArray.length; i++) {
			if(memberType==AcademyMember.MEMBER_STUDENT){
				if(memberArray[i] instanceof AcademyStudent){
					count++;
				}
			}else if(memberType==AcademyMember.MEMBER_STAFF){
				if(memberArray[i] instanceof AcademyStaff){
					count++;
				}
			}else if(memberType==AcademyMember.MEMBER_GANGSA){
				if(memberArray[i] instanceof AcademyGangsa){
					count++;
				}
			} 
		}
		AcademyMember[] findMembers=new AcademyMember[count];
		count=0;
		for (int i = 0; i < memberArray.length; i++) {
			if(memberType==AcademyMember.MEMBER_STUDENT){
				if(memberArray[i] instanceof AcademyStudent){
					findMembers[count] = memberArray[i];
					count++;
				}
			}else if(memberType==AcademyMember.MEMBER_STAFF){
				if(memberArray[i] instanceof AcademyStaff){
					findMembers[count] = memberArray[i];
					count++;
				}
			}else if(memberType==AcademyMember.MEMBER_GANGSA){
				if(memberArray[i] instanceof AcademyGangsa){
					findMembers[count] = memberArray[i];
					count++;
				}
			} 
			
		}
		return findMembers;
	}
	/*
		7.��  �̸� �Է¹޾� �˻��� AcademyStudent �� ��ȯ 
		8.�μ��̸� �Է¹޾� �˻��� AcademyStaff   �� ��ȯ 
		9.�����̸� �Է¹޾� �˻��� AcademyGansa   �� ��ȯ
	 */
	public AcademyMember[] findByChildMember1(AcademyMember findMember){
		
		return null;
	}
	public AcademyMember[] findByChildMember2(int memberType,String findData){
		return null;
	}
	

}
