/*
 * class ����(����)
 *  - ����
 *       ����������  class  Ŭ�����̸�{
 *       	- ����������(access modifier):public,protected,���°�
 *       
 *       } 
 *       ex> public class Car{
 *           }
 *           
 *  -�������
 *     1.�����������(�Ӽ�)
 *        ����������(public,proected,���°�,private) Ÿ�� indentifier;
 *        ex> public String carName;
 *        
 *     2.����޽�� ����(����)    
 *        ���������� ����Ÿ�� �޽���̸�(����){
 *           -����: ���� ȣ���ѳ��� ����Ÿ�� �־��� ���
 *        	 -����Ÿ��: ���� ȣ���ѳ𿡰� �� ����ŸŸ�� 
 *                     void --> �ٵ���Ÿ�� ���°��
 *        }
 *        ex> public int test(int a){
 *        	  	
 *            }
 */

public class Car {	//���������� class Ŭ������
	
	//������� ����, public ���� �����ִ�..
	public String no;
	public int inTime;
	public int outTime;
	public int fee;
	
	public void ipCha(String no, int inT){
		this.no = no;
		this.inTime = inT;
	}
	
	public void setOutTime(int outT){
		this.outTime = outT;
	}
	
	public void calculateFee(){
		this.fee = (this.outTime - this.inTime)*1000;
	}
	
	public static void headerPrint(){
		System.out.println("*********************************************************");
		System.out.println("������ȣ\t�����ð�\t�����ð�\t�������");
	}
	
	public static void footerPrint(){
		System.out.println("*********************************************************");
	}
	
	public void print(){
		System.out.println("---------------------------------------------------------");
		System.out.println(no+"\t"+inTime+"\t\t"+outTime+"\t\t"+fee);
	}
}
