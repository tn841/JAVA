
public class AcademyStudent extends AcademyMember {	//Student is a Member.
	public String clazz; // ��

	public AcademyStudent() {
	
	}

	public AcademyStudent(int no, String name, String clazz) {
		this.no = no;	//�θ� Ŭ������ ��������� this�� ���� �� �ִ�.
		this.name = name;
		this.clazz = clazz;
	}

	public void printStudent(){	//�θ� Ŭ������ print �޼ҵ�� �̸��� ��ġ�� ������ �̸��� �ٸ��� ���־���
		this.print();
		System.out.println(clazz);
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
