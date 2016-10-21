package resultset;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import com.itwill.jdbc.common.ConnectionFactory;

public class ResultSetMetaDataMain {

	public static void main(String[] args) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from emp");
		
		ResultSetMetaData rsmd = rs.getMetaData();
		
		
		int colCount = rsmd.getColumnCount();
		System.out.println("colCount : "+colCount);
		
		for(int i=1; i<9; i++){
			System.out.println("col("+i+") Name: "+rsmd.getColumnName(i));
		}
		System.out.println();
		for(int i=1; i<9; i++){
			System.out.println("col("+i+") TypeName: "+rsmd.getColumnTypeName(i));
			//  database-specific type name. DB의존적인 Type Name
		}
		System.out.println();
		for(int i=1; i<9; i++){
			System.out.println("col("+i+") TypeName: "+rsmd.getColumnType(i));
		}
		System.out.println();
		for(int i=1; i<9; i++){
			System.out.println("col("+i+") JavaClassName: "+rsmd.getColumnClassName(i));
			// the fully-qualified name of the Java class 
		}
		System.out.println();
		for(int i=1; i<9; i++){
			System.out.println("col("+i+") isNullable: "+rsmd.isNullable(i));
		}
		System.out.println();
		for(int i=1; i<9; i++){
			System.out.println("col("+i+") columnSize: "+rsmd.getColumnDisplaySize(i));
		}
		
		
		
		
	}

}
