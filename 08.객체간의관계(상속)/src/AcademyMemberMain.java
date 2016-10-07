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

public class AcademyMemberMain {//ㅇㅇㅇㅇ

	public static void main(String[] args) {
		AcademyStudent st1 = new AcademyStudent(1, "수민", "IOT");
		AcademyStudent st2 = new AcademyStudent(2, "민수", "오피스");
		AcademyStudent st3 = new AcademyStudent(3, "수수", "그래픽");
		
		AcademyGangsa gs1 = new AcademyGangsa(4, "자바 강사", "JAVA");
		AcademyGangsa gs2 = new AcademyGangsa(5, "IOT 강사", "IOT");
		
		AcademyStaff sf1 = new AcademyStaff(6, "스탭1", "교육");
		AcademyStaff sf2 = new AcademyStaff(7, "스탭2", "홍보");
		
		AcademyStudent[] students = new AcademyStudent[3];
		AcademyGangsa[] gangsas = new AcademyGangsa[2];
		AcademyStaff[] staffs = new AcademyStaff[2];
		
		students[0]=st1;
		students[1]=st2;
		students[2]=st3;
		
		gangsas[0] = gs1;
		gangsas[1] = gs2;
		
		staffs[0] = sf1;
		staffs[1] = sf2;
		
		
		System.out.println("----------students-----------");
		for(int i=0; i<students.length; i++){
			students[i].printStudent();	//오버라이딩(재정의)을 적용하지 않았다.
		}
		System.out.println();
		
		System.out.println("----------gangsas-----------");
		for(int i=0; i<gangsas.length; i++){
			gangsas[i].printGangsa();
		}
		System.out.println();
		
		System.out.println("----------staffs-----------");
		for(int i=0; i<staffs.length; i++){
			staffs[i].printStaff();
		}
		System.out.println();

	}

}
