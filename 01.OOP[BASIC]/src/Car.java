/*
 * class 선언(정의)
 *  - 형식
 *       접근제한자  class  클래스이름{
 *       	- 접근제한자(access modifier):public,protected,없는거
 *       
 *       } 
 *       ex> public class Car{
 *           }
 *           
 *  -구성요소
 *     1.멤버변수선언(속성)
 *        접근제한자(public,proected,없는거,private) 타입 indentifier;
 *        ex> public String carName;
 *        
 *     2.멤버메쏘드 선언(행위)    
 *        접근제한자 리턴타입 메쏘드이름(인자){
 *           -인자: 나를 호출한놈이 데이타를 넣어줄 통로
 *        	 -리턴타입: 나를 호출한놈에게 줄 데이타타입 
 *                     void --> 줄데이타가 없는경우
 *        }
 *        ex> public int test(int a){
 *        	  	
 *            }
 */

public class Car {	//접근제한자 class 클래스명
	
	//멤버변수 선언, public 으로 열려있다..
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
		System.out.println("차량번호\t입차시간\t출차시간\t주차요금");
	}
	
	public static void footerPrint(){
		System.out.println("*********************************************************");
	}
	
	public void print(){
		System.out.println("---------------------------------------------------------");
		System.out.println(no+"\t"+inTime+"\t\t"+outTime+"\t\t"+fee);
	}
}
