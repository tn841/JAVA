/*
�����ε�(�޽�� ��������)
  1. �ڹ� ������������� �����ϳ��̴�.
  2. ����:�����޽�� �̸����� �������� �����ϴ¹��
           - ��Ģ: 
               * �޽���� �̸��� ���ƾ��Ѵ�.
               * �޽���� ������ ���ڰ� �ٸ��ų�
               * �޽���� ������ Ÿ���� �޶���Ѵ�.
               * �޽���� ����Ÿ��,���������ڴ� �������.

*/
public class OverLoading {
		public void method(){
			System.out.println(">> method()");
		}
		public void method(String msg1){
			System.out.println(">> method(String msg1):"+msg1);
		}
		public void method(int a){
			System.out.println(">> method(int a):"+a);
		}
		/*
		//�޽���� ����Ÿ��,���������ڴ� �������.
		public int method(int a){
			System.out.println(">> method(int a):"+a);
			return a;
		}
		*/
		
		public void method(String msg1,String msg2){
			System.out.println(">> method(String msg1,String msg2):"+msg1+","+msg2);
		}
		public void method(int a,int b){
			System.out.println(">> method(int a,int b):"+a+","+b);
		}
		public void method(String msg1,int b){
			System.out.println(">> method(String msg1,int b):"+msg1+","+b);
		}
		
}
