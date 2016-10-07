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
     * - �Ż������Է�
     * - �����������Է�
     * 
     * - �������
     * - ��հ��
     * - �������
     * 
     * - ����, ���, ���� ���
     * 
     * - ���
     */
    
    public void personData(int no, String name){	//�Ż�����
    	this.no = no;
    	this.name = name;
    }
    
    public void scoreData(int kor, int eng, int math){	//����������
    	this.kor = kor;
    	this.eng = eng;
    	this.math = math;
    }
    
    public void calcTotal(){	//�������
    	this.total = this.kor + this.eng + this.math;
    }
    
    public void calcAvg(){	//��հ��
    	double temp = this.total / 3.0;
    	this.avg = (int) (temp*100+0.5)/100.0;
    }
    
    public void calcGrad(){		//���� ���
    	
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
    
    public void calcAll(){	//����, ���, ���� �ѹ��� ���
    	this.calcTotal();
    	this.calcAvg();
    	this.calcGrad();
    }
    
    public static void headerPrint(){	//��� ���� �޼ҵ�
    	System.out.println("-------------------------------------------------------------");
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t����");
    }
    
    public static void footerPrint(){	//Ǫ�� ���� �޼ҵ�
    	System.out.println("-------------------------------------------------------------");
    }
    
    public void print(){	//���� ���� ��� �޼ҵ�
    	System.out.println(no+"\t"+name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+total+"\t"+avg+"\t"+grad+"\t");
    }
    
   
}
