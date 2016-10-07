/*
������ �޼ҵ�(constructor): ��ü �������� ���ʷ� ����Ǹ� �� �ѹ��� ����Ǵ� �޼ҵ�(?) �̴�.
1. Ŭ���� �̸��������ϸ� ����Ÿ���� ��������ʴ� �޽��(???)
2. �ϳ��� Ŭ�������� �ݵ�� �ϳ��̻��� �����ڰ� �����Ͽ����Ѵ�
--> �����ڸ� ��������������� �����Ϸ��� ���ڰ��ϳ�������
    ������(������ ������)�� �ڵ����� �־ �������Ѵ�.    
3. ��ü������ ���ѹ� ȣ��ȴ�.
4. �ַ� ��ü�ʱ�ȭ�� �뵵�� ����Ѵ�.
5. ��ü�� �����ҷ��� �ݵ�� �����ڸ� ȣ���Ͽ����Ѵ�.
	
	-����: 
	 	public class Test{
	 		//�������� ����(����)
	 	    public Test(){
	 	    }
	 	}
	 	
    -���: 
           Test t = new Test(); 
	 	   Ŭ������ ���������̸� = new Ŭ������();
	 	   new ��� �����ڴ� �ݵ�� ������ �տ��־���ϸ�
	 	   �̿����ڿ����� ��ü�� �����Ѵ�.
*/


public class Constructor {
	private int member1;
	private int member2;
	/*
	 * �⺻(����Ʈ) ������
	 */
	public Constructor(){	//�����ڰ� ȣ��Ǵ� ������, ��ü�� �̹� �����Ǿ� �ֱ� ������ ��������(this)�� �����ϴ�.
		System.out.println("Constructor()");
		this.member1 = 100;
		this.member2 = 200;
	}
	
	public Constructor(int m1){	
		System.out.println("Constructor(int m1)");
		this.member1 = m1;
		this.member2 = 0;
	}
	
	public Constructor(int m1, int m2){	
		System.out.println("Constructor(int m1, int m2)");
		this.member1 = m1;
		this.member2 = m2;
	}
	
	public void print(){
		System.out.println(member1+", "+member2);
	}
	
	
	
	/*
	 * getter, setter ���� ����Ű Alt + Shift + S -> r
	 */
	public int getMember1() {
		return member1;
	}

	public void setMember1(int member1) {
		this.member1 = member1;
	}

	public int getMember2() {
		return member2;
	}

	public void setMember2(int member2) {
		this.member2 = member2;
	}



}
