
public class StaticMain {

	public static void main(String[] args) {
		/*
		 * static �������
		 */
		
		//Ŭ������ �����Ǵ�(�ε��Ǵ�) �޼ҵ� ������ ��������� ���������� ���ٰ����ϴ�.
		Static.static_var=300;	//���� ���������  ���Ÿ�ü�� ǥ�õ�.
		System.out.println("���� ����"+Static.static_var);	
		Static.static_method();
		
		/*
		 * instance �������
		 */
		Static st1 = new Static();
		Static st2 = new Static();
		st1.instance_var = 800;
		st2.instance_var = 900;
		System.out.println("st1 �ν��Ͻ� ����"+st1.instance_var);
		st1.instance_method();
		System.out.println("st2 �ν��Ͻ� ����"+st2.instance_var);
		st2.instance_method();
		
		System.out.println("------------���������� ���� static�������------------");
		System.out.println(st1.static_var);
		//The static field Static.static_var should be accessed in a static way
		System.out.println(st2.static_var);
		st1.static_method();
	}

}
