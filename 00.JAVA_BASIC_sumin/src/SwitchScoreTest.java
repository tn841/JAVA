public class SwitchScoreTest 
{
	public static void main(String[] args) 
	{
		/*
		����,����,���� ������ ������ 
		����,���,����(A,B,C....)�� ����Ͻÿ�....
           - 100���� �Ѵ� ���� ������ �ԷµǸ� �޼����� ����ϼ���
           - ����� �Ҽ������� 2�ڸ���������(�ݿø�) ����ϼ���
           - �������
			 
			 ************************
			 ����: 78
			 ����: 56
			 ����: 77
			 ����:256
			 ���:78.37
			 ����: C
			 ************************
		*/
		
		int kor,eng,math,total;
		double avg;
		char grade = 'A';
		kor=88;
		eng=76;
		math=30;
		
		if (kor<0 || kor >100){
			System.out.println("0~100 ������ ������ϴ�.");
			return;
		}
		if (eng<0 || eng >100){
			System.out.println("0~100 ������ ������ϴ�.");
			return;
		}
		if (math < 0 || math >100){
			System.out.println("0~100 ������ ������ϴ�.");
			return;
		}
		
		
		total = kor + eng+ math;
		
		
		avg = total/3.0;
		avg = avg+0.005;
		avg = avg*100;
		avg = (int)avg;	//�Ҽ��� �ڸ���
		avg = avg/100;	//�Ҽ� 2° �ڸ��� ǥ��
	

		
		switch ((int)avg/10) {
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		default:
			grade = 'F';
			break;
		}
		
		System.out.println("************************");
		System.out.println("����: "+kor);
		System.out.println("����: "+eng);
		System.out.println("����: "+math);
		System.out.println("����: "+total);
		System.out.println("���: "+avg);
		System.out.println("����: "+grade);
		System.out.println("************************");

		
	}
}

