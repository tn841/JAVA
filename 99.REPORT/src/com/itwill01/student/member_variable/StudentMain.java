package com.itwill01.student.member_variable;

public class StudentMain {

	public static void main(String[] args) {
		/*
		 * 1. �л�classŸ�� ��������(2��)
		 * 2. �л���ü ���� �� ���� ����
		 * 3. �л���ü�� �������Է� (��ȣ, �̸�, ����, ����, ����)
		 * 4. �л���ü�� �������Է� (����, ���, ����)
		 * 5. �������
		 */
		
		
		Student s1 = new Student();
		Student s2 = new Student();
		
		s1.no = 1;
		s1.name = "������";
		s1.kor = 97;
		s1.eng = 90;
		s1.math = 88;
		s1.total = s1.kor + s1.eng + s1.math;
		double temp = s1.total/3.0;
		s1.avg = (int) (temp*100+0.5)/100.0;
		s1.grad = 'A';
		
		
		s2.no = 2;
		s2.name = "�󸶹�";
		s2.kor = 95;
		s2.eng = 80;
		s2.math = 83;
		s2.total = s2.kor + s2.eng + s2.math;
		temp = s2.total/3.0;
		s2.avg = (int) (temp*100+0.5)/100.0;
		s2.grad = 'B';
		
		System.out.println("-------------------------------------------------------------");
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t����");
		System.out.println(s1.no+"\t"+s1.name+"\t"+s1.kor+"\t"+s1.eng+"\t"+s1.math+"\t"+s1.total+"\t"+s1.avg+"\t"+s1.grad);
		System.out.println(s2.no+"\t"+s2.name+"\t"+s2.kor+"\t"+s2.eng+"\t"+s2.math+"\t"+s2.total+"\t"+s2.avg+"\t"+s2.grad);
		System.out.println("-------------------------------------------------------------");
	}

}
