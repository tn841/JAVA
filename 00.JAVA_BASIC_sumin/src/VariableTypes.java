public class VariableTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ����('��' 'A' -> ���ڵ�����(���ͷ�))
		 */
		 
		char munja1, munja2, munja3, munja4, munja5;//��������
		
		munja1 ='A';
		munja2 ='��';
		munja3 ='��';
		munja4 ='ȯ';
		munja5 ='1'; // ���� ����
		
		/*
		 ���� 
		 
		 -������=(34 ,67,6 --> ������ ���ͷ�)
		 
		 -�Ǽ���=()
		 */
		 
		 
		byte b;
		short s;
		int i;
		long l;// ���� Ÿ�Ժ� ����
		
		b=127;
		s=32767;
		i=2147483647;
		l=2147483648l; //����Ÿ�Ժ� ����
		
		
		 //�������� Ÿ���� ������쿡�� ���԰���
		 		
		 int i1=1;
		 
		//byte b1= i1; <-- ������ Ÿ���� �ٸ��⶧���� ������ �Ұ���
		
		float f= 1.14f;
		double d=1.14;
		
		
		/*
		  ���� (���� ������(���ͷ�) --> true, false)
		*/
		
		boolean bool1;
		boolean bool2;
		
		bool1=true;
		bool2=false;
		
		boolean bool3=bool1;
		
		
		
		
		/*
		 * ���ڿ�
		*/
		
		 String str1, str2, result;
		 
		 str1="������ �������� ���� �����ؿ�~~";
		 str2="��̰ڴ�~~";
		 
		result= str1+str2;
		
		
		
		 
		
		System.out.println("--------------------");
		System.out.println("munja1="+munja1);
		System.out.println("munja2="+munja2);
		System.out.println("munja3="+munja3);
		System.out.println("munja4="+munja4);
		System.out.println("munja5="+munja5);
		
		System.out.println();
		
		System.out.println("b="+b);
		System.out.println("b="+Integer.toBinaryString(b));
		System.out.println("s="+s);
		System.out.println("i="+i);
		
		System.out.println();
		
		System.out.println("i1="+i1);
		System.out.println("f="+f);
		System.out.println("d="+d);
		
		System.out.println();
		
		System.out.println("str1="+str1);
		System.out.println("str2="+str2);
		System.out.println("str1+str2="+result);
		
		System.out.println();
		
		System.out.println("bool1"+bool1);
		System.out.println("bool2"+bool2);
		System.out.println("bool3"+bool3);
		
		
		
		
		System.out.println("--------------------");
		
		
		
	}

}
