package com.itwill99.student.service;

/*
 AcademyMember 배열을 멤버로가지며
 AcademyMember들을 관리하는 기능을가진 클래스
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
		memberArray[5] = new AcademyStaff(6, "KANG", "교육");
		memberArray[6] = new AcademyStaff(7, "SANG", "홍보");
		memberArray[7] = new AcademyStaff(8, "FANG", "홍보");
		memberArray[8] = new AcademyStaff(9, "DANG", "홍보");
		memberArray[9] = new AcademyStaff(10, "SANG", "홍보");
		memberArray[10] = new AcademyOperator(11, "OP", "PC정비");
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
	 * 0.AcademyMember(AcademyStudent,AcademyStaff,AcademyGangsa)추가"
	 * 1.AcademyMember전체출력기능 
	 * 2.번호 입력받아 AcademyMember 1명 반환 
	 * 3.이름 입력받아 AcademyMember 들 반환 
	 * 4.AcademyStudent들 반환 
	 * 5.AcademyStaff 들 반환
	 * 6.AcademyGangsa 들 반환 
	 * 7.반  이름 입력받아 검색후 AcademyStudent 들 반환 
	 * 8.부서이름 입력받아 검색후 AcademyStaff   들 반환 
	 * 9.과목이름 입력받아 검색후 AcademyGansa   들 반환
	 */
	
	/*
	  4.AcademyStudent들 반환 
	  5.AcademyStaff 들 반환
	  6.AcademyGangsa 들 반환 
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
		7.반  이름 입력받아 검색후 AcademyStudent 들 반환 
		8.부서이름 입력받아 검색후 AcademyStaff   들 반환 
		9.과목이름 입력받아 검색후 AcademyGansa   들 반환
	 */
	public AcademyMember[] findByChildMember1(AcademyMember findMember){
		
		return null;
	}
	public AcademyMember[] findByChildMember2(int memberType,String findData){
		return null;
	}
	

}
