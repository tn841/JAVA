package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressInsertMain {
	public static void main(String[] args) {
		String driverClassStr = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@210.16.214.203:1521:XE";	//��ҹ��� ���� �ʼ�
		String user = "user21";
		String pass = "user21";
		String insertSQL="insert into address values("
				+ "address_no_seq.nextval, "
				+ "'id'||address_no_seq.currval, "
				+ "'�̸�'||address_no_seq.currval, "
				+ "'010-1458-4751', "
				+ "'����� ������')";
		/*
		 *  �̸�      ��        ����           
			------- -------- ------------ 
			NO      NOT NULL NUMBER(4)    
			ID               VARCHAR2(6)  
			NAME             VARCHAR2(20) 
			PHONE            VARCHAR2(15) 
			ADDRESS          VARCHAR2(60) 
		 */
		
		
		try{
			// 1. Driver Loading
			Class.forName(driverClassStr);
			
			// 2. Connection
			Connection con = DriverManager.getConnection(url, user, pass);
			
			// 3. Statement
			Statement stmt = con.createStatement();
			
			// 4. SQL ����
			int insertRowCount = stmt.executeUpdate(insertSQL);
			
			System.out.println(insertRowCount+"�� insert...");
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}catch(SQLException e){
			System.out.println("***********************************");
			System.out.println("msg \t\t: "+e.getMessage());
			System.out.println("error code \t: "+e.getErrorCode());
			System.out.println("sql state \t: "+e.getSQLState());
			System.out.println("sql \t\t: "+insertSQL);
			System.out.println("***********************************");
		}
		
	}
}
