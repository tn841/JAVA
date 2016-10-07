/*
 * ���(Ŭ������ ����):
 * 	�θ�Ŭ����(��ü)�� ������� �ڽ�Ŭ����(��ü)�� �����޴°�
 * 
 *  1. ����� ����ϴ�����--> ������ �������� Ŭ������ ����,
 * 						 Ȯ�������ػ���Ѵ�.
 *  2. �ڹٿ����� ���ϻ�Ӹ��� �����ϴ�(�θ�Ŭ������ �Ѱ�������) 
 *  3. �θ�Ŭ����(super)�� �ڽ�Ŭ����(sub)�������Ѵ�.
 *  4. �ڹٿ��� �����Ǿ����� ��� Ŭ�������� Object ����ϴ�
 *     �ֻ��� Ŭ�����κ��� ��ӵǾ�����.
 *  5. ��������� Ŭ�����鵵 Object Ŭ������� �ֻ���Ŭ������
 *     ���  �޾ƾ��Ѵ�. 
 * 
 */

public class AcademyMemberConstructorMain {

	public static void main(String[] args) {
		AcademyStudent st1 = new AcademyStudent(1, "����", "IOT");
		AcademyStudent st2 = new AcademyStudent(2, "�μ�", "���ǽ�");
		AcademyStudent st3 = new AcademyStudent(3, "����", "�׷���");
		
		AcademyGangsa gs1 = new AcademyGangsa(4, "�ڹ� ����", "JAVA");
		AcademyGangsa gs2 = new AcademyGangsa(5, "IOT ����", "IOT");
		
		AcademyStaff sf1 = new AcademyStaff(6, "����1", "����");
		AcademyStaff sf2 = new AcademyStaff(7, "����2", "ȫ��");
		
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
		members[6] = sf2;//�θ��� Ż�� �� �ڽ� ��ü��
		
		for (int i = 0; i < members.length; i++) {
			members[i].print();
		}
		
		/*
	 	instanceof ������:
	 	 - ����: reference���� instanceof Ŭ�����̸�
	 	 - ��ȯ: �������ͷ�(true,false)
	 	 - ex>  boolean isStudentInstance = 
	 	           st1 instanceof AcademyStudent;
	 	 
		 */
		
		for (int i = 0; i < members.length; i++) {	//��� ����� ��ü�� �ݺ��ϸ�
			
			if( members[i] instanceof AcademyStudent){	// �����[i]��°�� Ŭ������ Student�̸�
				AcademyStudent tempStudent = (AcademyStudent)members[i];	//�θ��� Ż�� �� �ڽİ�ü�� ����� ����ȯ�� �̿��� ���� �ڽİ�ü�� ����ȯ
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
