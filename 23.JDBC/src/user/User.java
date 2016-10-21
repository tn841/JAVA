package user;

public class User {
/*
	 이름       널        유형           
	-------- -------- ------------ 
	USERID   NOT NULL VARCHAR2(12) 
	PASSWORD NOT NULL VARCHAR2(12) 
	NAME     NOT NULL VARCHAR2(20) 
	EMAIL             VARCHAR2(50) 
 */
	private String id;
	private String pw;
	private String name;
	private String email;
	
	public User(){
		
	}

	public User(String id, String pw, String name, String email) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
