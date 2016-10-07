
public class OuterClass {
	/*
	 * member field
	 */
	public int outer_member_var = 88;
	public OuterClass() {
		// TODO Auto-generated constructor stub
	}
	/*
	 * member method
	 */
	public void outer_method(){
		System.out.println("OuterClass.outer_method()");
	}
	
	/*
	 * �ܺ�Ŭ�������� ����Ŭ���� ���(��ü ����)
	 */
	public void outer_inner_use(){
		//OuterClass.InnerClass ic = this.new InnerClass();
		InnerClass ic = new InnerClass();
		int iii = ic.inner_member_var;
		ic.inner_method();
	}
	
	
	
	/*
	 * member class
	 */
	public class InnerClass{
		public int inner_member_var = 99;
		public void inner_method(){
			System.out.println("InnerClass.inner_method()");
		}
		
		/*
		 *  �̳�Ŭ������ ����� ����
		 *  	- ����Ŭ�������� �ܺ�Ŭ���� ��� ���� 
		 */
		
		public void inner_outer_access(){
			OuterClass.this.outer_member_var = 33;	//�������� ���� ���
			InnerClass.this.inner_member_var = 33;
			
			outer_member_var = 48684;	//��� ���� �����Ѱ���? �̳ʿ��� �ش��̸��� ��������� ã�� ������ �ƿ��Ϳ��� ��������� ã�´�.
			this.inner_member_var = 23423;
			System.out.println(outer_member_var);
		}
	}
	
}









