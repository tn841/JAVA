package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

public class JDBCFlowMain {

	public static void main(String[] args) throws Exception {
		String driverClassStr = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@210.16.214.203:1521:XE";	//대소문자 구별 필수
		String user = "user21";
		String pass = "user21";
		/*
		 * 1. Driver class loading
		 * 	- Driver 객체 생성
		 * 	- DriverManager에 Driver객체 등록
		 */
		//Driver driver = new OracleDriver();	//OracleDriver에 대한 의존성을 피하기 위해 이런 생성을 하지않음
		
		Class driverClass = Class.forName(driverClassStr);	// 클래스의 static block에서 객체 생성 및 driver Manager등록 작업까지 해준다.
		System.out.println("oracle driver 생성 : "+driverClass);
		
		/*
		 *  2. Connection 생성 (소켓과 비슷한..)
		 *  	- DB와 연결
		 */
		Connection con = DriverManager.getConnection(url,user,pass);
		System.out.println("connection 생성 :"+con);
		
		
		/*
		 *  3. Statement 생성 (SQL을 전달할 수 있는 스트림 같은 것)
		 *  	- SQL을 전송하는 객체
		 */
		Statement stmt = con.createStatement();
		System.out.println("statment 생성 : "+stmt);
		
		
		
		/*
		 * 	4. SQL 전송
		 */
		String updateSQL="update dept set loc='LA'";
		//int rows = stmt.executeUpdate("update emp set col2='1234'");
		boolean tt = stmt.execute("INSERT INTO EMP VALUES(13, '1313')");		
	
		
		/*
		 * 	5. 결과 핸들링
		 */
		
		
		
		/*
		 * 	6. 연결 해제
		 */
	}

}
