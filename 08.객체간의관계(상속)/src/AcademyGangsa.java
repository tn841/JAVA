
public class AcademyGangsa extends AcademyMember {
	public String subject;	//°ú¸ñ
	
	public AcademyGangsa() {
		// TODO Auto-generated constructor stub
	}

	public AcademyGangsa(int no, String name, String subject) {
		this.no = no;
		this.name = name;
		this.subject = subject;
	}

	public void printGangsa(){
		this.print();
		System.out.println(subject);
	}
	
	//getter, setter
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	
}
