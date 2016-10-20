package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressSelectMain {

	public static void main(String[] args) {
		String driverClass = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@210.16.214.203:1521:XE";
		String user = "user21";
		String password = "user21";
		String selectSQL = "select * from address";
		
		try{
			Class.forName(driverClass);
			Connection con = DriverManager.getConnection(url, user, password);	//Oracle의 connection은 비용이 든다.
			Statement stmt = con.createStatement();
			
			
			/* <<stmt.executeQuery(SQL);
			 * Executes the given SQL statement, which returns a single ResultSet object. 

				- Note:This method cannot be called on a PreparedStatement or CallableStatement.
				Parameters:sql an SQL statement to be sent to the database, 
				typically a static SQL SELECT statement
				
				- Returns:a ResultSet object that contains the data produced by the given query; 
							never null
			 */
			ResultSet rs = stmt.executeQuery(selectSQL);
			
			/*	<< boolean java.sql.ResultSet.next() >>
			 *  - Moves the cursor forward one row from its current position.
			 *  
			 *  - Returns:true if the new current row is valid; 
			 *  		  false if there are no more rows
			 */
			System.out.println("rs 확인 : "+rs+"\n");
			boolean isExist = rs.next();
			
			/*
			if(isExist){
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				System.out.println(no+"\t"+id+"\t"+name+"\t"+phone+"\t"+address);
			}
			else{
				System.out.println("데이터 없음");
			}*/
			
			while(rs.next()){
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				System.out.println(no+"\t"+id+"\t"+name+"\t"+phone+"\t"+address);
			}
			
			rs.close();
			stmt.close();
			con.close();//connection을 매번 닫는것은 큰비용을 초래한다.. 
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
