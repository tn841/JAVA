/*
 * �������̵�(������) - Overriding
 *   1. ��Ӱ��迡�� �߻��ϴ� �޽���� ������ ����̴�
 *   2. �ڹ��� ������ ��������ϳ��̴�.
 *   
 *   -���� : �θ�Ŭ���������� �� �޽���� �̸�,����Ÿ��,���ڰ�
 *          ������ �޽�带 �ڽ�Ŭ������ ����(������)�ϴ°�
 * 
 *   - ex> public class Super{
 *   			public void print(){
 *   			}		
 *   		}
 *        
 *        public class Sub extends Super{
 *        		public void print(){
 *        		}
 *        }
 * 
 */

public class OverridingMain {

	public static void main(String[] args) {
		Overriding ol = new Overriding();
		ol.method1();
		ol.method2();
		System.out.println("------------------------------------");
		
		OverridingChild oc = new OverridingChild();
		oc.method1();
		oc.method2();	//�����ǵ� �޼ҵ� ȣ��
		oc.method3();
		
		//�� ���� ���� �̸��� �޼ҵ带 �̿��ؼ� �����Ǹ� �ؾ��ϳ�?
		//�׳� �޼ҵ��̸��� �ٸ��� �ϸ� ���� �ʳ�?
		
	}

}
