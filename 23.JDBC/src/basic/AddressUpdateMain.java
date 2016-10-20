package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressUpdateMain {

	public static void main(String[] args) {
		String driverClassStr = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@210.16.214.203:1521:XE";	//대소문자 구별 필수
		String user = "user21";
		String pass = "user21";
		String updateSQL="update address "
				+ "set address='FRANCE' "
				+ "where no > 5 and no <= 10";
		/*
		 *  이름      널        유형           
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
			
			// 4. SQL 전송
			int insertRowCounts = stmt.executeUpdate(updateSQL);
			
			System.out.println("행 "+insertRowCounts+"개 update...");
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}catch(SQLException e){
			System.out.println("***********************************");
			System.out.println("msg \t\t: "+e.getMessage());
			System.out.println("error code \t: "+e.getErrorCode());
			System.out.println("sql state \t: "+e.getSQLState());
			System.out.println("sql \t\t: "+updateSQL);
			System.out.println("***********************************");
		}
		

	}

}
