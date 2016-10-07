
public class AcademyStudent extends AcademyMember {	//Student is a Member.
	public String clazz; // ��

	public AcademyStudent() {
	
	}

	public AcademyStudent(int no, String name, String clazz) {
		super();
		this.no = no;	//�θ� Ŭ������ ��������� this�� ���� �� �ִ�.
		this.name = name;
		this.clazz = clazz;
	}

//	public void printStudent(){	//�θ� Ŭ������ print �޼ҵ�� �̸��� ��ġ�� ������ �̸��� �ٸ��� ���־��� (Overriding �ʿ�,, �Ʒ����� ����)
//		this.print();
//		System.out.println(clazz);
//	}
	
	/* �θ� ������ �ִ� print()�޼ҵ�
	 public void print(){
	 	System.out.print(no+"\t"+name+"\t");
	 }	
	 */
	@Override
	public void print(){
		//this.print();	//�ڱ� �ڽ��� �����ϰԵȴ�.. ���⼭�� �������̵��� ���� ������ �θ� Ŭ������ �޼ҵ带 �ҷ����Ѵ�. -> super Ű���� �̿�
		super.print();	//super : self �������� (������ �Ǿ ����� �θ�Ŭ������ �޼ҵ� ���ٽ� ���)
		System.out.println(clazz);
		//System.out.println("this.toString = "+this.toString());
		//System.out.println("super.toString = "+super.toString());	//? �ּ� ���� ���� ����?
		
	}
	
	
	//getter, setter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

}
