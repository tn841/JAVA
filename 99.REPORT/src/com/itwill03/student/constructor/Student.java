package com.itwill03.student.constructor;

public class Student {
    
	//private으로 캡슐화
	private int no;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
	private char grad;
	private int rank;
    
	/*
	 * Constructor
	 */
	public Student(){	//디폴트 생성자는 기본적으로 정의해주자 (상속 문제)
		
	}
	
	public Student(int no, String name, int kor, int eng, int math) {	//인자를 4개 받는 생성자
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		//생성하면서 셀프 참조 변수를 통해 총점, 평균, 평점을 구할 수 있다.
		this.calcAll();
	}
	
	

	/*
	 * getter, setter 생성
	 */
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

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public char getGrad() {
		return grad;
	}

	public void setGrad(char grad) {
		this.grad = grad;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
	
	/*
	 * 기타 메소드
	 */   
    public void calcTotal(){	//총점계산
    	this.total = this.kor + this.eng + this.math;
    }
    
    public void calcAvg(){		//평균계산
    	double temp = this.total / 3.0;
    	this.avg = (int) (temp*100+0.5)/100.0;
    }
    
    public void calcGrad(){		//평점 계산
    	
    	if(this.avg >90){
    		grad = 'A';
    	}
    	else if(this.avg>80){
    		grad = 'B';
    	}
    	else if(this.avg>70){
    		grad = 'C';
    	}
    	else if(this.avg>60){
    		grad = 'D';
    	}
    	else{
    		grad = 'F';
    	}
    }
    
    public void calcAll(){	//총점, 평균, 평점 한번에 계산
    	this.calcTotal();
    	this.calcAvg();
    	this.calcGrad();
    }
    
    public static void headerPrint(){	//헤더 정적 메소드
    	System.out.println("-------------------------------------------------------------");
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t평점");
    }
    
    public static void footerPrint(){	//푸터 정적 메소드
    	System.out.println("-------------------------------------------------------------");
    }
    
    public void print(){	//성적 정보 출력 메소드
    	System.out.println(no+"\t"+name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+total+"\t"+avg+"\t"+grad+"\t");
    }
    
   
}
