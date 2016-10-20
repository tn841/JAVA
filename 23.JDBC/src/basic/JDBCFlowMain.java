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
		String url = "jdbc:oracle:thin:@210.16.214.203:1521:XE";	//��ҹ��� ���� �ʼ�
		String user = "user21";
		String pass = "user21";
		/*
		 * 1. Driver class loading
		 * 	- Driver ��ü ����
		 * 	- DriverManager�� Driver��ü ���
		 */
		//Driver driver = new OracleDriver();	//OracleDriver�� ���� �������� ���ϱ� ���� �̷� ������ ��������
		
		Class driverClass = Class.forName(driverClassStr);	// Ŭ������ static block���� ��ü ���� �� driver Manager��� �۾����� ���ش�.
		System.out.println("oracle driver ���� : "+driverClass);
		
		/*
		 *  2. Connection ���� (���ϰ� �����..)
		 *  	- DB�� ����
		 */
		Connection con = DriverManager.getConnection(url,user,pass);
		System.out.println("connection ���� :"+con);
		
		
		/*
		 *  3. Statement ���� (SQL�� ������ �� �ִ� ��Ʈ�� ���� ��)
		 *  	- SQL�� �����ϴ� ��ü
		 */
		Statement stmt = con.createStatement();
		System.out.println("statment ���� : "+stmt);
		
		
		
		/*
		 * 	4. SQL ����
		 */
		String updateSQL="update dept set loc='LA'";
		//int rows = stmt.executeUpdate("update emp set col2='1234'");
		boolean tt = stmt.execute("INSERT INTO EMP VALUES(13, '1313')");		
	
		
		/*
		 * 	5. ��� �ڵ鸵
		 */
		
		
		
		/*
		 * 	6. ���� ����
		 */
	}

}
