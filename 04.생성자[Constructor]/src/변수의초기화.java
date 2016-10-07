
public class 변수의초기화 {
	public static void main(String[] args) {
		/*
		 * local variable
		 *  - 반드시 초기화 작업을 하여야한다.
		 *  
		 */
		System.out.println("------기본형-----");
		/*
		 * 기본형 리터럴(데이타) 23,23.8,true,'A'
		 */
		int i;
		char c;
		double d;
		boolean b;
		/*
		 The local variable i may not have been initialized 
		 */
		i=0;
		int result = i+1;
		c='A';
		
		if(i==0){
			d=1.4;
		}else{
			d=1.5;
		}
		System.out.println(result);
		System.out.println(c);
		System.out.println(d);
		System.out.println("------참조형-----");
		
		Car car;
		car=new Car();
		/*
		 * 참조형 리터럴(데이타) null
		 * 
		 */
		Account account=null;
		
		
		System.out.println(car);
		System.out.println(account);
		
		car.ipCha("123", 14);
		if(account == null){
			account = new Account();
		}
		account.setAccountData("1111", "KIM", 88000, 0.05);
		account.print();
		
		
		System.out.println("==========객체의 비교==========");
		Car car1 = new Car("8888888888", 12, 17, 5000);
		Car car2 = new Car("9999999999", 16, 17, 1000);
		Car carTemp = null;
		
		carTemp = car1;
		
		if(car1 == carTemp){
			System.out.println("car1과 carTemp 주소값이 같음");
		}
		
		if(car1 == car2){
			System.out.println("car1과 car2 주소값이 같음");
		}
		else{
			System.out.println("car1과 car2 주소값이 다름");
		}
		
	
		Car.headerPrint();
		carTemp.print();
		car1.print();
		Car.footerPrint();
	
		System.out.println("=========객체 메모리 해지=========");
		car = null;
		car1 = null;
		car2 = null;
		
		
		
		
		/*
		 * 멤버변수(instance[클래스를 통해 찍어낸 객체] 변수) 초기화 
		 * 	- 객체 생성시 기본값으로 자동 초기화 됨 (객체는 null로 초기화됨)
		 */
		클래스 c1 = new 클래스();
		System.out.println(c1.멤버변수1);
		System.out.println(c1.멤버변수2);
		System.out.println(c1.멤버변수3);
		System.out.println(c1.멤버변수4);
		System.out.println(c1.참조형멤버변수1);
		System.out.println(c1.참조형멤버변수2);
		System.out.println(c1.참조형멤버변수3);
		
		
	}
}
