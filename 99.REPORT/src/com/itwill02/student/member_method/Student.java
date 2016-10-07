package com.itwill02.student.member_method;

public class Student {
    
	public int no;
    public String name;
    public int kor;
    public int eng;
    public int math;
    public int total;
    public double avg;
    public char grad;
    public int rank;
    
    /*
     * - 신상데이터입력
     * - 점수데이터입력
     * 
     * - 총점계산
     * - 평균계산
     * - 평점계산
     * 
     * - 총점, 평균, 평점 계산
     * 
     * - 출력
     */
    
    public void personData(int no, String name){	//신상데이터
    	this.no = no;
    	this.name = name;
    }
    
    public void scoreData(int kor, int eng, int math){	//점수데이터
    	this.kor = kor;
    	this.eng = eng;
    	this.math = math;
    }
    
    public void calcTotal(){	//총점계산
    	this.total = this.kor + this.eng + this.math;
    }
    
    public void calcAvg(){	//평균계산
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
    
    public void print(){	//성정 정보 출력 메소드
    	System.out.println(no+"\t"+name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+total+"\t"+avg+"\t"+grad+"\t");
    }
    
   
}
