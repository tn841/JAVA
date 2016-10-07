
public class AcademyStudent extends AcademyMember {	//Student is a Member.
	public String clazz; // 반

	public AcademyStudent() {
	
	}

	public AcademyStudent(int no, String name, String clazz) {
		super();
		this.no = no;	//부모 클래스의 멤버변수를 this로 받을 수 있다.
		this.name = name;
		this.clazz = clazz;
	}

//	public void printStudent(){	//부모 클래스의 print 메소드와 이름이 겹치기 때문에 이름을 다르게 해주었다 (Overriding 필요,, 아래에서 구현)
//		this.print();
//		System.out.println(clazz);
//	}
	
	/* 부모가 가지고 있는 print()메소드
	 public void print(){
	 	System.out.print(no+"\t"+name+"\t");
	 }	
	 */
	@Override
	public void print(){
		//this.print();	//자기 자신을 참조하게된다.. 여기서는 오버라이딩에 의해 감춰진 부모 클래스의 메소드를 불러야한다. -> super 키워드 이용
		super.print();	//super : self 참조변수 (재정의 되어서 은폐된 부모클래스의 메소드 접근시 사용)
		System.out.println(clazz);
		//System.out.println("this.toString = "+this.toString());
		//System.out.println("super.toString = "+super.toString());	//? 주소 값이 같은 이유?
		
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
