/*
 * 상속(클래스의 관계):
 * 	부모클래스(객체)의 멤버들을 자식클래스(객체)가 물려받는것
 * 
 *  1. 상속을 사용하는이유--> 기존에 만들어놓은 클래스의 재사용,
 * 						 확장을위해사용한다.
 *  2. 자바에서는 단일상속만이 가능하다(부모클래스가 한개만가능) 
 *  3. 부모클래스(super)와 자식클래스(sub)가존재한다.
 *  4. 자바에서 제공되어지는 모든 클래스들은 Object 라고하는
 *     최상위 클래스로부터 상속되어진다.
 *  5. 사용자정의 클래스들도 Object 클래스라는 최상위클래스를
 *     상속  받아야한다. 
 * 
 */

public class AcademyMemberConstructorMain {

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
		members[0] = st1;
		members[1] = st2;
		members[2] = st3;
		members[3] = gs1;
		members[4] = gs2;
		members[5] = sf1;
		members[6] = sf2;//부모의 탈을 쓴 자식 객체들
		
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
		
		for (int i = 0; i < members.length; i++) {	//모든 멤버스 객체를 반복하며
			
			if( members[i] instanceof AcademyStudent){	// 멤버스[i]번째의 클래스가 Student이면
				AcademyStudent tempStudent = (AcademyStudent)members[i];	//부모의 탈을 쓴 자식객체를 명시적 형변환을 이용해 원래 자식객체로 형변환
				String ban=tempStudent.getClazz();
				System.out.println("Student:"+ban);
			}
			if(members[i] instanceof AcademyStaff){
				AcademyStaff tempStaff=(AcademyStaff)members[i];
				System.out.println("Staff:"+tempStaff.getDepart());
			}
			if(members[i] instanceof AcademyGangsa){
				AcademyGangsa tempGangsa=(AcademyGangsa)members[i];
				System.out.println("Gangsa:"+tempGangsa.getSubject());
			}
			
			
		}

	}

}
