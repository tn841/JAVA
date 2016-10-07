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

public class AcademyMemberMain {//��������

	public static void main(String[] args) {
		AcademyStudent st1 = new AcademyStudent(1, "����", "IOT");
		AcademyStudent st2 = new AcademyStudent(2, "�μ�", "���ǽ�");
		AcademyStudent st3 = new AcademyStudent(3, "����", "�׷���");
		
		AcademyGangsa gs1 = new AcademyGangsa(4, "�ڹ� ����", "JAVA");
		AcademyGangsa gs2 = new AcademyGangsa(5, "IOT ����", "IOT");
		
		AcademyStaff sf1 = new AcademyStaff(6, "����1", "����");
		AcademyStaff sf2 = new AcademyStaff(7, "����2", "ȫ��");
		
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
			students[i].printStudent();	//�������̵�(������)�� �������� �ʾҴ�.
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
