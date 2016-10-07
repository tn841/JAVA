
public class AcademyMemberOverridingMain {

	public static void main(String[] args) {
		AcademyStudent st1 = new AcademyStudent(1, "수민", "IOT");
		AcademyStudent st2 = new AcademyStudent(2, "민수", "오피스");
		AcademyStudent st3 = new AcademyStudent(3, "수수", "그래픽");
		
		AcademyGangsa gs1 = new AcademyGangsa(4, "자바 강사", "JAVA");
		AcademyGangsa gs2 = new AcademyGangsa(5, "IOT 강사", "IOT");
		
		AcademyStaff sf1 = new AcademyStaff(6, "스탭1", "교육");
		AcademyStaff sf2 = new AcademyStaff(7, "스탭2", "홍보");
		
//		AcademyStudent[] students = new AcademyStudent[3];
//		AcademyGangsa[] gangsas = new AcademyGangsa[2];
//		AcademyStaff[] staffs = new AcademyStaff[2];
//		
//		students[0]=st1;
//		students[1]=st2;
//		students[2]=st3;
//		
//		gangsas[0] = gs1;
//		gangsas[1] = gs2;
//		
//		staffs[0] = sf1;
//		staffs[1] = sf2;
		
		
		AcademyMember[] members = new AcademyMember[7];
		members[0] = st1;	//부모 = 자식;
		members[1] = st2;
		members[2] = st3;
		members[3] = gs1;
		members[4] = gs2;
		members[5] = sf1;
		members[6] = sf2;
		
		for (int i = 0; i < members.length; i++) {
			members[i].print();
		}
		
		/*
	 	instanceof 연산자:
	 	 - 형태: reference변수 instanceof 클래스이름
	 	 - 반환: 논리형리터럴(true,false)
	 	 - ex>  boolean isStudentInstance = 
	 	           st1 instanceof AcademyStudent;
	 	 
		 */
		System.out.println("---------instanceof---------");
		
		for (int i = 0; i < members.length; i++) {
			if(members[i] instanceof AcademyStudent){
				AcademyStudent tempSt = (AcademyStudent)members[i];
				String clazz = tempSt.getClazz();
				System.out.println("Student:"+clazz);
			}
		}

	}

}
