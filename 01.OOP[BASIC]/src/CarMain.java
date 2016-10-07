
public class CarMain {

	public static void main(String[] args) {
		
		/*
		 * 1. 입차
		 *   - 클래스를 사용해서 차 객체 생성
		 *   - 차 객체에 데이터 입력
		 */
	
		Car car1 = new Car();	//객체(인스턴스) 선언 및 생성
		
		//생성된 인스턴스에 데이터 입력
		car1.no = "23러2973";	
		car1.inTime = 12;
		
		
		/*
		 * 2. 2시간이 지난 후 출차
		 *   - 출차시간을 객체에 입력
		 *   - 추자요금 계산 후 객체 Setting
		 */
		car1.outTime = 14;
		car1.fee = (car1.outTime - car1.inTime)*1000;
		
		
		/*
		 * 3. 영수증출력
		 *  
		 */
		System.out.println("*********************************************************");
		System.out.println("차량번호\t입차시간\t출차시간\t주차요금");
		System.out.println("---------------------------------------------------------");
		System.out.println(car1.no+"\t"+car1.inTime+"\t\t"+car1.outTime+"\t\t"+car1.fee);
		System.out.println("*********************************************************");
	}

}
