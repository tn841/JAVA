
public class Child extends Parent{
	public int member3;
	public Child() {
		/*
		 * �θ�Ŭ������ �⺻�����ڰ� ȣ��ȴ�.(��������)
		 */

		System.out.println("Child()");
	}
	
	public Child(int member1,int member2,int member3) {
		super(member1,member2);	//�θ�Ŭ������ �����ڸ� Ȱ����..
		//this.member1=member1;
		//this.member2=member2;
		this.member3 = member3;
		System.out.println("Child(int member1,int member2,int member3)");
	}

	public void method3(){
		System.out.println("method3()");
	}
	
}



