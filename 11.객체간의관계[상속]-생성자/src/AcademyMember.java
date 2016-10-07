
public class AcademyMember {
	private int no;
	private String name;
	
	public AcademyMember() {
		// TODO Auto-generated constructor stub
	}

	public AcademyMember(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public void print(){	//학생, 강사, 스텝의 정보는 찍지 못하는 약간 부족한 메소드, 각각 자식 클래스에서 해당 메소드를 재정의하여 부족한 정보를 채워준다.
		System.out.print(no+"\t"+name+"\t");
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
	
	
}
