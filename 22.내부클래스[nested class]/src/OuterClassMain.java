
public class OuterClassMain {

	public static void main(String[] args) {
		OuterClass oc = new OuterClass();
		oc.outer_member_var = 3215;
		oc.outer_method();
		
		oc.new InnerClass();	//�ܺ�Ŭ���� ��ü���� ����Ŭ���� ������ ȣ��
		OuterClass.InnerClass ic = oc.new InnerClass();
		ic.inner_member_var=41561;
		ic.inner_method();
	}

}
