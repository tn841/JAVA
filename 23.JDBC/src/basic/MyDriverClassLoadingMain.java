package basic;

public class MyDriverClassLoadingMain {

	public static void main(String[] args) throws Exception {
		/*
		 * MyDriver myDriver = new MyDriver(); //My DB에 의존성 발생, Oracle, MYSQL, MSSQL.. 등 모두에 사용가능한 의존성없는 객체 생성 방법?
		 */
		
		Class driverClass = Class.forName("basic.MyDriver");	//클래스 이름 문자열을 인자로.. 해당 클래스이름을 찾는다.
																//Oracle Driver 객체를 선언하고 생성하는 순간 의존성이 발생하기 때문에
																//위와 같은 방식으로 (문자열로) 클래스를 선언하고 아래에서 객체를 생성한다.
		Object diriverClassObj = driverClass.newInstance();
		System.out.println("드라이버객체 : "+diriverClassObj);
		
	}

}
