
public class OuterClass2 {
	public int outer_member_field = 999;
	
	public void outer_method(){
		System.out.println("OuterClass2.outer_method()");
	}
	
	public void outer_annonymous_local_inner_class(){	//�޼ҵ� ���δ� local�����̴�.
		/*
		 * local ���� (����, Ŭ���� ��..)
		 */
		int local_member = 99;
		
		/*
		 * Annoymous local inner Class
		 */
		
		
		//MemberInnerClass mic = new MemberInnerClass();
		//mic.Inner_method();
		Object oc = new Object(){	//oc�� Object Child ��ü�̴�.
			public void Inner_method() {	//�͸� Ŭ������ �޼ҵ�� �ǹ� ���� ���̴�..
				System.out.println("�̸�����.Inner_method()");
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "Here is annoymous class's overriding mothed";
			}
		};
		System.out.println(oc.toString());
		 
	}
	

	
}
