
public class AcademyStudent extends AcademyMember {	//Student is a Member.
	public String clazz; // 반

	public AcademyStudent() {
	
	}

	public AcademyStudent(int no, String name, String clazz) {
		this.no = no;	//부모 클래스의 멤버변수를 this로 받을 수 있다.
		this.name = name;
		this.clazz = clazz;
	}

	public void printStudent(){	//부모 클래스의 print 메소드와 이름이 겹치기 때문에 이름을 다르게 해주었다
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
